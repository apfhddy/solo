package detail.Goods;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Goods_DAO {
	private SqlSession sqlSession;
	
	public Goods_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Map<String,Object>> getGoodsList(Map<String,Object> map){
		return sqlSession.selectList("goods.getGoodsList",map);
	}
	
	public List<Map<String,Object>> getOrderDescList(int menuType_no){
		return sqlSession.selectList("goods.getOrderDescList",menuType_no);
	}
}
