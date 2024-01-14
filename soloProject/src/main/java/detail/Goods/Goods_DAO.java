package detail.Goods;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Goods_DAO {
	private SqlSession sqlSession;
	
	public Goods_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Goods_DTO> getGoodsList(Map<String,Object> map){
		return sqlSession.selectList("goods.getGoodsList",map);
	}
}
