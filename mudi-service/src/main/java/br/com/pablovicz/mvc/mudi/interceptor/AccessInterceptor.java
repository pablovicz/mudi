package br.com.pablovicz.mvc.mudi.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.pablovicz.mvc.mudi.business.AccessBusiness;
import br.com.pablovicz.mvc.mudi.model.Access;

@SuppressWarnings("deprecation")
public class AccessInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private AccessBusiness accessBusiness;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Access access = new Access();
		access.setPath(request.getRequestURI());
		access.setDate(LocalDateTime.now());

		request.setAttribute("access", access);

		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("entrou no afterCompletion");
		Access access = (Access) request.getAttribute("access");

		System.out.println("está com access: " + access.getPath());

		access.setDuration(Duration.between(access.getDate(), LocalDateTime.now()));

		System.out.println("setou duration: " + access.getDuration());

		System.out.println("access antes de salvar:");
		System.out.println(access.getId());
		System.out.println(access.getPath());
		System.out.println(access.getDate());
		System.out.println(access.getDuration());

		accessBusiness.save(access);
	}

}