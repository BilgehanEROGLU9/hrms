package hrmsJava.hrms.business.concretes;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsJava.hrms.business.abstracts.JobAdvertisementService;
import hrmsJava.hrms.business.constants.Messages;
import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.core.utilities.results.SuccessDataResult;
import hrmsJava.hrms.core.utilities.results.SuccessResult;
import hrmsJava.hrms.dataAccess.abstracts.JobAdvertisementDao;
import hrmsJava.hrms.entities.concretes.JobAdvertisement;
@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), Messages.listingSuccess);
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult(Messages.savingSuccess);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getActiveAdvertisements() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrue(), Messages.listingSuccess);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getIsActiveTrueAndDeadlineDateEquals(Date deadlineDate) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.findByIsActiveTrueAndDeadlineDateEquals(deadlineDate), Messages.listingSuccess);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getIsActiveTrueAndEmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueAndEmployerId(employerId),
				Messages.listingSuccess);
	}

	@Override
	public Result changeJobAdvertisementIsActivity(int jobAdvertisementId) {
		JobAdvertisement jobAdvertisementToUpdate = this.jobAdvertisementDao.findById(jobAdvertisementId);
		if (jobAdvertisementToUpdate.isActive() == true) {
			jobAdvertisementToUpdate.setActive(false);
		} else {
			jobAdvertisementToUpdate.setActive(true);
		}

		this.jobAdvertisementDao.save(jobAdvertisementToUpdate);
		return new SuccessResult(Messages.change);
	}

}
