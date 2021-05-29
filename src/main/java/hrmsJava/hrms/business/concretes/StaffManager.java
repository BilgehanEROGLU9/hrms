package hrmsJava.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsJava.hrms.business.abstracts.StaffService;
import hrmsJava.hrms.business.abstracts.UserService;
import hrmsJava.hrms.business.abstracts.ValidInfoService;
import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.ErrorResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.core.utilities.results.SuccessDataResult;
import hrmsJava.hrms.core.utilities.results.SuccessResult;
import hrmsJava.hrms.dataAccess.abstracts.StaffDao;
import hrmsJava.hrms.entities.concretes.Staff;
@Service
public class StaffManager implements StaffService {
	
	private StaffDao staffDao;
	private ValidInfoService validInfoService;
	private UserService userService;
	
	@Autowired
	public StaffManager(StaffDao staffDao, ValidInfoService validInfoService,UserService userService) {
		super();
		this.staffDao = staffDao;
		this.validInfoService = validInfoService;
		this.userService=userService;
	}

	
	@Override
	public DataResult<List<Staff>> getAll() {
		return new SuccessDataResult<List<Staff>>
		(this.staffDao.findAll(),"Sistem Personelleri başarılı şekilde listelendi");
	}

	@Override
	public Result add(Staff staff) {
		if(!validInfoService.validFirstNameStaff(staff)) {
			return new ErrorResult("Ad bilgisi hatalı");
		}
		else if(!validInfoService.validLastNameStaff(staff)) {
			return new ErrorResult("Soyad bilgisi hatalı");
		}
		else if(!validInfoService.validEmailStaff(staff)) {
			return new ErrorResult("Email bilgisi hatalı");
		}
		else if(!validInfoService.validPasswordStaff(staff)) {
			return new ErrorResult("Şifre bilgisi hatalı");
		}
		else if (userService.findByEmailEquals(staff.getEmail()).getData()!=null) {
			
			return new ErrorResult("Bu email zaten mevcut");
		}
		else{this.staffDao.save(staff);
		return new SuccessResult("Kaydınız başarılı");}
	}

}
