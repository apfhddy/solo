package detail.User_Address;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class User_Address_DAO {
	private SqlSession sqlSession;
	
	public User_Address_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int addrInsert(User_Address_DTO dto){
		int userAddr_no = sqlSession.selectOne("user_Address.nextSequence");
		
		dto.setUserAddr_no(userAddr_no);
		
		sqlSession.insert("user_Address.addrInsert",dto);
		
		return userAddr_no;
	}
	
	public List<User_Address_DTO> allAddrList(int user_no){
		return sqlSession.selectList("user_Address.allAddrList",user_no);
	}
	
	public int rownumUpdate(Map<String,Object> map) {
		return sqlSession.update("user_Address.rownumUpdate",map);
	}
	
	public int addrDelete(Map<String,Object> map) {
		return sqlSession.delete("user_Address.addrDelete",map);
	}
	
	
}
