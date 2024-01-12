package detail.User_Terms;

public class User_Terms_DTO {
	private int userTerms_no;
	private int user_no;
	private int terms_no;
	private int checked;
	
	public User_Terms_DTO() {}

	public User_Terms_DTO(int userTerms_no, int user_no, int terms_no, int checked) {
		super();
		this.userTerms_no = userTerms_no;
		this.user_no = user_no;
		this.terms_no = terms_no;
		this.checked = checked;
	}

	public int getUserTerms_no() {
		return userTerms_no;
	}

	public void setUserTerms_no(int userTerms_no) {
		this.userTerms_no = userTerms_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getTerms_no() {
		return terms_no;
	}

	public void setTerms_no(int terms_no) {
		this.terms_no = terms_no;
	}

	public int getChecked() {
		return checked;
	}

	public void setChecked(int checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "User_Terms_DTO [userTerms_no=" + userTerms_no + ", user_no=" + user_no + ", terms_no=" + terms_no
				+ ", checked=" + checked + "]";
	}


	
	
}
