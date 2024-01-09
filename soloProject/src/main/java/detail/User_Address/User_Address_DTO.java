package detail.User_Address;

public class User_Address_DTO {
	private int userAddr_no;
	private int user_no;
	private String location;
	private String detail;
	private String significant;
	
	public User_Address_DTO() {}

	public User_Address_DTO(int userAddr_no, int user_no, String location, String detail, String significant) {
		super();
		this.userAddr_no = userAddr_no;
		this.user_no = user_no;
		this.location = location;
		this.detail = detail;
		this.significant = significant;
	}

	public int getUserAddr_no() {
		return userAddr_no;
	}

	public void setUserAddr_no(int userAddr_no) {
		this.userAddr_no = userAddr_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getSignificant() {
		return significant;
	}

	public void setSignificant(String significant) {
		this.significant = significant;
	}

	@Override
	public String toString() {
		return "User_Address_DTO [userAddr_no=" + userAddr_no + ", user_no=" + user_no + ", location=" + location
				+ ", detail=" + detail + ", significant=" + significant + "]";
	}

	
	
	
	
}
