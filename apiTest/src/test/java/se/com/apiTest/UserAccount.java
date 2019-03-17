package se.com.apiTest;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;
import se.com.apiTest.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;

public class UserAccount {
	
	@Test
	public void test() {
		
		CommonData commonData = new CommonData();
		UserLogin UL = new UserLogin();
		
		RestAssured.baseURI="https://testb.21smarthome.com";
	    RequestSpecification request = RestAssured.given();
	    
	    JSONObject requestParams = new JSONObject();
	    




	    // Add a header stating the Request body is a JSON
	    String token = UL.token();
	    request.header("wm-commerce-token", token);

	    

	    Response response = request.get("/commerce/users/user/account ");
	    
	    String output = response.
	    		then().
	    		contentType(ContentType.JSON).
	    		extract().
	    		response().asString();
	    
	    System.out.println("response : "+ output);
	    System.out.println("response code : "+response.statusCode());
	    System.out.println();
	    
	    response.then().body("data.availableBalanceCent", Matchers.is("0"));
	    response.then().body("data.availableBalanceCurrency", Matchers.is("USD"));
	    response.then().body("data.freezeBalanceCent", Matchers.is("0"));
	    response.then().body("data.freezeBalanceCurrency", Matchers.is("USD"));
	    response.then().body("data.balanceCent", Matchers.is("0"));
	    response.then().body("data.balanceCurrency", Matchers.is("USD"));
	    response.then().body("code", Matchers.is("1"));
	    
		
	}

}
