package detail.Parts_ChangeList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Parts_ChangeList_DAO {
	private SqlSession sqlSession;
	
	public Parts_ChangeList_DAO(SqlSession sqSession) {
		this.sqlSession = sqSession;
	}
	
	public List<Map<String,Object>> getPartsChangeList(int partsChange_no){
		return sqlSession.selectList("parts_ChangeList.getPartsChangeList",partsChange_no);
	}
	
	public int partsSumPrice(Map<String,Object> map) {
		return sqlSession.selectOne("parts_ChangeList.partsSumPrice",map);
	}
	
	public Map<String,Object> getOnePart(Map<String,Object> map){
		return sqlSession.selectOne("parts_ChangeList.getOnePart",map);
	}
}
