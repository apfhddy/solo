package detail.Parts_ChangeList;

import java.util.HashMap;
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
	
	public int partsSumPrice(int goodsDetail_no,List<Integer> menus) {
		Map<String,Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("no", goodsDetail_no);
		parameterMap.put("menus", menus);
		return parts_ChangeList_DAO.partsSumPrice(parameterMap);
	}
}
