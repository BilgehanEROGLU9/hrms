package hrmsJava.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsJava.hrms.entities.concretes.Staff;

public interface StaffDao extends JpaRepository<Staff, Integer>{

}
