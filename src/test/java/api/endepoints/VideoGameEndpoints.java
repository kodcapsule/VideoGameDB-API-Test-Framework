package api.endepoints;

import static io.restassured.RestAssured.given;

import api.payload.VideoGame;
import api.utilities.ConfigManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class VideoGameEndpoints {

	
//	Create a video endpoint 
	public static Response  createVideoGame(VideoGame payload) {
		Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)		
		.when()
			.post(ConfigManager.getUrl("games.controller.endpoint"));
		
		return response;
	}
	
	
//	Endpoint to get  all videos
	
	public static Response  getVideoGames() {
		Response response = given()								
				.when()
				.get(ConfigManager.getUrl("games.controller.endpoint"));
		
		return response;
	}
	
	
	
//	Endpoint to get a specific video game  by id
	public static Response  getVideoGameById(int id) {
		Response response = given()		
							.pathParam("id", Integer.toString(id))						
				.when()
				.get(ConfigManager.getUrl("games2.controller.endpoint"));
		
		return response;
	}
	
	
//	Endpoint to delete a specific video game  by id
	public static Response  deleteVideoGameById(int id) {
		Response response = given()		
							.pathParam("id", Integer.toString(id))						
				.when()
				.delete(ConfigManager.getUrl("games2.controller.endpoint"));
		
		return response;
	}
	
	//	Endpoint to update a specific video game  by id
	public static Response  updateVideoGame(int id, VideoGame videoGame) {
		Response response = given()		
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.pathParam("id", Integer.toString(id))
						.body(videoGame)												
				.when()
				  .put(ConfigManager.getUrl("games2.controller.endpoint"));
		
		return response;
	}
}
