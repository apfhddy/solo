package detail.Order_Total;

import org.apache.ibatis.session.SqlSession;

public class Order_Total_DAO {
	private SqlSession sqlSession;
	
	public Order_Total_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
