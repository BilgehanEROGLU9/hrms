package hrmsJava.hrms.business.abstracts;

import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.entities.concretes.Candidate;
import hrmsJava.hrms.entities.concretes.User;

public interface UserService {
	 DataResult<User> findByEmailEquals(String email);
	 DataResult<Candidate> findByNationalIdentity(String national_identity);
}
