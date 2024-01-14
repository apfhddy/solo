package detail.Goods_Size;

public class Goods_Size_DTO {
	private int goodsSize_no;
	private String name;
	private int sort;
	private int setCheck;
	
	public Goods_Size_DTO() {}

	public Goods_Size_DTO(int goodsSize_no, String name, int sort, int setCheck) {
		super();
		this.goodsSize_no = goodsSize_no;
		this.name = name;
		this.sort = sort;
		this.setCheck = setCheck;
	}

	public int getGoodsSize_no() {
		return goodsSize_no;
	}

	public void setGoodsSize_no(int goodsSize_no) {
		this.goodsSize_no = goodsSize_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getSetCheck() {
		return setCheck;
	}

	public void setSetCheck(int setCheck) {
		this.setCheck = setCheck;
	}
	
	
}
