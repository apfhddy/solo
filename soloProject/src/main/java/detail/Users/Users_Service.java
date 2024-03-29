package detail.Users;

import java.util.HashMap;
import java.util.Map;

import common.Encry;
import detail.Terms.Terms_DAO;
import detail.User_Address.User_Address_DAO;
import detail.User_Address.User_Address_DTO;
import detail.User_Terms.User_Terms_DAO;
import detail.User_Terms.User_Terms_DTO;

public class Users_Service {
	private Users_DAO users_DAO;
	private User_Address_DAO user_Address_DAO;
	private User_Terms_DAO user_Terms_DAO;
	
	public Users_Service(Users_DAO users_DAO,User_Address_DAO user_Address_DAO,User_Terms_DAO user_Terms_DAO) {
		this.users_DAO = users_DAO;
		this.user_Address_DAO = user_Address_DAO;
		this.user_Terms_DAO = user_Terms_DAO;
	}
	
	public int insertUser(Map<String,Object> userData) {
		User_Address_DTO addr_DTO = (User_Address_DTO)userData.get("addr");
		Users_DTO users_DTO = (Users_DTO)userData.get("detail");
		User_Terms_DTO[] userTerms = (User_Terms_DTO[])userData.get("userTerms");
		
		int user_no = users_DAO.nextSequence();
		
		String salt = Encry.getSalt();
		String pw = Encry.encry(users_DTO.getPw(), salt);
		
		addr_DTO.setUser_no(user_no);
		int userAddr_no = user_Address_DAO.getNextNo();
		
		addr_DTO.setUserAddr_no(userAddr_no);
		user_Address_DAO.addrInsert(addr_DTO);
		
		
		users_DTO.setUser_no(user_no);
		users_DTO.setSalt(salt);
		users_DTO.setPw(pw);
		users_DTO.setUserAddr_no(userAddr_no);
		
		int success = users_DAO.inesrtUser(users_DTO);
		
		if(success == 1) {
			for(User_Terms_DTO userTermsDTO : userTerms) {
				userTermsDTO.setUser_no(user_no);
				user_Terms_DAO.userTermsInsert(userTermsDTO);
			}
		}
		
			
		return success; 
	}
	
	public Users_DTO userSelect(String id) {
		return users_DAO.userSelect(id);
	}
	
	public int userUpdate(Users_DTO dto) {
		return users_DAO.userUpdate(dto);
	}
	
	public boolean loginCheck(String id,String pw) {
		Users_DTO users_DTO = userSelect(id);
		if(users_DTO == null)return true;
		
		pw = Encry.encry(pw,users_DTO.getSalt()); 
		
		if(!((String)users_DTO.getPw()).equals(pw)) {
			return true;
		}
		return false;
	}
	
	public boolean checkEmailOrPhone(int type,String value) {
		Map<String,Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("type", type);
		parameterMap.put("value", value);
		return users_DAO.checkEmailOrPhone(parameterMap);
	}
	
}
