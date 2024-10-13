package api.endepoints;

import static io.restassured.RestAssured.given;
import api.payload.User;
import api.utilities.ConfigManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {	
	public static Response  authUser(User payload) {
		Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		
		.when()
			.post(ConfigManager.getUrl("auth.controller.endpoint"));		
		return response;
	}

}
