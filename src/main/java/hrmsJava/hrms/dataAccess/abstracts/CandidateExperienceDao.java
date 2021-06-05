package hrmsJava.hrms.dataAccess.abstracts;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsJava.hrms.entities.concretes.CandidateExperience;

public interface CandidateExperienceDao extends JpaRepository<CandidateExperience, Integer>{
	List<CandidateExperience> getByCandidate_Id(int candidateId);
	List<CandidateExperience> getByCandidate_IdOrderByDueDateDesc(int candidateId);
}
