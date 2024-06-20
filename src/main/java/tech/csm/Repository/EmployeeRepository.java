package tech.csm.Repository;

import java.util.List;

import tech.csm.model.EmployeeMaster;

public interface EmployeeRepository {

	List<EmployeeMaster> getEmployeeByTechId(Integer tId, Integer bId);

}
