package detail.Certified_Type;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class Certified_Type_DAO {
	private SqlSession sqlSession;
	
	public Certified_Type_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Certified_Type_DTO> getTypeList(){
		return sqlSession.selectList("certified_Type.getTypeList");
	}
}
