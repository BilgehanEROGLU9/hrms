package hrmsJava.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsJava.hrms.entities.concretes.CandidateEducation;

public interface CandidateEducationDao extends JpaRepository<CandidateEducation, Integer>{
	List<CandidateEducation> getByCandidate_Id(int candidateId);
	List<CandidateEducation> getByCandidate_IdOrderByGraduationDateDesc(int candidateId);
}
