package api.endepoints;

import static io.restassured.RestAssured.given;


import api.payload.User;
import api.utilities.ConfigManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class VideoGameEndpoints {
	
	
//	public static Response  authUser(User payload) {
//		Response response = given()
//		   .contentType(ContentType.JSON)
//		   .accept(ContentType.JSON)
//		   .body(payload)
//		
//		.when()
//			.get(ConfigManager.getUrl("games.endpoint"));		
//		return response;
//	}

	
	
	public static Response  getVideoGames() {
		Response response = given()								
				.when()
				.get(ConfigManager.getUrl("games.endpoint"));
		
		return response;
	}
}
