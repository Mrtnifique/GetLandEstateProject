package getlandestate.pojos;

public class US_05_SelinUserPatch {
	private String firstName;
	private String lastName;
	private String password;
	private String role;
	private String phone;
	private String email;

	public US_05_SelinUserPatch() {
	}

	public US_05_SelinUserPatch(String firstName, String lastName, String password, String role, String phone, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
		this.phone = phone;
		this.email = email;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public String getPassword(){
		return password;
	}

	public String getRole(){
		return role;
	}

	public String getPhone(){
		return phone;
	}

	public String getEmail(){
		return email;
	}
}
