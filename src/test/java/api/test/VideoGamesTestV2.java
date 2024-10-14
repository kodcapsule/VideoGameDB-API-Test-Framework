package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import api.endepoints.ViseoGameEndpointsV2;
import api.payload.VideoGame;
import io.restassured.response.Response;

public class VideoGamesTestV2 {	
	
	@BeforeClass
	public void setupData() {		
		videoGamePayload = new  VideoGame();
		
				
	}
	
	VideoGame videoGamePayload;
	// Test case  to create a video game 		
	
		@Test(priority=1)
		public void testPostCreateVideoGameV2 () {
			videoGamePayload.setCategory("Platform101");
			videoGamePayload.setName("Mario");
			videoGamePayload.setRating("Mature");
			videoGamePayload.setReleaseDate("2012-05-04");
			videoGamePayload.setReviewScore(85);
			
			Response response = ViseoGameEndpointsV2.createVideoGameV2(videoGamePayload);
			response.then().log().body();		
			Assert.assertEquals(response.getStatusCode(),200);
		}
	
	
	@Test(priority=2)
	public void testGetVideoGamesV2 () {
		Response response = ViseoGameEndpointsV2.getVideoGamesV2();
		response.then().log().body();		
		Assert.assertEquals(response.getStatusCode(),200);
			}
	

	
	// Test case for an valid game id 
	
	@Test(priority=3)
	public void testGetVideoGameByIdV2 () {
		videoGamePayload.setId(10);	
		Response response = ViseoGameEndpointsV2.getVideoGameByIdV2(this.videoGamePayload.getId());
		response.then().log().all();		
		Assert.assertEquals(response.getStatusCode(),200);
		
			}

	
// Test case for an invalid game id 
	@Test(priority=3)
	public void testGetVideoGameByInvalidIdV2 () {
		videoGamePayload.setId(100);	
		Response response = ViseoGameEndpointsV2.getVideoGameByIdV2(this.videoGamePayload.getId());
		response.then().log().all();		
		Assert.assertEquals(response.getStatusCode(),404);
		
			}
	
	// Test case to update a video game with a valid id 	
			@Test(priority=3)
			public void testUpdateVideoGameById () {
				videoGamePayload.setId(3);
				videoGamePayload.setCategory("Platform");	
				videoGamePayload.setName("Mario");
				videoGamePayload.setRating("Mature");
				videoGamePayload.setReleaseDate("2012-05-04");
				videoGamePayload.setReviewScore(85);
				Response response = ViseoGameEndpointsV2.updateVideoGameV2(this.videoGamePayload.getId(),videoGamePayload);
				response.then().log().body();		
				Assert.assertEquals(response.getStatusCode(),200);
					}
			
			
			// Test case to update a video game with an  invalid ID 	
						@Test(priority=3)
						public void testUpdateVideoGameByInvalId () {
							videoGamePayload.setId(100);
							videoGamePayload.setCategory("Platform");	
							videoGamePayload.setName("Mario");
							videoGamePayload.setRating("Mature");
							videoGamePayload.setReleaseDate("2012-05-04");
							videoGamePayload.setReviewScore(85);
							Response response = ViseoGameEndpointsV2.updateVideoGameV2(this.videoGamePayload.getId(),videoGamePayload);
							response.then().log().body();		
							Assert.assertEquals(response.getStatusCode(),404);
								}
			
// Test case to delete a video game with a valid id 	
			@Test(priority=3)
			public void testDeleteVideoGameById () {
				videoGamePayload.setId(1);	
				Response response = ViseoGameEndpointsV2.deleteVideoGameByIdV2(this.videoGamePayload.getId());
				response.then().log().body();		
				Assert.assertEquals(response.getStatusCode(),200);
					
			}

			
// Test case to delete a video game with a valid id 	
			@Test(priority=3)
			public void testDeleteVideoGameByvalidInId () {
			videoGamePayload.setId(100);	
			Response response = ViseoGameEndpointsV2.deleteVideoGameByIdV2(this.videoGamePayload.getId());
			response.then().log().body();		
			Assert.assertEquals(response.getStatusCode(),404);
			
			}
}
