package detail.Goods_Detail;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Goods_Detail_DAO {
	private SqlSession sqlSession;
	
	public Goods_Detail_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Map<String,Object>> getGoodsDetailList(int no){
		return sqlSession.selectList("goods_Detail.getGoodsDetailList",no);
	}
}
