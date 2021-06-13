package hrmsJava.hrms.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler","candidate"})
public class Candidate extends User{
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "national_identity")
	private String nationalIdentity;
	@Column(name = "birthdate")
	private Date birthdate;
	@Column(name = "image_url")
	private String imageUrl;
	@Column(name = "is_activated")
	private boolean isActivated;
	@Column(name = "description")
	private String description;
	



}