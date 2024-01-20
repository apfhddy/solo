package detail.Order_Parts;

import org.apache.ibatis.session.SqlSession;

public class Order_Parts_DAO {
	private SqlSession sqlSession;
	
	public Order_Parts_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
