package detail.Menu_Type;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class Menu_Type_DAO {
	private SqlSession sqlSession;
	
	public Menu_Type_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Menu_Type_DTO> getChoiceSortList(int no){
		return sqlSession.selectList("menu_Type.getChoiceSortList",no);
	}
	
}
