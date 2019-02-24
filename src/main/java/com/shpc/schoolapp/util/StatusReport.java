package com.shpc.schoolapp.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * Created by jinyulei on 2016/12/19.
 */
public class StatusReport {
    static ObjectMapper objectMapper=new ObjectMapper();
    static final int SUCCESS=200;
    static final int ERROR=400;
    static final int NO_RESULT=405;
    public static String buildResult(int number,Map<String,Object> map,String errorInformation) throws JsonProcessingException {
        if (number==SUCCESS){
            return "{\"status\":" + SUCCESS+"," +
                    "\"details\":" +objectMapper.writeValueAsString(map)+ "}";
        }else if (number==ERROR){
            return "{\"status\":" + ERROR+"," +
                    "\"errorInformation\":\"" +errorInformation+ "\"}";
        }else if (number==NO_RESULT){
            return "{\"status\":" + NO_RESULT+"," +
                    "\"errorInformation\":\"No results matching\"}";
        }
        return "{\"status\":" + ERROR+"," +
                "\"errorInformation\":\"UnKnow\"}";
    }
    public static String buildStringResult(int number,String string,String errorInformation) throws JsonProcessingException {
        if (number==SUCCESS){
            return "{\"status\":" + SUCCESS+"," +
                    "\"details\":\"" +string+ "\"}";
        }else if (number==ERROR){
            return "{\"status\":" + ERROR+"," +
                    "\"errorInformation\":\"" +errorInformation+ "\"}";
        }else if (number==NO_RESULT){
            return "{\"status\":" + NO_RESULT+"," +
                    "\"errorInformation\":\"No results matching\"}";
        }
        return "{\"status\":" + ERROR+"," +
                "\"errorInformation\":\"UnKnow\"}";
    }
}
