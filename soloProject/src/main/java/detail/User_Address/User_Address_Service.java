package detail.User_Address;

import java.util.List;
import java.util.Map;

public class User_Address_Service {
	private User_Address_DAO user_Address_DAO;
	
	public User_Address_Service(User_Address_DAO user_Address_DAO) {
		this.user_Address_DAO = user_Address_DAO;
	}
	
	public List<User_Address_DTO> getAddrList(int user_no) {
		return user_Address_DAO.getAddrList(user_no);
	}
	
	public int rownumUpdate(Map<String, Object> map) {
		return user_Address_DAO.rownumUpdate(map);
	}
	
	public int addrDelete(Map<String, Object> map) {
		return user_Address_DAO.addrDelete(map);
	}
	
	public int addrInsert(User_Address_DTO dto) {
		return user_Address_DAO.addrInsert(dto);
	}
	
	public int getNextNo() {
		return user_Address_DAO.getNextNo();
	}

}
