package hrmsJava.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name="cover_letter")
@NoArgsConstructor
@AllArgsConstructor
public class CoverLetter {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="letter")
	private String letter;
	
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
}
