package hrmsJava.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.entities.concretes.Candidate;
import hrmsJava.hrms.entities.dtos.CurriculumVitaeDto;


public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	Result add(Candidate candidate);
	DataResult<Candidate> getByNationalIdentity(String nationalIdentity);
	DataResult<Candidate> getById(int candidateId);
	DataResult<CurriculumVitaeDto> getCVByCandidate(int candidateId);
	Result changeDescription(int candidateId, String description);
	Result uploadPhoto(int candidateId, MultipartFile file);
}
