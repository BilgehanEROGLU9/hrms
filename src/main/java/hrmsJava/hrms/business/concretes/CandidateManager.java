package hrmsJava.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrmsJava.hrms.business.abstracts.CandidateService;
import hrmsJava.hrms.business.abstracts.*;
import hrmsJava.hrms.core.utilities.image.ImageService;
import hrmsJava.hrms.core.utilities.results.DataResult;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.core.utilities.results.SuccessDataResult;
import hrmsJava.hrms.core.utilities.results.SuccessResult;
import hrmsJava.hrms.dataAccess.abstracts.CandidateDao;
import hrmsJava.hrms.entities.concretes.Candidate;
import hrmsJava.hrms.entities.dtos.CurriculumVitaeDto;
@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;
	private ImageService imageService;
	private CandidateExperienceService candidateExperienceService;
	private CandidateLanguageService candidateLanguageService;
	private CandidateLinkService candidateLinkService;
	private CandidateEducationService candidateEducationService;
	private CandidateSkillService candidateSkillService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, ImageService imageService,
			CandidateExperienceService candidateExperienceService, CandidateLanguageService candidateLanguageService,
			CandidateLinkService candidateLinkService, CandidateEducationService candidateEducationService,
			CandidateSkillService candidateSkillService) {
		
		this.candidateDao = candidateDao;
		this.imageService = imageService;
		this.candidateExperienceService = candidateExperienceService;
		this.candidateLanguageService = candidateLanguageService;
		this.candidateLinkService = candidateLinkService;
		this.candidateEducationService = candidateEducationService;
		this.candidateSkillService = candidateSkillService;
	}




	
	

	


	@Override
	public DataResult<List<Candidate>> getAll() {
	
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findAll(),"İş Arayanlar başarılı şekilde listelendi");
	}




	@Override
	public Result add(Candidate candidate) {
		candidateDao.save(candidate);
		return new SuccessResult();
	}





	@Override
	public DataResult<Candidate> getByNationalIdentity(String nationalIdentity) {
		return new SuccessDataResult<Candidate>(candidateDao.findByNationalIdentity(nationalIdentity));
	}










	@Override
	public DataResult<Candidate> getById(int candidateId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(candidateId));
	}










	@Override
	public DataResult<CurriculumVitaeDto> getCVByCandidate(int candidateId) {
		CurriculumVitaeDto dto = new CurriculumVitaeDto();
		dto.setCandidate(this.getById(candidateId).getData());
		dto.setCandidateLinks(this.candidateLinkService.getByCandidateId(candidateId).getData());
		dto.setCandidateExperiences(this.candidateExperienceService.getByCandidate(candidateId).getData());
		dto.setCandidateLanguages(this.candidateLanguageService.getByCandidate(candidateId).getData());
		dto.setCandidateEducations(this.candidateEducationService.getByCandidate(candidateId).getData());
		dto.setCandidateSkills(this.candidateSkillService.getByCandidate(candidateId).getData());

		return new SuccessDataResult<CurriculumVitaeDto>(dto);
	}










	@Override
	public Result changeDescription(int candidateId, String description) {
		Candidate candidateToAddDescription = this.getById(candidateId).getData();
		candidateToAddDescription.setDescription(description);
		this.candidateDao.save(candidateToAddDescription);
		return new SuccessResult();
	}










	@Override
	public Result uploadPhoto(int candidateId, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) this.imageService.uploadPhoto(file).getData();
		String url = result.get("url");
		Candidate candidateToAddPhoto = this.getById(candidateId).getData();
		candidateToAddPhoto.setImageUrl(url);
		this.candidateDao.save(candidateToAddPhoto);
		return new SuccessResult();
	}
	

}
