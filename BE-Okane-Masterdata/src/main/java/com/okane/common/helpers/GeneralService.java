package com.okane.common.helpers;

import com.okane.domain.master.*;
import com.okane.dto.responseList;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.*;
import java.text.*;
import java.util.Date;
import java.util.Objects;

@ApplicationScoped
@Transactional
public class GeneralService extends DateUtil {
    public SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public String dateModifierTIA(Integer userId, Date dateModifier) {
        if (dateModifier != null) {
            UserEntity user = userId == null ? null : UserEntity.findById(userId);
            String username = null;
            String monthNumber = DateUtil.dateToString(dateModifier, "MM");

            String date = DateUtil.dateToString(dateModifier, "dd");
            String month = monthName(monthNumber);
            String year = DateUtil.dateToString(dateModifier, "yyyy");
            String time = DateUtil.dateToString(dateModifier, "HH:mm");

            if (user != null) {
                username = user.getFullname();
            } else {
                username = "System";
            }

            return toTitleCase(username) + " - " + date + " " + month + " " + year + ", " + time;
        }

        return null;
    }

    public String toTitleCase(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder converted = new StringBuilder();

        boolean convertNext = true;
        for (char ch : text.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                convertNext = true;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            converted.append(ch);
        }

        return converted.toString();
    }

    public String monthName(String month) {
        String monthName = null;

        if (null != month) {
            switch (month) {
                case "01":
                    monthName = "Jan";
                    break;
                case "02":
                    monthName = "Feb";
                    break;
                case "03":
                    monthName = "Mar";
                    break;
                case "04":
                    monthName = "Apr";
                    break;
                case "05":
                    monthName = "May";
                    break;
                case "06":
                    monthName = "Jun";
                    break;
                case "07":
                    monthName = "Jul";
                    break;
                case "08":
                    monthName = "Aug";
                    break;
                case "09":
                    monthName = "Sep";
                    break;
                case "10":
                    monthName = "Oct";
                    break;
                case "11":
                    monthName = "Nov";
                    break;
                case "12":
                    monthName = "Dec";
                    break;
                default:
                    break;
            }
        }

        return monthName;
    }

    public String checkStatus(Integer status, String startDate, String endDate) {
        Date today = new Date();
        String str = DateUtil.dateToString(today, "yyyy-MM-dd");
        Date formatted = DateUtil.stringToDate(str, "yyyy-MM-dd");
        Date convertedStartDate = DateUtil.stringToDate(startDate, "yyyy-MM-dd");
        Date convertedEndDate = DateUtil.stringToDate(endDate, "yyyy-MM-dd");
        if (((today.after(convertedStartDate) || (formatted.equals(convertedStartDate))) && (today.before(convertedEndDate)) || (formatted.equals(convertedEndDate))) && status.equals(1)) {
            return "Active";
        } else if ((formatted.equals(convertedStartDate) && formatted.equals(convertedEndDate)) && status.equals(1)) {
            return "Active";
        }
        return "Inactive";
    }

    public Boolean isActive(String startDate, String endDate) {
        System.out.println(String.format("[[ %s ]]-------------------- isActive: START --------------------",startDate));
        Date today = new Date();
        String str = DateUtil.dateToString(today, "yyyy-MM-dd");
        Date formatted = DateUtil.stringToDate(str, "yyyy-MM-dd");

        Date convertedStartDate = DateUtil.stringToDate(startDate, "yyyy-MM-dd");
        Date convertedEndDate = DateUtil.stringToDate(endDate, "yyyy-MM-dd");

        if ((today.after(convertedStartDate) || Objects.equals(formatted, convertedStartDate)) && (today.before(convertedEndDate) || Objects.equals(formatted, convertedEndDate))) {
            System.out.println(String.format("[[ %s ]]-------------------- isActive: END [[ TRUE ]] --------------------",startDate));
            return true;
        } else {
            if (formatted.equals(convertedStartDate) && formatted.equals(convertedEndDate)) {
                System.out.println(String.format("[[ %s ]]-------------------- isActive: END [[ FALSE ]] --------------------", startDate));
                return false;
            }
            return false;
        }
    }

    public Boolean isSuperadmin(Integer roleId){
        System.out.println(String.format("[[ %s ]]-------------------- isSuperadmin: START --------------------",roleId));
        RoleEntity role = RoleEntity.findById(roleId);

        if (role.isPersistent()) {
            System.out.println(String.format("[[ %s ]]-------------------- isSuperadmin: END [[ TRUE ]] --------------------",roleId));
            return role.getRoleName().equalsIgnoreCase("superadmin");
        }

        System.out.println(String.format("[[ %s ]]-------------------- isSuperadmin: END [[ FALSE ]] --------------------",roleId));
        return false;
    }

    public Response checkToken(String token) throws ParseException {
        responseList response = new responseList("failed", null, "Internal Server Error!");

        if (token != null && !token.isEmpty()) {
            UserEntity checkToken = UserEntity.find("token = ?1", token).singleResult();
            System.out.println(String.format("[[ %s ]]-------------------- checkToken: START --------------------",checkToken.getUserId()));

            if (checkToken.isPersistent()) {
                String strTokenExpired = checkToken.getTokenExpired().contains(":") ? checkToken.getTokenExpired() : checkToken.getTokenExpired() + " 00:00";

                Date tokenExpired = formatter.parse(strTokenExpired);
                Date today = formatter.parse(formatter.format(new Date()));

                if (tokenExpired != null) {
                    if (today.compareTo(tokenExpired) > 0) {
                        response.setMessage("Token Expired!");
                        System.out.println(String.format("[[ %s ]]-------------------- checkToken: END [[ %s ]] --------------------",checkToken.getUserId(),response.getMessage()));
                        return Response.status(Response.Status.OK).entity(response).build();
                    } else {
                        if (checkToken.getStatus() != 1) {
                            response.setMessage("You Don't Have Any Access to This Application!");
                            System.out.println(String.format("[[ %s ]]-------------------- checkToken: END [[ %s ]] --------------------",checkToken.getUserId(),response.getMessage()));
                            return Response.status(Response.Status.OK).entity(response).build();
                        }

                        if (!isSuperadmin(checkToken.getRoleId())) {
                            if (!isActive(checkToken.getStartDate(), checkToken.getEndDate())) {
                                response.setMessage("Your Account Has Been Expired!");
                                System.out.println(String.format("[[ %s ]]-------------------- checkToken: END [[ %s ]] --------------------",checkToken.getUserId(),response.getMessage()));
                                return Response.status(Response.Status.OK).entity(response).build();
                            }

                            RoleEntity role = RoleEntity.findById(checkToken.getRoleId());

                            if (role != null) {
                                if (role.getStatus() != 1) {
                                    response.setMessage("You Don't Have Any Authority to This Application!");
                                    System.out.println(String.format("[[ %s ]]-------------------- checkToken: END [[ %s ]] --------------------",checkToken.getUserId(),response.getMessage()));
                                    return Response.status(Response.Status.OK).entity(response).build();
                                }

                                if (!isActive(role.getStartDate(), role.getEndDate())) {
                                    response.setMessage("Your Authority Has Been Expired!");
                                    System.out.println(String.format("[[ %s ]]-------------------- checkToken: END [[ %s ]] --------------------",checkToken.getUserId(),response.getMessage()));
                                    return Response.status(Response.Status.OK).entity(response).build();
                                }
                            }

                            if (role == null) {
                                response.setMessage("You Don't Have Any Authority to This Application!");
                                System.out.println(String.format("[[ %s ]]-------------------- checkToken: END [[ %s ]] --------------------",checkToken.getUserId(),response.getMessage()));
                                return Response.status(Response.Status.OK).entity(response).build();
                            }
                        }
                        response = new responseList("success", null, "Token Valid!");

                        System.out.println(String.format("[[ %s ]]-------------------- checkToken: END [[ %s ]] --------------------",checkToken.getUserId(),response.getMessage()));
                        return Response.status(Response.Status.ACCEPTED).entity(response).build();
                    }
                }
                response.setMessage("Token Expired!");
                System.out.println(String.format("[[ %s ]]-------------------- checkToken: END [[ %s ]] --------------------",checkToken.getUserId(),response.getMessage()));
                return Response.status(Response.Status.OK).entity(response).build();
            }
            response.setMessage("Someone Logged In to Your Account on Another Device!");
            System.out.println(String.format("[[ %s ]]-------------------- checkToken: END [[ %s ]] --------------------",checkToken.getUserId(),response.getMessage()));
            return Response.status(Response.Status.OK).entity(response).build();
        }
        response.setMessage("Token Required!");
        System.out.println(String.format("[[ %s ]]-------------------- checkToken: END [[ %s ]] --------------------",null,response.getMessage()));
        return Response.status(Response.Status.OK).entity(response).build();
    }
}
