package detail.Terms;

public class Terms_DTO {
	private int terms_no;
	private String detail;
	
	public Terms_DTO() {}

	public Terms_DTO(int terms_no, String detail) {
		super();
		this.terms_no = terms_no;
		this.detail = detail;
	}

	public int getTerms_no() {
		return terms_no;
	}

	public void setTerms_no(int terms_no) {
		this.terms_no = terms_no;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}
