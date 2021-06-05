package hrmsJava.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsJava.hrms.entities.concretes.CandidateSkill;

public interface CandidateSkillDao extends JpaRepository<CandidateSkill, Integer> {
	List<CandidateSkill> getByCandidate_Id(int candidateId);
}
