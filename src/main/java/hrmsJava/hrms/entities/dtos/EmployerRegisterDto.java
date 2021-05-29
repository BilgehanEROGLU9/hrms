package hrmsJava.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerRegisterDto {
	private String email;
	private String password;
	private String passwordRepeat;
	private String companyName;
	private String companyWebsite;
	private String companyNumber;
}
