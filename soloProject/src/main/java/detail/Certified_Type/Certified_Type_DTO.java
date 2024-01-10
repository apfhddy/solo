package detail.Certified_Type;

public class Certified_Type_DTO {
	private int certifiedType_no;
	private String name;
	
	public Certified_Type_DTO() {}

	public Certified_Type_DTO(int certifiedType_no, String name) {
		super();
		this.certifiedType_no = certifiedType_no;
		this.name = name;
	}

	public int getCertifiedType_no() {
		return certifiedType_no;
	}

	public void setCertifiedType_no(int certifiedType_no) {
		this.certifiedType_no = certifiedType_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
