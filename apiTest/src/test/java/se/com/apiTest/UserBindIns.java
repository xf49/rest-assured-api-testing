package se.com.apiTest;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;

public class UserBindIns {

	@Test
	public void test() {
		
		CommonData commonData = new CommonData();
		UserLogin UL = new UserLogin();
		
		RestAssured.baseURI="https://testb.21smarthome.com";
	    RequestSpecification request = RestAssured.given();
	    
	    JSONObject requestParams = new JSONObject();
	    
        requestParams.put("username", "x_f_4_9");



	    // Add a header stating the Request body is a JSON
	    String token = UL.token();
	    
	    request.header("wm-commerce-token", token);
	    request.contentType(ContentType.JSON);
	    request.body(requestParams.toString());

	    

	    Response response = request.put("/commerce/users/bind/ins");
	    
	    String output = response.
	    		then().
	    		contentType(ContentType.JSON).
	    		extract().
	    		response().asString();
	    

	    System.out.println("response : "+ output);
	    System.out.println("response code : "+response.statusCode());
	    System.out.println();
	    

	    response.then().body("data.number",Matchers.is(1));
	    
	    response.then().body("code", Matchers.is("1"));
	    
		
	}
}
