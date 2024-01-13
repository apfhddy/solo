package detail.Goods;

import org.apache.ibatis.session.SqlSession;

public class Goods_DAO {
	private SqlSession sqlSession;
	
	public Goods_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
