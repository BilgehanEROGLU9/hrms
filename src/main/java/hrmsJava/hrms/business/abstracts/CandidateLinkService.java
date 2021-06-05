package hrmsJava.hrms.business.abstracts;
import java.util.List;

import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.entities.concretes.CandidateLink;
public interface CandidateLinkService {
	DataResult<List<CandidateLink>> getByCandidateId(int candidateId);
	Result add(CandidateLink candidateLink);
}
