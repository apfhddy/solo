package detail.Menu_Type;

import java.util.List;

public class Menu_Type_Service {
	private Menu_Type_DAO menu_Type_DAO;
	
	public Menu_Type_Service(Menu_Type_DAO menu_Type_DAO) {
		this.menu_Type_DAO = menu_Type_DAO;
	}
	
	
	public List<Menu_Type_DTO> getChoiceSortList(int no){
		return menu_Type_DAO.getChoiceSortList(no);
	}
	
}
