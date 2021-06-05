package hrmsJava.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrmsJava.hrms.business.abstracts.CandidateEducationService;
import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.entities.concretes.CandidateEducation;

@RestController
@RequestMapping("/api/education")
public class CandidateEducationController {
	private CandidateEducationService candidateEducationService;
	
	@Autowired
	public CandidateEducationController(CandidateEducationService candidateEducationService) {
		this.candidateEducationService = candidateEducationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateEducation candidateEducation) {
		return this.candidateEducationService.add(candidateEducation);
	}
	@GetMapping("/getCandidateEducationDesc")
	public DataResult<List<CandidateEducation>> getCandidateEducationsDesc(@RequestParam int candidateId){
		return this.candidateEducationService.getCandidateEducationsDesc(candidateId);
	}

}
