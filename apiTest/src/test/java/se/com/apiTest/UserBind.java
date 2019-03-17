package se.com.apiTest;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;

public class UserBind {

	@Test
	public void test() {
		
		CommonData commonData = new CommonData();
		UserLogin UL = new UserLogin();
		
		String email = "xf49@columbiaUniversity.edu";
		
		RestAssured.baseURI="https://testb.21smarthome.com";
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("email", email);
		
		// Add a header stating the Request body is a JSON
		String token =UL.token();
		
		request.header("wm-commerce-token",token);
		request.contentType(ContentType.JSON);
		request.body(requestParams.toString());
		
		
		Response response = request.put("/commerce/users/bind");
		
		String output = response.
						then().
						contentType(ContentType.JSON).
						extract().
						response().
						asString();
		
		
		System.out.println("response : "+output);
		System.out.println();
		System.out.println("response code : "+response.statusCode());
		
		response.then().body("data.email",Matchers.is(email) );
		response.then().body("data.fullName", Matchers.is("xuming feng"));
		response.then().body("code",Matchers.is("1") );
		
//		CommonData commonData = new CommonData();
//		UserLogin UL = new UserLogin();
//		
//		RestAssured.baseURI="https://testb.21smarthome.com";
//	    RequestSpecification request = RestAssured.given();
//	    
//	    JSONObject requestParams = new JSONObject();
//	    
//        requestParams.put("email", "xf49@columbia.edu");
//
//
//
//	    // Add a header stating the Request body is a JSON
//	    //String token = UL.token();
//	    
//	    System.out.println(UL.token());
//	    
////	    request.header("wm-commerce-token", token);
////	    request.contentType(ContentType.JSON);
////	    request.body(requestParams.toString());
////
////	    
////
////	    Response response = request.put("/commerce/users/bind");
////	    
////	    String output = response.
////	    		then().
////	    		contentType(ContentType.JSON).
////	    		extract().
////	    		response().asString();
////	    
////
////	    System.out.println("response : "+ output);
////	    System.out.println("response code : "+response.statusCode());
////	    System.out.println();
////	    
////
////	    response.then().body("data.email",Matchers.is("xf49@columbia.edu"));
////	    response.then().body("data.fullName", Matchers.is("xuming feng"));
////	    response.then().body("code", Matchers.is("1"));
		
		
	}
}
