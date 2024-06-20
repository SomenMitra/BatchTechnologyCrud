package tech.csm.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import jakarta.validation.constraints.Null;
import tech.csm.model.BatchMaster;

@Repository
public class BatchRepositoryImpl implements BatchRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<BatchMaster> getAllBatches() {
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate.getDataSource()).withProcedureName("ManageBatchAndAssessment").returningResultSet("batchList", new BeanPropertyRowMapper<>(BatchMaster.class));
		
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("p_status", "GetAllBatches")
				.addValue("p_Batch_id", null)
				.addValue("p_Technology_id", null)
				.addValue("p_empid", null)
				.addValue("p_mark", null);
		
		Map<String, Object> res = simpleJdbcCall.execute(sqlParameterSource);
		
		List<BatchMaster> batchList = (List<BatchMaster>)res.get("batchList");
		
		return batchList;
	}

}
