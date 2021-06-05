package hrmsJava.hrms.business.abstracts;
import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.entities.concretes.CandidateEducation;
import java.util.List;

public interface CandidateEducationService {
	DataResult<List<CandidateEducation>> getByCandidate(int candidateId);
	Result add(CandidateEducation candidateEducation);
	DataResult<List<CandidateEducation>> getCandidateEducationsDesc(int candidateId);
}
