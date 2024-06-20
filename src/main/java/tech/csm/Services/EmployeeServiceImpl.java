package tech.csm.Services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.Repository.EmployeeRepository;
import tech.csm.model.EmployeeMaster;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;

	

	@Override
	public List<EmployeeMaster> getEmployeeByTechId(Integer tId, Integer bId) {
		
		return employeeRepo.getEmployeeByTechId(tId,bId);
	}





}
