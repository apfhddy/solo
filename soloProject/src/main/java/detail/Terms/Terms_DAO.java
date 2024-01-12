package detail.Terms;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class Terms_DAO {
	private SqlSession sqlSession;
	
	public Terms_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Terms_DTO> getTermsList(){
		return sqlSession.selectList("terms.getTermsList");
	}
}
