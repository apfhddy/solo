package detail.Category;

import org.apache.ibatis.session.SqlSession;

public class Category_DAO {
	private SqlSession sqlSession;
	
	public Category_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
