package detail.Goods;

public class Goods_DTO {
	private int goods_no;
	private String name;
	private String filePath;
	private int main_no;
	private String allergy;
	private String origin;
	private int exhibition;

	public Goods_DTO() {}

	public Goods_DTO(int goods_no, String name, String filePath, int main_no, String allergy, String origin,
			int exhibition) {
		super();
		this.goods_no = goods_no;
		this.name = name;
		this.filePath = filePath;
		this.main_no = main_no;
		this.allergy = allergy;
		this.origin = origin;
		this.exhibition = exhibition;
	}

	public int getGoods_no() {
		return goods_no;
	}

	public void setGoods_no(int goods_no) {
		this.goods_no = goods_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getMain_no() {
		return main_no;
	}

	public void setMain_no(int main_no) {
		this.main_no = main_no;
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

	public int getExhibition() {
		return exhibition;
	}

	public void setExhibition(int exhibition) {
		this.exhibition = exhibition;
	}



	
	
}
