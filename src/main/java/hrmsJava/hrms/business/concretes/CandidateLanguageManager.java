package hrmsJava.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsJava.hrms.business.abstracts.CandidateLanguageService;
import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.core.utilities.results.SuccessDataResult;
import hrmsJava.hrms.core.utilities.results.SuccessResult;
import hrmsJava.hrms.dataAccess.abstracts.CandidateLanguageDao;
import hrmsJava.hrms.entities.concretes.CandidateLanguage;
@Service
public class CandidateLanguageManager implements CandidateLanguageService {
	private CandidateLanguageDao candidateLanguageDao;
	
	@Autowired
	public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao) {
		
		this.candidateLanguageDao = candidateLanguageDao;
	}

	@Override
	public DataResult<List<CandidateLanguage>> getByCandidate(int candidateId) {
		return new SuccessDataResult<List<CandidateLanguage>>(this.candidateLanguageDao.getByCandidate_Id(candidateId));
	}

	@Override
	public Result add(CandidateLanguage candidateLanguage) {
		this.candidateLanguageDao.save(candidateLanguage);
		return new SuccessResult();
	}

}
