package tech.csm.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BatchMaster {	
	private Integer batchId;
	private String batchName;
	private Date batchStartDate;
	private Integer batchStrength;

}
