package hrmsJava.hrms.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import hrmsJava.hrms.business.abstracts.ValidInfoService;
import hrmsJava.hrms.entities.concretes.Staff;
import hrmsJava.hrms.entities.dtos.CandidateRegisterDto;
import hrmsJava.hrms.entities.dtos.EmployerRegisterDto;
@Service
public class ValidInfoManager implements ValidInfoService {

	@Override
	public boolean validEmailCandidate(CandidateRegisterDto candidateRegisterDto) {
		String regex = "^(.+)@(.+)$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(candidateRegisterDto.getEmail());
		if (candidateRegisterDto.getEmail()==null||matcher.matches() == false) {
			return false;
		}
		else {
		return true;}
	
	}

	@Override
	public boolean validPasswordCandidate(CandidateRegisterDto candidateRegisterDto) {
		if(candidateRegisterDto.getPassword().length()<6||candidateRegisterDto.getPassword()==null) {
			return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public boolean validFirstName(CandidateRegisterDto candidateRegisterDto) {
		String regex = "(.+)$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(candidateRegisterDto.getFirstName());
		if(candidateRegisterDto.getFirstName()==null||matcher.matches() == false||candidateRegisterDto.getFirstName().length()<2) {
		return false;}
		else{return true;}
	}

	@Override
	public boolean validLastName(CandidateRegisterDto candidateRegisterDto) {
		String regex = "(.+)$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(candidateRegisterDto.getLastName());
		if(candidateRegisterDto.getLastName()==null||matcher.matches() == false||candidateRegisterDto.getLastName().length()<2) {
			return false;}
			else{return true;}
	}

	@Override
	public boolean validFirstNameStaff(Staff staff) {
		String regex = "(.+)$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(staff.getFirstName());
		if(staff.getFirstName()==null||staff.getFirstName().length()<2||matcher.matches() == false) {
			return false;}
			else{return true;}
	}

	@Override
	public boolean validLastNameStaff(Staff staff) {
		String regex = "(.+)$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(staff.getLastName());
		if(staff.getLastName()==null||staff.getLastName().length()<2||matcher.matches() == false) {
			return false;}
			else{return true;}
	}

	@Override
	public boolean validNationalIdentity(CandidateRegisterDto candidateRegisterDto) {
		if(candidateRegisterDto.getNationalIdentity()==null||candidateRegisterDto.getNationalIdentity().length()!=11) {
			return false;}
			else{return true;}
	}

	@Override
	public boolean validBirthdate(CandidateRegisterDto candidateRegisterDto) {
		if(candidateRegisterDto.getBirthdate()==null) {

			return false;}
			else{return true;}
	}

	@Override
	public boolean validCompanyName(EmployerRegisterDto employerRegisterDto) {
		if (employerRegisterDto.getCompanyName()==null||employerRegisterDto.getCompanyName().length()<2) {
			return false;
		}
		else {return true;}
	}

	@Override
	public boolean validCompanyWebsite(EmployerRegisterDto employerRegisterDto) {
		String regex = "(www.)?[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(employerRegisterDto.getCompanyWebsite());
		if (employerRegisterDto.getCompanyWebsite()==null||employerRegisterDto.getCompanyWebsite().length()<2||matcher.matches() == false) {
			return false;
		}
		else {return true;}
	}

	@Override
	public boolean validCompanyNumber(EmployerRegisterDto employerRegisterDto) {
		if (employerRegisterDto.getCompanyNumber()==null||employerRegisterDto.getCompanyNumber().length()<2) {
			return false;
		}
		else {return true;}
	}

	@Override
	public boolean validEmailEmployer(EmployerRegisterDto employerRegisterDto) {
		String regex = "^(.+)@(.+)$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(employerRegisterDto.getEmail());
		if (employerRegisterDto.getEmail()==null||matcher.matches() == false) {
			return false;
		}
		else {
		return true;}
	}

	@Override
	public boolean validPasswordEmployer(EmployerRegisterDto employerRegisterDto) {
		if(employerRegisterDto.getPassword().length()<6||employerRegisterDto.getPassword()==null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean validPasswordRepeatCandidate(CandidateRegisterDto candidateRegisterDto) {
		if (!candidateRegisterDto.getPassword().contentEquals(candidateRegisterDto.getPasswordRepeat().toString())) {
			return false;
		}
		else {return true;}
	}

	@Override
	public boolean validPasswordRepeatEmployer(EmployerRegisterDto employerRegisterDto) {
		if (!employerRegisterDto.getPassword().contentEquals(employerRegisterDto.getPasswordRepeat().toString())) {
			return false;
		}
		else {return true;}
	}

	@Override
	public boolean validEmailStaff(Staff staff) {
		String regex = "^(.+)@(.+)$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(staff.getEmail());
		if (staff.getEmail()==null||matcher.matches() == false) {
			return false;
		}
		else {
		return true;}
	
	}

	@Override
	public boolean validPasswordStaff(Staff staff) {
		if(staff.getPassword().length()<6||staff.getPassword()==null) {
			return false;
		}
		else {
			return true;
		}
	}

}
