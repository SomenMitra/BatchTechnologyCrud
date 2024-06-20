package tech.csm.Services;

import java.util.List;
import java.util.Map;

import tech.csm.model.AssessmentMark;

public interface AssessmentMarkService {

	String saveMark(AssessmentMark am);

	List<Map<String, Object>> getAllAssessmentDetails();

	List<Map<String, Object>> getBatchWiseData(Integer bId);
}
