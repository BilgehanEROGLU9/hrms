package hrmsJava.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsJava.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	User findByEmailEquals(String email);

}
