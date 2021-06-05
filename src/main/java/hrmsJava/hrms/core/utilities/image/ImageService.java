package hrmsJava.hrms.core.utilities.image;

import org.springframework.web.multipart.MultipartFile;

import hrmsJava.hrms.core.utilities.results.DataResult;

public interface ImageService {
	DataResult<?> uploadPhoto(MultipartFile file);
}
