package hrmsJava.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsJava.hrms.business.abstracts.CandidateExperienceService;
import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.core.utilities.results.SuccessDataResult;
import hrmsJava.hrms.core.utilities.results.SuccessResult;
import hrmsJava.hrms.dataAccess.abstracts.CandidateExperienceDao;
import hrmsJava.hrms.entities.concretes.CandidateExperience;
@Service
public class CandidateExperienceManager implements CandidateExperienceService {
	private CandidateExperienceDao candidateExperienceDao;
	
	@Autowired
	public CandidateExperienceManager(CandidateExperienceDao candidateExperienceDao) {
		this.candidateExperienceDao = candidateExperienceDao;
	}

	@Override
	public DataResult<List<CandidateExperience>> getByCandidate(int candidateId) {
		return new SuccessDataResult<List<CandidateExperience>>(this.candidateExperienceDao.getByCandidate_Id(candidateId));
	}

	@Override
	public Result add(CandidateExperience candidateExperience) {
		this.candidateExperienceDao.save(candidateExperience);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CandidateExperience>> getCandidateExperiencesDesc(int candidateId) {
		return new SuccessDataResult<List<CandidateExperience>>(
				this.candidateExperienceDao.getByCandidate_IdOrderByDueDateDesc(candidateId));
	}

}
