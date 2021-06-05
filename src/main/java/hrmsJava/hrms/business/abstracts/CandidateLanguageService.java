package hrmsJava.hrms.business.abstracts;
import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.entities.concretes.CandidateLanguage;
import java.util.List;

public interface CandidateLanguageService {
	DataResult<List<CandidateLanguage>> getByCandidate(int candidateId);
	Result add(CandidateLanguage candidateLanguage);
}
