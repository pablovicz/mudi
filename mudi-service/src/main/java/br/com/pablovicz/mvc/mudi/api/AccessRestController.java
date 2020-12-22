package br.com.pablovicz.mvc.mudi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pablovicz.mvc.mudi.business.AccessBusiness;
import br.com.pablovicz.mvc.mudi.model.Access;


@RestController
@RequestMapping("access")
public class AccessRestController {
	
	@Autowired
	private AccessBusiness accessBusiness;
	

	@GetMapping
	public List<Access> getAccess(){
		
		return accessBusiness.getAll();
	}
	
	
}
