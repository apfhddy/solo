package detail.Menu_Type;

import org.apache.ibatis.session.SqlSession;

public class Menu_Type_DAO {
	private SqlSession sqlSession;
	
	public Menu_Type_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
}
