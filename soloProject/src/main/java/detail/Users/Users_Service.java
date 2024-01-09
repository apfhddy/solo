package detail.Users;

import java.util.Map;

import common.Encry;
import detail.User_Address.User_Address_DAO;
import detail.User_Address.User_Address_DTO;

public class Users_Service {
	private Users_DAO users_DAO;
	private User_Address_DAO user_Address_DAO;
	
	public Users_Service(Users_DAO users_DAO,User_Address_DAO user_Address_DAO) {
		this.users_DAO = users_DAO;
		this.user_Address_DAO = user_Address_DAO;
	}
	
	public int insertUser(Map<String,Object> userData) {
		User_Address_DTO addr_DTO = (User_Address_DTO)userData.get("addr");
		Users_DTO users_DTO = (Users_DTO)userData.get("detail");
		
		int user_no = users_DAO.nextSequence();
		
		String salt = Encry.getSalt();
		String pw = Encry.encry(users_DTO.getPw(), salt);
		
		addr_DTO.setUser_no(user_no);
		int userAddr_no = user_Address_DAO.addrInsert(addr_DTO);
		
		
		users_DTO.setUser_no(user_no);
		users_DTO.setSalt(salt);
		users_DTO.setPw(pw);
		users_DTO.setUserAddr_no(userAddr_no);
		return users_DAO.inesrtUser(users_DTO);
	}
	
	public Map<String,Object> userData(String id) {
		return users_DAO.userData(id);
	}
	
	
}
