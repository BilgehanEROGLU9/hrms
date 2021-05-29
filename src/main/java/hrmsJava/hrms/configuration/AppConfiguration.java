package hrmsJava.hrms.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hrmsJava.hrms.core.utilities.validation.email.EmailActivationManager;
import hrmsJava.hrms.core.utilities.validation.email.EmailActivationService;


@Configuration
public class AppConfiguration {
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}


	@Bean
	public EmailActivationService emailActivationService() {
		return new EmailActivationManager();
	}
}
