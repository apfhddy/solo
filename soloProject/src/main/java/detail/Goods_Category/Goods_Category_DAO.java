package detail.Goods_Category;

import org.apache.ibatis.session.SqlSession;

public class Goods_Category_DAO {
	private SqlSession sqlSession;
	
	public Goods_Category_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
