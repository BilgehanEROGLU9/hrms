package hrmsJava.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsJava.hrms.business.abstracts.CandidateLinkService;
import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.core.utilities.results.SuccessDataResult;
import hrmsJava.hrms.core.utilities.results.SuccessResult;
import hrmsJava.hrms.dataAccess.abstracts.CandidateLinkDao;
import hrmsJava.hrms.entities.concretes.CandidateLink;
@Service
public class CandidateLinkManager implements CandidateLinkService {
	private CandidateLinkDao candidateLikDao;
	@Autowired
	public CandidateLinkManager(CandidateLinkDao candidateLikDao) {
	
		this.candidateLikDao = candidateLikDao;
	}

	@Override
	public DataResult<List<CandidateLink>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CandidateLink>>(this.candidateLikDao.getByCandidate_Id(candidateId));
	}

	@Override
	public Result add(CandidateLink candidateLink) {
		this.candidateLikDao.save(candidateLink);
		return new SuccessResult();
	}

}
