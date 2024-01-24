package detail.Parts_ChangeList;

import java.util.List;
import java.util.Map;

public class Parts_ChangeList_Service {
	private Parts_ChangeList_DAO parts_ChangeList_DAO;
	
	public Parts_ChangeList_Service(Parts_ChangeList_DAO parts_ChangeList_DAO) {
		this.parts_ChangeList_DAO = parts_ChangeList_DAO;
	}
	
	public List<Map<String,Object>> getPartsChangeList(int partsChange_no){
		return parts_ChangeList_DAO.getPartsChangeList(partsChange_no);
	}
}