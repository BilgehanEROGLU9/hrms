package hrmsJava.hrms.business.abstracts;

import java.sql.Date;
import java.util.List;

import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();
	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getActiveAdvertisements();
	DataResult<List<JobAdvertisement>> getIsActiveTrueAndDeadlineDateEquals(Date deadlineDate);
	DataResult<List<JobAdvertisement>> getIsActiveTrueAndEmployerId(int employerId);
	Result changeJobAdvertisementIsActivity(int jobAdvertisementId);



}
