package hrmsJava.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrmsJava.hrms.business.abstracts.CandidateExperienceService;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.entities.concretes.CandidateExperience;

@RestController
@RequestMapping("/api/candidateExperience")
public class CandidateExperienceController {
	private CandidateExperienceService candidateExperienceService;
	@Autowired
	public CandidateExperienceController(CandidateExperienceService candidateExperienceService) {

		this.candidateExperienceService = candidateExperienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateExperience candidateExperience) {
		return this.candidateExperienceService.add(candidateExperience);
	}
	
	@GetMapping("/getCandidateExperiencesDesc")
	public Result getCandidateExperiencesDesc(@RequestParam int candidateId) {
		return this.candidateExperienceService.getCandidateExperiencesDesc(candidateId);
	}
}
