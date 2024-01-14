package detail.Goods;

public class Goods_DTO {
	private int goods_no;
	private int category_no;
	private String name;
	private String allergy;
	private String origin;
	private int sort;
	private int exhibition;

	public Goods_DTO() {}

	public Goods_DTO(int goods_no, int category_no, String name, String allergy, String origin, int sort,
			int exhibition) {
		super();
		this.goods_no = goods_no;
		this.category_no = category_no;
		this.name = name;
		this.allergy = allergy;
		this.origin = origin;
		this.sort = sort;
		this.exhibition = exhibition;
	}

	public int getGoods_no() {
		return goods_no;
	}

	public void setGoods_no(int goods_no) {
		this.goods_no = goods_no;
	}

	public int getCategory_no() {
		return category_no;
	}

	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getExhibition() {
		return exhibition;
	}

	public void setExhibition(int exhibition) {
		this.exhibition = exhibition;
	}

	
	
	
}
