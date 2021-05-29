package hrmsJava.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsJava.hrms.business.abstracts.UserService;
import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.SuccessDataResult;
import hrmsJava.hrms.dataAccess.abstracts.CandidateDao;
import hrmsJava.hrms.dataAccess.abstracts.UserDao;
import hrmsJava.hrms.entities.concretes.Candidate;
import hrmsJava.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {
private UserDao userDao;
private CandidateDao candidateDao;

	@Autowired
	public UserManager(UserDao userDao,CandidateDao candidateDao) {
	super();
	this.userDao = userDao;
	this.candidateDao = candidateDao;
}
	@Override
	public DataResult<User> findByEmailEquals(String email) {
		
		return new SuccessDataResult<User>(userDao.findByEmailEquals(email));
	}
	@Override
	public DataResult<Candidate> findByNationalIdentity(String national_identity) {
		return new SuccessDataResult<Candidate>(candidateDao.findByNationalIdentity(national_identity));
	}
	
	

}
