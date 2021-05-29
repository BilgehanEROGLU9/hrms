package hrmsJava.hrms.core.utilities.validation.person;

import org.springframework.stereotype.Service;

@Service
public class PersonValidationAdapter implements PersonValidationService {

	@Override
	public boolean validate(String nationalIdentity, String firstName, String lastName, String birthdate) {
		
		return true;
	}

}
