package hrmsJava.hrms.business.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsJava.hrms.business.abstracts.AuthenticationService;
import hrmsJava.hrms.business.abstracts.CandidateService;
import hrmsJava.hrms.business.abstracts.EmployerService;
import hrmsJava.hrms.business.abstracts.UserService;
import hrmsJava.hrms.business.abstracts.ValidInfoService;
import hrmsJava.hrms.business.constants.Messages;
import hrmsJava.hrms.core.utilities.results.ErrorResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.core.utilities.results.SuccessResult;
import hrmsJava.hrms.core.utilities.validation.email.EmailActivationService;
import hrmsJava.hrms.core.utilities.validation.person.PersonValidationService;
import hrmsJava.hrms.entities.concretes.Candidate;
import hrmsJava.hrms.entities.concretes.Employer;
import hrmsJava.hrms.entities.dtos.CandidateRegisterDto;
import hrmsJava.hrms.entities.dtos.EmployerRegisterDto;
@Service
public class AuthenticationManager implements AuthenticationService{
	private ModelMapper modelMapper;
	private CandidateService candidateService;
	private EmployerService employerService;
	private UserService userService;
	private PersonValidationService personValidationService;
	private EmailActivationService emailActivationService;
	private ValidInfoService validInfoService;
	
	@Autowired
	public AuthenticationManager(ModelMapper modelMapper, CandidateService candidateService,
			EmployerService employerService, UserService userService, PersonValidationService personValidationService,
			EmailActivationService emailActivationService,ValidInfoService validInfoService) {
		this.modelMapper = modelMapper;
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.userService = userService;
		this.personValidationService = personValidationService;
		this.emailActivationService = emailActivationService;
		this.validInfoService = validInfoService;
	}


	@Override
	public Result registerForCandidate(CandidateRegisterDto candidateRegisterDto) {
		if (candidateRegisterDto.getFirstName() == null && candidateRegisterDto.getLastName() == null
				&& candidateRegisterDto.getNationalIdentity() == null
				&& candidateRegisterDto.getBirthdate() == null && candidateRegisterDto.getEmail() == null
				&& candidateRegisterDto.getPassword() == null) {
			return new ErrorResult(Messages.checkForm);
		}
		else if(!validInfoService.validEmailCandidate(candidateRegisterDto)) {
			return new ErrorResult(Messages.invalidEmail);
		}
		else if(!validInfoService.validPasswordCandidate(candidateRegisterDto)) {
			return new ErrorResult(Messages.invalidPassword);
		}
		else if(!validInfoService.validPasswordRepeatCandidate(candidateRegisterDto)) {
			return new ErrorResult(Messages.invalidPasswordRepeat);
		}
		else if(!validInfoService.validFirstName(candidateRegisterDto)) {
			return new ErrorResult(Messages.invalidFirstName);
		}
		else if(!validInfoService.validLastName(candidateRegisterDto)) {
			return new ErrorResult(Messages.invalidLastName);
		}
		else if(!validInfoService.validNationalIdentity(candidateRegisterDto)) {
			return new ErrorResult(Messages.invalidNationalIdentity);
		}
		else if(!validInfoService.validBirthdate(candidateRegisterDto)) {
			return new ErrorResult(Messages.invalidBirthdate);
		}
		else if (this.userService.findByEmailEquals(candidateRegisterDto.getEmail()).getData() != null && this.candidateService
				.getByNationalIdentity(candidateRegisterDto.getNationalIdentity()).getData() != null) {
			return new ErrorResult(Messages.emailAndIdentityExists);
		}
		else if (userService.findByEmailEquals(candidateRegisterDto.getEmail()).getData()!=null) {
			
			return new ErrorResult(Messages.emailExists);
		}
		else if (userService.findByNationalIdentity(candidateRegisterDto.getNationalIdentity()).getData()!=null) {
			return new ErrorResult(Messages.nationalIdentityExists);
		}
		else if (!personValidationService.validate(candidateRegisterDto.getNationalIdentity(),
				candidateRegisterDto.getFirstName(), candidateRegisterDto.getLastName(),
				candidateRegisterDto.getBirthdate())) {
			return new ErrorResult(Messages.wrongInfos);
		}

		

		Candidate candidatesForRegister = modelMapper.map(candidateRegisterDto, Candidate.class);
		candidateService.add(candidatesForRegister);
		return new SuccessResult(Messages.savingSuccess);
	}

	@Override
	public Result registerForEmployer(EmployerRegisterDto employerRegisterDto) {
		if (employerRegisterDto.getCompanyName() == null && employerRegisterDto.getCompanyWebsite() == null
				&& employerRegisterDto.getCompanyNumber() == null && employerRegisterDto.getEmail() == null
				&& employerRegisterDto.getPassword() == null && checkDomain(employerRegisterDto)) {
			return new ErrorResult(Messages.checkForm);
		}
		else if (this.userService.findByEmailEquals(employerRegisterDto.getEmail()).getData() != null) {
			return new ErrorResult(Messages.emailExists);
		}
		else if (!validInfoService.validEmailEmployer(employerRegisterDto)) {
			return new ErrorResult(Messages.invalidEmail);
		}
		else if(!validInfoService.validPasswordEmployer(employerRegisterDto)) {
			return new ErrorResult(Messages.invalidPassword);
		}
		else if(!validInfoService.validPasswordRepeatEmployer(employerRegisterDto)) {
			return new ErrorResult(Messages.invalidPasswordRepeat);
		}
		else if(!validInfoService.validCompanyName(employerRegisterDto)) {
			return new ErrorResult(Messages.invalidCompanyName);
		}
		else if(!validInfoService.validCompanyNumber(employerRegisterDto)) {
			return new ErrorResult(Messages.invalidCompanyNumber);
		}
		else if(!validInfoService.validCompanyWebsite(employerRegisterDto)) {
			return new ErrorResult(Messages.invalidCompanyWebsite);
		}
		else if (userService.findByEmailEquals(employerRegisterDto.getEmail()).getData()!=null) {
			
			return new ErrorResult(Messages.emailExists);
		}
		
		
		emailActivationService.mailSend(employerRegisterDto.getEmail());
		Employer employerForRegister = modelMapper.map(employerRegisterDto, Employer.class);
		employerService.add(employerForRegister);
		return new SuccessResult(Messages.savingSuccess);
	}
	private boolean checkDomain(EmployerRegisterDto employerRegisterDto) {
		String checkDomain = employerRegisterDto.getEmail().split("@")[1];
		return checkDomain.equals(employerRegisterDto.getCompanyWebsite());
	}

}
