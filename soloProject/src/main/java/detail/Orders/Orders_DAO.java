package detail.Orders;

import org.apache.ibatis.session.SqlSession;

public class Orders_DAO {
	private SqlSession sqlSession;
	
	public Orders_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int getNextNo() {
		return sqlSession.selectOne("orders.getNextNo");
	}
	
	public int insertOrders(Orders_DTO dto) {
		return sqlSession.insert("orders.insertOrders",dto);
	}
}
