package detail.Users;

public class Users_DTO {
	private int user_no;
	private String email;
	private String pw;
	private String solt;
	private int userAddr_no;
	private String name;
	private int gender;
	private String phone;
	
	public Users_DTO() {}

	public Users_DTO(int user_no, String email, String pw, String solt, int userAddr_no, String name, int gender,
			String phone) {
		super();
		this.user_no = user_no;
		this.email = email;
		this.pw = pw;
		this.solt = solt;
		this.userAddr_no = userAddr_no;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getSolt() {
		return solt;
	}

	public void setSolt(String solt) {
		this.solt = solt;
	}

	public int getUserAddr_no() {
		return userAddr_no;
	}

	public void setUserAddr_no(int userAddr_no) {
		this.userAddr_no = userAddr_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	

	
	
	
	
}
