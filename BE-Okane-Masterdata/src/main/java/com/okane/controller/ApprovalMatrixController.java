package com.okane.controller;

import com.okane.dto.approvalMatrix.*;
import com.okane.service.ApprovalMatrixService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.text.ParseException;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/public/masterdata/approval_matrix")
public class ApprovalMatrixController {
    @Inject
    ApprovalMatrixService ams;

    @POST
    @Path("/search_approval_matrix")
    public Response searchApprovalMatrix(@Context HttpHeaders headers, approvalMatrixSearchRequest req) throws ParseException {
        return ams.searchApprovalMatrix(req,headers.getHeaderString("token"));
    }

    @POST
    @Path("/create_approval_matrix")
    public Response createApprovalMatrix(@Context HttpHeaders headers, approvalMatrixRequest req) throws ParseException {
        return ams.createApprovalMatrix(req,headers.getHeaderString("token"));
    }

    @POST
    @Path("/update_approval_matrix")
    public Response updateApprovalMatrix(@Context HttpHeaders headers, approvalMatrixRequest req) throws ParseException {
        return ams.updateApprovalMatrix(req,headers.getHeaderString("token"));
    }

    @POST
    @Path("/delete_approval_matrix/{approvalMatrixId}")
    public Response deleteApprovalMatrix(@Context HttpHeaders headers, @PathParam("approvalMatrixId") String req) throws ParseException {
        return ams.deleteApprovalMatrix(Integer.valueOf(req),headers.getHeaderString("token"));
    }

    @GET
    @Path("/get_all_approval_matrix")
    public Response getAllApprovalMatrix(@Context HttpHeaders headers) throws ParseException {
        return ams.getAllApprovalMatrix(headers.getHeaderString("token"));
    }
}
