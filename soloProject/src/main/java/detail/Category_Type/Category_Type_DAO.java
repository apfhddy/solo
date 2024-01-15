package detail.Category_Type;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class Category_Type_DAO {
	private SqlSession sqlSession;
	
	public Category_Type_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Category_Type_DTO> getCategoryList(int menuType_no){
		return sqlSession.selectList("category_Type.getCategoryList",menuType_no);
	}
}
