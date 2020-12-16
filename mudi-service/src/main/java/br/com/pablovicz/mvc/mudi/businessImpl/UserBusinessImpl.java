package br.com.pablovicz.mvc.mudi.businessImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pablovicz.mvc.mudi.business.UserBusiness;
import br.com.pablovicz.mvc.mudi.model.User;
import br.com.pablovicz.mvc.mudi.repository.UserRepository;

@Service
public class UserBusinessImpl implements UserBusiness{

	
	@Autowired
	private UserRepository userRepository;
	
	public User findUser(String username) {
		
		return userRepository.findByUsername(username);
	}

}
