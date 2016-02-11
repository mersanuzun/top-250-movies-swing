package model;

import java.util.ArrayList;

public abstract class AbstractPerson implements Person{
	protected String biography;
	protected String name;
	protected String birthPlace;
	protected String birthDay;
	protected int height;
	protected String posterLink;
	
	protected ArrayList<Movie> ownMovies = new ArrayList<Movie>();
	public AbstractPerson(String name, String biography, String birthPlace, String birthDay, int height, String posterLink) {
		this.biography = biography;
		this.name = name;
		this.birthPlace = birthPlace;
		this.birthDay = birthDay;
		this.height = height;
		this.posterLink = posterLink;
	}
	
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getBiography() {
		// TODO Auto-generated method stub
		return this.biography;
	}

	@Override
	public String getbirthPlace() {
		// TODO Auto-generated method stub
		return this.birthPlace;
	}

	@Override
	public String getBirthDay() {
		// TODO Auto-generated method stub
		return this.birthDay;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setBiography(String biography) {
		this.biography = biography;
		
	}

	@Override
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
		
	}

	@Override
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
		
	}

	@Override
	public void setHeight(int height) {
		this.height = height;
		
	}
	
	@Override
	public void addOwnMovie(Movie m){
		this.ownMovies.add(m);
	}
	
	@Override
	public ArrayList<Movie> getOwnMovies(){
		return this.ownMovies;
	}
	
	public String getPosterLink(){
		return this.posterLink;
	}
}
