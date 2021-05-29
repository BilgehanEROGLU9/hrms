package hrmsJava.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@Table(name = "candidates")
@NoArgsConstructor
@AllArgsConstructor
public class Candidate extends User{
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "national_identity")
	private String nationalIdentity;
	@Column(name = "birthdate")
	private Date birthdate;



}
