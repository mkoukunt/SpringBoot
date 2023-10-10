package resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import models.CatalogItem;
import models.Movie;
import models.Rating;
import models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogService {
	@Autowired
	RestTemplate template;
	@Autowired
	WebClient.Builder webBuilder;
	
	@RequestMapping("/{userId}")
public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){	
		
	
		
		UserRating ratings=template.getForObject("http://localhost:8082/ratingsdata/user/"+userId, UserRating.class);
		return ratings.getUserRatigs().stream().map(rating ->{
		//Movie mv=template.getForObject("http://localhost:8081/movies/"+rating.getMovieId(), Movie.class);
		
		Movie mv= webBuilder.build().get().uri("http://localhost:8081/movies/"+rating.getMovieId()).retrieve().bodyToMono(Movie.class).block();
		
			return new CatalogItem(mv.getMovieName(), "desc", rating.getRating());}
			
		).collect(Collectors.toList());
	
}
}
