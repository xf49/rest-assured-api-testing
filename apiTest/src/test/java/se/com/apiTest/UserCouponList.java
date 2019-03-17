package se.com.apiTest;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;

public class UserCouponList {

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

	    

	    Response response = request.get("/commerce/users/couponList ");
	 

	    response.then().body("code", Matchers.is("1"));
	    
		
	}
}
