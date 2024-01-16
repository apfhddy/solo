package detail.Goods_Detail;

import java.util.List;
import java.util.Map;

public class Goods_Detail_Service {
	private Goods_Detail_DAO goods_Detail_DAO;
	
	public Goods_Detail_Service(Goods_Detail_DAO goods_Detail_DAO) {
		this.goods_Detail_DAO = goods_Detail_DAO;
	}
	
	public List<Map<String,Object>> getGoodsDetailList(int no){
		return goods_Detail_DAO.getGoodsDetailList(no);
	}
}
