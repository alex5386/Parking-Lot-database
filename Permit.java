
public class Permit {

	private int price;
	private int duration;
	private String begin;
	private String end;
	private String type;

	
	public Permit(	
			int price,
			int duration,
			String begin,
			String end,
			String type
	) {
		setbegin(begin);
		setend(end);
		setprice(price);
		setduration(duration) ;
		settype(type) ;
	}

	
	public String getbegin() {
		return begin;
	}

	
	public void setbegin(String begin) {
		this.begin = begin;
	}
	
	public String getend() {
		return end;
	}

	
	public void setend(String end) {
		this.end= end;
	}
	
	
	public int getprice() {
		return price;
	}

	
	public void setprice(int  price) {
		this.price = price;
	}

	public int getduration() {
		return duration;
	}

	
	public void setduration(int  duration) {
		this.duration=duration;
	}
	public String gettype() {
		return type;
	}

	
	public void settype(String type) {
		this.type=type;
	}

	

	
}
