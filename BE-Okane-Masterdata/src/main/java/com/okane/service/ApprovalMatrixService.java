package com.okane.service;

import com.okane.common.helpers.GlobalFunction;
import com.okane.domain.master.*;
import com.okane.domain.transaction.*;
import com.okane.dto.approvalMatrix.*;
import com.okane.dto.responseList;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.util.*;

@ApplicationScoped
@Transactional
public class ApprovalMatrixService extends GlobalFunction {
    public Response searchApprovalMatrix(approvalMatrixSearchRequest req, String tokenReq) throws ParseException {
        responseList response = new responseList("failed", null, "Internal Server Error!");
        Response token = checkToken(tokenReq);
        int statusCode = token.getStatus();

        if (statusCode == 202) {
            UserEntity dataToken = UserEntity.find("token = ?1",tokenReq).singleResult();
            String keyword = req.getKeyword().trim().toLowerCase();
            System.out.println(String.format("[[ %s ]]-------------------- searchApprovalMatrix: START [[ %s ]] --------------------",dataToken.getUserId(),keyword));

            // search by approval type
            List<ApprovalTypeEntity> approvalTypeId = ApprovalTypeEntity.find("lower(approvalTypeName) like (concat('%',?1,'%'))",keyword).list();
            List<Optional<?>> sortedList = new ArrayList<>();

            if (!approvalTypeId.isEmpty()) {
                List<ApprovalMatrixEntity> listApprovalMatrix = ApprovalMatrixEntity.find("approval_type_id in ?1 and status = 1 and cast(?2 as date) >= cast(start_date as date) and cast(?2 as date) <= cast(end_date as date)", approvalTypeId, new Date()).list();
                listApprovalMatrix.forEach((item) -> {
                    ApprovalTypeEntity approvalTypeName = ApprovalTypeEntity.findById(item.getApprovalTypeId());
                    OperatorTypeEntity operatorTypeName = OperatorTypeEntity.findById(item.getOperatorTypeId());
                    UserEntity fullname = UserEntity.findById(item.getUserId());

                    approvalMatrixResponse stringList = new approvalMatrixResponse(
                            item.getApprovalMatrixId(),
                            item.getApprovalTypeId(),
                            approvalTypeName == null ? "" : approvalTypeName.getApprovalTypeName(),
                            item.getOperatorTypeId(),
                            operatorTypeName == null ? "" : operatorTypeName.getOperatorTypeName(),
                            item.getUserId(),
                            fullname == null ? "" : fullname.getFullname(),
                            item.getOrders(),
                            item.getStartDate(),
                            item.getEndDate(),
                            checkStatus(item.getStatus(), item.getStartDate(), item.getEndDate()),
                            dateModifierTIA(item.getCreatedBy(), item.getCreatedAt()),
                            dateModifierTIA(item.getUpdatedBy(), item.getUpdatedAt())
                    );

                    List<?> listDataApprovalMatrix = new ArrayList(Arrays.asList(stringList));
                    Optional<?> dataApprovalMatrix = listDataApprovalMatrix.stream().findFirst();
                    sortedList.add(dataApprovalMatrix);
                });
            }

            setActivity(
                    dataToken.getUserId(),
                    "search_approval_matrix",
                    null,
                    ("Search data approval matrix"),
                    "activity_search_ApprovalMatrix",
                    "/public/masterdata/approval_matrix/search_approval_matrix"
            );

            response.setStatus("success");
            response.setData(sortedList);
            response.setMessage("Get Data Approval Matrix Success");

            System.out.println(String.format("[[ %s ]]-------------------- searchApprovalMatrix: END [[ %s ]] --------------------",dataToken.getUserId(),response.getMessage()));
            return Response.status(Response.Status.OK).entity(response).build();
        } else {
            return token;
        }
    }

    public Response createApprovalMatrix(approvalMatrixRequest req, String tokenReq) throws ParseException {
        responseList response = new responseList("failed", null, "Internal Server Error!");
        if (req.getApproval_type_id() != null) {
            response.setMessage("Approval Type ID Cannot be Empty");
            return Response.status(Response.Status.OK).entity(response).build();
        } else if (req.getOperator_type_id() != null) {
            response.setMessage("Operator Type ID Cannot be Empty");
            return Response.status(Response.Status.OK).entity(response).build();
        } else if (req.getUser_id() != null) {
            response.setMessage("User ID Cannot be Empty");
            return Response.status(Response.Status.OK).entity(response).build();
        } else if (req.getOrders() != null) {
            response.setMessage("Order Cannot be Empty");
            return Response.status(Response.Status.OK).entity(response).build();
        } else if (req.getStart_date() != null) {
            response.setMessage("Valid From Date Cannot be Empty");
            return Response.status(Response.Status.OK).entity(response).build();
        } else if (req.getEnd_date() != null) {
            response.setMessage("Valid To Date Cannot be Empty");
            return Response.status(Response.Status.OK).entity(response).build();
        }

        Response token = checkToken(tokenReq);
        int statusCode = token.getStatus();

        if (statusCode == 202) {
            UserEntity dataToken = UserEntity.find("token = ?1",tokenReq).singleResult();
            List<ApprovalMatrixEntity> isHaveDifferentOperator = ApprovalMatrixEntity.find("approval_type_id = ?1 and operator_type_id = 1 and orders = ?2 and status = 1",req.getApproval_type_id(), req.getOrders()).list();
            if (isHaveDifferentOperator.size() > 0) {
                response.setMessage("Cannot Add More Than 1 Approver for Operator Type \"-\"");
                return Response.status(Response.Status.OK).entity(response).build();
            }

            List<ApprovalMatrixEntity> isHaveApproverInSameOrder = ApprovalMatrixEntity.find("approval_type_id = ?1 and user_id = ?2 and status = 1",req.getApproval_type_id(), req.getUser_id()).list();
            if (isHaveApproverInSameOrder.size() > 0) {
                response.setMessage("Data With That User in Same Approval Type Already Exist");
                return Response.status(Response.Status.OK).entity(response).build();
            }

            List<ApprovalMatrixEntity> isHaveDifferentOperatorInSameOrder = ApprovalMatrixEntity.find("approval_type_id = ?1 and operator_type_id != ?2 and orders = ?3 and status = 1",req.getApproval_type_id(), req.getOperator_type_id(), req.getOrders()).list();
            if (isHaveDifferentOperatorInSameOrder.size() > 0) {
                response.setMessage("Operator Type Must be The Same In Order");
                return Response.status(Response.Status.OK).entity(response).build();
            }

            ApprovalMatrixEntity approvalMatrix = new ApprovalMatrixEntity(
                    req.getApproval_type_id(),
                    req.getOperator_type_id(),
                    req.getUser_id(),
                    req.getOrders(),
                    req.getStart_date(),
                    req.getEnd_date(),
                    1,
                    dataToken.getUserId(),
                    new Date()
            );

            approvalMatrix.persist();
            setActivity(
                    dataToken.getUserId(),
                    "create_approval_matrix",
                    approvalMatrix.getApprovalMatrixId(),
                    ("Create approval matrix " + req.getApproval_type_id()),
                    "activity_create_approval_matrix",
                    "/public/masterdata/approval_matrix/create_approval_matrix");

            response.setStatus("success");
            response.setMessage("Data was Saved Successfully");
            return Response.status(Response.Status.OK).entity(response).build();
        } else {
            return token;
        }
    }

    public Response updateApprovalMatrix(approvalMatrixRequest req, String tokenReq) throws ParseException {
        responseList response = new responseList("failed", null, "Internal Server Error!");
        if (req.getApproval_matrix_id() != null) {
            response.setMessage("Approval Matrix ID Cannot be Empty");
            return Response.status(Response.Status.OK).entity(response).build();
        } else if (req.getApproval_type_id() != null) {
            response.setMessage("Approval Type ID Cannot be Empty");
            return Response.status(Response.Status.OK).entity(response).build();
        } else if (req.getOperator_type_id() != null) {
            response.setMessage("Operator Type ID Cannot be Empty");
            return Response.status(Response.Status.OK).entity(response).build();
        } else if (req.getUser_id() != null) {
            response.setMessage("User ID Cannot be Empty");
            return Response.status(Response.Status.OK).entity(response).build();
        } else if (req.getOrders() != null) {
            response.setMessage("Order Cannot be Empty");
            return Response.status(Response.Status.OK).entity(response).build();
        } else if (req.getStart_date() != null) {
            response.setMessage("Valid From Date Cannot be Empty");
            return Response.status(Response.Status.OK).entity(response).build();
        } else if (req.getEnd_date() != null) {
            response.setMessage("Valid To Date Cannot be Empty");
            return Response.status(Response.Status.OK).entity(response).build();
        }

        Response token = checkToken(tokenReq);
        int statusCode = token.getStatus();

        if (statusCode == 202) {
            UserEntity dataToken = UserEntity.find("token = ?1", tokenReq).singleResult();
            setActivity(
                    dataToken.getUserId(),
                    "update_approval_matrix",
                    req.getApproval_matrix_id(),
                    ("Update approval matrix for " + req.getApproval_matrix_id()),
                    "activity_update_approval_matrix",
                    "/public/masterdata/approval_matrix/update_approval_matrix"
            );

            response.setStatus("success");
            response.setMessage("Data was Saved Successfully");
            return Response.status(Response.Status.OK).entity(response).build();
        } else {
            return token;
        }
    }

    public Response deleteApprovalMatrix(Integer id, String tokenReq){
        responseList response = new responseList("failed", null, "Internal Server Error!");
        return Response.status(Response.Status.OK).entity(response).build();
    }

    public Response getAllApprovalMatrix(String tokenReq) {
        responseList response = new responseList("failed", null, "Internal Server Error!");
        return Response.status(Response.Status.OK).entity(response).build();
    }

    public Response getApprovalMatrixByApprovalMatrixId(Integer approvalMatrixId, String tokenReq) {
        responseList response = new responseList("failed", null, "Internal Server Error!");
        return Response.status(Response.Status.OK).entity(response).build();
    }

    public Response getAllApprover() {
        responseList response = new responseList("failed", null, "Internal Server Error!");
        return Response.status(Response.Status.OK).entity(response).build();
    }

    public Response saveVisualization(){
        responseList response = new responseList("failed", null, "Internal Server Error!");
        return Response.status(Response.Status.OK).entity(response).build();
    }

    public Response exportApprovalMatrix(){
        responseList response = new responseList("failed", null, "Internal Server Error!");
        return Response.status(Response.Status.OK).entity(response).build();
    }

    public Response checkImport(){
        responseList response = new responseList("failed", null, "Internal Server Error!");
        return Response.status(Response.Status.OK).entity(response).build();
    }

    public Response importApprovalMatrix(){
        responseList response = new responseList("failed", null, "Internal Server Error!");
        return Response.status(Response.Status.OK).entity(response).build();
    }
}
