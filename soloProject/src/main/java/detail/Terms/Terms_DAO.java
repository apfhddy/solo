package detail.Terms;

import org.apache.ibatis.session.SqlSession;

public class Terms_DAO {
	private SqlSession sqlSession;
	
	public Terms_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
