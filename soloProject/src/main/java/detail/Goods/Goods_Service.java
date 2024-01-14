package detail.Goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Goods_Service {
	private Goods_DAO goods_DAO;
	
	public Goods_Service(Goods_DAO goods_DAO) {
		this.goods_DAO = goods_DAO;
	}
	
	public List<Goods_DTO> getGoodsList(int menuType_no,int cateRowNum){
		Map<String,Object> paraMap = new HashMap<String, Object>();
		paraMap.put("menuType_no", menuType_no);
		paraMap.put("cateRowNum", cateRowNum);
		
		return goods_DAO.getGoodsList(paraMap);
	}
}
