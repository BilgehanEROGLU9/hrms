package hrmsJava.hrms.entities.dtos;

import java.util.List;

import hrmsJava.hrms.entities.concretes.Candidate;
import hrmsJava.hrms.entities.concretes.CandidateEducation;
import hrmsJava.hrms.entities.concretes.CandidateExperience;
import hrmsJava.hrms.entities.concretes.CandidateLanguage;
import hrmsJava.hrms.entities.concretes.CandidateLink;
import hrmsJava.hrms.entities.concretes.CandidateSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurriculumVitaeDto {
	private Candidate candidate;
	private List<CandidateLink> candidateLinks;
	private List<CandidateExperience> candidateExperiences;
	private List<CandidateLanguage> candidateLanguages;
	private List<CandidateEducation> candidateEducations;
	private List<CandidateSkill> candidateSkills;

}
