package tech.csm.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AssessmentMark {
	
	private Integer slno;
	private EmployeeMaster employee;
	private Double mark;

}
