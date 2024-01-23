package detail.Order_Parts;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class Order_Parts_DAO {
	private SqlSession sqlSession;
	
	public Order_Parts_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insertOrderParts(List<Integer> menus,int orders_no) {
		
		for(int no : menus) {
			Order_Parts_DTO dto = new Order_Parts_DTO(0, orders_no,no);
			sqlSession.insert("order_Parts.insertOrderParts",dto);
		}
		
		return 0;
	}
	
	public List<String> getOrderParts(int orders_no){
		return sqlSession.selectList("order_Parts.getOrderParts",orders_no);
	}
	
	
	
	
}
