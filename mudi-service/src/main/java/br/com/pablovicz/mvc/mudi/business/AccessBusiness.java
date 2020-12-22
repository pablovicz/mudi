package br.com.pablovicz.mvc.mudi.business;

import java.util.List;

import br.com.pablovicz.mvc.mudi.model.Access;

public interface AccessBusiness {
	
	public List<Access> getAll();
	
	public void save(Access access);

}
