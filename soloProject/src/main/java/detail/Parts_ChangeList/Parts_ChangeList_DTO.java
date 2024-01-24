package detail.Parts_ChangeList;

public class Parts_ChangeList_DTO {
	private int partsChangeList_no;
	private int partsChange_no;
	private int goodsDetail_no;
	private int addPay;
	
	public Parts_ChangeList_DTO() {}

	public Parts_ChangeList_DTO(int partsChangeList_no, int partsChange_no, int goodsDetail_no, int addPay) {
		super();
		this.partsChangeList_no = partsChangeList_no;
		this.partsChange_no = partsChange_no;
		this.goodsDetail_no = goodsDetail_no;
		this.addPay = addPay;
	}

	public int getPartsChangeList_no() {
		return partsChangeList_no;
	}

	public void setPartsChangeList_no(int partsChangeList_no) {
		this.partsChangeList_no = partsChangeList_no;
	}

	public int getPartsChange_no() {
		return partsChange_no;
	}

	public void setPartsChange_no(int partsChange_no) {
		this.partsChange_no = partsChange_no;
	}

	public int getGoodsDetail_no() {
		return goodsDetail_no;
	}

	public void setGoodsDetail_no(int goodsDetail_no) {
		this.goodsDetail_no = goodsDetail_no;
	}

	public int getAddPay() {
		return addPay;
	}

	public void setAddPay(int addPay) {
		this.addPay = addPay;
	}
	
	
}
