package back.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/project")
public class projectRestController {

    @Autowired
    private projectRepository projectRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<project> findAll() {
        return projectRepository.findAll();
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/{projectId}")
    public project findOne(@PathVariable Long projectId) {
        return projectRepository.findOne(projectId);
    }
    
	@RequestMapping(method = RequestMethod.POST)
    public project add(@RequestBody project project) {
        return projectRepository.save(project);
    }

	@RequestMapping(method = RequestMethod.PUT)
    public project update(@RequestBody project project) {
        return projectRepository.save(project);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{projectId}")
    public void delete(@PathVariable Long projectId) {
        projectRepository.delete(projectId);
    }
	
}

