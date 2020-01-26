import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.swing.*;
import java.awt.*;
import java.util.List;
//import java.util.Date;

public class PakringGUI extends JFrame implements ActionListener, TableModelListener {
	private static final long serialVersionUID = 1L;
	private JButton UserBtn= new JButton("User list"), 
			StudentBtn = new JButton("student list"),
			StaffBtn = new JButton("staff list"),
			addstaffbtn = new JButton("Create staff"), 
			
			bookbtn = new JButton("Book a space"),
			permitbtn = new JButton("Permit price");
	private ParkingDB db;
	
	
	private JPanel ButtonsPnl, Content, userPnl,staffPnl,staffAddPnl,permitPnl,  bookPnl,spaPnl,studentPnl;
	
	//add staff
	private JTextField[] staffaddtex = new JTextField[4];
	private JLabel[] staffaddlabel = new JLabel[4];
	private JButton staffadd = new JButton("Add Staff");

	//update permit
	private Object[][] permitdata;
	private List<Permit> listpermit;
	private static String[] permitcolumn = {"permit type","duration(day)","price","start date","end date"};
	private JTable permittable;
	private JScrollPane permitscroll;
	//update staff
		private Object[][] staffdata;
		private List<Staff> liststaff;
		private static String[] staffcolumn = {"username","password","admin"};
		private JTable stafftable;
		private JScrollPane staffscroll;
	//update user
	private Object[][] userdata;
	private List<User> listuser;
	private static String[] usercolumn = {"username","password","email","last_name","first_name","phone","vehiclePlate"};
	private JTable usertable;
	private JScrollPane userscroll;
	
	//update student
		private Object[][] studentdata;
		private List<Student> liststudent;
		private static String[] studentcolumn = {"username","password","enrolled_year","graduation_year","live in campus?"};
		private JTable studenttable;
		private JScrollPane studentscroll;
		
	
		//update student
				private Object[][] lotdata;
				private List<Student> listlot;
				private static String[] lotcolumn = {"Lot number","is_resevered","is_available","is permit only","hourused"};
				private JTable lottable;
				private JScrollPane lotscroll;
	//book space
	private JButton bookspa = new JButton("Book");
	private JTextField[] booktex = new JTextField[5];
	private JLabel[] bookLabel = new JLabel[5]; 
	private static Date date = new Date(System.currentTimeMillis());
	private Object[][] spacedata;
	//private List<Space> listSpace;
	private static String[] spacecolumn = {"spanum","spatype","lotname"};
	private JTable spacetable;
	private JScrollPane spacescroll;
	
	
	/**
	 * Constructor for PakringGUI.
	 * Create connection with database
	 * and launch the main panel.
	 */
	public PakringGUI() {
		super("Pakring Application");
		try{
			db = new ParkingDB();
		}catch(Exception e){
			JOptionPane.showMessageDialog(this,"Error: " + e.getMessage());
			return;
		}
		createGUI();
		setVisible(true);
		setSize(1500, 1200);
	}
	
	
	/**
	 * Create panels for 
	 * add staff, staff list, add space, add lot, assign space and booking space 
	 */
	private void createGUI(){
		//initial JPanels
		ButtonsPnl = new JPanel();
		Content = new JPanel();
		//Content.setPreferredSize(new Dimension(500, 600));
		
		//link button with action
		addstaffbtn.addActionListener(this);		
		UserBtn.addActionListener(this);
		StudentBtn.addActionListener(this);
		StaffBtn.addActionListener(this);
		
		bookbtn.addActionListener(this);
		permitbtn.addActionListener(this);
		
		//add tabs
		ButtonsPnl.add(addstaffbtn);
		ButtonsPnl.add(UserBtn);
		ButtonsPnl.add(StudentBtn);
		ButtonsPnl.add(StaffBtn);
		ButtonsPnl.add(permitbtn);
	
		ButtonsPnl.add(bookbtn);
		add(ButtonsPnl, BorderLayout.NORTH);
		
		//Staff add page
		staffAddPnl = new JPanel();
		staffAddPnl.setLayout(new GridLayout(6, 0));
		String staffaddlables[] = {
				"Enter staff id: ", 
				"Enter staff name: ",
				"Enter staff telephone: ",
				"Enter staff vehcle number: "
				};
		for(int i=0; i<staffaddlables.length; i++){
			JPanel pan = new JPanel();
			staffaddlabel[i] = new JLabel(staffaddlables[i]);
			staffaddtex[i] = new JTextField(50);
			pan.add(staffaddlabel[i]);
			pan.add(staffaddtex[i]);
			staffAddPnl.add(pan);
		}
		JPanel pan = new JPanel();
		staffadd.addActionListener(this);
		pan.add(staffadd);
		staffAddPnl.add(pan);
		Content.add(staffAddPnl);
		
	
	
		
		
		
		//book space page
		bookPnl = new JPanel();
		bookPnl.setLayout(new GridLayout(6,0));
		String spacelabels [] ={
				"Enter booking id: ",
				"Enter space id: ",
				"Enter staff id: ",
				"Enter vehicle number: ",
				"Enter the date of visit: "
		};
		for(int i =0; i<spacelabels.length;i++){
			JPanel panbook = new JPanel();
			bookLabel[i] = new JLabel(spacelabels[i]);
			if (i==booktex.length-1)
				booktex[i] = new JTextField(date.toString(),25);
			else booktex[i]=new JTextField(25);
			panbook.add(bookLabel[i]);
			panbook.add(booktex[i]);
			bookPnl.add(panbook);
		}
		JPanel panbook = new JPanel();
		bookspa.addActionListener(this);
		panbook.add(bookspa);
		bookPnl.add(panbook);
		spaPnl = new JPanel();
		try{
			//listSpace = db.getValidSpaceList();	
		}catch(Exception er){
			JOptionPane.showMessageDialog(this,"Error: " + er.getMessage());
			return;
		}
	
		
		spacetable = new JTable(spacedata, spacecolumn);
		spacescroll = new JScrollPane(spacetable);
		spaPnl.add(spacescroll);
		
		add(Content, BorderLayout.CENTER);
	}
	
	
	/*
	 *  change panel when different tabs are clicked 
	
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//user list page
		if(e.getSource() == UserBtn){
			Content.removeAll();
			userPnl = new JPanel();
			try{
				listuser = db.getUserList();
			}catch(Exception er){
				er.printStackTrace();
				JOptionPane.showMessageDialog(this,"Error: " + er.getMessage());
				return;
			}
			
			userdata = new Object[listuser.size()][usercolumn.length];
			for(int i=0; i<listuser.size();i++){
				userdata[i][0] = listuser.get(i).getusername();
				userdata[i][1] = listuser.get(i).getpassword();
				userdata[i][2] = listuser.get(i).getemail();
				userdata[i][3] = listuser.get(i).getlast();
				userdata[i][4] = listuser.get(i).getfirst();
				userdata[i][5] = listuser.get(i).getphone();
				userdata[i][6] = listuser.get(i).getvehicle();
			}
			usertable = new JTable(userdata, usercolumn);
			userscroll = new JScrollPane(usertable);
			userscroll.setPreferredSize(new Dimension(750, 700));
			userPnl.add(userscroll);
			usertable.getModel().addTableModelListener(this);
			Content.add(userPnl);
			Content.revalidate();
			this.repaint();
		}else if(e.getSource() == StudentBtn) {
			Content.removeAll();
			studentPnl = new JPanel();
			try{
				liststudent = db.getStudentList();
			}catch(Exception er){
				er.printStackTrace();
				JOptionPane.showMessageDialog(this,"Error: " + er.getMessage());
				return;
			}
			
			studentdata = new Object[liststudent.size()][studentcolumn.length];
			for(int i=0; i<liststudent.size();i++){
				studentdata[i][0] = liststudent.get(i).getusername();
				studentdata[i][1] = liststudent.get(i).getpassword();
				studentdata[i][2] = liststudent.get(i).getenrolled();
				studentdata[i][3] = liststudent.get(i).getgraduation();
				if(liststudent.get(i).getcampus()==1) {
				studentdata[i][4] = "Yes";
				}else {
					
					studentdata[i][4] = "No";
				}
			}
			studenttable = new JTable(studentdata, studentcolumn);
			studentscroll = new JScrollPane(studenttable);
			studentscroll.setPreferredSize(new Dimension(750, 700));
			studentPnl.add(studentscroll);
			studenttable.getModel().addTableModelListener(this);
			Content.add(studentPnl);
			Content.revalidate();
			this.repaint();
			
		
		
		}else if(e.getSource() == permitbtn) {
			Content.removeAll();
			permitPnl = new JPanel();
			try{
				listpermit = db.getPermitList();
			}catch(Exception er){
				er.printStackTrace();
				JOptionPane.showMessageDialog(this,"Error: " + er.getMessage());
				return;
			}
			
			permitdata = new Object[listpermit.size()][permitcolumn.length];
			for(int i=0; i<listpermit.size();i++){
				permitdata[i][0] = listpermit.get(i).gettype();
				permitdata[i][1] = listpermit.get(i).getduration();
				permitdata[i][2] = listpermit.get(i).getprice();
				permitdata[i][3] = listpermit.get(i).getbegin();
				permitdata[i][4] = listpermit.get(i).getend();
			}
			permittable = new JTable(permitdata, permitcolumn);
			permitscroll = new JScrollPane(permittable);
			permitscroll.setPreferredSize(new Dimension(750, 700));
			permitPnl.add(permitscroll);
			permittable.getModel().addTableModelListener(this);
			Content.add(permitPnl);
			Content.revalidate();
			this.repaint();
			
		
		}else if(e.getSource() == StaffBtn) {
			Content.removeAll();
			staffPnl = new JPanel();
			try{
				liststaff = db.getStaffList();
			}catch(Exception er){
				er.printStackTrace();
				JOptionPane.showMessageDialog(this,"Error: " + er.getMessage());
				return;
			}
			
			staffdata = new Object[liststaff.size()][staffcolumn.length];
			for(int i=0; i<liststaff.size();i++){
				staffdata[i][0] = liststaff.get(i).getusername();
				staffdata[i][1] = liststaff.get(i).getpassword();
				
				
				if(liststaff.get(i).getadmin()==1) {
					staffdata[i][2] = "Yes";
				}else {
					
					staffdata[i][2] = "no";
				}
			}
			stafftable = new JTable(staffdata, staffcolumn);
			staffscroll = new JScrollPane(stafftable);
			staffscroll.setPreferredSize(new Dimension(750, 700));
			staffPnl.add(staffscroll);
			stafftable.getModel().addTableModelListener(this);
			Content.add(staffPnl);
			Content.revalidate();
			this.repaint();
			
		
		}else if(e.getSource() == bookbtn) {
			Content.removeAll();
			staffPnl = new JPanel();
			try{
				liststaff = db.getStaffList();
			}catch(Exception er){
				er.printStackTrace();
				JOptionPane.showMessageDialog(this,"Error: " + er.getMessage());
				return;
			}
			
			staffdata = new Object[liststaff.size()][staffcolumn.length];
			for(int i=0; i<liststaff.size();i++){
				staffdata[i][0] = liststaff.get(i).getusername();
				staffdata[i][1] = liststaff.get(i).getpassword();
				
				
				if(liststaff.get(i).getadmin()==1) {
					staffdata[i][2] = "Yes";
				}else {
					
					staffdata[i][2] = "no";
				}
			}
			stafftable = new JTable(staffdata, staffcolumn);
			staffscroll = new JScrollPane(stafftable);
			staffscroll.setPreferredSize(new Dimension(750, 700));
			staffPnl.add(staffscroll);
			stafftable.getModel().addTableModelListener(this);
			Content.add(staffPnl);
			Content.revalidate();
			this.repaint();
			
		
		}
	}//action
	
	
	@Override
	public void tableChanged(TableModelEvent e) {
		
       
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		PakringGUI gui = new PakringGUI();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
