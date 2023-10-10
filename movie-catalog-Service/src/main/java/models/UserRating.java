package models;

import java.util.List;

public class UserRating {
private List<Rating> userRatigs;

public List<Rating> getUserRatigs() {
	return userRatigs;
}

public void setUserRatigs(List<Rating> userRatigs) {
	this.userRatigs = userRatigs;
}
}
