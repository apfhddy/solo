package detail.User_Address;

import org.apache.ibatis.session.SqlSession;

public class User_Address_DAO {
	private SqlSession sqlSession;
	
	public User_Address_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
