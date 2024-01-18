package detail.Set_Parts;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Set_Parts_DAO {
	private SqlSession sqlSession;
	
	public Set_Parts_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Map<String,Object>> getSetList(int no){
		return sqlSession.selectList("set_Parts.getSetList",no);
	}
}
