package model;

import java.util.ArrayList;

public interface Person {
	String getRole();
	String getName();
	String getBiography();
	String getbirthPlace();
	String getBirthDay();
	String getPosterLink();
	ArrayList<Movie> getOwnMovies();
	int getHeight();
	void setName(String name);
	void setBiography(String biography);
	void setBirthPlace(String birthPlace);
	void setBirthDay(String birthDay);
	void setHeight(int height);
	void addOwnMovie(Movie m);
}
