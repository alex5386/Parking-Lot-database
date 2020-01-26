
public class Student {
	private int enrolled;
	private int graduation;
	
	private String username;
	private String password;
	private int campus;

	
	public Student(
			int enrolled,
			int graduation,
			
			 String username,
		 String password,
			int campus
	) {
		setusername(username);
		setpassword(password);
		setenrolled(enrolled);
		setgraduation(graduation);
	 setcampus(campus) ;
	
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
	
	
	public int getenrolled() {
		return enrolled;
	}

	
	public void setenrolled(int enrolled) {
		this.enrolled = enrolled;
	}
	
	public int getgraduation() {
		return  graduation;
	}

	
	public void setgraduation(int  graduation) {
		this. graduation=  graduation;
	}
	public int getcampus() {
		return campus;
	}

	
	public void setcampus(int  campus) {
		this. campus=  campus;
	}
	
	
	
}
