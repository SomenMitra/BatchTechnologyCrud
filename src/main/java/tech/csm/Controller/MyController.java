package tech.csm.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletResponse;
import tech.csm.Services.AssessmentMarkService;
import tech.csm.Services.BatchService;
import tech.csm.Services.EmployeeService;
import tech.csm.Services.TechnologyService;
import tech.csm.model.AssessmentMark;
import tech.csm.model.BatchMaster;
import tech.csm.model.EmployeeMaster;
import tech.csm.model.TechnologyMaster;

@Controller
public class MyController {

	@Autowired
	private BatchService batchService;

	@Autowired
	private TechnologyService technologyService;

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private AssessmentMarkService amService;

	@RequestMapping(path = "/getForm", method = RequestMethod.GET)
	public String getForm(Model model) {

		List<BatchMaster> batchList = batchService.getAllBatches();
		List<TechnologyMaster> techList = technologyService.getAllTechnologies();
		List<Map<String, Object>> dataList = amService.getAllAssessmentDetails();
		
		Map<String, Object> retMap = new HashMap<>();
		retMap.put("bList", batchList);
		retMap.put("tList", techList);
		retMap.put("dataList", dataList);
		model.addAllAttributes(retMap);
		return "registration";
	}

	@GetMapping("/getEmpByTechID")
	public void getEmployeeByTechId(@RequestParam("techId") Integer tId, @RequestParam("batchId") Integer bId,
			HttpServletResponse resp) {
		
		try {
			List<EmployeeMaster> employeeList = employeeService.getEmployeeByTechId(tId, bId);

			String res = "<option value='0'>-select-</option>";
			for (EmployeeMaster e : employeeList) {
				res += "<option value='" + e.getEmployeeId() + "'>" + e.getEmployeeName() + "</option>";
			}

			resp.getWriter().println(res);
		} catch (IOException e1) {

			System.out.println(e1.getMessage());
		}

	}
	
	@PostMapping("/registerMark")
	public String saveMark(@RequestParam("empId") Integer eId,@RequestParam("mark") Double mark, RedirectAttributes rd) {
		AssessmentMark am = new AssessmentMark();
		EmployeeMaster e = new EmployeeMaster();
		e.setEmployeeId(eId);
		am.setEmployee(e);
		am.setMark(mark);
		String str = amService.saveMark(am);
		if(str.length() < 50) {
			rd.addFlashAttribute("dmsg", str);
		}else if (str.length() > 50) {
			rd.addFlashAttribute("msg", str);
		}
		return "redirect:./getForm";
	}
	
	@GetMapping("/providerFilter")
	public String getBatchWiseData(Model model,@RequestParam("batchId") Integer bId) {
		List<BatchMaster> batchList = batchService.getAllBatches();
		List<TechnologyMaster> techList = technologyService.getAllTechnologies();
		List<Map<String, Object>> dataList = amService.getBatchWiseData(bId);
		Map<String, Object> retMap = new HashMap<>();
		retMap.put("bList", batchList);
		retMap.put("tList", techList);
		retMap.put("batchDataList", dataList);
		model.addAllAttributes(retMap);
		return "registration";
	}

}
