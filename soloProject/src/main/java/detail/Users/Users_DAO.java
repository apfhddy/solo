package detail.Users;

import org.apache.ibatis.session.SqlSession;

public class Users_DAO {
	private SqlSession sqlSession;
	
	public Users_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
