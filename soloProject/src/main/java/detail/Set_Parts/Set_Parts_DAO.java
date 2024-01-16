package detail.Set_Parts;

import org.apache.ibatis.session.SqlSession;

public class Set_Parts_DAO {
	private SqlSession sqlSession;
	
	public Set_Parts_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
