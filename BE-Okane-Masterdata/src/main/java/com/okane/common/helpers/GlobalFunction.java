package com.okane.common.helpers;

import com.okane.domain.master.*;
import com.okane.domain.transaction.*;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@ApplicationScoped
@Transactional
public class GlobalFunction extends GeneralService{
    private SimpleDateFormat formatId = new SimpleDateFormat("yyyyMMddhhmmss");

    public Integer generatorId(Integer userId,Integer reportId,Integer typeReportId){
        System.out.println(String.format("[[ %s ]]-------------------- generatorId: START [[ %s,%s ]]--------------------",userId,reportId,typeReportId));
        int idGenerator = 0;
        if (reportId != null && typeReportId != null) {
            ReportEntity checkReportId = ReportEntity.findById(reportId);
            TypeReportEntity checkTypeReportId = TypeReportEntity.findById(typeReportId);
            if (checkReportId != null && checkTypeReportId != null) {
                String id = formatId.format(new Date()) + reportId + typeReportId;
                idGenerator = new BigDecimal(id).intValue();
                System.out.println(String.format("[[ %s ]]-------------------- generatorId: Not Null %s --------------------",userId,idGenerator));
            }
        } else {
            String id = formatId.format(new Date());
            idGenerator = new BigDecimal(id).intValue();
            System.out.println(String.format("[[ %s ]]-------------------- generatorId: Null %s --------------------",userId,idGenerator));
        }
        return idGenerator;
    }

    public void setActivity(Integer userId, String modules, Integer moduleId, String activity, String activityType, String url) {
        System.out.println(String.format("[[ %s ]]-------------------- setActivity: START [[ %s ]]--------------------",userId,modules));
        if (userId != null) {
            LogActivityEntity activities = new LogActivityEntity(
                    userId,
                    modules,
                    moduleId,
                    activity,
                    activityType,
                    url,
                    userId,
                    new Date()
            );
//            activities.setLogActivityId(generatorId(userId,moduleId,typeReportId));
            activities.persist();

            UserEntity userToken = UserEntity.findById(userId);
            if (userToken != null) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.MINUTE, 50);

                String tokenExpired = formatter.format(cal.getTime());

                userToken.setTokenExpired(tokenExpired);
                userToken.persist();
            }
        }
    }
}
