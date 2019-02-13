package com.arpico.groupit.pc_repair.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.arpico.groupit.pc_repair.dto.RepairDto;
import com.arpico.groupit.pc_repair.service.WarrantyClameService;

@Controller
@PropertySource("classpath:application.properties")
public class WarrantyClameController {

	@Value("${server.context-path}")
	private String path;
	
	@Autowired
	WarrantyClameService warrantyClameService;
	
	@Autowired
	ServletContext context;
	
	@RequestMapping("/add_warranty")
	public ModelAndView addWrrantyClame()throws Exception{
		
		context.setAttribute("path", path);
		
		ModelAndView mav = new  ModelAndView("pages/warranty/warranty");
		mav.addObject("title", "PC REPAIR | WARRANTY CLAME");
		return mav;
		
	}
	
	@RequestMapping("/all_warranty_clame_dt")
	@ResponseBody
	public Map allWrrantyClames()throws Exception{
		
		List entity = new ArrayList();
		
		List<RepairDto> repairDtos = warrantyClameService.getWrrantyClames();
		
		for (RepairDto repairDto : repairDtos) {
			
			List entitys = new ArrayList<>();
			
			entitys.add(repairDto.getJobNo());
			/* entitys.add(repairDto.getAssetDto().getAssetId()); */
			entitys.add(repairDto.getPriority());
			entitys.add(repairDto.getRemark());
			
			entity.add(entitys);
		}
		
		Map responseMap = new HashMap();
		responseMap.put("data",entity);
		
		System.out.println("All Warranty ==/" +responseMap.toString());
		
		return responseMap;
	}
	
	@RequestMapping("/all_warranty_clames")
	public ModelAndView allWrrantyClames1()throws Exception{
		
		context.setAttribute("path", path);
		ModelAndView mav = new ModelAndView("pages/warranty/allwarrantyclame");
		
		mav.addObject("title", "PC REPAIR | All Warranty Clames");
		System.out.println("call" +mav);
		return mav;
	}
}
