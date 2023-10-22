package com.eksad.ddms.service;

import com.eksad.ddms.dto.GeneralResponse;
import com.eksad.ddms.dto.hello.HelloRequestDto;
import com.eksad.ddms.dto.hello.HelloResponseDto;

import javax.inject.Singleton;

@Singleton
public class HelloService {
    public GeneralResponse helloService(HelloRequestDto request) {
        GeneralResponse response=new GeneralResponse();
        HelloResponseDto dataResult=new HelloResponseDto();

        String gender=request.getGender();
        String name=request.getName();
        if (gender==null||gender.isEmpty()) {
            response.setStatus("failed");
            dataResult.setResult(false);
            response.setData(dataResult);
            return response;
        }

        if (name==null||name.isEmpty()) {
            response.setStatus("failed");
            dataResult.setResult(false);
            response.setData(dataResult);
            return response;
        }

        String title=gender.trim().equalsIgnoreCase("M")?"Mr.":"Ms.";
        String message="Hello "+title+name;
        dataResult.setResult(true);
        dataResult.setMessage(message);
        response.setData(dataResult);
        response.setStatus("success");
        return response;
    }
}
