package detail.Menu_Type;

public class Menu_Type_DTO {
	private int menuType_no;
	private String name;
	
	public Menu_Type_DTO() {}

	public Menu_Type_DTO(int menuType_no, String name) {
		super();
		this.menuType_no = menuType_no;
		this.name = name;
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
