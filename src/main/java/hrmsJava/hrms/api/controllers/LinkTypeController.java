package hrmsJava.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsJava.hrms.business.abstracts.LinkTypeService;
import hrmsJava.hrms.core.utilities.results.Result;
import hrmsJava.hrms.entities.concretes.LinkType;

@RestController
@RequestMapping("/api/linkTypes")
public class LinkTypeController {
	private LinkTypeService linkTypeService;

	@Autowired
	public LinkTypeController(LinkTypeService linkTypeService) {
		this.linkTypeService = linkTypeService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody LinkType linkType) {
		return this.linkTypeService.add(linkType);
	}
}
