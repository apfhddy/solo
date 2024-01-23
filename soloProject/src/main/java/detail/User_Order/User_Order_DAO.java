package detail.User_Order;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class User_Order_DAO {
	private SqlSession sqlSession;
	
	public User_Order_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insertUserOrder(User_Order_DTO dto) {
		return sqlSession.insert("user_Order.insertUserOrder",dto);
	}
	
	public List<Map<String,Object>> getUserOrderList(int no){
		return sqlSession.selectList("user_Order.getUserOrderList",no);
	}
}
