package tech.csm.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.Repository.TechnologyRepository;
import tech.csm.model.TechnologyMaster;

@Service
public class TechnologyServiceImpl implements TechnologyService {
	
	@Autowired
	private TechnologyRepository techRepository;

	@Override
	public List<TechnologyMaster> getAllTechnologies() {
		
		return techRepository.getAllTechnologies();
	}

}
