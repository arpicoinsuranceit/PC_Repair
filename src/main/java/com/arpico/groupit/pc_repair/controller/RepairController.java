package com.arpico.groupit.pc_repair.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.arpico.groupit.pc_repair.dto.NameValueDto;
import com.arpico.groupit.pc_repair.dto.RepairReturnDto;
import com.arpico.groupit.pc_repair.dto.RepairSentDto;
import com.arpico.groupit.pc_repair.dto.SupplierDto;
import com.arpico.groupit.pc_repair.entity.RepairPartsEntity;
import com.arpico.groupit.pc_repair.service.AssetService;
import com.arpico.groupit.pc_repair.service.LocationService;
import com.arpico.groupit.pc_repair.service.RepairReturnService;
import com.arpico.groupit.pc_repair.service.RepairSendService;
import com.arpico.groupit.pc_repair.service.RepairService;
import com.arpico.groupit.pc_repair.util.AppConstant;

@Controller
public class RepairController {

	@Autowired
	private LocationService locationService;

	@Autowired
	private AssetService assetService;

	@Autowired
	private RepairService repairService;

	@Autowired
	private RepairSendService repairSendService;
	
	@Autowired
	private RepairReturnService repairReturnService;

	@RequestMapping("/send_repair")
	public ModelAndView sendRepair() throws Exception {
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
		ModelAndView mav = new ModelAndView("pages/repair/sendrepairs");

		mav.addObject("title", "PC REPAIR | SEND REPAIRS");

		return mav;

	}
	
	@RequestMapping("/all_return_repair")
	public ModelAndView allReturnRepair() throws Exception {
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
				entity.add("<button type=\"button\" class=\"btn btn-default\" id=\"" + repairSentDto.getRepairSendId()
						+ "\" onclick = \"repairReceived('" + repairSentDto.getRepairSendId()
						+ "')\" ><i class=\"fa fa-edit\" aria-hidden=\"true\"></i><span>&nbsp;&nbsp;RECEIVED</span></button>");
				
				entity.add("<button disabled type=\"button\" class=\"btn btn-default\" id=\"" + repairSentDto.getRepairId()
				+ "\" onclick = \"showRepair('" + repairSentDto.getRepairId()
				+ "')\" ><i class=\"fa fa-edit\" aria-hidden=\"true\"></i><span>&nbsp;&nbsp;SHOW</span></button>");
			}
			else {
				entity.add("<button disabled type=\"button\" class=\"btn btn-default\" id=\"" + repairSentDto.getRepairSendId()
				+ "\" onclick = \"repairReceived('" + repairSentDto.getRepairSendId()
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

		List<RepairSentDto> repairSentDtos = repairService.getReturnRepairs();

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
				entity.add("<button type=\"button\" class=\"btn btn-default\" id=\"" + repairSentDto.getRepairSendId()
						+ "\" onclick = \"repairReceived('" + repairSentDto.getRepairSendId()
						+ "')\" ><i class=\"fa fa-edit\" aria-hidden=\"true\"></i><span>&nbsp;&nbsp;RECEIVED</span></button>");
			}
			else {
				entity.add("<button disabled type=\"button\" class=\"btn btn-default\" id=\"" + repairSentDto.getRepairSendId()
				+ "\" onclick = \"repairReceived('" + repairSentDto.getRepairSendId()
				+ "')\" ><i class=\"fa fa-edit\" aria-hidden=\"true\"></i><span>&nbsp;&nbsp;RECEIVED</span></button>");
				
			}
			
			
			
			entities.add(entity);
		}

		Map responseMap = new HashMap();
		responseMap.put("data", entities);
		return responseMap;
	}
	
	@RequestMapping(value = "/received_send/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String receivedRepair(@PathVariable String id) throws Exception {
		return repairSendService.received(id);
	}

	
}
