import java.sql.*;
import java.util.*;
import java.util.Date;

public class ParkingDB {
	private static String userName = "hngai2"; 
	private static String password = "ghetEjni"; 
	private static String serverName = "cssgate.insttech.washington.edu"; 
	private static Connection ServerCon;
	private static List<User> listuser;
	private static List<Student> listStudent;
	private static List<Staff> listStaff;
	private static List<Permit> listPermit;
	private static List<Lot> listLot;
	/**
	 * Create SQL connection with Database.
	 * Get Staff information.
	 * @throws Exception
	 */
	public ParkingDB() throws Exception {
		ServerCon = DriverManager.
				getConnection("jdbc:mysql://" + serverName + "/" + userName + "?user=" + userName + "&password=" + password+"&serverTimezone=UTC"); 
		getUserList();
	}
	
	
	//add car model
	   public void addModel(String make,String model) throws Exception{
	      PreparedStatement psmt = null;
	      String sql = "insert into model values " + "(?, ?); ";
	      try {
	         psmt = ServerCon.prepareStatement(sql);
	         psmt.setString(1, make);
	         psmt.setString(2, model);
	        
	         psmt.executeUpdate();
	      }catch(Exception e){
	         e.printStackTrace();
	         throw new Exception("Unable to update model: "+e.getMessage());
	      }
	     
	   }
	   //add vehicle
	      public void addVehicle(int year,String color,String vehicle_num,String model) throws Exception{
	      PreparedStatement psmt = null;
	      String sql = "insert into vehicle values " + "(?, ?,?,?); ";
	      try {
	         psmt = ServerCon.prepareStatement(sql);
	         psmt.setInt(1, year);
	         psmt.setString(2, color);
	         psmt.setString(3, vehicle_num);
	         psmt.setString(4, model);
	        
	         psmt.executeUpdate();
	      }catch(Exception e){
	         e.printStackTrace();
	         throw new Exception("Unable to update vehicle: "+e.getMessage());
	      }
	     
	   }
	   //add user
	      public void addUser(String username,String password,String email,String last_name,String first_name,int phone,String vehicle_num) throws Exception{
	      PreparedStatement psmt = null;
	      String sql = "insert into user values " + "(?, ?,?,?,?,?,?); ";
	      try {
	         psmt = ServerCon.prepareStatement(sql);
	         psmt.setString(1, username);
	         psmt.setString(2, password);
	         psmt.setString(3, email);
	         psmt.setString(4, last_name);
	         psmt.setString(5, first_name);
	         psmt.setInt(6, phone);
	         psmt.setString(7, vehicle_num);
	  
	        
	         psmt.executeUpdate();
	      }catch(Exception e){
	         e.printStackTrace();
	         throw new Exception("Unable to update user: "+e.getMessage());
	      }
	     
	   }
	  
	    //add student
	      public void addStudent(int enrolled,int graduation,String username,String password,boolean campus) throws Exception{
	      PreparedStatement psmt = null;
	      String sql = "insert into student values " + "(?,?,?,?,?); ";
	      try {
	         psmt = ServerCon.prepareStatement(sql);
	         psmt.setInt(1, enrolled);
	         psmt.setInt(2, graduation);
	         psmt.setString(3, username);
	         psmt.setString(4, password);
	         if (campus){
	         psmt.setInt(5, 1);
	          }else{
	          psmt.setInt(5, 0);

	          }
	  
	        
	         psmt.executeUpdate();
	      }catch(Exception e){
	         e.printStackTrace();
	         throw new Exception("Unable to update student: "+e.getMessage());
	      }
	     
	   }

	  

	 //add staff
	      public void addStaff(boolean admin,String username,String password) throws Exception{
	      PreparedStatement psmt = null;
	      String sql = "insert into staff values " + "(?,?,?); ";
	      try {
	         psmt = ServerCon.prepareStatement(sql);
	         if(admin){
	         psmt.setInt(1, 1);
	         }else{
	         psmt.setInt(1, 0);
	         }
	  
	         psmt.setString(2, username);
	         psmt.setString(3, password);
	             
	        
	         psmt.executeUpdate();
	      }catch(Exception e){
	         e.printStackTrace();
	         throw new Exception("Unable to update stff: "+e.getMessage());
	      }
	     
	   }
	    //add payment
	      public void addPayment(String username,String password,String pay_num) throws Exception{
	      PreparedStatement psmt = null;
	      String sql = "insert into payment values " + "(?,?,?); ";
	      try {
	         psmt = ServerCon.prepareStatement(sql);
	         psmt.setString(1, username);
	         psmt.setString(2, password);
	         psmt.setString(3, pay_num);
	        
	        
	 
	        
	         psmt.executeUpdate();
	      }catch(Exception e){
	         e.printStackTrace();
	         throw new Exception("Unable to update payment: "+e.getMessage());
	      }
	     
	   }
	      //add cash
	      public void addCash(String pay_num,String office,double cash) throws Exception{
	      PreparedStatement psmt = null;
	      String sql = "insert into cash values " + "(?,?,?); ";
	      try {
	         psmt = ServerCon.prepareStatement(sql);
	         psmt.setString(1, pay_num);
	         psmt.setString(2, office);
	         psmt.setDouble(3, cash);
	        
	        
	 
	        
	         psmt.executeUpdate();
	      }catch(Exception e){
	         e.printStackTrace();
	         throw new Exception("Unable to update cash: "+e.getMessage());
	      }
	     
	   }
	     
	   //add credit card
	      public void addCard(String pay_num,String company,String address,int zipcode, String city,String state) throws Exception{
	      PreparedStatement psmt = null;
	      String sql = "insert into credit_card values " + "(?,?,?,?,?,?); ";
	      try {
	         psmt = ServerCon.prepareStatement(sql);
	         psmt.setString(1, pay_num);
	         psmt.setString(2, company);
	         psmt.setString(3, address);
	         psmt.setInt(4, zipcode);
	         psmt.setString(5, city);
	         psmt.setString(6, state);
	        
	 
	        
	         psmt.executeUpdate();
	      }catch(Exception e){
	         e.printStackTrace();
	         throw new Exception("Unable to update credit_card: "+e.getMessage());
	      }
	     
	   }
	    //add city
	      public void addCity(String city) throws Exception{
	      PreparedStatement psmt = null;
	      String sql = "insert into city values " + "(?); ";
	      try {
	         psmt = ServerCon.prepareStatement(sql);
	         psmt.setString(1, city);
	     
	  
	       
	         psmt.executeUpdate();
	      }catch(Exception e){
	         e.printStackTrace();
	         throw new Exception("Unable to update city: "+e.getMessage());
	      }
	     
	   }
	
	    //add permit
	      public void addPermit(int price, int duration,String begin,String end,String type) throws Exception{
	      PreparedStatement psmt = null;
	      String sql = "insert into permit values " + "(?,?,?,?,?); ";
	      try {
	         psmt = ServerCon.prepareStatement(sql);
	         psmt.setInt(1, price);
	         psmt.setInt(2, duration);
	         psmt.setString(3,begin);
	         psmt.setString(4, end);
	         psmt.setString(5, type);
	      
	        
	 
	        
	         psmt.executeUpdate();
	      }catch(Exception e){
	         e.printStackTrace();
	         throw new Exception("Unable to update permit: "+e.getMessage());
	      }
	     
	   }
	      //add parking_lot
	      public void addLot(String num,int resevered,int available,int permit, double hour) throws Exception{
	      PreparedStatement psmt = null;
	      String sql = "insert into lot_number values " + "(?,?,?,?,?); ";
	      try {
	         psmt = ServerCon.prepareStatement(sql);
	         psmt.setString(1, num);
	         psmt.setInt(2, resevered);
	         psmt.setInt(3,available);
	         psmt.setInt(4, permit);
	         psmt.setDouble(5, hour);
	      
	        
	 
	        
	         psmt.executeUpdate();
	      }catch(Exception e){
	         e.printStackTrace();
	         throw new Exception("Unable to update lot_number: "+e.getMessage());
	      }
	     
	   }
	    //add parking_price
	      public void addPrice(String num,int cost,int cost_hour,int limit, int holiday) throws Exception{
	      PreparedStatement psmt = null;
	      String sql = "insert into parking_price values " + "(?,?,?,?,?); ";
	      try {
	         psmt = ServerCon.prepareStatement(sql);
	         psmt.setString(1, num);
	         psmt.setInt(2, cost);
	         psmt.setInt(3,cost_hour);
	         psmt.setInt(4, limit);
	         psmt.setInt(5, holiday);
	      
	        
	 
	        
	         psmt.executeUpdate();
	      }catch(Exception e){
	         e.printStackTrace();
	         throw new Exception("Unable to update parking_price: "+e.getMessage());
	      }
	     
	   }
	      //add indoor
	      public void addIndoor(String num,String building,int floor,int size,String open,String end) throws Exception{
	      PreparedStatement psmt = null;
	      String sql = "insert into  indoor values " + "(?,?,?,?,?,?); ";
	      try {
	         psmt = ServerCon.prepareStatement(sql);
	         psmt.setString(1, num);
	         psmt.setString(2, building);
	         psmt.setInt(3,floor);
	         psmt.setInt(4, size);
	         psmt.setString(5, open);
	         psmt.setString(6, end);
	        
	 
	        
	         psmt.executeUpdate();
	      }catch(Exception e){
	         e.printStackTrace();
	         throw new Exception("Unable to update  indoor: "+e.getMessage());
	      }
	     
	   }
	      //add outdoor
	      public void addOutdoor(String num,String street,int size) throws Exception{
	      PreparedStatement psmt = null;
	      String sql = "insert into  outdoor values " + "(?,?,?); ";
	      try {
	         psmt = ServerCon.prepareStatement(sql);
	         psmt.setString(1, num);
	         psmt.setString(2, street);
	         psmt.setInt(3,size);
	     
	 
	        
	         psmt.executeUpdate();
	      }catch(Exception e){
	         e.printStackTrace();
	         throw new Exception("Unable to update  outdoor: "+e.getMessage());
	      }
	     
	   }
	      //add one_time_parking
	      public void addOne_time(String num,String vehicle,int paid,double hour,int cost) throws Exception{
	      PreparedStatement psmt = null;
	      String sql = "insert into  one_time_parking values " + "(?,?,?,?,?); ";
	      try {
	         psmt = ServerCon.prepareStatement(sql);
	         psmt.setString(1, num);
	         psmt.setString(2,vehicle);
	         psmt.setInt(3,paid);
	         psmt.setDouble(4, hour);
	         psmt.setInt(5, cost);

	        
	 
	        
	         psmt.executeUpdate();
	      }catch(Exception e){
	         e.printStackTrace();
	         throw new Exception("Unable to update  one_time_parking: "+e.getMessage());
	      }
	     
	   }
	      //add purchase_pemit
	      public void addPurchase(String username,String password,String pay_num,String type,String date,String lot) throws Exception{
	      PreparedStatement psmt = null;
	      String sql = "insert into  purchase_pemit values " + "(?,?,?,?,?,?); ";
	      try {
	         psmt = ServerCon.prepareStatement(sql);
	         psmt.setString(1, username);
	         psmt.setString(2,password);
	         psmt.setString(3,pay_num);
	         psmt.setString(4, type);
	         psmt.setString(5,date);
	         psmt.setString(6,lot);
	        
	 
	        
	         psmt.executeUpdate();
	      }catch(Exception e){
	         e.printStackTrace();
	         throw new Exception("Unable to update  purchase_pemit: "+e.getMessage());
	      }
	     
	   }
	
	//list user
	public List<User> getUserList() throws Exception {
		listuser = new ArrayList<User>();
		String sql = "select *"+ " from user";
		Statement smt = null;
		try{
			smt = ServerCon.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while(rs.next()){
				String username=rs.getString("username");
					
					String password=rs.getString("password");
					String last=rs.getString("last_name");
					String first=rs.getString("first_name");
					String email= rs.getString("email");
					int phone= rs.getInt("phone");
					String vehicle=rs.getString("vehicle_plate_number");
				User s = new User(username, password,email, last, first,phone,vehicle);
				listuser.add(s);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("Unable to retrieve user information: "+ e.getMessage());
		}finally{
			if(smt != null)
				smt.close();
		}
		
		return listuser;
	}
	//list student
	public List<Student> getStudentList() throws Exception {
		listStudent = new ArrayList<Student>();
		String sql = "select *"+ " from student";
		Statement smt = null;
		try{
			smt = ServerCon.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while(rs.next()){
				String username=rs.getString("user_username");
					
					String password=rs.getString("user_password");
					int enrolled=rs.getInt("enrolled_year");
					int graduation=rs.getInt("enrolled_year");
					int campus=rs.getInt("is_live_campus");
					
				Student s = new Student(enrolled,graduation,username,password,campus);
				listStudent.add(s);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("Unable to retrieve student information: "+ e.getMessage());
		}finally{
			if(smt != null)
				smt.close();
		}
		
		return listStudent;
	}
	//list staff
	public List<Staff> getStaffList() throws Exception {
		listStaff = new ArrayList<Staff>();
		String sql = "select *"+ " from staff";
		Statement smt = null;
		try{
			smt = ServerCon.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while(rs.next()){
				String username=rs.getString("user_username");
					
					String password=rs.getString("user_password");
					int admin=rs.getInt("is_admin");
					
					
				Staff s = new Staff(username,password,admin);
				listStaff.add(s);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("Unable to retrieve staff information: "+ e.getMessage());
		}finally{
			if(smt != null)
				smt.close();
		}
		
		return listStaff;
	}
	//list permit
	public List<Permit> getPermitList() throws Exception {
		listPermit = new ArrayList<Permit>();
		String sql = "select *"+ " from permit";
		Statement smt = null;
		try{
			smt = ServerCon.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while(rs.next()){
				String end=rs.getString("end_date");
				String type=rs.getString("permit_type");
					String begin=rs.getString("begin_date");
					int duration=rs.getInt("duration");
					int price=rs.getInt("price");
					
				Permit s = new Permit(price,duration,begin,end,type);
				listPermit.add(s);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("Unable to retrieve Permit information: "+ e.getMessage());
		}finally{
			if(smt != null)
				smt.close();
		}
		
		return listPermit;
	}
//list lot
	public List<Lot> getLotList() throws Exception{
		listLot = new ArrayList<Lot>();
		
		String sql = "select * from parking_lot"
				+ " where is_resevered != 1" 
				+ " and is_available !=1 " ;
		Statement smt = null;
		try{
			smt = ServerCon.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while(rs.next()){
				int resevered = rs.getInt("is_resevered");
				int available = rs.getInt("is_available");
				int permit= rs.getInt("is_permit");
				String num = rs.getString("lot_number");
				double hour = rs.getDouble("hour_used");
				Lot s = new Lot(num,resevered,available,permit,hour);
				listLot.add(s);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception ("Unable to retrieve lot information: " + e.getMessage());
		}finally{
			if (smt != null)
				smt.close();
		}
		return listLot;
	}
	
}
