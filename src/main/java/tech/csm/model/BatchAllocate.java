package tech.csm.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BatchAllocate {
	
	private Integer batchAllocateId;
	
	private EmployeeMaster employeeMaster;
	
	private BatchMaster batchMaster;
	
	private TechnologyMaster technologyMaster;

}
