package br.com.pablovicz.mvc.mudi.businessImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pablovicz.mvc.mudi.business.AccessBusiness;
import br.com.pablovicz.mvc.mudi.model.Access;
import br.com.pablovicz.mvc.mudi.repository.AccessRepository;

@Service
public class AccessBusinessImpl implements AccessBusiness{

	@Autowired
	private AccessRepository accessRepository;
	
	public List<Access> getAll() {
		return accessRepository.findAll();
	}

	public void save(Access access) {
		
		System.out.println("access no businessimpl:");
		System.out.println(access.getId());
		System.out.println(access.getPath());
		System.out.println(access.getDate());
		System.out.println(access.getDuration());
		

		accessRepository.save(access);
	}

	
	
}
