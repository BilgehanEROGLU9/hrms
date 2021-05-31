package hrmsJava.hrms.dataAccess.abstracts;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsJava.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	List<JobAdvertisement> findByIsActiveTrue();
	List<JobAdvertisement> findByIsActiveTrueAndDeadlineDateEquals(Date deadlineDate);
	List<JobAdvertisement> findByIsActiveTrueAndEmployerId(int employerId);
	
	JobAdvertisement findById(int jobAdvertisementId);
}
