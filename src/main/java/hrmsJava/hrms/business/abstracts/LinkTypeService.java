package hrmsJava.hrms.business.abstracts;

import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.entities.concretes.LinkType;

public interface LinkTypeService {
	Result add(LinkType linkType);
	DataResult<LinkType> getById(int linkTypeId);
}
