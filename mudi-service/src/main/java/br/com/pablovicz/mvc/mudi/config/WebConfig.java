package br.com.pablovicz.mvc.mudi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import br.com.pablovicz.mvc.mudi.interceptor.AccessInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport{

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AccessInterceptor()).addPathPatterns("/**");
	}
}

