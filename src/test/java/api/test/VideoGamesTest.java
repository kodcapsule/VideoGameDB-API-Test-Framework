package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import api.endepoints.VideoGameEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class VideoGamesTest {
	
	
	
	@Test(priority=1)
	public void testGetVideoGames () {
		Response response = VideoGameEndpoints.getVideoGames();
		response.then().log().all();		
		Assert.assertEquals(response.getStatusCode(),200);
			}

}
