package com.test.api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONObject;

public class APITest {
    public static void main(String[] args) throws UnirestException {
        JSONObject object = new JSONObject();
        object.put("accountNo","0002601020864");
        HttpResponse<JsonNode> jsonResponse =
                Unirest.post("http://localhost:9196/callapi/account")
                        .header("Content-Type", "application/json")
                        .body(object)
                        .asJson();
        if(jsonResponse.getStatus()== HttpStatus.SC_OK){
            System.out.println(jsonResponse.getBody());
            System.out.println(jsonResponse.getBody().getObject().get("ProductForRunningAc"));
            System.out.println(jsonResponse.getBody().getObject().get("Emails"));
            Object emailList = jsonResponse.getBody().getObject().get("Emails");
            String statusCode = jsonResponse.getBody().getObject().getString("StatusCode");
            System.out.println(statusCode.equals("00"));
            if(emailList.equals(null)){
                System.out.println("NULL value");
            }
            System.out.println(jsonResponse.getBody().getObject().getBigDecimal("Balance"));

        }

    }
}
