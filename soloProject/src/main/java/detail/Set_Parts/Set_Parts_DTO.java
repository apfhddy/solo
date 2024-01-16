package detail.Set_Parts;

public class Set_Parts_DTO {
	private int setParts_no;
	private int m_goodsDetail_no;
	private int p_goodsDetail_no;
	private int partsChange_no;
	
	public Set_Parts_DTO() {}

	public Set_Parts_DTO(int setParts_no, int m_goodsDetail_no, int p_goodsDetail_no, int partsChange_no) {
		super();
		this.setParts_no = setParts_no;
		this.m_goodsDetail_no = m_goodsDetail_no;
		this.p_goodsDetail_no = p_goodsDetail_no;
		this.partsChange_no = partsChange_no;
	}

	public int getSetParts_no() {
		return setParts_no;
	}

	public void setSetParts_no(int setParts_no) {
		this.setParts_no = setParts_no;
	}

	public int getM_goodsDetail_no() {
		return m_goodsDetail_no;
	}

	public void setM_goodsDetail_no(int m_goodsDetail_no) {
		this.m_goodsDetail_no = m_goodsDetail_no;
	}

	public int getP_goodsDetail_no() {
		return p_goodsDetail_no;
	}

	public void setP_goodsDetail_no(int p_goodsDetail_no) {
		this.p_goodsDetail_no = p_goodsDetail_no;
	}

	public int getPartsChange_no() {
		return partsChange_no;
	}

	public void setPartsChange_no(int partsChange_no) {
		this.partsChange_no = partsChange_no;
	}
	
	
	
	
}
