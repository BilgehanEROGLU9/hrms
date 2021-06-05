package hrmsJava.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsJava.hrms.business.abstracts.CandidateSkillService;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.entities.concretes.CandidateSkill;

@RestController
@RequestMapping("/api/candidateSkills")
public class CandidateSkillController {
	private CandidateSkillService candidateSkillService;
	@Autowired
	public CandidateSkillController(CandidateSkillService candidateSkillService) {
		
		this.candidateSkillService = candidateSkillService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateSkill candidateSkill) {
		return this.candidateSkillService.add(candidateSkill);
	}
}
