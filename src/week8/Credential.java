package week8;

/*
	A class that keeps the user 
	input of username and passowrd.
	The class provides method for 
	comparing two pairs of username and password.
*/
public class Credential {
	private String username;
	private String password;

	public Credential(String _username, String _password) {
		username = _username;
		password = _password;
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	/*
		Return true if the given Credential object 
		has the same username and password as this 
		Credential object.
	*/
	public boolean Check(Credential c) {
		return username.equals(c.getUsername()) && password.equals(c.getPassword());
	}
}