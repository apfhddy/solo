package detail.User_Terms;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class User_Terms_DAO {
private SqlSession sqlSession;
	
	public User_Terms_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int userTermsInsert(User_Terms_DTO dto) {
		return sqlSession.insert("user_Terms.userTermsInsert",dto);
	}
	
	public List<Map<String,Object>> getUserTermsList(int user_no){
		return sqlSession.selectList("user_Terms.getUserTermsList",user_no);
	}
	
	public int userTermsUpdate(User_Terms_DTO dto) {
		return sqlSession.update("user_Terms.userTermsUpdate",dto);
	}
}
