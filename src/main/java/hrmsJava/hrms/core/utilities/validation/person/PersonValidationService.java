package hrmsJava.hrms.core.utilities.validation.person;

public interface PersonValidationService {
	boolean validate(String nationalIdentity, String firstName, String lastName, String birthdate);
}
