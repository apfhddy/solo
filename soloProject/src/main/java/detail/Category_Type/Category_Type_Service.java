package detail.Category_Type;

import java.util.List;

public class Category_Type_Service {
	private Category_Type_DAO category_Type_DAO;
	
	public Category_Type_Service(Category_Type_DAO category_Type_DAO) {
		this.category_Type_DAO = category_Type_DAO;
	}
	
	public List<Category_Type_DTO> getCategoryList(int menuType_no){
		return category_Type_DAO.getCategoryList(menuType_no);
	}
}
