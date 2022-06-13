package NWB.Api;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
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

    //Header Reusable Variables
    static public String name;
    static public String value;

    static public String headerType = "Content-Type";
    static public String headerMediaType = "application/json";

    //static public String OTPtoken="eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJFdmVyeW9uZSxCVUlMVElOXFxVc2VycyxDT05TT0xFIExPR09OLE5UIEFVVEhPUklUWVxcQXV0aGVudGljYXRlZCBVc2VycyxOVCBBVVRIT1JJVFlcXFRoaXMgT3JnYW5pemF0aW9uLExPQ0FMIiwiVXNlcklkIjoiNzMiLCJVc2VyVHlwZXMiOiJJbnB1dHRlcixWaWV3ZXIiLCJleHAiOjE2MDA4NTQyMzcsImlzcyI6InNtZXNrLmluIiwiYXVkIjoicmVhZGVycyJ9.OgPW7c3n84rAzSQC1MMoObsCMpUheuu1_LwXyPEpYts";

    public  ApiTest()
    {


        RestAssured.baseURI  = "http://nwbtestapi.vizalys.com";


    }


    @Nested
    @DisplayName("NWBVizalys Api's")
    class Api

    {


        @Test
        @Order(1)
        public void NWB_TokenLogin()
        {
            System.out.println("----------API_TokenLogIn----------");
//            String APIBody = "{\"email\": \"superadmin@vizalys.com\",\n" +
//                    "  \"password\": \"Admin123!@#\"}";
            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/auth/login.json");

            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
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
            System.out.println(statusCode);
            //


            APIbodyTOkenLOgin = body.asString(); 	///I COMMENTED THIS OUT FOR CHECKING response

            //	System.out.println("Response body "+APIbodyTOkenLOgin);


            JSONObject json = new JSONObject(body.asString());
            //json = json.getJSONObject("Model");
            token = json.getString("message");
            System.out.println("checking LoginToken "+token);

            //executOPTWebService();

            //System.out.println("checking apiTokenfromLogin "+APIbodyTOkenLOgin);

            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);
            //assertEquals(bodyAsString.contains("Fetched Successful") /*Expected value*/, true /*Actual Value*/);

            //APIbodyTOkenLOgin = body.asString(); 	///I COMMENTED THIS OUT FOR CHECKING response
            //	System.out.println("checking apiTokenfromLogin "+APIbodyTOkenLOgin); ///I COMMENTED THIS OUT FOR CHECKING response
            //	System.out.println("kaam hogaya------"+APIbodyTOkenLOgin);

            //if(bodyAsString.contains("Fetched Successful")==false)
            {
                //		System.out.println(" in iff");
                //	fail("Should not have thrown invalidity");
            }
            //fail("Should not have thrown any exception");
            //	assertEquals(bodyAsString.contains("Fetched Successful") /*Expected value*/, true /*Actual Value*/);

            name = "Authorization";
            value = "bearer "+ token;
            //System.out.println(value);
        }


        @Test
        @Order(2)
        public void NWB_Post_User()
        {
            System.out.println("----------***** NWB_POST_User *****-----------");


//            String APIBody = "{\"userName\": \"ali\",\n" +
//                    "  \"email\": \"ali@gmail.com\",\n" +
//                    "  \"password\": \"Loss@123\",\n" +
//                    "  \"confirmPassword\": \"Loss@123\",\n" +
//                    "  \"userRoles\": [\n" +
//                    "    {\n" +
//                    "      \"roleName\": \"SuperAdmin\",\n" +
//                    "      \"selected\": true\n" +
//                    "    }\n" +
//                    "  ]}";

            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/auth/user.json");

            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","salman"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("Authorization","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Auth/Users");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            // Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }

        }



        @Test
        @Order(3)
        public void NWB_Get_allUsers()
        {
            System.out.println("----------***** NWB_GET_allUsers *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiTmF2ZWVkIiwiRW1haWwiOiJzdXBlcmFkbWluQHZpemFseXMuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiJkY2FjODk0NS05M2VlLTQ1ZGQtOWFjYS0wMjBlODE4YzE2YjAiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsiQWRtaW4iLCJTdXBlckFkbWluIl0sIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuQXV0aENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdXNpbmVzc1BhcnRuZXJDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVzaW5lc3NQYXJ0bmVyQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Pcmdhbml6YXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuT3JnYW5pemF0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNhbXB1c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYW1wdXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldhcmVob3VzZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5XYXJlaG91c2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxvY2F0aW9uQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Mb2NhdGlvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua0FjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtTdGF0ZW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FzaEFjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNhc2hBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNoYXJ0T2ZBY2NvdW50Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNoYXJ0T2ZBY2NvdW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DaGFydE9mQWNjb3VudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQ2hhcnRPZkFjY291bnRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXRlZ29yaWVzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DYXRlZ29yaWVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYXRlZ29yaWVzQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUHJvZHVjdHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd1N0YXR1c0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLldvcmtmbG93Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuTGV2ZWw0Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1JlY29uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuVHJhbnNhY3Rpb25SZWNvbkNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuVHJhbnNhY3Rpb25SZWNvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuVHJhbnNhY3Rpb25SZWNvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkludm9pY2VDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkludm9pY2VDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkludm9pY2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CaWxsQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CaWxsQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5CaWxsQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUGF5bWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUGF5bWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUGF5bWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNyZWRpdE5vdGVDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkNyZWRpdE5vdGVDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNyZWRpdE5vdGVDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5EZWJpdE5vdGVDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Kb3VybmFsRW50cnlDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5CdWRnZXRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuR2VuZXJhbExlZGdlckNsYWltcy5WaWV3Il0sImV4cCI6MTY0OTk1NzgyMiwiaXNzIjoiaHR0cDovL3dhbGVlZC5uZXQiLCJhdWQiOiJodHRwOi8vd2FsZWVkLm5ldCJ9.SiWm8tSAX4KksC-deeSLlHE3zZs7rZ6F0WCqYaJPRTc"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Auth/Users");


            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);


            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }
//
//
        @Test
        @Order(4)
        public void NWB_Put_Users_ById()
        {
            System.out.println("----------***** NWB_PUT_Users_ById *****----------");

            String APIBody = "{\"email\": \"ali@gmail.com\",\n" +
                    "  \"userName\": \"ali\",\n" +
                    "  \"userId\": \"79ceeaa0-5567-4a91-b859-a2c3f4f85ede\",\n" +
                    "  \"userRoles\": [\n" +
                    "    {\n" +
                    "      \"roleName\": \"SuperAdmin\",\n" +
                    "      \"selected\": true\n" +
                    "    }\n" +
                    "  ]}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Auth/Users/79ceeaa0-5567-4a91-b859-a2c3f4f85ede");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(5)
        public void NWB_Get_Users_ById()
        {
            System.out.println("----------***** NWB_GET_Users_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Auth/Users/79ceeaa0-5567-4a91-b859-a2c3f4f85ede");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(6)
        public void NWB_Post_Roles()
        {
            System.out.println("----------***** NWB_Post_Roles *****----------");


//            String APIBody = "{\"roleName\": \"Finance\",\n" +
//                    "  \"roleClaims\": [\n" +
//                    "    {\n" +
//                    "      \"type\": \"string\",\n" +
//                    "      \"value\": \"string\",\n" +
//                    "      \"selected\": true\n" +
//                    "    }\n" +
//                    "  ]}";

            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/auth/roles.json");


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Auth/Roles");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(7)
        public void NWB_Get_AllRoles()
        {
            System.out.println("----------***** NWB_Get_AllRoles *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Auth/Roles");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }

        @Test
        @Order(8)
        public void NWB_Get_Roles_ById()
        {
            System.out.println("----------***** NWB_Get_Roles_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Auth/Roles/7c2beedc-4b9a-4dd5-8d2b-da9ec5cc22ea");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(9)
        public void NWB_Put_Roles_ById()
        {
            System.out.println("----------***** NWB_Put_Roles_ById *****----------");


            String APIBody = "{\"roleName\": \"Tester\",\n" +
                    "  \"roleClaims\": [\n" +
                    "    {\n" +
                    "      \"type\": \"string\",\n" +
                    "      \"value\": \"string\",\n" +
                    "      \"selected\": true\n" +
                    "    }\n" +
                    "  ]}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Auth/Roles/7c2beedc-4b9a-4dd5-8d2b-da9ec5cc22ea");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(10)
        public void NWB_Get_AllRolesClaims()
        {
            System.out.println("----------***** NWB_Get_AllRolesClaims *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            headerlist.add(new Header("Authorization","bearer "+token));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Auth/Claims");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(11)
        public void NWB_Post_Campus()
        {
            System.out.println("----------***** NWB_Post_Campus *****----------");


//            String APIBody = "{\"name\": \"Campus 4\"}";

            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/profiling/campus.json");


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiTmF2ZWVkIiwiRW1haWwiOiJzdXBlcmFkbWluQHZpemFseXMuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiI2OTgxM2MyMy0xNmE3LTRhZmUtYmZlMy0wYjAyMWUzOTJhOGUiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsiQWRtaW4iLCJTdXBlckFkbWluIl0sIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuQXV0aENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdXNpbmVzc1BhcnRuZXJDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVzaW5lc3NQYXJ0bmVyQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Pcmdhbml6YXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuT3JnYW5pemF0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXNpZ25hdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVzaWduYXRpb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNhbXB1c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYW1wdXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldhcmVob3VzZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5XYXJlaG91c2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxvY2F0aW9uQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Mb2NhdGlvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua0FjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtTdGF0ZW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FzaEFjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNhc2hBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNhdGVnb3JpZXNDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZHVjdHNDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd1N0YXR1c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLldvcmtmbG93Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTGV2ZWw0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1JlY29uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5UcmFuc2FjdGlvblJlY29uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuSW52b2ljZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5QYXltZW50Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ3JlZGl0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZWJpdE5vdGVDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Kb3VybmFsRW50cnlDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdWRnZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlJlY2VpcHRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVxdWlzaXRpb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlJlcXVpc2l0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlB1cmNoYXNlT3JkZXJDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuR1JOQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkdSTkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuRXN0aW1hdGVkQnVkZ2V0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVzdGltYXRlZEJ1ZGdldENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DaGFydE9mQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuR2VuZXJhbExlZGdlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuVHJpYWxCYWxhbmNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYWxhbmNlU2hlZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlByb2ZpdExvc3NDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRW1wbG95ZWVDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQnVkZ2V0UmVwb3J0Q2xhaW1zLlZpZXciXSwiZXhwIjoxNjUyMzAxNjE4LCJpc3MiOiJodHRwOi8vd2FsZWVkLm5ldCIsImF1ZCI6Imh0dHA6Ly93YWxlZWQubmV0In0.cT1IhtQEO0f1AJFVUr4fBuiJ86TPIfjbZrMAxD1cBpI"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Campus");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(12)
        public void NWB_Get_Campus()
        {
            System.out.println("----------***** NWB_Get_Campus *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Campus");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(13)
        public void NWB_Get_Campus_ById()
        {
            System.out.println("----------***** NWB_Get_Campus_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Campus/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(14)
        public void NWB_Put_Campus_ById()
        {
            System.out.println("----------***** NWB_Put_Campus_ById *****----------");


            String APIBody = "{\"name\": \"Campus 1\",\n" +
                    "  \"id\": 2}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Campus/2");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(15)
        public void NWB_Post_Store()
        {
            System.out.println("----------***** NWB_Post_Store *****----------");


//            String APIBody = "{\n" +
//                    "    \"name\": \"Store 1\",\n" +
//                    "    \"manager\": \"Kashif\",\n" +
//                    "    \"campusId\": 1}";

            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/profiling/store.json");


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            headerlist.add(new Header("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiTmF2ZWVkIiwiRW1haWwiOiJzdXBlcmFkbWluQHZpemFseXMuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiI2OTgxM2MyMy0xNmE3LTRhZmUtYmZlMy0wYjAyMWUzOTJhOGUiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsiQWRtaW4iLCJTdXBlckFkbWluIl0sIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuQXV0aENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdXNpbmVzc1BhcnRuZXJDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVzaW5lc3NQYXJ0bmVyQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Pcmdhbml6YXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuT3JnYW5pemF0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXNpZ25hdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVzaWduYXRpb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNhbXB1c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYW1wdXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldhcmVob3VzZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5XYXJlaG91c2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxvY2F0aW9uQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Mb2NhdGlvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua0FjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtTdGF0ZW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FzaEFjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNhc2hBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNhdGVnb3JpZXNDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZHVjdHNDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd1N0YXR1c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLldvcmtmbG93Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTGV2ZWw0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1JlY29uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5UcmFuc2FjdGlvblJlY29uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuSW52b2ljZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5QYXltZW50Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ3JlZGl0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZWJpdE5vdGVDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Kb3VybmFsRW50cnlDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdWRnZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlJlY2VpcHRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVxdWlzaXRpb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlJlcXVpc2l0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlB1cmNoYXNlT3JkZXJDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuR1JOQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkdSTkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuRXN0aW1hdGVkQnVkZ2V0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVzdGltYXRlZEJ1ZGdldENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DaGFydE9mQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuR2VuZXJhbExlZGdlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuVHJpYWxCYWxhbmNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYWxhbmNlU2hlZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlByb2ZpdExvc3NDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRW1wbG95ZWVDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQnVkZ2V0UmVwb3J0Q2xhaW1zLlZpZXciXSwiZXhwIjoxNjUyMzAxNjE4LCJpc3MiOiJodHRwOi8vd2FsZWVkLm5ldCIsImF1ZCI6Imh0dHA6Ly93YWxlZWQubmV0In0.cT1IhtQEO0f1AJFVUr4fBuiJ86TPIfjbZrMAxD1cBpI "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            //headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Warehouse");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(16)
        public void NWB_Get_Store()
        {
            System.out.println("----------***** NWB_Get_Store *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Warehouse");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(17)
        public void NWB_Get_Store_ById()
        {
            System.out.println("----------***** NWB_Get_Store_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Warehouse/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(18)
        public void NWB_Put_Store_ById()
        {
            System.out.println("----------***** NWB_Put_Store_ById *****----------");


            String APIBody = "{ \"name\": \"Store 1\",\n" +
                    "    \"manager\": \"Kashif\",\n" +
                    "    \"campusId\": 1,\n" +
                    "    \"id\": 1}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Warehouse/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(19)
        public void NWB_Post_BusinessPartner()
        {
            System.out.println("----------***** NWB_Post_BusinessPartner *****----------");


//            String APIBody = "{\"businessPartnerType\": 4,\n" +
//                    "    \"name\": \"RA\",\n" +
//                    "    \"address\": \"E - 434\",\n" +
//                    "    \"phone\": \"0215895623\",\n" +
//                    "    \"mobile\": \"0334859566\",\n" +
//                    "    \"incomeTaxId\": \"02\",\n" +
//                    "    \"salesTaxId\": \"01\",\n" +
//                    "    \"bankAccountTitle\": \"RA\",\n" +
//                    "    \"bankAccountNumber\": \"426456553623654\",\n" +
//                    "    \"accountPayableId\": \"22140000-5566-7788-99aa-bbccddeeff00\",\n" +
//                    "    \"accountReceivableId\": \"12220000-5566-7788-99aa-bbccddeeff00\",\n" +
//                    "    \"cnic\": \"42259895665656\"}";

            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/profiling/businesspartner.json");


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiTmF2ZWVkIiwiRW1haWwiOiJzdXBlcmFkbWluQHZpemFseXMuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiI2OTgxM2MyMy0xNmE3LTRhZmUtYmZlMy0wYjAyMWUzOTJhOGUiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsiQWRtaW4iLCJTdXBlckFkbWluIl0sIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuQXV0aENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdXNpbmVzc1BhcnRuZXJDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVzaW5lc3NQYXJ0bmVyQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Pcmdhbml6YXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuT3JnYW5pemF0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXNpZ25hdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVzaWduYXRpb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNhbXB1c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYW1wdXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldhcmVob3VzZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5XYXJlaG91c2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxvY2F0aW9uQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Mb2NhdGlvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua0FjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtTdGF0ZW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FzaEFjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNhc2hBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNhdGVnb3JpZXNDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZHVjdHNDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd1N0YXR1c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLldvcmtmbG93Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTGV2ZWw0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1JlY29uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5UcmFuc2FjdGlvblJlY29uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuSW52b2ljZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5QYXltZW50Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ3JlZGl0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZWJpdE5vdGVDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Kb3VybmFsRW50cnlDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdWRnZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlJlY2VpcHRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVxdWlzaXRpb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlJlcXVpc2l0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlB1cmNoYXNlT3JkZXJDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuR1JOQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkdSTkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuRXN0aW1hdGVkQnVkZ2V0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVzdGltYXRlZEJ1ZGdldENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DaGFydE9mQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuR2VuZXJhbExlZGdlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuVHJpYWxCYWxhbmNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYWxhbmNlU2hlZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlByb2ZpdExvc3NDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRW1wbG95ZWVDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQnVkZ2V0UmVwb3J0Q2xhaW1zLlZpZXciXSwiZXhwIjoxNjUyMzAxNjE4LCJpc3MiOiJodHRwOi8vd2FsZWVkLm5ldCIsImF1ZCI6Imh0dHA6Ly93YWxlZWQubmV0In0.cT1IhtQEO0f1AJFVUr4fBuiJ86TPIfjbZrMAxD1cBpI"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/BusinessPartner");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }

        @Test
        @Order(62)
        public void NWB_Get_Budget()
        {
            System.out.println("----------***** NWB_Get_Budget *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Budget");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }

        @Test
        @Order(20)
        public void NWB_Get_BusinessPartner()
        {
            System.out.println("----------***** NWB_Get_BusinessPartner *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/BusinessPartner");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(21)
        public void NWB_Get_BusinessPartner_ById()
        {
            System.out.println("----------***** NWB_Get_BusinessPartner_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/BusinessPartner/2");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(22)
        public void NWB_Put_BusinessPartner_ById()
        {
            System.out.println("----------***** NWB_Put_BusinessPartner_ById *****----------");


            String APIBody = "{\"id\": 2,\n" +
                    "    \"businessPartnerType\": 4,\n" +
                    "    \"name\": \"Fim\",\n" +
                    "    \"address\": \"T - 4342\",\n" +
                    "    \"phone\": \"0215895623\",\n" +
                    "    \"mobile\": \"0334859566\",\n" +
                    "    \"incomeTaxId\": \"03\",\n" +
                    "    \"salesTaxId\": \"03\",\n" +
                    "    \"bankAccountTitle\": \"Fim\",\n" +
                    "    \"bankAccountNumber\": \"426456553623654\",\n" +
                    "    \"accountPayableId\": \"22140000-5566-7788-99aa-bbccddeeff00\",\n" +
                    "    \"accountReceivableId\": \"12220000-5566-7788-99aa-bbccddeeff00\",\n" +
                    "    \"cnic\": \"42259895665656\"}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/BusinessPartner/2");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(23)
        public void NWB_Post_Category()
        {
            System.out.println("----------***** NWB_Put_Category *****----------");


//            String APIBody = "{\"name\": \"Utensils\",\n" +
//                    "  \"inventoryAccountId\": \"51120000-5566-7788-99aa-bbccddeeff00\",\n" +
//                    "  \"revenueAccountId\": \"22210000-5566-7788-99aa-bbccddeeff00\",\n" +
//                    "  \"costAccountId\": \"41110000-5566-7788-99aa-bbccddeeff00\",\n" +
//                    "  \"id\": 0}";

            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/profiling/category.json");


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiTmF2ZWVkIiwiRW1haWwiOiJzdXBlcmFkbWluQHZpemFseXMuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiI2OTgxM2MyMy0xNmE3LTRhZmUtYmZlMy0wYjAyMWUzOTJhOGUiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsiQWRtaW4iLCJTdXBlckFkbWluIl0sIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuQXV0aENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdXNpbmVzc1BhcnRuZXJDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVzaW5lc3NQYXJ0bmVyQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Pcmdhbml6YXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuT3JnYW5pemF0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXNpZ25hdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVzaWduYXRpb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNhbXB1c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYW1wdXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldhcmVob3VzZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5XYXJlaG91c2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxvY2F0aW9uQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Mb2NhdGlvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua0FjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtTdGF0ZW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FzaEFjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNhc2hBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNhdGVnb3JpZXNDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZHVjdHNDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd1N0YXR1c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLldvcmtmbG93Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTGV2ZWw0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1JlY29uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5UcmFuc2FjdGlvblJlY29uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuSW52b2ljZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5QYXltZW50Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ3JlZGl0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZWJpdE5vdGVDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Kb3VybmFsRW50cnlDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdWRnZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlJlY2VpcHRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVxdWlzaXRpb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlJlcXVpc2l0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlB1cmNoYXNlT3JkZXJDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuR1JOQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkdSTkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuRXN0aW1hdGVkQnVkZ2V0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVzdGltYXRlZEJ1ZGdldENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DaGFydE9mQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuR2VuZXJhbExlZGdlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuVHJpYWxCYWxhbmNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYWxhbmNlU2hlZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlByb2ZpdExvc3NDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRW1wbG95ZWVDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQnVkZ2V0UmVwb3J0Q2xhaW1zLlZpZXciXSwiZXhwIjoxNjUyMzAxNjE4LCJpc3MiOiJodHRwOi8vd2FsZWVkLm5ldCIsImF1ZCI6Imh0dHA6Ly93YWxlZWQubmV0In0.cT1IhtQEO0f1AJFVUr4fBuiJ86TPIfjbZrMAxD1cBpI"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Category");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(24)
        public void NWB_Get_Category()
        {
            System.out.println("----------***** NWB_Get_Category *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Category");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(25)
        public void NWB_Get_Category_ById()
        {
            System.out.println("----------***** NWB_Get_Category_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Category/3");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(26)
        public void NWB_Put_Category_ById()
        {
            System.out.println("----------***** NWB_Put_Category_ById *****----------");


            String APIBody = "{\"name\": \"Utensil\",\n" +
                    "  \"inventoryAccountId\": \"51120000-5566-7788-99aa-bbccddeeff00\",\n" +
                    "  \"revenueAccountId\": \"22210000-5566-7788-99aa-bbccddeeff00\",\n" +
                    "  \"costAccountId\": \"41110000-5566-7788-99aa-bbccddeeff00\",\n" +
                    "  \"id\": 3}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Category/3");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(27)
        public void NWB_Post_Product()
        {
            System.out.println("----------***** NWB_Post_Product *****----------");


//            String APIBody = "{\"id\": 0,\n" +
//                    "    \"productName\": \"Juicers\",\n" +
//                    "    \"productType\": 0,\n" +
//                    "    \"categoryId\": 1,\n" +
//                    "    \"categoryName\": \"Electronics\",\n" +
//                    "    \"salesPrice\": \"12000.354\",\n" +
//                    "    \"purchasePrice\": \"11000.454\",\n" +
//                    "    \"salesTax\": \"5\",\n" +
//                    "    \"barcode\": \"abcd\"}";

            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/profiling/product.json");


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiTmF2ZWVkIiwiRW1haWwiOiJzdXBlcmFkbWluQHZpemFseXMuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiI2OTgxM2MyMy0xNmE3LTRhZmUtYmZlMy0wYjAyMWUzOTJhOGUiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsiQWRtaW4iLCJTdXBlckFkbWluIl0sIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuQXV0aENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdXNpbmVzc1BhcnRuZXJDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVzaW5lc3NQYXJ0bmVyQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Pcmdhbml6YXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuT3JnYW5pemF0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXNpZ25hdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVzaWduYXRpb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNhbXB1c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYW1wdXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldhcmVob3VzZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5XYXJlaG91c2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxvY2F0aW9uQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Mb2NhdGlvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua0FjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtTdGF0ZW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FzaEFjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNhc2hBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNhdGVnb3JpZXNDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZHVjdHNDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd1N0YXR1c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLldvcmtmbG93Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTGV2ZWw0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1JlY29uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5UcmFuc2FjdGlvblJlY29uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuSW52b2ljZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5QYXltZW50Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ3JlZGl0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZWJpdE5vdGVDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Kb3VybmFsRW50cnlDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdWRnZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlJlY2VpcHRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVxdWlzaXRpb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlJlcXVpc2l0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlB1cmNoYXNlT3JkZXJDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuR1JOQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkdSTkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuRXN0aW1hdGVkQnVkZ2V0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVzdGltYXRlZEJ1ZGdldENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DaGFydE9mQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuR2VuZXJhbExlZGdlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuVHJpYWxCYWxhbmNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYWxhbmNlU2hlZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlByb2ZpdExvc3NDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRW1wbG95ZWVDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQnVkZ2V0UmVwb3J0Q2xhaW1zLlZpZXciXSwiZXhwIjoxNjUyMzAxNjE4LCJpc3MiOiJodHRwOi8vd2FsZWVkLm5ldCIsImF1ZCI6Imh0dHA6Ly93YWxlZWQubmV0In0.cT1IhtQEO0f1AJFVUr4fBuiJ86TPIfjbZrMAxD1cBpI"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Product");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }

        @Test
        @Order(28)
        public void NWB_Get_Product()
        {
            System.out.println("----------***** NWB_Get_Product *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Product");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(29)
        public void NWB_Get_Product_ById()
        {
            System.out.println("----------***** NWB_Get_Product_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Product/2");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(30)
        public void NWB_Put_Product_ById()
        {
            System.out.println("----------***** NWB_Put_Product_ById *****----------");


            String APIBody = "{\"id\": 2,\n" +
                    "    \"productName\": \"Juicers\",\n" +
                    "    \"productType\": 0,\n" +
                    "    \"categoryId\": 1,\n" +
                    "    \"categoryName\": \"Electronics\",\n" +
                    "    \"salesPrice\": \"12000.354\",\n" +
                    "    \"purchasePrice\": \"11000.454\",\n" +
                    "    \"salesTax\": \"5\",\n" +
                    "    \"barcode\": \"abcd\"}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Product/2");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }

        //Finance Module
        @Test
        @Order(31)
        public void NWB_Post_CashAccount()
        {
            System.out.println("----------***** NWB_Post_CashAccount *****----------");


//            String APIBody = "{\"id\": 0,\n" +
//                    "  \"cashAccountName\": \"Cash Account 1\",\n" +
//                    "  \"handler\": \"Hasnain\",\n" +
//                    "  \"openingBalance\": 500.976,\n" +
//                    "  \"openingBalanceDate\": \"2022-04-07T09:28:31.266Z\",\n" +
//                    "  \"campusId\": 2}";

            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/finance/cashaccount.json");


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiTmF2ZWVkIiwiRW1haWwiOiJzdXBlcmFkbWluQHZpemFseXMuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiI2OTgxM2MyMy0xNmE3LTRhZmUtYmZlMy0wYjAyMWUzOTJhOGUiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsiQWRtaW4iLCJTdXBlckFkbWluIl0sIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuQXV0aENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdXNpbmVzc1BhcnRuZXJDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVzaW5lc3NQYXJ0bmVyQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Pcmdhbml6YXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuT3JnYW5pemF0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXNpZ25hdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVzaWduYXRpb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNhbXB1c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYW1wdXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldhcmVob3VzZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5XYXJlaG91c2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxvY2F0aW9uQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Mb2NhdGlvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua0FjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtTdGF0ZW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FzaEFjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNhc2hBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNhdGVnb3JpZXNDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZHVjdHNDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd1N0YXR1c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLldvcmtmbG93Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTGV2ZWw0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1JlY29uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5UcmFuc2FjdGlvblJlY29uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuSW52b2ljZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5QYXltZW50Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ3JlZGl0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZWJpdE5vdGVDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Kb3VybmFsRW50cnlDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdWRnZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlJlY2VpcHRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVxdWlzaXRpb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlJlcXVpc2l0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlB1cmNoYXNlT3JkZXJDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuR1JOQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkdSTkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuRXN0aW1hdGVkQnVkZ2V0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVzdGltYXRlZEJ1ZGdldENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DaGFydE9mQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuR2VuZXJhbExlZGdlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuVHJpYWxCYWxhbmNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYWxhbmNlU2hlZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlByb2ZpdExvc3NDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRW1wbG95ZWVDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQnVkZ2V0UmVwb3J0Q2xhaW1zLlZpZXciXSwiZXhwIjoxNjUyMzAxNjE4LCJpc3MiOiJodHRwOi8vd2FsZWVkLm5ldCIsImF1ZCI6Imh0dHA6Ly93YWxlZWQubmV0In0.cT1IhtQEO0f1AJFVUr4fBuiJ86TPIfjbZrMAxD1cBpI"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/CashAccount");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(32)
        public void NWB_Get_CashAccount()
        {
            System.out.println("----------***** NWB_Get_CashAccount *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/CashAccount");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(33)
        public void NWB_Get_CashAccount_ById()
        {
            System.out.println("----------***** NWB_Get_CashAccount_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/CashAccount/4");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(34)
        public void NWB_Put_CashAccount_ById()
        {
            System.out.println("----------***** NWB_Put_CashAccount_ById *****----------");


            String APIBody = "{\"cashAccountName\": \"Cash Account 2\",\n" +
                    "  \"id\": 4,\n" +
                    "  \"handler\": \"Hasnain\"}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/CashAccount/4");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(35)
        public void NWB_Post_BankAccount()
        {
            System.out.println("----------***** NWB_Post_BankAccount *****----------");


//            String APIBody = "{\"accountNumber\": 43410969230,\n" +
//                    "  \"accountTitle\": \"Rizwan\",\n" +
//                    "  \"bankName\": \"MCB\",\n" +
//                    "  \"campusId\": 2,\n" +
//                    "  \"openingBalance\": 700.507,\n" +
//                    "  \"openingBalanceDate\": \"2008-03-27T10:12:24.815Z\",\n" +
//                    "  \"id\": 0,\n" +
//                    "  \"branch\": \"SMCH\"}";

            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/finance/bankaccount.json");


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiTmF2ZWVkIiwiRW1haWwiOiJzdXBlcmFkbWluQHZpemFseXMuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiI2OTgxM2MyMy0xNmE3LTRhZmUtYmZlMy0wYjAyMWUzOTJhOGUiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsiQWRtaW4iLCJTdXBlckFkbWluIl0sIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuQXV0aENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdXNpbmVzc1BhcnRuZXJDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVzaW5lc3NQYXJ0bmVyQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Pcmdhbml6YXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuT3JnYW5pemF0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXNpZ25hdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVzaWduYXRpb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNhbXB1c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYW1wdXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldhcmVob3VzZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5XYXJlaG91c2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxvY2F0aW9uQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Mb2NhdGlvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua0FjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtTdGF0ZW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FzaEFjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNhc2hBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNhdGVnb3JpZXNDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZHVjdHNDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd1N0YXR1c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLldvcmtmbG93Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTGV2ZWw0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1JlY29uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5UcmFuc2FjdGlvblJlY29uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuSW52b2ljZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5QYXltZW50Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ3JlZGl0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZWJpdE5vdGVDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Kb3VybmFsRW50cnlDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdWRnZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlJlY2VpcHRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVxdWlzaXRpb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlJlcXVpc2l0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlB1cmNoYXNlT3JkZXJDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuR1JOQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkdSTkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuRXN0aW1hdGVkQnVkZ2V0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVzdGltYXRlZEJ1ZGdldENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DaGFydE9mQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuR2VuZXJhbExlZGdlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuVHJpYWxCYWxhbmNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYWxhbmNlU2hlZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlByb2ZpdExvc3NDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRW1wbG95ZWVDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQnVkZ2V0UmVwb3J0Q2xhaW1zLlZpZXciXSwiZXhwIjoxNjUyMzAxNjE4LCJpc3MiOiJodHRwOi8vd2FsZWVkLm5ldCIsImF1ZCI6Imh0dHA6Ly93YWxlZWQubmV0In0.cT1IhtQEO0f1AJFVUr4fBuiJ86TPIfjbZrMAxD1cBpI"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/BankAccount");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(36)
        public void NWB_Get_BankAccount()
        {
            System.out.println("----------***** NWB_Get_BankAccount *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/BankAccount");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(37)
        public void NWB_Get_BankAccount_ById()
        {
            System.out.println("----------***** NWB_Get_BankAccount_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/BankAccount/2");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(38)
        public void NWB_Put_BankAccount_ById()
        {
            System.out.println("----------***** NWB_Put_BankAccount_ById *****----------");


            String APIBody = "{\"id\": 2,\n" +
                    "  \"accountNumber\": 46465664464654645,\n" +
                    "  \"accountTitle\": \"Hamza\",\n" +
                    "  \"bankName\": \"HBL\",\n" +
                    "  \"branch\": \"SMCH\"}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/BankAccount/2");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(39)
        public void NWB_Post_Payment()
        {
            System.out.println("----------***** NWB_Post_Payment *****----------");


//            String APIBody = "{\"paymentRegisterType\": 2,\n" +
//                    "    \"paymentType\": 1,\n" +
//                    "    \"businessPartnerId\": 1,\n" +
//                    "    \"accountId\": \"52130000-5566-7788-99aa-bbccddeeff00\",\n" +
//                    "    \"paymentDate\": \"2022-04-15\",\n" +
//                    "    \"paymentRegisterId\": \"fc07447b-733f-4661-c0de-08da1ea52f76\",\n" +
//                    "    \"campusId\": 1,\n" +
//                    "    \"description\": \"abc\",\n" +
//                    "    \"grossPayment\": \"1160.365\",\n" +
//                    "    \"discount\": \"10\",\n" +
//                    "    \"salesTax\": \"5\",\n" +
//                    "    \"incomeTax\": \"5\",\n" +
//                    "    \"srbTax\": \"5\",\n" +
//                    "    \"isSubmit\": true}";

            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/finance/payment.json");


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiTmF2ZWVkIiwiRW1haWwiOiJzdXBlcmFkbWluQHZpemFseXMuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiI2OTgxM2MyMy0xNmE3LTRhZmUtYmZlMy0wYjAyMWUzOTJhOGUiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsiQWRtaW4iLCJTdXBlckFkbWluIl0sIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuQXV0aENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdXNpbmVzc1BhcnRuZXJDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVzaW5lc3NQYXJ0bmVyQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Pcmdhbml6YXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuT3JnYW5pemF0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXNpZ25hdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVzaWduYXRpb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNhbXB1c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYW1wdXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldhcmVob3VzZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5XYXJlaG91c2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxvY2F0aW9uQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Mb2NhdGlvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua0FjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtTdGF0ZW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FzaEFjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNhc2hBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNhdGVnb3JpZXNDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZHVjdHNDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd1N0YXR1c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLldvcmtmbG93Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTGV2ZWw0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1JlY29uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5UcmFuc2FjdGlvblJlY29uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuSW52b2ljZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5QYXltZW50Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ3JlZGl0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZWJpdE5vdGVDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Kb3VybmFsRW50cnlDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdWRnZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlJlY2VpcHRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVxdWlzaXRpb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlJlcXVpc2l0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlB1cmNoYXNlT3JkZXJDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuR1JOQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkdSTkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuRXN0aW1hdGVkQnVkZ2V0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVzdGltYXRlZEJ1ZGdldENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DaGFydE9mQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuR2VuZXJhbExlZGdlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuVHJpYWxCYWxhbmNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYWxhbmNlU2hlZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlByb2ZpdExvc3NDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRW1wbG95ZWVDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQnVkZ2V0UmVwb3J0Q2xhaW1zLlZpZXciXSwiZXhwIjoxNjUyMzAxNjE4LCJpc3MiOiJodHRwOi8vd2FsZWVkLm5ldCIsImF1ZCI6Imh0dHA6Ly93YWxlZWQubmV0In0.cT1IhtQEO0f1AJFVUr4fBuiJ86TPIfjbZrMAxD1cBpI"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Payment");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(40)
        public void NWB_Get_Payment()
        {
            System.out.println("----------***** NWB_Get_Payment *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Payment");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(41)
        public void NWB_Get_Payment_ById()
        {
            System.out.println("----------***** NWB_Get_Payment_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Payment/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(42)
        public void NWB_Post_Journal()
        {
            System.out.println("----------***** NWB_Post_Journal *****----------");


//            String APIBody = "{\"date\": \"2022-04-15\",\n" +
//                    "    \"description\": \"abc\",\n" +
//                    "    \"campusId\": 2,\n" +
//                    "    \"journalEntryLines\": [\n" +
//                    "        {\n" +
//                    "            \"accountId\": \"41110000-5566-7788-99aa-bbccddeeff00\",\n" +
//                    "            \"businessPartnerId\": 2,\n" +
//                    "            \"description\": \"ggg\",\n" +
//                    "            \"debit\": \"550.569\",\n" +
//                    "            \"warehouseId\": 1\n" +
//                    "        },\n" +
//                    "        {\n" +
//                    "            \"accountId\": \"41110000-5566-7788-99aa-bbccddeeff00\",\n" +
//                    "            \"businessPartnerId\": 2,\n" +
//                    "            \"description\": \"ggg\",\n" +
//                    "            \"credit\": \"550.569\",\n" +
//                    "            \"warehouseId\": 1\n" +
//                    "        }\n" +
//                    "    ],\n" +
//                    "    \"isSubmit\": true}";


            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/finance/journalentry.json");

            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiTmF2ZWVkIiwiRW1haWwiOiJzdXBlcmFkbWluQHZpemFseXMuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiI2OTgxM2MyMy0xNmE3LTRhZmUtYmZlMy0wYjAyMWUzOTJhOGUiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsiQWRtaW4iLCJTdXBlckFkbWluIl0sIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuQXV0aENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdXNpbmVzc1BhcnRuZXJDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVzaW5lc3NQYXJ0bmVyQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Pcmdhbml6YXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuT3JnYW5pemF0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXNpZ25hdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVzaWduYXRpb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNhbXB1c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYW1wdXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldhcmVob3VzZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5XYXJlaG91c2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxvY2F0aW9uQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Mb2NhdGlvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua0FjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtTdGF0ZW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FzaEFjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNhc2hBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNhdGVnb3JpZXNDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZHVjdHNDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd1N0YXR1c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLldvcmtmbG93Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTGV2ZWw0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1JlY29uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5UcmFuc2FjdGlvblJlY29uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuSW52b2ljZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5QYXltZW50Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ3JlZGl0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZWJpdE5vdGVDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Kb3VybmFsRW50cnlDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdWRnZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlJlY2VpcHRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVxdWlzaXRpb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlJlcXVpc2l0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlB1cmNoYXNlT3JkZXJDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuR1JOQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkdSTkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuRXN0aW1hdGVkQnVkZ2V0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVzdGltYXRlZEJ1ZGdldENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DaGFydE9mQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuR2VuZXJhbExlZGdlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuVHJpYWxCYWxhbmNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYWxhbmNlU2hlZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlByb2ZpdExvc3NDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRW1wbG95ZWVDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQnVkZ2V0UmVwb3J0Q2xhaW1zLlZpZXciXSwiZXhwIjoxNjUyNDc2MTUwLCJpc3MiOiJodHRwOi8vd2FsZWVkLm5ldCIsImF1ZCI6Imh0dHA6Ly93YWxlZWQubmV0In0.JAAx3pr7IH4n4URqvR9O2dVUavuS-ounZf_oSilHkoo"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/JournalEntry");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(43)
        public void NWB_Get_Journal()
        {
            System.out.println("----------***** NWB_Get_Journal *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/JournalEntry");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(44)
        public void NWB_Get_Journal_ById()
        {
            System.out.println("----------***** NWB_Get_Journal_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/JournalEntry/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(45)
        public void NWB_Post_Invoice()
        {
            System.out.println("----------***** NWB_Post_Invoice *****----------");


//            String APIBody = "{ \"customerId\": 2,\n" +
//                    "    \"invoiceDate\": \"2022-04-15\",\n" +
//                    "    \"campusId\": 2,\n" +
//                    "    \"contact\": \"\",\n" +
//                    "    \"dueDate\": \"2022-04-16\",\n" +
//                    "    \"invoiceLines\": [\n" +
//                    "        {\n" +
//                    "            \"itemId\": 1,\n" +
//                    "            \"description\": \"ttt\",\n" +
//                    "            \"price\": 11000.35,\n" +
//                    "            \"quantity\": \"2\",\n" +
//                    "            \"tax\": 5,\n" +
//                    "            \"accountId\": \"22140000-5566-7788-99aa-bbccddeeff00\",\n" +
//                    "            \"warehouseId\": 1\n" +
//                    "        }\n" +
//                    "    ],\n" +
//                    "    \"isSubmit\": true}";

            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/finance/invoice.json");

            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiTmF2ZWVkIiwiRW1haWwiOiJzdXBlcmFkbWluQHZpemFseXMuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiI2OTgxM2MyMy0xNmE3LTRhZmUtYmZlMy0wYjAyMWUzOTJhOGUiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsiQWRtaW4iLCJTdXBlckFkbWluIl0sIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuQXV0aENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdXNpbmVzc1BhcnRuZXJDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVzaW5lc3NQYXJ0bmVyQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Pcmdhbml6YXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuT3JnYW5pemF0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXNpZ25hdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVzaWduYXRpb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNhbXB1c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYW1wdXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldhcmVob3VzZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5XYXJlaG91c2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxvY2F0aW9uQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Mb2NhdGlvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua0FjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtTdGF0ZW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FzaEFjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNhc2hBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNhdGVnb3JpZXNDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZHVjdHNDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd1N0YXR1c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLldvcmtmbG93Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTGV2ZWw0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1JlY29uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5UcmFuc2FjdGlvblJlY29uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuSW52b2ljZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5QYXltZW50Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ3JlZGl0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZWJpdE5vdGVDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Kb3VybmFsRW50cnlDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdWRnZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlJlY2VpcHRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVxdWlzaXRpb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlJlcXVpc2l0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlB1cmNoYXNlT3JkZXJDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuR1JOQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkdSTkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuRXN0aW1hdGVkQnVkZ2V0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVzdGltYXRlZEJ1ZGdldENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DaGFydE9mQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuR2VuZXJhbExlZGdlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuVHJpYWxCYWxhbmNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYWxhbmNlU2hlZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlByb2ZpdExvc3NDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRW1wbG95ZWVDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQnVkZ2V0UmVwb3J0Q2xhaW1zLlZpZXciXSwiZXhwIjoxNjUyNDc2MTUwLCJpc3MiOiJodHRwOi8vd2FsZWVkLm5ldCIsImF1ZCI6Imh0dHA6Ly93YWxlZWQubmV0In0.JAAx3pr7IH4n4URqvR9O2dVUavuS-ounZf_oSilHkoo"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Invoice");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(46)
        public void NWB_Get_Invoice()
        {
            System.out.println("----------***** NWB_Get_Invoice *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Invoice");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(47)
        public void NWB_Get_Invoice_ById()
        {
            System.out.println("----------***** NWB_Get_Invoice_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Invoice/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(48)
        public void NWB_Post_CreditNote()
        {
            System.out.println("----------***** NWB_Post_CreditNote *****----------");


//            String APIBody = "{ \"customerId\": 2,\n" +
//                    "    \"noteDate\": \"2022-04-15\",\n" +
//                    "    \"campusId\": 2,\n" +
//                    "    \"creditNoteLines\": [\n" +
//                    "        {\n" +
//                    "            \"itemId\": 1,\n" +
//                    "            \"description\": \"www\",\n" +
//                    "            \"price\": \"1400.436\",\n" +
//                    "            \"quantity\": \"2\",\n" +
//                    "            \"tax\": 5,\n" +
//                    "            \"accountId\": \"11120000-5566-7788-99aa-bbccddeeff00\",\n" +
//                    "            \"warehouseId\": 1\n" +
//                    "        }\n" +
//                    "    ],\n" +
//                    "    \"isSubmit\": true}";

            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/finance/creditnote.json");


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiTmF2ZWVkIiwiRW1haWwiOiJzdXBlcmFkbWluQHZpemFseXMuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiI2OTgxM2MyMy0xNmE3LTRhZmUtYmZlMy0wYjAyMWUzOTJhOGUiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsiQWRtaW4iLCJTdXBlckFkbWluIl0sIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuQXV0aENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdXNpbmVzc1BhcnRuZXJDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVzaW5lc3NQYXJ0bmVyQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Pcmdhbml6YXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuT3JnYW5pemF0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXNpZ25hdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVzaWduYXRpb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNhbXB1c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYW1wdXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldhcmVob3VzZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5XYXJlaG91c2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxvY2F0aW9uQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Mb2NhdGlvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua0FjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtTdGF0ZW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FzaEFjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNhc2hBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNhdGVnb3JpZXNDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZHVjdHNDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd1N0YXR1c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLldvcmtmbG93Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTGV2ZWw0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1JlY29uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5UcmFuc2FjdGlvblJlY29uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuSW52b2ljZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5QYXltZW50Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ3JlZGl0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZWJpdE5vdGVDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Kb3VybmFsRW50cnlDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdWRnZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlJlY2VpcHRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVxdWlzaXRpb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlJlcXVpc2l0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlB1cmNoYXNlT3JkZXJDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuR1JOQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkdSTkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuRXN0aW1hdGVkQnVkZ2V0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVzdGltYXRlZEJ1ZGdldENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DaGFydE9mQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuR2VuZXJhbExlZGdlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuVHJpYWxCYWxhbmNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYWxhbmNlU2hlZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlByb2ZpdExvc3NDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRW1wbG95ZWVDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQnVkZ2V0UmVwb3J0Q2xhaW1zLlZpZXciXSwiZXhwIjoxNjUyNDc2MTUwLCJpc3MiOiJodHRwOi8vd2FsZWVkLm5ldCIsImF1ZCI6Imh0dHA6Ly93YWxlZWQubmV0In0.JAAx3pr7IH4n4URqvR9O2dVUavuS-ounZf_oSilHkoo"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/CreditNote");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(49)
        public void NWB_Get_CreditNote()
        {
            System.out.println("----------***** NWB_Get_CreditNote *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/CreditNote");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(50)
        public void NWB_Get_CreditNote_ById()
        {
            System.out.println("----------***** NWB_Get_CreditNote_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/CreditNote/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(51)
        public void NWB_Post_VendorBill()
        {
            System.out.println("----------***** NWB_Post_VendorBill *****----------");


//            String APIBody = "{ \"vendorId\": 2,\n" +
//                    "    \"billDate\": \"2022-04-17T19:00:00.000Z\",\n" +
//                    "    \"dueDate\": \"2022-04-18T19:00:00.000Z\",\n" +
//                    "    \"campusId\": 3,\n" +
//                    "    \"billLines\": [\n" +
//                    "        {\n" +
//                    "            \"itemId\": 2,\n" +
//                    "            \"description\": \"sss\",\n" +
//                    "            \"cost\": 1200.45,\n" +
//                    "            \"quantity\": \"2\",\n" +
//                    "            \"tax\": 5,\n" +
//                    "            \"anyOtherTax\": \"2\",\n" +
//                    "            \"accountId\": \"11130000-5566-7788-99aa-bbccddeeff00\",\n" +
//                    "            \"warehouseId\": 1\n" +
//                    "        },\n" +
//                    "        {\n" +
//                    "            \"itemId\": 1,\n" +
//                    "            \"description\": \"sss\",\n" +
//                    "            \"cost\": 1300.45,\n" +
//                    "            \"quantity\": \"2\",\n" +
//                    "            \"tax\": 5,\n" +
//                    "            \"anyOtherTax\": \"2\",\n" +
//                    "            \"accountId\": \"52130000-5566-7788-99aa-bbccddeeff00\",\n" +
//                    "            \"warehouseId\": 2\n" +
//                    "        }\n" +
//                    "    ],\n" +
//                    "    \"isSubmit\": true}";

            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/finance/vendorbill.json");


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiTmF2ZWVkIiwiRW1haWwiOiJzdXBlcmFkbWluQHZpemFseXMuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiI2OTgxM2MyMy0xNmE3LTRhZmUtYmZlMy0wYjAyMWUzOTJhOGUiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsiQWRtaW4iLCJTdXBlckFkbWluIl0sIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuQXV0aENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdXNpbmVzc1BhcnRuZXJDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVzaW5lc3NQYXJ0bmVyQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Pcmdhbml6YXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuT3JnYW5pemF0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXNpZ25hdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVzaWduYXRpb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNhbXB1c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYW1wdXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldhcmVob3VzZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5XYXJlaG91c2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxvY2F0aW9uQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Mb2NhdGlvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua0FjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtTdGF0ZW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FzaEFjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNhc2hBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNhdGVnb3JpZXNDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZHVjdHNDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd1N0YXR1c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLldvcmtmbG93Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTGV2ZWw0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1JlY29uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5UcmFuc2FjdGlvblJlY29uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuSW52b2ljZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5QYXltZW50Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ3JlZGl0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZWJpdE5vdGVDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Kb3VybmFsRW50cnlDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdWRnZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlJlY2VpcHRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVxdWlzaXRpb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlJlcXVpc2l0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlB1cmNoYXNlT3JkZXJDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuR1JOQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkdSTkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuRXN0aW1hdGVkQnVkZ2V0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVzdGltYXRlZEJ1ZGdldENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DaGFydE9mQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuR2VuZXJhbExlZGdlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuVHJpYWxCYWxhbmNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYWxhbmNlU2hlZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlByb2ZpdExvc3NDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRW1wbG95ZWVDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQnVkZ2V0UmVwb3J0Q2xhaW1zLlZpZXciXSwiZXhwIjoxNjUyNDc2MTUwLCJpc3MiOiJodHRwOi8vd2FsZWVkLm5ldCIsImF1ZCI6Imh0dHA6Ly93YWxlZWQubmV0In0.JAAx3pr7IH4n4URqvR9O2dVUavuS-ounZf_oSilHkoo"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Bill");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(52)
        public void NWB_Get_VendorBill()
        {
            System.out.println("----------***** NWB_Get_VendorBill *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Bill");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(53)
        public void NWB_Get_VendorBill_ById()
        {
            System.out.println("----------***** NWB_Get_VendorBill_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Bill/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(54)
        public void NWB_Post_DebitNote()
        {
            System.out.println("----------***** NWB_Post_DebitNote *****----------");


//            String APIBody = "{\"vendorId\": 1,\n" +
//                    "    \"noteDate\": \"2022-04-18\",\n" +
//                    "    \"campusId\": 2,\n" +
//                    "    \"debitNoteLines\": [\n" +
//                    "        {\n" +
//                    "            \"itemId\": 1,\n" +
//                    "            \"description\": \"ddd\",\n" +
//                    "            \"cost\": \"650.346\",\n" +
//                    "            \"quantity\": \"2\",\n" +
//                    "            \"tax\": \"2\",\n" +
//                    "            \"accountId\": \"52110000-5566-7788-99aa-bbccddeeff00\",\n" +
//                    "            \"warehouseId\": 1\n" +
//                    "        },\n" +
//                    "        {\n" +
//                    "            \"itemId\": 1,\n" +
//                    "            \"description\": \"ddd\",\n" +
//                    "            \"cost\": \"850.347\",\n" +
//                    "            \"quantity\": \"2\",\n" +
//                    "            \"tax\": \"2\",\n" +
//                    "            \"accountId\": \"52160000-5566-7788-99aa-bbccddeeff00\",\n" +
//                    "            \"warehouseId\": 1\n" +
//                    "        }\n" +
//                    "    ],\n" +
//                    "    \"isSubmit\": true}";

            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/finance/debitnote.json");


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiTmF2ZWVkIiwiRW1haWwiOiJzdXBlcmFkbWluQHZpemFseXMuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiI2OTgxM2MyMy0xNmE3LTRhZmUtYmZlMy0wYjAyMWUzOTJhOGUiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsiQWRtaW4iLCJTdXBlckFkbWluIl0sIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuQXV0aENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdXNpbmVzc1BhcnRuZXJDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVzaW5lc3NQYXJ0bmVyQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Pcmdhbml6YXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuT3JnYW5pemF0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXNpZ25hdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVzaWduYXRpb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNhbXB1c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYW1wdXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldhcmVob3VzZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5XYXJlaG91c2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxvY2F0aW9uQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Mb2NhdGlvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua0FjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtTdGF0ZW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FzaEFjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNhc2hBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNhdGVnb3JpZXNDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZHVjdHNDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd1N0YXR1c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLldvcmtmbG93Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTGV2ZWw0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1JlY29uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5UcmFuc2FjdGlvblJlY29uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuSW52b2ljZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5QYXltZW50Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ3JlZGl0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZWJpdE5vdGVDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Kb3VybmFsRW50cnlDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdWRnZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlJlY2VpcHRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVxdWlzaXRpb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlJlcXVpc2l0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlB1cmNoYXNlT3JkZXJDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuR1JOQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkdSTkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuRXN0aW1hdGVkQnVkZ2V0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVzdGltYXRlZEJ1ZGdldENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DaGFydE9mQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuR2VuZXJhbExlZGdlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuVHJpYWxCYWxhbmNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYWxhbmNlU2hlZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlByb2ZpdExvc3NDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRW1wbG95ZWVDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQnVkZ2V0UmVwb3J0Q2xhaW1zLlZpZXciXSwiZXhwIjoxNjUyNDc2MTUwLCJpc3MiOiJodHRwOi8vd2FsZWVkLm5ldCIsImF1ZCI6Imh0dHA6Ly93YWxlZWQubmV0In0.JAAx3pr7IH4n4URqvR9O2dVUavuS-ounZf_oSilHkoo"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/DebitNote");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(55)
        public void NWB_Get_DebitNote()
        {
            System.out.println("----------***** NWB_Get_DebitNote *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/DebitNote");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(56)
        public void NWB_Get_DebitNote_ById()
        {
            System.out.println("----------***** NWB_Get_DebitNote_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/DebitNote/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }

        //This API is not Working from the Backend
        @Test
        @Order(57)
        public void NWB_Post_BankStatement()
        {
            System.out.println("----------***** NWB_Post_BankStatement *****----------");


//            String APIBody = "{\"bankAccountId\": 1,\n" +
//                    "    \"description\": \"ttt\",\n" +
//                    "    \"openingBalance\": 500.356,\n" +
//                    "    \"bankStmtLines\": [\n" +
//                    "        {\n" +
//                    "            \"id\": 0,\n" +
//                    "            \"reference\": 1,\n" +
//                    "            \"stmtDate\": \"2022-04-17T19:00:00.000Z\",\n" +
//                    "            \"label\": \"Label 1\",\n" +
//                    "            \"debit\": 700.856,\n" +
//                    "            \"credit\": 0\n" +
//                    "        },\n" +
//                    "        {\n" +
//                    "            \"id\": 0,\n" +
//                    "            \"reference\": 2,\n" +
//                    "            \"stmtDate\": \"2022-04-17T19:00:00.000Z\",\n" +
//                    "            \"label\": \"Label 2\",\n" +
//                    "            \"credit\": 801.456,\n" +
//                    "            \"debit\": 0\n" +
//                    "        }\n" +
//                    "    ]}";

            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/finance/bankstatement.json");


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiTmF2ZWVkIiwiRW1haWwiOiJzdXBlcmFkbWluQHZpemFseXMuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiI2OTgxM2MyMy0xNmE3LTRhZmUtYmZlMy0wYjAyMWUzOTJhOGUiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsiQWRtaW4iLCJTdXBlckFkbWluIl0sIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuQXV0aENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdXNpbmVzc1BhcnRuZXJDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVzaW5lc3NQYXJ0bmVyQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Pcmdhbml6YXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuT3JnYW5pemF0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXNpZ25hdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVzaWduYXRpb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNhbXB1c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYW1wdXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldhcmVob3VzZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5XYXJlaG91c2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxvY2F0aW9uQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Mb2NhdGlvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua0FjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtTdGF0ZW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FzaEFjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNhc2hBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNhdGVnb3JpZXNDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZHVjdHNDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd1N0YXR1c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLldvcmtmbG93Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTGV2ZWw0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1JlY29uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5UcmFuc2FjdGlvblJlY29uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuSW52b2ljZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5QYXltZW50Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ3JlZGl0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZWJpdE5vdGVDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Kb3VybmFsRW50cnlDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdWRnZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlJlY2VpcHRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVxdWlzaXRpb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlJlcXVpc2l0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlB1cmNoYXNlT3JkZXJDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuR1JOQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkdSTkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuRXN0aW1hdGVkQnVkZ2V0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVzdGltYXRlZEJ1ZGdldENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DaGFydE9mQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuR2VuZXJhbExlZGdlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuVHJpYWxCYWxhbmNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYWxhbmNlU2hlZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlByb2ZpdExvc3NDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRW1wbG95ZWVDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQnVkZ2V0UmVwb3J0Q2xhaW1zLlZpZXciXSwiZXhwIjoxNjUyNDc2MTUwLCJpc3MiOiJodHRwOi8vd2FsZWVkLm5ldCIsImF1ZCI6Imh0dHA6Ly93YWxlZWQubmV0In0.JAAx3pr7IH4n4URqvR9O2dVUavuS-ounZf_oSilHkoo"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/BankStmt");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(58)
        public void NWB_Get_BankStatement()
        {
            System.out.println("----------***** NWB_Get_BankStatement *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/BankStmt");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(59)
        public void NWB_Get_BankStatement_ById()
        {
            System.out.println("----------***** NWB_Get_BankStatement_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/BankStmt/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(60)
        public void NWB_Put_BankStatement_ById()
        {
            System.out.println("----------***** NWB_Get_BankStatement_ById *****----------");


            String APIBody = "{ \"id\": 5,\n" +
                    "    \"bankAccountId\": 2,\n" +
                    "    \"description\": \"ttt\",\n" +
                    "    \"openingBalance\": 500.356,\n" +
                    "    \"bankStmtLines\": [\n" +
                    "        {\n" +
                    "            \"id\": 0,\n" +
                    "            \"reference\": 1,\n" +
                    "            \"stmtDate\": \"2022-04-17T19:00:00.000Z\",\n" +
                    "            \"label\": \"Label 1\",\n" +
                    "            \"debit\": 750.856,\n" +
                    "            \"credit\": 0\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"id\": 0,\n" +
                    "            \"reference\": 2,\n" +
                    "            \"stmtDate\": \"2022-04-17T19:00:00.000Z\",\n" +
                    "            \"label\": \"Label 2\",\n" +
                    "            \"credit\": 806.456,\n" +
                    "            \"debit\": 0\n" +
                    "        }\n" +
                    "    ]}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/BankStmt/5");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(61)
        public void NWB_Post_Budget()
        {
            System.out.println("----------***** NWB_Post_Budget *****----------");


//            String APIBody = "{ \"budgetName\": \"Budget 4\",\n" +
//                    "    \"from\": \"2022-04-18\",\n" +
//                    "    \"to\": \"2022-04-19\",\n" +
//                    "    \"budgetLines\": [\n" +
//                    "        {\n" +
//                    "            \"accountId\": \"e188bb29-195a-4d8d-c0dd-08da1ea52f76\",\n" +
//                    "            \"amount\": \"1750.876\"\n" +
//                    "        },\n" +
//                    "        {\n" +
//                    "            \"accountId\": \"11120000-5566-7788-99aa-bbccddeeff00\",\n" +
//                    "            \"amount\": \"2200.675\"\n" +
//                    "        }\n" +
//                    "    ]}";

            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/budget/budget.json");


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiTmF2ZWVkIiwiRW1haWwiOiJzdXBlcmFkbWluQHZpemFseXMuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiI2OTgxM2MyMy0xNmE3LTRhZmUtYmZlMy0wYjAyMWUzOTJhOGUiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsiQWRtaW4iLCJTdXBlckFkbWluIl0sIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuQXV0aENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdXNpbmVzc1BhcnRuZXJDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVzaW5lc3NQYXJ0bmVyQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Pcmdhbml6YXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuT3JnYW5pemF0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXNpZ25hdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVzaWduYXRpb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNhbXB1c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYW1wdXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldhcmVob3VzZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5XYXJlaG91c2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxvY2F0aW9uQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Mb2NhdGlvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua0FjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtTdGF0ZW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FzaEFjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNhc2hBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNhdGVnb3JpZXNDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZHVjdHNDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd1N0YXR1c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLldvcmtmbG93Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTGV2ZWw0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1JlY29uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5UcmFuc2FjdGlvblJlY29uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuSW52b2ljZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5QYXltZW50Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ3JlZGl0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZWJpdE5vdGVDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Kb3VybmFsRW50cnlDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdWRnZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlJlY2VpcHRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVxdWlzaXRpb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlJlcXVpc2l0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlB1cmNoYXNlT3JkZXJDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuR1JOQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkdSTkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuRXN0aW1hdGVkQnVkZ2V0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVzdGltYXRlZEJ1ZGdldENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DaGFydE9mQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuR2VuZXJhbExlZGdlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuVHJpYWxCYWxhbmNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYWxhbmNlU2hlZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlByb2ZpdExvc3NDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRW1wbG95ZWVDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQnVkZ2V0UmVwb3J0Q2xhaW1zLlZpZXciXSwiZXhwIjoxNjUyNDc2MTUwLCJpc3MiOiJodHRwOi8vd2FsZWVkLm5ldCIsImF1ZCI6Imh0dHA6Ly93YWxlZWQubmV0In0.JAAx3pr7IH4n4URqvR9O2dVUavuS-ounZf_oSilHkoo"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Budget");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }





        @Test
        @Order(63)
        public void NWB_Get_Budget_ById()
        {
            System.out.println("----------***** NWB_Get_Budget_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Budget/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }

        //Issue(Updating Multiple Lines of Entries on Front End)
        @Test
        @Order(64)
        public void NWB_Put_Budget_ById()
        {
            System.out.println("----------***** NWB_Put_Budget_ById *****----------");


            String APIBody = "{ \"id\": 3,\n" +
                    "    \"budgetName\": \"Budget 4\",\n" +
                    "    \"from\": \"2022-04-19\",\n" +
                    "    \"to\": \"2022-04-20\",\n" +
                    "    \"budgetLines\": [\n" +
                    "        {\n" +
                    "            \"accountId\": \"e188bb29-195a-4d8d-c0dd-08da1ea52f76\",\n" +
                    "            \"amount\": \"1750.876\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"accountId\": \"11120000-5566-7788-99aa-bbccddeeff00\",\n" +
                    "            \"amount\": \"2200.675\"\n" +
                    "        }\n" +
                    "    ]}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Budget/3");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }

        @Test
        @Order(65)
        public void NWB_Post_EstimatedBudget()
        {
            System.out.println("----------***** NWB_Post_EstimatedBudget *****----------");


//            String APIBody = "{
//            "id": 0,
//            "budgetId": 1,
//            "estimatedBudgetName": "Estimated API",
//            "from": "2021-06-01T00:00:00",
//            "to": "2022-06-30T00:00:00",
//            "estimatedBudgetLines": [
//        {
//            "accountId": "52110000-5566-7788-99aa-bbccddeeff00",
//            "amount": 50000,
//            "calculationType": 1,
//            "value": 100,
//            "estimatedValue": 50100
//        },
//        {
//            "accountId": "11120000-5566-7788-99aa-bbccddeeff00",
//            "amount": 100000,
//            "calculationType": 1,
//            "value": 100,
//            "estimatedValue": 100100
//        },
//        {
//            "accountId": "11130000-5566-7788-99aa-bbccddeeff00",
//            "amount": 60000,
//            "calculationType": 1,
//            "value": 100,
//            "estimatedValue": 60100
//        },
//        {
//            "accountId": "52120000-5566-7788-99aa-bbccddeeff00",
//            "amount": 80000,
//            "calculationType": 1,
//            "value": 100,
//            "estimatedValue": 80100
//        }
//    ]}";

            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/budget/estimatedbudget.json");


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiTmF2ZWVkIiwiRW1haWwiOiJzdXBlcmFkbWluQHZpemFseXMuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiJiZWY3MzMzYy1jZWI2LTQyMjUtYjNkOS0xNzFhNzJmOTg2ZWYiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsiQWRtaW4iLCJTdXBlckFkbWluIl0sIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuQXV0aENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdXNpbmVzc1BhcnRuZXJDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVzaW5lc3NQYXJ0bmVyQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Pcmdhbml6YXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuT3JnYW5pemF0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXNpZ25hdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVzaWduYXRpb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNhbXB1c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYW1wdXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldhcmVob3VzZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5XYXJlaG91c2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxvY2F0aW9uQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Mb2NhdGlvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua0FjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtTdGF0ZW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FzaEFjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNhc2hBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNhdGVnb3JpZXNDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZHVjdHNDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd1N0YXR1c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLldvcmtmbG93Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTGV2ZWw0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1JlY29uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5UcmFuc2FjdGlvblJlY29uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuSW52b2ljZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5QYXltZW50Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ3JlZGl0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZWJpdE5vdGVDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Kb3VybmFsRW50cnlDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdWRnZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlJlY2VpcHRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVxdWlzaXRpb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlJlcXVpc2l0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlB1cmNoYXNlT3JkZXJDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuR1JOQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkdSTkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuRXN0aW1hdGVkQnVkZ2V0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVzdGltYXRlZEJ1ZGdldENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuRW1wbG95ZWVDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlBheXJvbGxJdGVtQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheXJvbGxJdGVtQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5QYXlyb2xsSXRlbUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUGF5cm9sbEl0ZW1DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuUGF5cm9sbEl0ZW1FbXBsb3llZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5QYXlyb2xsSXRlbUVtcGxveWVlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5QYXlyb2xsSXRlbUVtcGxveWVlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5QYXlyb2xsSXRlbUVtcGxveWVlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlBheXJvbGxUcmFuc2FjdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5QYXlyb2xsVHJhbnNhY3Rpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheXJvbGxUcmFuc2FjdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUGF5cm9sbFRyYW5zYWN0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNoYXJ0T2ZBY2NvdW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HZW5lcmFsTGVkZ2VyQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5UcmlhbEJhbGFuY2VDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJhbGFuY2VTaGVldENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZml0TG9zc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQnVkZ2V0UmVwb3J0Q2xhaW1zLlZpZXciXSwiZXhwIjoxNjU0OTA0Njg0LCJpc3MiOiJodHRwOi8vd2FsZWVkLm5ldCIsImF1ZCI6Imh0dHA6Ly93YWxlZWQubmV0In0.65qpum7a1Bw85chxWigGvE7PtIVg-0TA1XyOQJ85QDA"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/EstimatedBudget");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }

        @Test
        @Order(67)
        public void NWB_Post_BudgetReport()
        {
            System.out.println("----------***** NWB_Post_BudgetReport *****----------");


//            String APIBody = "{ \"to\": \"2022-06-08\",\n" +
//                    "    \"budgetName\": \"Budget 01\"}";

            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/budget/budgetreport.json");


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiTmF2ZWVkIiwiRW1haWwiOiJzdXBlcmFkbWluQHZpemFseXMuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiJiZWY3MzMzYy1jZWI2LTQyMjUtYjNkOS0xNzFhNzJmOTg2ZWYiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsiQWRtaW4iLCJTdXBlckFkbWluIl0sIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuQXV0aENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdXNpbmVzc1BhcnRuZXJDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVzaW5lc3NQYXJ0bmVyQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Pcmdhbml6YXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuT3JnYW5pemF0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXNpZ25hdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVzaWduYXRpb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNhbXB1c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYW1wdXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldhcmVob3VzZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5XYXJlaG91c2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxvY2F0aW9uQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Mb2NhdGlvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua0FjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtTdGF0ZW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FzaEFjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNhc2hBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNhdGVnb3JpZXNDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZHVjdHNDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd1N0YXR1c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLldvcmtmbG93Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTGV2ZWw0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1JlY29uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5UcmFuc2FjdGlvblJlY29uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuSW52b2ljZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5QYXltZW50Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ3JlZGl0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZWJpdE5vdGVDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Kb3VybmFsRW50cnlDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdWRnZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlJlY2VpcHRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVxdWlzaXRpb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlJlcXVpc2l0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlB1cmNoYXNlT3JkZXJDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuR1JOQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkdSTkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuRXN0aW1hdGVkQnVkZ2V0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVzdGltYXRlZEJ1ZGdldENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuRW1wbG95ZWVDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlBheXJvbGxJdGVtQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheXJvbGxJdGVtQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5QYXlyb2xsSXRlbUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUGF5cm9sbEl0ZW1DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuUGF5cm9sbEl0ZW1FbXBsb3llZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5QYXlyb2xsSXRlbUVtcGxveWVlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5QYXlyb2xsSXRlbUVtcGxveWVlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5QYXlyb2xsSXRlbUVtcGxveWVlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlBheXJvbGxUcmFuc2FjdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5QYXlyb2xsVHJhbnNhY3Rpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheXJvbGxUcmFuc2FjdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUGF5cm9sbFRyYW5zYWN0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNoYXJ0T2ZBY2NvdW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HZW5lcmFsTGVkZ2VyQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5UcmlhbEJhbGFuY2VDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJhbGFuY2VTaGVldENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZml0TG9zc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQnVkZ2V0UmVwb3J0Q2xhaW1zLlZpZXciXSwiZXhwIjoxNjU0OTA0Njg0LCJpc3MiOiJodHRwOi8vd2FsZWVkLm5ldCIsImF1ZCI6Imh0dHA6Ly93YWxlZWQubmV0In0.65qpum7a1Bw85chxWigGvE7PtIVg-0TA1XyOQJ85QDA"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Budget/BudgetReport");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }



        @Test
        @Order(66)
        public void NWB_Get_EstimatedBudget()
        {
            System.out.println("----------***** NWB_Get_EstimatedBudget *****----------");


            String APIBody = "{}";




            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiTmF2ZWVkIiwiRW1haWwiOiJzdXBlcmFkbWluQHZpemFseXMuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiJiZWY3MzMzYy1jZWI2LTQyMjUtYjNkOS0xNzFhNzJmOTg2ZWYiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsiQWRtaW4iLCJTdXBlckFkbWluIl0sIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuQXV0aENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdXNpbmVzc1BhcnRuZXJDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVzaW5lc3NQYXJ0bmVyQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Pcmdhbml6YXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuT3JnYW5pemF0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXNpZ25hdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVzaWduYXRpb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNhbXB1c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYW1wdXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldhcmVob3VzZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5XYXJlaG91c2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxvY2F0aW9uQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Mb2NhdGlvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua0FjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtTdGF0ZW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FzaEFjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNhc2hBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNhdGVnb3JpZXNDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZHVjdHNDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd1N0YXR1c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLldvcmtmbG93Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTGV2ZWw0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1JlY29uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5UcmFuc2FjdGlvblJlY29uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuSW52b2ljZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5QYXltZW50Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ3JlZGl0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZWJpdE5vdGVDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Kb3VybmFsRW50cnlDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdWRnZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlJlY2VpcHRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVxdWlzaXRpb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlJlcXVpc2l0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlB1cmNoYXNlT3JkZXJDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuR1JOQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkdSTkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuRXN0aW1hdGVkQnVkZ2V0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVzdGltYXRlZEJ1ZGdldENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuRW1wbG95ZWVDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlBheXJvbGxJdGVtQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheXJvbGxJdGVtQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5QYXlyb2xsSXRlbUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUGF5cm9sbEl0ZW1DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuUGF5cm9sbEl0ZW1FbXBsb3llZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5QYXlyb2xsSXRlbUVtcGxveWVlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5QYXlyb2xsSXRlbUVtcGxveWVlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5QYXlyb2xsSXRlbUVtcGxveWVlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlBheXJvbGxUcmFuc2FjdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5QYXlyb2xsVHJhbnNhY3Rpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheXJvbGxUcmFuc2FjdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUGF5cm9sbFRyYW5zYWN0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNoYXJ0T2ZBY2NvdW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HZW5lcmFsTGVkZ2VyQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5UcmlhbEJhbGFuY2VDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJhbGFuY2VTaGVldENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZml0TG9zc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQnVkZ2V0UmVwb3J0Q2xhaW1zLlZpZXciXSwiZXhwIjoxNjU0OTA0Njg0LCJpc3MiOiJodHRwOi8vd2FsZWVkLm5ldCIsImF1ZCI6Imh0dHA6Ly93YWxlZWQubmV0In0.65qpum7a1Bw85chxWigGvE7PtIVg-0TA1XyOQJ85QDA"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/EstimatedBudget");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(65)
        public void NWB_Post_Receipt()
        {
            System.out.println("----------***** NWB_Post_Receipt *****----------");


//            String APIBody = "{ \"paymentRegisterType\": 2,\n" +
//                    "    \"paymentType\": 0,\n" +
//                    "    \"businessPartnerId\": 8,\n" +
//                    "    \"accountId\": \"22160000-5566-7788-99aa-bbccddeeff00\",\n" +
//                    "    \"paymentDate\": \"2022-06-08\",\n" +
//                    "    \"paymentRegisterId\": \"189c1298-ed9e-459a-2120-08da479543c5\",\n" +
//                    "    \"campusId\": 1,\n" +
//                    "    \"description\": \"eee\",\n" +
//                    "    \"grossPayment\": 12000,\n" +
//                    "    \"discount\": 100,\n" +
//                    "    \"salesTax\": 50,\n" +
//                    "    \"incomeTax\": 50,\n" +
//                    "    \"srbTax\": 20,\n" +
//                    "    \"isSubmit\": false}";

            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/finance/receipt.json");


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Receipt");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(66)
        public void NWB_Get_Receipt()
        {
            System.out.println("----------***** NWB_Get_Receipt *****----------");


            String APIBody = "{}";




            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiTmF2ZWVkIiwiRW1haWwiOiJzdXBlcmFkbWluQHZpemFseXMuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiJiZWY3MzMzYy1jZWI2LTQyMjUtYjNkOS0xNzFhNzJmOTg2ZWYiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsiQWRtaW4iLCJTdXBlckFkbWluIl0sIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuQXV0aENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdXNpbmVzc1BhcnRuZXJDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVzaW5lc3NQYXJ0bmVyQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Pcmdhbml6YXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuT3JnYW5pemF0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXNpZ25hdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVzaWduYXRpb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNhbXB1c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYW1wdXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldhcmVob3VzZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5XYXJlaG91c2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxvY2F0aW9uQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Mb2NhdGlvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua0FjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtTdGF0ZW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FzaEFjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNhc2hBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNhdGVnb3JpZXNDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZHVjdHNDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd1N0YXR1c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLldvcmtmbG93Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTGV2ZWw0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1JlY29uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5UcmFuc2FjdGlvblJlY29uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuSW52b2ljZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5QYXltZW50Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ3JlZGl0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZWJpdE5vdGVDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Kb3VybmFsRW50cnlDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdWRnZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlJlY2VpcHRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVxdWlzaXRpb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlJlcXVpc2l0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlB1cmNoYXNlT3JkZXJDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuR1JOQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkdSTkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuRXN0aW1hdGVkQnVkZ2V0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVzdGltYXRlZEJ1ZGdldENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuRW1wbG95ZWVDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlBheXJvbGxJdGVtQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheXJvbGxJdGVtQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5QYXlyb2xsSXRlbUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUGF5cm9sbEl0ZW1DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuUGF5cm9sbEl0ZW1FbXBsb3llZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5QYXlyb2xsSXRlbUVtcGxveWVlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5QYXlyb2xsSXRlbUVtcGxveWVlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5QYXlyb2xsSXRlbUVtcGxveWVlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlBheXJvbGxUcmFuc2FjdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5QYXlyb2xsVHJhbnNhY3Rpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheXJvbGxUcmFuc2FjdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUGF5cm9sbFRyYW5zYWN0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNoYXJ0T2ZBY2NvdW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HZW5lcmFsTGVkZ2VyQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5UcmlhbEJhbGFuY2VDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJhbGFuY2VTaGVldENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZml0TG9zc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQnVkZ2V0UmVwb3J0Q2xhaW1zLlZpZXciXSwiZXhwIjoxNjU0OTA0Njg0LCJpc3MiOiJodHRwOi8vd2FsZWVkLm5ldCIsImF1ZCI6Imh0dHA6Ly93YWxlZWQubmV0In0.65qpum7a1Bw85chxWigGvE7PtIVg-0TA1XyOQJ85QDA"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Receipt");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }



        @Test
        @Order(65)
        public void NWB_Post_GeneralLedger()
        {
            System.out.println("----------***** NWB_Post_GeneralLedger *****----------");


//            String APIBody = "{\"docDate\": \"2022-04-01\",\n" +
//                    "    \"docDate2\": \"2022-04-21\",\n" +
//                    "    \"accountName\": \"\",\n" +
//                    "    \"businessPartnerName\": \"\",\n" +
//                    "    \"warehouseName\": \"\",\n" +
//                    "    \"campusName\": \"\"}";

            //Getting API Post Body from the External File
            File APIBody = new File(System.getProperty("user.dir") + "/allapis/report/generalledger.json");


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiTmF2ZWVkIiwiRW1haWwiOiJzdXBlcmFkbWluQHZpemFseXMuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiI2OTgxM2MyMy0xNmE3LTRhZmUtYmZlMy0wYjAyMWUzOTJhOGUiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsiQWRtaW4iLCJTdXBlckFkbWluIl0sIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuQXV0aENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5BdXRoQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdXNpbmVzc1BhcnRuZXJDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1c2luZXNzUGFydG5lckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVzaW5lc3NQYXJ0bmVyQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Pcmdhbml6YXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLk9yZ2FuaXphdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuT3JnYW5pemF0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlcGFydG1lbnRzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudHNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuRGVwYXJ0bWVudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5EZXBhcnRtZW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkRlc2lnbmF0aW9uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5EZXNpZ25hdGlvbkNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGVzaWduYXRpb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkNhbXB1c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FtcHVzQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DYW1wdXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldhcmVob3VzZUNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuV2FyZWhvdXNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5XYXJlaG91c2VDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTG9jYXRpb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkxvY2F0aW9uQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Mb2NhdGlvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CYW5rQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua0FjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJhbmtTdGF0ZW1lbnRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmFua1N0YXRlbWVudENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DYXNoQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2FzaEFjY291bnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkNhc2hBY2NvdW50Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkNhdGVnb3JpZXNDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQ2F0ZWdvcmllc0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Qcm9kdWN0c0NsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZHVjdHNDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlByb2R1Y3RzQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLldvcmtmbG93U3RhdHVzQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd1N0YXR1c0NsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuV29ya2Zsb3dTdGF0dXNDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuV29ya2Zsb3dDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLldvcmtmbG93Q2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5Xb3JrZmxvd0NsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuTGV2ZWw0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5MZXZlbDRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkxldmVsNENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmFua1JlY29uQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYW5rUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkJhbmtSZWNvbkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5UcmFuc2FjdGlvblJlY29uQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlRyYW5zYWN0aW9uUmVjb25DbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuSW52b2ljZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5JbnZvaWNlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQmlsbENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5QYXltZW50Q2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlBheW1lbnRDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQ3JlZGl0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkVkaXQiLCJQZXJtaXNzaW9ucy5DcmVkaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5EZWJpdE5vdGVDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkRlYml0Tm90ZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRGViaXROb3RlQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Kb3VybmFsRW50cnlDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkpvdXJuYWxFbnRyeUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuSm91cm5hbEVudHJ5Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CdWRnZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkJ1ZGdldENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuQnVkZ2V0Q2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlJlY2VpcHRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUmVjZWlwdENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5SZXF1aXNpdGlvbkNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUmVxdWlzaXRpb25DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLlJlcXVpc2l0aW9uQ2xhaW1zLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlB1cmNoYXNlT3JkZXJDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuUHVyY2hhc2VPcmRlckNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuR1JOQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5HUk5DbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkdSTkNsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuRXN0aW1hdGVkQnVkZ2V0Q2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5Fc3RpbWF0ZWRCdWRnZXRDbGFpbXMuRWRpdCIsIlBlcm1pc3Npb25zLkVzdGltYXRlZEJ1ZGdldENsYWltcy5EZWxldGUiLCJQZXJtaXNzaW9ucy5DaGFydE9mQWNjb3VudENsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuR2VuZXJhbExlZGdlckNsYWltcy5WaWV3IiwiUGVybWlzc2lvbnMuVHJpYWxCYWxhbmNlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5CYWxhbmNlU2hlZXRDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLlByb2ZpdExvc3NDbGFpbXMuVmlldyIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkVtcGxveWVlQ2xhaW1zLlZpZXciLCJQZXJtaXNzaW9ucy5FbXBsb3llZUNsYWltcy5FZGl0IiwiUGVybWlzc2lvbnMuRW1wbG95ZWVDbGFpbXMuRGVsZXRlIiwiUGVybWlzc2lvbnMuQnVkZ2V0UmVwb3J0Q2xhaW1zLlZpZXciXSwiZXhwIjoxNjUyNDc2MTUwLCJpc3MiOiJodHRwOi8vd2FsZWVkLm5ldCIsImF1ZCI6Imh0dHA6Ly93YWxlZWQubmV0In0.JAAx3pr7IH4n4URqvR9O2dVUavuS-ounZf_oSilHkoo"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/GeneralLedger");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(66)
        public void NWB_Get_COA()
        {
            System.out.println("----------***** NWB_Get_COA *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/COA");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }
    }
}