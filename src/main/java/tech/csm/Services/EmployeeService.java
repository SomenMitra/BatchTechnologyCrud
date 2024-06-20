package tech.csm.Services;

import java.util.List;
import java.util.Map;

import tech.csm.model.EmployeeMaster;

public interface EmployeeService {

	List<EmployeeMaster> getEmployeeByTechId(Integer tId, Integer bId);


}
