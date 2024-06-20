package tech.csm.Repository;

import java.util.List;
import java.util.Map;

import tech.csm.model.AssessmentMark;

public interface AssessmentMarkRepo {

	String saveMark(AssessmentMark am);

	List<Map<String, Object>> getAllAssessmentDetails();

	List<Map<String, Object>> getBatchWiseData(Integer bId);


}
