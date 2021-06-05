package hrmsJava.hrms.business.abstracts;
import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.entities.concretes.CandidateExperience;
import java.util.List;

public interface CandidateExperienceService {
	DataResult<List<CandidateExperience>> getByCandidate(int candidateId);
	Result add(CandidateExperience candidateExperience);
	DataResult<List<CandidateExperience>> getCandidateExperiencesDesc(int candidateId);
}
