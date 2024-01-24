package detail.Parts_ChangeList;

import org.apache.ibatis.session.SqlSession;

public class Parts_ChangeList_DAO {
	private SqlSession sqSession;
	
	public Parts_ChangeList_DAO(SqlSession sqSession) {
		this.sqSession = sqSession;
	}
}
