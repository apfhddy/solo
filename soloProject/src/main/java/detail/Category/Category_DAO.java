package detail.Category;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class Category_DAO {
	private SqlSession sqlSession;
	
	public Category_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Category_DTO> getCategoryList(int menuType_no){
		return sqlSession.selectList("category.getCategoryList",menuType_no);
	}
}
