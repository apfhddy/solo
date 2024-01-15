package detail.Goods_Category;

public class Goods_Category_DTO {
	private int goodsCategory_no;
	private int goods_no;
	private int categoryType_no;
	private int solt;
	
	public Goods_Category_DTO() {}

	public Goods_Category_DTO(int goodsCategory_no, int goods_no, int categoryType_no, int solt) {
		super();
		this.goodsCategory_no = goodsCategory_no;
		this.goods_no = goods_no;
		this.categoryType_no = categoryType_no;
		this.solt = solt;
	}

	public int getGoodsCategory_no() {
		return goodsCategory_no;
	}

	public void setGoodsCategory_no(int goodsCategory_no) {
		this.goodsCategory_no = goodsCategory_no;
	}

	public int getGoods_no() {
		return goods_no;
	}

	public void setGoods_no(int goods_no) {
		this.goods_no = goods_no;
	}

	public int getCategoryType_no() {
		return categoryType_no;
	}

	public void setCategoryType_no(int categoryType_no) {
		this.categoryType_no = categoryType_no;
	}

	public int getSolt() {
		return solt;
	}

	public void setSolt(int solt) {
		this.solt = solt;
	}
	
	
}	
