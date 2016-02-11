package model;

public class PersonDemo {
	private String biography;
	private String name;
	private String birthPlace;
	private String birthDay;
	private int height;
	
	public PersonDemo(String name, String biography, String birthPlace, String birthDay, int height) {
		this.biography = biography;
		this.name = name;
		this.birthPlace = birthPlace;
		this.birthDay = birthDay;
		this.height = height;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
