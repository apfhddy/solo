package detail.Order_Total;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Order_Total_DAO {
	private SqlSession sqlSession;
	
	public Order_Total_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int getNextNo() {
		return sqlSession.selectOne("order_Total.getNextNo");
	}
	
	public int insertOrderTotal(Order_Total_DTO dto) {
		return sqlSession.insert("order_Total.insertOrderTotal",dto);
	}
	
	public Map<String,Object> getOrderTotal(int no){
		return sqlSession.selectOne("order_Total.getOrderTotal",no);
	}
	
	public List<Map<String,Object>> getOders(int orderTotal_no){
		return sqlSession.selectList("order_Total.getOders",orderTotal_no);
	}
	
}
