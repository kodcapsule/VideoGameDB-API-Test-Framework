package api.endepoints;

import static io.restassured.RestAssured.given;

import api.payload.VideoGame;
import api.utilities.ConfigManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ViseoGameEndpointsV2 {
	
//	Create a video endpoint v2 
	public static Response  createVideoGameV2(VideoGame payload) {
		Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.XML)
		   .body(payload)
		
		.when()
			.post(ConfigManager.getUrl("games.controller-v-2.endpoint"));
		
		return response;
	}
	
	
//	Endpoint to get  all videos
	
	public static Response  getVideoGamesV2() {
		Response response = given()	
				.contentType(ContentType.XML)
				.accept(ContentType.XML)
				.when()
				.get(ConfigManager.getUrl("games.controller-v-2.endpoint"));
		
		return response;
	}
	
	
	
//	Endpoint to get a specific video game  by id
	public static Response  getVideoGameByIdV2(int id) {
		Response response = given()	
							.contentType(ContentType.XML)
							.accept(ContentType.XML)
							.pathParam("id", Integer.toString(id))						
				.when()
				.get(ConfigManager.getUrl("games.controller-v-2.endpointId"));
		
		return response;
	}
	
	
//	Endpoint to delete a specific video game  by id
	public static Response  deleteVideoGameByIdV2(int id) {
		Response response = given()		
							.accept(ContentType.TEXT)
							.pathParam("id", Integer.toString(id))						
				.when()
				.delete(ConfigManager.getUrl("games.controller-v-2.endpointId"));
		
		return response;
	}
	
	//	Endpoint to update a specific video game  by id
	public static Response  updateVideoGameV2(int id, VideoGame videoGame) {
		Response response = given()					
				   .contentType(ContentType.JSON)
				   .accept(ContentType.XML)
				   
						.pathParam("id", Integer.toString(id))
						.body(videoGame)												
				.when()
				  .put(ConfigManager.getUrl("games.controller-v-2.endpointId"));
		
		return response;
	}

}
