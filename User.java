
public class User {
	
	private String username;
	private String password;
	private String email;
	private String last;
	private String first;
	private int phone;
	private String vehicle;
	
	public User(
			String username,
			String password,
			String email,
			String last,
			String first,
			int phone,
			String vehicle
	) {
		setusername(username);
		setpassword(password);
		setemail(email);
		setlast(last);
	 setfirst(first) ;
	 setphone(phone);
	 setvehicle(vehicle);
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
	public String getemail() {
		return email;
	}

	
	public void setemail(String email) {
		this.email = email;
	}

	public String getlast() {
		return last;
	}

	
	public void setlast(String last) {
		this.last = last;
	}
	
	public String getfirst() {
		return first;
	}

	
	public void setfirst(String first) {
		this.first = first;
	}
	public int getphone() {
		return phone;
	}

	
	public void setphone(int phone) {
		this.phone = phone;
	}

	public String getvehicle() {
		return vehicle;
	}

	
	public void setvehicle(String vehicle) {
		this.vehicle = vehicle;
	}


	
	
}
