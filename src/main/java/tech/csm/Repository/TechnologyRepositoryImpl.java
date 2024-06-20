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

import tech.csm.model.BatchMaster;
import tech.csm.model.TechnologyMaster;

@Repository
public class TechnologyRepositoryImpl implements TechnologyRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<TechnologyMaster> getAllTechnologies() {

		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate.getDataSource())
				.withProcedureName("ManageBatchAndAssessment")
				.returningResultSet("tList", new BeanPropertyRowMapper<>(TechnologyMaster.class));

		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("p_status", "GetAllTechnologies")
				.addValue("p_Batch_id", null)
				.addValue("p_Technology_id", null)
				.addValue("p_empid", null)
				.addValue("p_mark", null);

		Map<String, Object> res = simpleJdbcCall.execute(sqlParameterSource);

		List<TechnologyMaster> techList = (List<TechnologyMaster>) res.get("tList");

		return techList;

	}
}
