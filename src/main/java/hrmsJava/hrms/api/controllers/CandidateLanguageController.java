package hrmsJava.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsJava.hrms.business.abstracts.CandidateLanguageService;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.entities.concretes.CandidateLanguage;

@RestController
@RequestMapping("/api/candidateLanguages")
public class CandidateLanguageController {
	private CandidateLanguageService candidateLanguageService;
	@Autowired
	public CandidateLanguageController(CandidateLanguageService candidateLanguageService) {
		super();
		this.candidateLanguageService = candidateLanguageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateLanguage candidateLanguage) {
		return this.candidateLanguageService.add(candidateLanguage);
				
	}
}
