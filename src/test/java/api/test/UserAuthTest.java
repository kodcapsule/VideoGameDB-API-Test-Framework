package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endepoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;
public class UserAuthTest {
	

	User userPayload;
	
	
	@BeforeClass
	public void setupData() {	
		userPayload = new  User();
		userPayload.setUsername("admin");
		userPayload.setPassword("admin");
		
	}
	
	@Test(priority=1)
	public void testPostUser () {
		Response response = UserEndpoints.authUser(userPayload);
		response.then().log().all();		
		Assert.assertEquals(response.getStatusCode(),200);
		Assert.assertNotNull(response.jsonPath().get("token"));
	}
}
