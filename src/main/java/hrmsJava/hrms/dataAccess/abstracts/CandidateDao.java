package hrmsJava.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;



import hrmsJava.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	Candidate findByNationalIdentity(String national_identity);

	
}
