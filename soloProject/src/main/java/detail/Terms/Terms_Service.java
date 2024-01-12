package detail.Terms;

import java.util.List;

public class Terms_Service {
	private Terms_DAO terms_DAO;
	
	
	
	public Terms_Service(Terms_DAO terms_DAO) {
		this.terms_DAO = terms_DAO;
	}
	
	public List<Terms_DTO> getTermsList(){
		return terms_DAO.getTermsList();
	}

	
	
	
	
	
	public int getTermsSu() {
		return terms_DAO.getTermsSu();
	}

	
}
