package hrmsJava.hrms.business.abstracts;


import hrmsJava.hrms.entities.concretes.Staff;
import hrmsJava.hrms.entities.dtos.CandidateRegisterDto;
import hrmsJava.hrms.entities.dtos.EmployerRegisterDto;

public interface ValidInfoService {
	boolean validEmailCandidate(CandidateRegisterDto candidateRegisterDto);
	boolean validPasswordCandidate(CandidateRegisterDto candidateRegisterDto);
	boolean validPasswordRepeatCandidate(CandidateRegisterDto candidateRegisterDto);
	boolean validEmailEmployer(EmployerRegisterDto employerRegisterDto);
	boolean validPasswordEmployer(EmployerRegisterDto employerRegisterDto);
	boolean validPasswordRepeatEmployer(EmployerRegisterDto employerRegisterDto);
	boolean validFirstName(CandidateRegisterDto candidateRegisterDto);
	boolean validLastName(CandidateRegisterDto candidateRegisterDto);
	boolean validFirstNameStaff(Staff staff);
	boolean validLastNameStaff(Staff staff);
	boolean validNationalIdentity(CandidateRegisterDto candidateRegisterDto);
	boolean validBirthdate(CandidateRegisterDto candidateRegisterDto);
	boolean validCompanyName(EmployerRegisterDto employerRegisterDto);
	boolean validCompanyWebsite(EmployerRegisterDto employerRegisterDto);
	boolean validCompanyNumber(EmployerRegisterDto employerRegisterDto);
	boolean validEmailStaff(Staff staff);
	boolean validPasswordStaff(Staff staff);
	
	

}
