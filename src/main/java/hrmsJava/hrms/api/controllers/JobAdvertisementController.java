package hrmsJava.hrms.api.controllers;
import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.entities.concretes.JobAdvertisement;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrmsJava.hrms.business.abstracts.JobAdvertisementService;

@RestController
@RequestMapping("/api/jobAdvertisement")
public class JobAdvertisementController {
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}

	@GetMapping("/getActivePostings")
	public DataResult<List<JobAdvertisement>> getActiveAdvertisements() {
		return this.jobAdvertisementService.getActiveAdvertisements();
	}

	@GetMapping("/getIsActiveTrueAndDeadlineDateEquals")
	public DataResult<List<JobAdvertisement>> getIsActiveTrueAndDeadlineDateEquals(@RequestParam Date deadlineDate) {
		return this.jobAdvertisementService.getIsActiveTrueAndDeadlineDateEquals(deadlineDate);
	}

	@GetMapping("/getIsActiveTrueAndEmployerId")
	public DataResult<List<JobAdvertisement>> getIsActiveTrueAndEmployerId(@RequestParam int employerId) {
		return this.jobAdvertisementService.getIsActiveTrueAndEmployerId(employerId);
	} 

	@PostMapping("/changeJobPostingIsActivity")
	public Result changeJobAdvertisementIsActivity(@RequestParam int JobAdvertisementId) {
		return this.jobAdvertisementService.changeJobAdvertisementIsActivity(JobAdvertisementId);
	}
}
