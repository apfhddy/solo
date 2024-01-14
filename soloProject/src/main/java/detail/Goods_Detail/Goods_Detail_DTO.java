package detail.Goods_Detail;

public class Goods_Detail_DTO {
	private int goodsDetail_no;
	private int goods_no;
	private int goodsSize_no;
	private String imgPath;
	private int calorie;
	private int price;
	
	public Goods_Detail_DTO() {}

	public Goods_Detail_DTO(int goodsDetail_no, int goods_no, int goodsSize_no, String imgPath, int calorie,
			int price) {
		super();
		this.goodsDetail_no = goodsDetail_no;
		this.goods_no = goods_no;
		this.goodsSize_no = goodsSize_no;
		this.imgPath = imgPath;
		this.calorie = calorie;
		this.price = price;
	}

	public int getGoodsDetail_no() {
		return goodsDetail_no;
	}

	public void setGoodsDetail_no(int goodsDetail_no) {
		this.goodsDetail_no = goodsDetail_no;
	}

	public int getGoods_no() {
		return goods_no;
	}

	public void setGoods_no(int goods_no) {
		this.goods_no = goods_no;
	}

	public int getGoodsSize_no() {
		return goodsSize_no;
	}

	public void setGoodsSize_no(int goodsSize_no) {
		this.goodsSize_no = goodsSize_no;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
