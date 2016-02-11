package model;

public class Writer extends AbstractPerson{
	private static final String role = "Writer";
	public Writer(String name, String biography, String birthPlace, String birthDay, int height, String posterLink){
		super(name, biography, birthPlace, birthDay, height, posterLink);
	}
	
	public String getRole() {
		return role;
	}

}

