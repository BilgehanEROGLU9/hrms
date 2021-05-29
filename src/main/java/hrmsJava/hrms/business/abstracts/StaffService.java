package hrmsJava.hrms.business.abstracts;

import java.util.List;

import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.entities.concretes.Staff;

public interface StaffService {
	DataResult<List<Staff>> getAll();
	Result add(Staff staff);
}
