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

import tech.csm.model.EmployeeMaster;
import tech.csm.model.TechnologyMaster;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<EmployeeMaster> getEmployeeByTechId(Integer tId,Integer bId) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate.getDataSource())
				.withProcedureName("ManageBatchAndAssessment")
				.returningResultSet("eList", new BeanPropertyRowMapper<>(EmployeeMaster.class));

		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("p_status", "GetEmployeesByBatchAndTechnology")
				.addValue("p_Batch_id", bId)
				.addValue("p_Technology_id", tId)
				.addValue("p_empid", null)
				.addValue("p_mark", null);

		Map<String, Object> res = simpleJdbcCall.execute(sqlParameterSource);

		List<EmployeeMaster> empList = (List<EmployeeMaster>) res.get("eList");

		return empList;
	}
	
	

}
