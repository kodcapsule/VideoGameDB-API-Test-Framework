package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endepoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;
public class UserAuthTest {
	

	User authUserPayload;
	User wrongAuthUserPayload;
	
	
	@BeforeClass
	public void setupData() {	
		authUserPayload = new  User();
		authUserPayload.setUsername("admin");
		authUserPayload.setPassword("admin");		
	}
	
	
	
//	Test case for correct username and password
	
	@Test(priority=1)
	public void testAuthUser () {
		Response response = UserEndpoints.authUser(authUserPayload);
		response.then().log().all();		
		Assert.assertEquals(response.getStatusCode(),200);		
		Assert.assertNotNull(response.jsonPath().get("token"));
	}
	
	
	
//	Test case for wrong username and password
	@Test(priority=1)
	public void testWrongAuthtUserDetails () {
		authUserPayload.setUsername("admin101");
		authUserPayload.setPassword("admin101");
		Response response = UserEndpoints.authUser(authUserPayload);
		response.then().log().all();		
		Assert.assertEquals(response.getStatusCode(),403);		
	}
	
		
//	Test case for wrong username
	@Test(priority=2)
	public void testWrongAuthtUsername () {
		authUserPayload.setUsername("admin101");
		authUserPayload.setPassword("admin");
		Response response = UserEndpoints.authUser(authUserPayload);
		response.then().log().body();		
		Assert.assertEquals(response.getStatusCode(),400);		
	}
}


