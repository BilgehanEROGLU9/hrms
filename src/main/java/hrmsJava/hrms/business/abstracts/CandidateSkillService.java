package hrmsJava.hrms.business.abstracts;
import java.util.List;

import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.entities.concretes.CandidateSkill;
public interface CandidateSkillService {
	DataResult<List<CandidateSkill>> getByCandidate(int candidateId);
	Result add(CandidateSkill candidateSkill);
}
