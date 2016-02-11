package model;

public class Director extends AbstractPerson{
	private static final String role = "Director";
	public Director(String name, String biography, String birthPlace, String birthDay, int height, String posterLink){
		super(name, biography, birthPlace, birthDay, height, posterLink);
	}
	
	public String getRole() {
		return role;
	}

}
