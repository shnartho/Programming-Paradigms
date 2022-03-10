package Other;

public class Author {

	private final String name;
	private final String email;
	private final char gender;

	public Author(String name, String email, char gender) {
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	public String toString() {
		return "[ " + name + ", " + email + ", " + gender + " ]";
	}

}
