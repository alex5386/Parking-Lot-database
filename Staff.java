
public class Staff {

	private String username;
	private String password;
	private int admin;

	
	public Staff(
			
			
			
			 String username,
		 String password,
			int admin
	) {
		setusername(username);
		setpassword(password);
		setadmin(admin);
	
	}

	
	public String getusername() {
		return username;
	}

	
	public void setusername(String username) {
		this.username = username;
	}
	
	public String getpassword() {
		return password;
	}

	
	public void setpassword(String password) {
		this.password = password;
	}
	
	
	public int getadmin() {
		return admin;
	}

	
	public void setadmin(int  admin) {
		this.admin = admin;
	}


	

	
}
