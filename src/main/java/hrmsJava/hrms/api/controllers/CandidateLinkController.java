package hrmsJava.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsJava.hrms.business.abstracts.CandidateLinkService;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.entities.concretes.CandidateLink;

@RestController
@RequestMapping("/api/candidateLinks")
public class CandidateLinkController {
	private CandidateLinkService candidateLinkService;
	@Autowired
	public CandidateLinkController(CandidateLinkService candidateLinkService) {

		this.candidateLinkService = candidateLinkService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateLink candidateLink) {
		return this.candidateLinkService.add(candidateLink);
	}
	
	

}
