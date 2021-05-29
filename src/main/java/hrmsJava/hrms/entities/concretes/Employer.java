package hrmsJava.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employers")
@NoArgsConstructor
@AllArgsConstructor
public class Employer extends User {

	@Column(name = "company_name")
	private String companyName;
	@Column(name = "company_website")
	private String companyWebsite;
	@Column(name = "company_number")
	private String companyNumber;

	


}
