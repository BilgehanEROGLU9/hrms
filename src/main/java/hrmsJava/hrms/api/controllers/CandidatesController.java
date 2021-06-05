package hrmsJava.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hrmsJava.hrms.business.abstracts.CandidateService;
import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.entities.concretes.Candidate;
import hrmsJava.hrms.entities.dtos.CurriculumVitaeDto;



@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	private CandidateService candidateService;
	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	

	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll() {
		return this.candidateService.getAll();
	}
	@PostMapping("/changeDescription")
	public Result addDescription(@RequestParam int candidateId,@RequestParam String description)
	{
		return this.candidateService.changeDescription(candidateId, description);
	}

	
	@GetMapping("/getCVByCandidate")
	public DataResult<CurriculumVitaeDto> getCVByCandidateId(@RequestParam int candidateId)
	{
		return this.candidateService.getCVByCandidate(candidateId);
	}
	
	@PostMapping("/uploadPhoto")
	public Result uploadImage(@RequestParam int candidateId,@RequestBody MultipartFile file)
	{
		return this.candidateService.uploadPhoto(candidateId,file);
	}
	
}
