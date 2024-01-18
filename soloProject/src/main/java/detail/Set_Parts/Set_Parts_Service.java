package detail.Set_Parts;

import java.util.List;
import java.util.Map;

public class Set_Parts_Service {
	private Set_Parts_DAO set_Parts_DAO;
	
	public Set_Parts_Service(Set_Parts_DAO set_Parts_DAO) {
		this.set_Parts_DAO = set_Parts_DAO;
	}
	
	public List<Map<String,Object>> getSetList(int no){
		return set_Parts_DAO.getSetList(no);
	}
}
