package resources;

import java.util.Arrays;
import java.util.List;import org.apache.tomcat.util.buf.UEncoder;
import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import models.Rating;
import models.UserRating;



@RestController
@RequestMapping("/ratingsdata")

public class RatingsResource {
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		
		return new Rating("1234", 4);
	}
	
	@RequestMapping("user/{userId}")
	public UserRating getUserRatings(@PathVariable("userId") String movieId) {
		List<Rating> ratings= Arrays.asList(new Rating("1234", 4),new Rating("5678", 3));
				UserRating userRating= new UserRating();
				userRating.setUserRatigs(ratings);
				return userRating;
		
	}

}
