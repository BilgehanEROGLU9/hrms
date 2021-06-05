package hrmsJava.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrmsJava.hrms.business.abstracts.CandidateEducationService;
import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.core.utilities.results.SuccessDataResult;
import hrmsJava.hrms.core.utilities.results.SuccessResult;
import hrmsJava.hrms.dataAccess.abstracts.CandidateEducationDao;
import hrmsJava.hrms.entities.concretes.CandidateEducation;
@Service
public class CandidateEducationManager implements CandidateEducationService {
	private CandidateEducationDao candidateEducationDao;
	public CandidateEducationManager(CandidateEducationDao candidateEducationDao) {
		
		this.candidateEducationDao = candidateEducationDao;
	}

	@Override
	public DataResult<List<CandidateEducation>> getByCandidate(int candidateId) {
		return new SuccessDataResult<List<CandidateEducation>>(this.candidateEducationDao.getByCandidate_Id(candidateId));
	}

	@Override
	public Result add(CandidateEducation candidateEducation) {
		this.candidateEducationDao.save(candidateEducation);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CandidateEducation>> getCandidateEducationsDesc(int candidateId) {
		return new SuccessDataResult<List<CandidateEducation>>(
				this.candidateEducationDao.getByCandidate_IdOrderByGraduationDateDesc(candidateId));
	}

}
