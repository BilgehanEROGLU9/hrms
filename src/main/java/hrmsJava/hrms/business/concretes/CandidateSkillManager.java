package hrmsJava.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsJava.hrms.business.abstracts.CandidateSkillService;
import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.core.utilities.results.SuccessDataResult;
import hrmsJava.hrms.core.utilities.results.SuccessResult;
import hrmsJava.hrms.dataAccess.abstracts.CandidateSkillDao;
import hrmsJava.hrms.entities.concretes.CandidateSkill;
@Service
public class CandidateSkillManager implements CandidateSkillService {
	private CandidateSkillDao candidateSkillDao;
	@Autowired
	public CandidateSkillManager(CandidateSkillDao candidateSkillDao) {
		this.candidateSkillDao = candidateSkillDao;
	}

	@Override
	public DataResult<List<CandidateSkill>> getByCandidate(int candidateId) {
		return new SuccessDataResult<List<CandidateSkill>>(this.candidateSkillDao.getByCandidate_Id(candidateId));
	}

	@Override
	public Result add(CandidateSkill candidateSkill) {
		this.candidateSkillDao.save(candidateSkill);
		return new SuccessResult();
	}

}
