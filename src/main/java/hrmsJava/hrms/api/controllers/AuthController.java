package hrmsJava.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsJava.hrms.business.abstracts.AuthenticationService;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.entities.dtos.CandidateRegisterDto;
import hrmsJava.hrms.entities.dtos.EmployerRegisterDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	AuthenticationService  authenticationService;

	@Autowired
	public AuthController(AuthenticationService  authenticationService) {
		this.authenticationService = authenticationService;
	}

	@PostMapping("/registerAsCandidate")
	public Result registerForCandidate(@RequestBody CandidateRegisterDto candidateRegisterDto) {
		return authenticationService.registerForCandidate(candidateRegisterDto) ;
	}
	
	@PostMapping("/registerAsEmployer")
	public Result registerForEmployer(@RequestBody EmployerRegisterDto employerRegisterDto) {
		return authenticationService.registerForEmployer(employerRegisterDto) ;
	}
}
