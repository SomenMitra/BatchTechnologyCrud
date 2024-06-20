package tech.csm.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.Repository.BatchRepository;
import tech.csm.model.BatchMaster;

@Service
public class BatchServiceImpl implements BatchService {
	
	@Autowired
	private BatchRepository batchRepo;
	

	@Override
	public List<BatchMaster> getAllBatches() {
		
		return batchRepo.getAllBatches();
	}

}
