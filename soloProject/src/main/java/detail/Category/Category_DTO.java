package detail.Category;

public class Category_DTO {
	private int category_no;
	private int menuType_no;
	private String name;
	
	public Category_DTO() {}

	public Category_DTO(int category_no, int menuType_no, String name) {
		super();
		this.category_no = category_no;
		this.menuType_no = menuType_no;
		this.name = name;
	}

	public int getCategory_no() {
		return category_no;
	}

	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}

	public int getMenuType_no() {
		return menuType_no;
	}

	public void setMenuType_no(int menuType_no) {
		this.menuType_no = menuType_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
