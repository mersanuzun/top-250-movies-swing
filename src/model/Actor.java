package model;

public class Actor extends AbstractPerson{
	private static final String role = "Actor";
	public Actor(String name, String biography, String birthPlace, String birthDay, int height, String posterLink){
		super(name, biography, birthPlace, birthDay, height, posterLink);
	}
	
	
	public String getRole() {
		return role;
	}

}
