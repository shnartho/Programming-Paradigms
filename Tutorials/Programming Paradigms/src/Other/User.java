package Other;

public class User {

	private int id;
	private String name;
	private String email;
	private String mobile;

	public int hashCode() {
		return id + name.hashCode() + email.hashCode() + mobile.hashCode();
	}

	public boolean equals(Object other) {
		// Null case
		if (other == null) return false;
		// Compare class
		if (!(other instanceof User)) return false;
		// Compare all values
		return (((User) other).id == id && ((User) other).name.equals(name) && ((User) other).email.equals(email)
			&& ((User) other).mobile.equals(mobile));
	}

}
