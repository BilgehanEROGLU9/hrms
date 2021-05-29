package hrmsJava.hrms.business.abstracts;

import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.entities.dtos.CandidateRegisterDto;
import hrmsJava.hrms.entities.dtos.EmployerRegisterDto;

public interface AuthenticationService {
	Result registerForCandidate(CandidateRegisterDto candidateRegisterDto);
	Result registerForEmployer(EmployerRegisterDto employerRegisterDto);
}
