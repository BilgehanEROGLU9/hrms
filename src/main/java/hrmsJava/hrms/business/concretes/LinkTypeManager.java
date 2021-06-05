package hrmsJava.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsJava.hrms.business.abstracts.LinkTypeService;
import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.core.utilities.results.SuccessDataResult;
import hrmsJava.hrms.core.utilities.results.SuccessResult;
import hrmsJava.hrms.dataAccess.abstracts.LinkTypeDao;
import hrmsJava.hrms.entities.concretes.LinkType;
@Service
public class LinkTypeManager implements LinkTypeService {
	private LinkTypeDao linkTypeDao;
	@Autowired
	public LinkTypeManager(LinkTypeDao linkTypeDao) {
		this.linkTypeDao = linkTypeDao;
	}

	@Override	
	public Result add(LinkType linkType) {
		this.linkTypeDao.save(linkType);
		return new SuccessResult();
	}

	@Override
	public DataResult<LinkType> getById(int linkTypeId) {
		return new SuccessDataResult<LinkType>(this.linkTypeDao.getById(linkTypeId));
	}

}
