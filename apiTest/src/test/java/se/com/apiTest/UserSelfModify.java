package se.com.apiTest;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;

public class UserSelfModify {

	@Test
	public void test() {
		
		CommonData commonData = new CommonData();
		UserLogin UL = new UserLogin();
		
		RestAssured.baseURI="https://testb.21smarthome.com";
	    RequestSpecification request = RestAssured.given();
	    
	    String gender ="1";
	    String height = "178";
	    
	    
	    JSONObject requestParams = new JSONObject();
	    
	    requestParams.put("gender", gender);
	    requestParams.put("height",height);


	    request.body(requestParams.toString());


	    // Add a header stating the Request body is a JSON
	    String token = UL.token();
	    request.header("wm-commerce-token", token);

	    

	    Response response = request.put("/commerce/users/self");
	    
	
	    

	    response.then().body("data.gender",Matchers.is(gender));
	    response.then().body("data.height",Matchers.is(height));
	    response.then().body("code", Matchers.is("1"));
	    
		
	}
	
	
}
