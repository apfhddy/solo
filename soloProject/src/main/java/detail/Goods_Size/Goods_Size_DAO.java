package detail.Goods_Size;

import org.apache.ibatis.session.SqlSession;

public class Goods_Size_DAO {
	private SqlSession sqlSession;
	
	public Goods_Size_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
