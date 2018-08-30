package com.arpico.groupit.pc_repair.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.arpico.groupit.pc_repair.dto.AssetDto;
import com.arpico.groupit.pc_repair.dto.AssigneeDto;
import com.arpico.groupit.pc_repair.dto.ErrorDto;
import com.arpico.groupit.pc_repair.dto.NameValueDto;
import com.arpico.groupit.pc_repair.dto.PartsDto;
import com.arpico.groupit.pc_repair.dto.RepairBasicsDto;
import com.arpico.groupit.pc_repair.dto.RepairDto;
import com.arpico.groupit.pc_repair.dto.RepairReturnDto;
import com.arpico.groupit.pc_repair.dto.RepairSentDto;
import com.arpico.groupit.pc_repair.dto.StatusDto;
import com.arpico.groupit.pc_repair.dto.SupplierDto;
import com.arpico.groupit.pc_repair.entity.RepairPartsEntity;
import com.arpico.groupit.pc_repair.service.AssetService;
import com.arpico.groupit.pc_repair.service.AssigneeService;
import com.arpico.groupit.pc_repair.service.ErrorService;
import com.arpico.groupit.pc_repair.service.LocationService;
import com.arpico.groupit.pc_repair.service.PartsService;
import com.arpico.groupit.pc_repair.service.RepairReturnService;
import com.arpico.groupit.pc_repair.service.RepairSendService;
import com.arpico.groupit.pc_repair.service.RepairService;
import com.arpico.groupit.pc_repair.service.StatusService;
import com.arpico.groupit.pc_repair.util.AppConstant;

@Controller
public class RepairController {

	@Value("${server.context-path}")
	private String path;
	
	@Autowired
	private LocationService locationService;

	@Autowired
	private AssetService assetService;

	@Autowired
	private RepairService repairService;

	@Autowired
	private RepairSendService repairSendService;
	
	@Autowired
	private AssigneeService assigneeService;
	
	@Autowired
	private RepairReturnService repairReturnService;

	@Autowired
	private ErrorService errorService;
	
	@Autowired
	private StatusService statusService;
	
	@Autowired
	ServletContext context;
	
	
	@RequestMapping("/repair/{id}")
	public ModelAndView navigateRepair(@PathVariable String id) throws Exception {
		context.setAttribute("path", path);
		ModelAndView mav = new ModelAndView("pages/repair/repair");

		List<AssigneeDto> assigneeDtos = assigneeService.getAll();
		List<ErrorDto> errorDtos = errorService.getAll();
		List<StatusDto> statusDtos = statusService.getAll();
		
		List<String> priorities = new ArrayList<>();
		priorities.add("LEVEL 1");
		priorities.add("LEVEL 2");
		priorities.add("LEVEL 3");
		priorities.add("LEVEL 4");
		priorities.add("LEVEL 5");
		
		RepairDto repairDto = repairService.getRepair(id);
		
		
		mav.addObject("title", "PC REPAIR | REPAIR");
		mav.addObject("assignees", assigneeDtos);
		mav.addObject("errors", errorDtos);
		mav.addObject("status", statusDtos);
		mav.addObject("repair", repairDto);
		mav.addObject("priorities", priorities);
		

		return mav;

	}
	
	@RequestMapping("/send_repair")
	public ModelAndView sendRepair() throws Exception {
		context.setAttribute("path", path);
		ModelAndView mav = new ModelAndView("pages/repair/sendrepair");

		List<NameValueDto> locations = locationService.getAllNameValue();
		List<AssetDto> assetDtos = assetService.getAll();

		mav.addObject("title", "PC REPAIR | SEND REPAIR");
		mav.addObject("locations", locations);
		mav.addObject("assets", assetDtos);

		return mav;

	}
	
	
	
	@RequestMapping("/return_repair")
	public ModelAndView returnrepair() throws Exception {
		context.setAttribute("path", path);
		ModelAndView mav = new ModelAndView("pages/repair/returnrepair");

		List<NameValueDto> locations = locationService.getAllNameValue();
		List<AssetDto> assetDtos = repairService.getAllRepaired();


		mav.addObject("title", "PC REPAIR | SEND REPAIR");
		mav.addObject("locations", locations);
		mav.addObject("assets", assetDtos);

		return mav;

	}

	@RequestMapping(value = "/send_repair", method = RequestMethod.POST)
	@ResponseBody
	public String saveSendRepair(@RequestBody RepairSentDto repairSentDto) throws Exception {
		return repairSendService.save(repairSentDto);
	}
	
	@RequestMapping(value = "/return_repair", method = RequestMethod.POST)
	@ResponseBody
	public String saveReturnRepair(@RequestBody RepairReturnDto repairReturnDto) throws Exception {
		return repairReturnService.save(repairReturnDto);
	}

	@RequestMapping("/all_send_repair")
	public ModelAndView allSendRepair() throws Exception {
		context.setAttribute("path", path);
		ModelAndView mav = new ModelAndView("pages/repair/sendrepairs");

		mav.addObject("title", "PC REPAIR | SEND REPAIRS");

		return mav;

	}
	
	@RequestMapping("/all_return_repair")
	public ModelAndView allReturnRepair() throws Exception {
		context.setAttribute("path", path);
		ModelAndView mav = new ModelAndView("pages/repair/returnrepairs");

		mav.addObject("title", "PC REPAIR | RETURN REPAIRS");

		return mav;

	}

	@RequestMapping("/all_send_repair_dt")
	@ResponseBody
	public Map allsupplierDetails() throws Exception {

		List entities = new ArrayList();

		List<RepairSentDto> repairSentDtos = repairService.getSendRepairs();

		for (RepairSentDto repairSentDto : repairSentDtos) {
			List entity = new ArrayList<>();

			entity.add(repairSentDto.getRepairId());
			entity.add(repairSentDto.getAssetId());
			entity.add(repairSentDto.getSendDate());
			entity.add(repairSentDto.getSendingMethod());
			entity.add(repairSentDto.getCourierId());
			entity.add(repairSentDto.getFromLocation());
			entity.add(repairSentDto.getReason());
			if (repairSentDto.getStatus().equals(AppConstant.SEND)) {
				entity.add("<button type=\"button\" class=\"btn btn-default\" id=\"" + repairSentDto.getRepairId()
						+ "\" onclick = \"repairReceived('" + repairSentDto.getRepairId()
						+ "')\" ><i class=\"fa fa-edit\" aria-hidden=\"true\"></i><span>&nbsp;&nbsp;RECEIVED</span></button>");
				
				entity.add("<button disabled type=\"button\" class=\"btn btn-default\" id=\"" + repairSentDto.getRepairId()
				+ "\" onclick = \"showRepair('" + repairSentDto.getRepairId()
				+ "')\" ><i class=\"fa fa-edit\" aria-hidden=\"true\"></i><span>&nbsp;&nbsp;SHOW</span></button>");
			}
			else {
				entity.add("<button disabled type=\"button\" class=\"btn btn-default\" id=\"" + repairSentDto.getRepairId()
				+ "\" onclick = \"repairReceived('" + repairSentDto.getRepairId()
				+ "')\" ><i class=\"fa fa-edit\" aria-hidden=\"true\"></i><span>&nbsp;&nbsp;RECEIVED</span></button>");
				
				entity.add("<button type=\"button\" class=\"btn btn-default\" id=\"" + repairSentDto.getRepairId()
				+ "\" onclick = \"showRepair('" + repairSentDto.getRepairId()
				+ "')\" ><i class=\"fa fa-edit\" aria-hidden=\"true\"></i><span>&nbsp;&nbsp;SHOW</span></button>");
			}
			
			
			
			entities.add(entity);
		}

		Map responseMap = new HashMap();
		responseMap.put("data", entities);
		return responseMap;
	}
	
	@RequestMapping("/all_return_repair_dt")
	@ResponseBody
	public Map allReturnDetails() throws Exception {
		List entities = new ArrayList();
		List<RepairReturnDto> repairReturnDtos = repairService.getReturnRepairs();
		for (RepairReturnDto repairReturnDto : repairReturnDtos) {
			List entity = new ArrayList<>();

			entity.add(repairReturnDto.getRepairId());
			entity.add(repairReturnDto.getAssetId());
			entity.add(repairReturnDto.getSendingMethod());
			entity.add(repairReturnDto.getCourierId());
			entity.add(repairReturnDto.getFromLocation());
			entity.add(repairReturnDto.getHandOverTo());
			if (repairReturnDto.getStatus().equals(AppConstant.RETURN)) {
				entity.add("<button type=\"button\" class=\"btn btn-default\" id=\"" + repairReturnDto.getRepairId()
						+ "\" onclick = \"repairReceived('" + repairReturnDto.getRepairId()
						+ "')\" ><i class=\"fa fa-edit\" aria-hidden=\"true\"></i><span>&nbsp;&nbsp;RECEIVED</span></button>");
			}
			else {
				entity.add("<button disabled type=\"button\" class=\"btn btn-default\" id=\"" + repairReturnDto.getRepairId()
				+ "\" onclick = \"repairReceived('" + repairReturnDto.getRepairId()
				+ "')\" ><i class=\"fa fa-edit\" aria-hidden=\"true\"></i><span>&nbsp;&nbsp;RECEIVED</span></button>");
				
			}
			
			
			
			entities.add(entity);
		}
		Map responseMap = new HashMap();
		responseMap.put("data", entities);
		return responseMap;
		
		
	}
	
	
	@RequestMapping("/dashboard_repair_dt")
	@ResponseBody
	public Map dashboardRepairDetails() throws Exception {

		List entities = new ArrayList();

		List<RepairDto> repairDtos = repairService.getRepairForDashboard();

		for (RepairDto repairDto : repairDtos) {
			List entity = new ArrayList<>();

			entity.add(repairDto.getJobNo());
			entity.add(repairDto.getAssetDto().getAssetId());
			entity.add(repairDto.getLocationDto().getLocationName());
			entity.add(repairDto.getReason());
			entity.add(repairDto.getPriority());
			entity.add(repairDto.getStatusDto().getDescription());
			
			
			entity.add("<button type=\"button\" class=\"btn btn-default\" id=\"" + repairDto.getRepairId()
			+ "\" onclick = \"showRepair('" + repairDto.getRepairId()
			+ "')\" ><i class=\"fa fa-edit\" aria-hidden=\"true\"></i><span>&nbsp;&nbsp;SHOW</span></button>");
			
			entities.add(entity);
		}

		Map responseMap = new HashMap();
		responseMap.put("data", entities);
		return responseMap;
	}
	
	@RequestMapping(value = "/received_send/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String receivedRepairSend(@PathVariable String id) throws Exception {
		return repairSendService.received(id, AppConstant.SEND_REC);
	}

	
	@RequestMapping(value = "/received_return/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String receivedRepairReturn(@PathVariable String id) throws Exception {
		return repairSendService.received(id, AppConstant.RETURN_REC);
	}
	
	@RequestMapping(value = "/addAssigneeToRepair/{repairId}/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String addAssigneeToRepair(@PathVariable String id, @PathVariable String repairId) throws Exception {
		return repairSendService.addAssignee(id, repairId);
	}
	
	@RequestMapping(value = "/send_repair_basics/{repairId}", method = RequestMethod.POST)
	@ResponseBody
	public String addBasicDetailsRepair(@RequestBody RepairBasicsDto repairBasicsDto, @PathVariable String repairId) throws Exception {
		return repairService.addBasicDetails(repairBasicsDto, repairId);
	}
	
	@RequestMapping(value = "/send_repair_cart/{repairId}", method = RequestMethod.POST)
	@ResponseBody
	public String addRepairParts(@RequestBody List<String> repairParts, @PathVariable String repairId) throws Exception {
		return repairService.addCartDetails(repairParts, repairId);
	}
	

	
}
