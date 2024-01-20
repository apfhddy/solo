package detail.Orders;

import org.apache.ibatis.session.SqlSession;

public class Orders_DAO {
	private SqlSession sqlSession;
	
	public Orders_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
