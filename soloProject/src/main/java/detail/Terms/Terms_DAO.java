package detail.Terms;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class Terms_DAO {
	private SqlSession sqlSession;
	private int termsSu;
	
	public Terms_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		termsSu = getMaxNo();
	}
	
	public List<Terms_DTO> getTermsList(){
		return sqlSession.selectList("terms.getTermsList");
	}
	
	public int getMaxNo() {
		return sqlSession.selectOne("terms.getMaxNo");
	}
	
	
	
	public int getTermsSu() {
		return termsSu;
	}

	public void setTermsSu(int termsSu) {
		this.termsSu = termsSu;
	}
	
	
}
