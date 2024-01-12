package detail.User_Terms;

import java.util.List;
import java.util.Map;

public class User_Terms_Service {
	private User_Terms_DAO user_Terms_DAO;
	
	public User_Terms_Service(User_Terms_DAO user_Terms_DAO) {
		this.user_Terms_DAO = user_Terms_DAO;
	}
	
	public List<Map<String,Object>> getUserTermsList(int user_no){
		return user_Terms_DAO.getUserTermsList(user_no);
	}
	
	public int userTermsUpdate(User_Terms_DTO dto) {
		return user_Terms_DAO.userTermsUpdate(dto);
	}
}
