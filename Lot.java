
public class Lot {

	private String num;
	private int resevered;
	private int available;
	private int permit;
	private double hour;

	
	public Lot(	
			String num,
		int resevered,
			int available,
			 int permit,
			double hour
	) {
		setnum(num);
		setresevered(resevered);
		setavailable(available);
		setavailable(available) ;
		setpermit(permit) ;
		sethour(hour) ;
	}

	
	public String getnum() {
		return num;
	}

	
	public void setnum(String num) {
		this.num = num;
	}
	
	
	public int getresevered() {
		return resevered;
	}

	
	public void setresevered(int  resevered) {
		this.resevered=resevered;
	}
	public int getavailable() {
		return available;
	}

	
	public void setavailable(int  available) {
		this.available=available;
	}
	public int getpermit() {
		return permit;
	}

	
	public void setpermit(int  permit) {
		this.permit=permit;
	}
	public double gethour() {
		return hour;
	}

	
	public void sethour(double hour) {
		this.hour=hour;
	}

	

	
}
