package getlandestate.pojos;

public class US06ErvaContactControllerPost {
	private String firstName;
	private String lastName;
	private String message;
	private String email;
	private boolean status;

	public US06ErvaContactControllerPost() {
	}

	public US06ErvaContactControllerPost(String firstName, String lastName, String message, String email, boolean status) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.message = message;
		this.email = email;
		this.status = status;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public String getMessage(){
		return message;
	}

	public String getEmail(){
		return email;
	}

	public boolean isStatus(){
		return status;
	}
}
