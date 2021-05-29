package hrmsJava.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsJava.hrms.business.abstracts.CandidateService;
import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.core.utilities.results.SuccessDataResult;
import hrmsJava.hrms.core.utilities.results.SuccessResult;

import hrmsJava.hrms.dataAccess.abstracts.CandidateDao;
import hrmsJava.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {
	
	CandidateDao candidateDao;
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
		
		
		
	}

	


	@Override
	public DataResult<List<Candidate>> getAll() {
	
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findAll(),"İş Arayanlar başarılı şekilde listelendi");
	}




	@Override
	public Result add(Candidate candidate) {
		candidateDao.save(candidate);
		return new SuccessResult();
	}





	@Override
	public DataResult<Candidate> getByNationalIdentity(String nationalIdentity) {
		return new SuccessDataResult<Candidate>(candidateDao.findByNationalIdentity(nationalIdentity));
	}
	

}
