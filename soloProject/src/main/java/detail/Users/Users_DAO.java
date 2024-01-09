package detail.Users;

import org.apache.ibatis.session.SqlSession;

public class Users_DAO {
	private SqlSession sqlSession;
	
	public Users_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int nextSequence() {
		return sqlSession.selectOne("users.nextSequence");
	}
	
	public int inesrtUser(Users_DTO dto) {
		return sqlSession.insert("users.insertUser",dto);
	}
	
	public Users_DTO userSelect(String id) {
		return sqlSession.selectOne("users.userSelect",id);
	}
	
	public int userUpdate(Users_DTO dto) {
		return sqlSession.update("users.userUpdate",dto);
	}
}
