package detail.Certified_Type;

import java.util.List;

public class Certified_Type_Service {
	private Certified_Type_DAO certified_Type_DAO;
	
	public Certified_Type_Service(Certified_Type_DAO certified_Type_DAO) {
		this.certified_Type_DAO = certified_Type_DAO;
	}
	
	public List<Certified_Type_DTO> getTypeList(){
		return certified_Type_DAO.getTypeList();
	}
}
