package model;

import java.util.ArrayList;

public class Movie {
	private String imdbID;
	private String title;
	private Double imdbRating;
	private int imdbVotes;
	private String releasedDate;
	private int runtime;
	private String plot;
	private String posterLink;
	private ArrayList<Country> countries;
	private ArrayList<Language> languages;
	private ArrayList<Person> cast;
	private ArrayList<Genre> genres;
	
	public Movie(String imdbID, String title, Double imdbRating, int imdbVotes, String releasedDate, int runtime, String plot, String posterLink){
		this.imdbID = imdbID;
		this.title = title;
		this.imdbRating = imdbRating;
		this.imdbVotes = imdbVotes;
		this.releasedDate = releasedDate;
		this.runtime = runtime;
		this.plot = plot;
		this.posterLink = posterLink;
		this.countries = new ArrayList<Country>();
		this.languages = new ArrayList<Language>();
		this.cast = new ArrayList<Person>();
		this.genres = new ArrayList<Genre>();
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(Double imdbRating) {
		this.imdbRating = imdbRating;
	}
	public int getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getReleasedDate() {
		return releasedDate;
	}
	public void setReleasedDate(String releasedDate) {
		this.releasedDate = releasedDate;
	}
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getPosterLink() {
		return posterLink;
	}
	public void addPosterLink(String posterLink) {
		this.posterLink = posterLink;
	}
	public ArrayList<Country> getCountries() {
		return countries;
	}
	public void addCountry(Country country) {
		this.countries.add(country);
	}
	public ArrayList<Language> getLanguages() {
		return languages;
	}
	public void addLanguage(Language language) {
		this.languages.add(language);
	}
	public ArrayList<Person> getCast() {
		return cast;
	}
	public void addCast(Person cast) {
		this.cast.add(cast);
	}
	public ArrayList<Genre> getGenres() {
		return genres;
	}
	public void addGenre(Genre genre) {
		this.genres.add(genre);
	}
}
