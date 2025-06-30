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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public US_05_SelinUserPatch(String firstName, String lastName, String password, String role, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
