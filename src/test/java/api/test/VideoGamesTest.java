package api.test;



import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endepoints.VideoGameEndpoints;
import api.payload.VideoGame;
import io.restassured.response.Response;

public class VideoGamesTest {
	
	Faker faker;
	VideoGame videoGamePayload; 
	
	@BeforeClass
	public void setupData() {
		faker = new Faker();
		videoGamePayload = new  VideoGame();
		videoGamePayload.setId(1);		
	}
	
	
	
// Test case  to create a video game 		
	
	@Test(priority=1)
	public void testPostCreateVideoGame () {
		Response response = VideoGameEndpoints.createVideoGame(videoGamePayload);
		response.then().log().body();		
		Assert.assertEquals(response.getStatusCode(),403);
	}
	
	
	
//	Test case for  get video games
	@Test(priority=2)
	public void testGetVideoGames () {
		Response response = VideoGameEndpoints.getVideoGames();
		response.then().log().body();		
		Assert.assertEquals(response.getStatusCode(),200);
			}

//	Test case to  get a video  game with a valid  id 
//	
	@Test(priority=3)
	public void testGetVideoGameById () {
		videoGamePayload.setId(1);	
		Response response = VideoGameEndpoints.getVideoGameById(this.videoGamePayload.getId());
		response.then().log().all();		
		Assert.assertEquals(response.getStatusCode(),200);
			}
	
//// Test case to get video game with an invalid id
	@Test(priority=3)
	public void testGetVideoGameByInvalidId () {
		videoGamePayload.setId(100);	
		Response response = VideoGameEndpoints.getVideoGameById(this.videoGamePayload.getId());
		response.then().log().all();		
		Assert.assertEquals(response.getStatusCode(),404);
			}
	
	
//// Test case to delete a video game with a valid id 	
	@Test(priority=3)
	public void testDeleteVideoGameById () {
		videoGamePayload.setId(1);	
		Response response = VideoGameEndpoints.deleteVideoGameById(this.videoGamePayload.getId());
		response.then().log().all();		
		Assert.assertEquals(response.getStatusCode(),403);
			}
	
	
	
	// Test case to update a video game with a valid id 	
		@Test(priority=3)
		public void testUpdateVideoGame () {
			videoGamePayload.setId(1);
			videoGamePayload.setCategory("Platform");	
			videoGamePayload.setName("Mario");
			videoGamePayload.setRating("Mature");
			videoGamePayload.setReleaseDate("2012-05-04");
			videoGamePayload.setReviewScore(85);
			Response response = VideoGameEndpoints.updateVideoGame(this.videoGamePayload.getId(), videoGamePayload);
			response.then().log().all();		
			Assert.assertEquals(response.getStatusCode(),403);
				}
}
