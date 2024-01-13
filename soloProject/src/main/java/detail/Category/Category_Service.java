package detail.Category;

import java.util.List;

public class Category_Service {
	private Category_DAO category_DAO;
	
	public Category_Service(Category_DAO category_DAO) {
		this.category_DAO = category_DAO;
	}
	
	public List<Category_DTO> getCategoryList(int menuType_no){
		return category_DAO.getCategoryList(menuType_no);
	}
}
