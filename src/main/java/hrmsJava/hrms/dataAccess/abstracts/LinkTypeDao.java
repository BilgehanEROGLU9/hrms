package hrmsJava.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsJava.hrms.entities.concretes.LinkType;

public interface LinkTypeDao extends JpaRepository<LinkType, Integer> {
	LinkType getById(int id);
}
