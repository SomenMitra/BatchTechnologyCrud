package tech.csm.Services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.Repository.AssessmentMarkRepo;
import tech.csm.model.AssessmentMark;

@Service
public class AssessmentMarkServiceImpl implements AssessmentMarkService {

	@Autowired
	private AssessmentMarkRepo amRepo;

	@Override
	public String saveMark(AssessmentMark am) {
		return amRepo.saveMark(am);
	}

	@Override
	public List<Map<String, Object>> getAllAssessmentDetails() {
		return amRepo.getAllAssessmentDetails();
	}

	@Override
	public List<Map<String, Object>> getBatchWiseData(Integer bId) {
		
		return amRepo.getBatchWiseData(bId);
	}

	
	
}
