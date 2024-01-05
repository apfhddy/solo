package detail.User_Terms;

import org.apache.ibatis.session.SqlSession;

public class User_Terms_DAO {
private SqlSession sqlSession;
	
	public User_Terms_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
