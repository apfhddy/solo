package detail.Users;

public class Users_DTO {
	private int user_no;
	private String email;
	private String pw;
	private String salt;
	private int userAddr_no;
	private String name;
	private int gender;
	private String phone;
	private int certifiedType_no;
	
	public Users_DTO() {}

	public Users_DTO(int user_no, String email, String pw, String salt, int userAddr_no, String name, int gender,
			String phone, int certifiedType_no) {
		super();
		this.user_no = user_no;
		this.email = email;
		this.pw = pw;
		this.salt = salt;
		this.userAddr_no = userAddr_no;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.certifiedType_no = certifiedType_no;
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
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

	public int getCertifiedType_no() {
		return certifiedType_no;
	}

	public void setCertifiedType_no(int certifiedType_no) {
		this.certifiedType_no = certifiedType_no;
	}

	@Override
	public String toString() {
		return "Users_DTO [user_no=" + user_no + ", email=" + email + ", pw=" + pw + ", salt=" + salt + ", userAddr_no="
				+ userAddr_no + ", name=" + name + ", gender=" + gender + ", phone=" + phone + ", certifiedType_no="
				+ certifiedType_no + "]";
	}

	
	
	
}
