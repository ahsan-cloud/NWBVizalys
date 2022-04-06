package NWB.Api;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

class ApiTest {

    static String APIbodyTOkenLOgin;
    static List<Header> headerlist = new ArrayList<Header>();
    static public String token;
    //static public String OTPtoken="eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJFdmVyeW9uZSxCVUlMVElOXFxVc2VycyxDT05TT0xFIExPR09OLE5UIEFVVEhPUklUWVxcQXV0aGVudGljYXRlZCBVc2VycyxOVCBBVVRIT1JJVFlcXFRoaXMgT3JnYW5pemF0aW9uLExPQ0FMIiwiVXNlcklkIjoiNzMiLCJVc2VyVHlwZXMiOiJJbnB1dHRlcixWaWV3ZXIiLCJleHAiOjE2MDA4NTQyMzcsImlzcyI6InNtZXNrLmluIiwiYXVkIjoicmVhZGVycyJ9.OgPW7c3n84rAzSQC1MMoObsCMpUheuu1_LwXyPEpYts";

    public  ApiTest()
    {


        RestAssured.baseURI  = "http://nwbtestapi.vizalys.com";


    }


    @Nested
    @DisplayName("StressTest Api's")
    class Api

    {


        @Test
        @Order(1)
        public void StressTest_API_TokenLogIn()
        {
            System.out.println("----------API_TokenLogIn----------");
            String APIBody = "{\"email\": \"s@gmail.com\",\n" +
                    "  \"password\": \"Loss@123\"}";

            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header("Content-Type","application/json"));
            //headerlist.add(new Header("device-id","1"));
            //headerlist.add(new Header("user-agents","postman"));
            //headerlist.add(new Header("device-type","mobile"));
            //headerlist.add(new Header("license-key","EF834317-1486-48E6-91EC-04D76FF720B8"));
            //headerlist.add(new Header("user-host-name","salman"));
            //headerlist.add(new Header("user-language","English"));
            //headerlist.add(new Header("user-host-address","::::0"));

            Headers headers = new Headers(headerlist);

            System.out.println(headers);



            Response r;

            r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Auth/Login");


            ResponseBody body = r.getBody();
            int statusCode = r.getStatusCode();

            //


            APIbodyTOkenLOgin = body.asString(); 	///I COMMENTED THIS OUT FOR CHECKING response

            //	System.out.println("Response body "+APIbodyTOkenLOgin);


            JSONObject json = new JSONObject(body.asString());
            //json = json.getJSONObject("Model");
            token = json.getString("message");
            System.out.println("checking LoginToken "+token);

            //executOPTWebService();

            //System.out.println("checking apiTokenfromLogin "+APIbodyTOkenLOgin);

            assertEquals(statusCode /*actual value*/, 200 /*expected value*/);
            //assertEquals(bodyAsString.contains("Fetched Successful") /*Expected value*/, true /*Actual Value*/);

            APIbodyTOkenLOgin = body.asString(); 	///I COMMENTED THIS OUT FOR CHECKING response
            //	System.out.println("checking apiTokenfromLogin "+APIbodyTOkenLOgin); ///I COMMENTED THIS OUT FOR CHECKING response
            //	System.out.println("kaam hogaya------"+APIbodyTOkenLOgin);

            //if(bodyAsString.contains("Fetched Successful")==false)
            {
                //		System.out.println(" in iff");
                //	fail("Should not have thrown invalidity");
            }
            //fail("Should not have thrown any exception");
            //	assertEquals(bodyAsString.contains("Fetched Successful") /*Expected value*/, true /*Actual Value*/);
        }


    }
}