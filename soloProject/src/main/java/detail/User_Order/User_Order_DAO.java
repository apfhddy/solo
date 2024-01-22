package detail.User_Order;

import org.apache.ibatis.session.SqlSession;

public class User_Order_DAO {
	private SqlSession sqlSession;
	
	public User_Order_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insertUserOrder(User_Order_DTO dto) {
		return sqlSession.insert("user_Order.insertUserOrder",dto);
	}
}
