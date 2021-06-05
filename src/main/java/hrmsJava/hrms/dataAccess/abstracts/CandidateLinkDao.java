package hrmsJava.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsJava.hrms.entities.concretes.CandidateLink;

public interface CandidateLinkDao extends JpaRepository<CandidateLink, Integer>{
	List<CandidateLink> getByCandidate_Id(int candidateId);
}
