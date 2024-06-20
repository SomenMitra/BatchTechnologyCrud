package tech.csm.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import tech.csm.model.AssessmentMark;
import tech.csm.model.BatchMaster;

@Repository
public class AssessmentMarkRepoImpl implements AssessmentMarkRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String saveMark(AssessmentMark am) {

		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate.getDataSource())
				.withProcedureName("ManageBatchAndAssessment")
				.returningResultSet("batchList", new BeanPropertyRowMapper<>(BatchMaster.class));

		SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("p_status", "SaveAssessmentMark")
				.addValue("p_Batch_id", null).addValue("p_Technology_id", null)
				.addValue("p_empid", am.getEmployee().getEmployeeId()).addValue("p_mark", am.getMark());

		Map<String, Object> res = simpleJdbcCall.execute(sqlParameterSource);

		return (String) res.get("p_msg");
	}

	
	
	@Override
	public List<Map<String, Object>> getAllAssessmentDetails() {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate.getDataSource())
				.withProcedureName("ManageBatchAndAssessment")
				.returningResultSet("allData", new RowMapper<Map<String, Object>>() {

					@Override
					public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
						Map<String,Object> dataMap=new HashMap<>();
						dataMap.put("batchName", rs.getString(1));
						dataMap.put("batchStartDate", rs.getDate(2));
						dataMap.put("technologyName", rs.getString(3));
						dataMap.put("employeeName", rs.getString(4));
						dataMap.put("employeePhone", rs.getString(5));
						dataMap.put("mark", rs.getInt(6));
						return dataMap;
					}
				});

		Map<String, Object> data = simpleJdbcCall.execute("getAllMarkData",Types.NULL,Types.NULL,Types.NULL,Types.NULL);
		List<Map<String,Object>> dataList = (List<Map<String,Object>>) data.get("allData");
		return dataList;
	}



	@Override
	public List<Map<String, Object>> getBatchWiseData(Integer bId) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate.getDataSource())
				.withProcedureName("ManageBatchAndAssessment")
				.returningResultSet("allData", new RowMapper<Map<String, Object>>() {

					@Override
					public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
						Map<String,Object> dataMap=new HashMap<>();
						dataMap.put("empName", rs.getString(1));
						dataMap.put("mark", rs.getString(2));
						dataMap.put("grade", rs.getString(3));
						dataMap.put("status", rs.getString(4));
						return dataMap;
					}
				});

		Map<String, Object> data = simpleJdbcCall.execute("ShowReportByBatch",bId,Types.NULL,Types.NULL,Types.NULL);
		List<Map<String,Object>> dataList = (List<Map<String,Object>>) data.get("allData");
		return dataList;
	}

}
