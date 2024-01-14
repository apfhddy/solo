package detail.Goods_Detail;

import org.apache.ibatis.session.SqlSession;

public class Goods_Detail_DAO {
	private SqlSession sqlSession;
	
	public Goods_Detail_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
