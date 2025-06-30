package getlandestate.pojos;

public class US_05_SelinUserLogin {
	private String password;
	private String email;

	public US_05_SelinUserLogin(String password) {
		this.password = password;
	}

	public US_05_SelinUserLogin(String password, String email) {
		this.password = password;
		this.email = email;
	}

	public String getPassword(){
		return password;
	}

	public String getEmail(){
		return email;
	}
}
