package com.arpico.groupit.pc_repair.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.arpico.groupit.pc_repair.dto.AssetDto;
import com.arpico.groupit.pc_repair.dto.ErrorDto;
import com.arpico.groupit.pc_repair.dto.NameValueDto;
import com.arpico.groupit.pc_repair.dto.PartsDto;
import com.arpico.groupit.pc_repair.service.PartsService;
import com.arpico.groupit.pc_repair.service.SupplierService;

@Controller
public class PartsController {
	
	@Autowired
	private PartsService partsService;

	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping("/all_parts")
	public ModelAndView manageError() throws Exception {
		ModelAndView mav = new ModelAndView("pages/parts/manageparts");
		mav.addObject("title", "PC REPAIR | MANAGE PARTS");

		return mav;

	}
	
	@RequestMapping("/add_part")
    public ModelAndView addPart () throws Exception {
        ModelAndView mav = new ModelAndView("pages/parts/addparts");

        List<NameValueDto> suppliers = supplierService.getAllNameValue();
        
        
        mav.addObject("title", "PC REPAIR | ADD PART");
        mav.addObject("suppliers", suppliers);

        return mav;

    }
	
	@RequestMapping("/edit_part/{id}")
    public ModelAndView editPart (@PathVariable String id) throws Exception {
        ModelAndView mav = new ModelAndView("pages/parts/editparts");

        PartsDto partsDto = partsService.get(id);
        
        List<NameValueDto> suppliers = supplierService.getAllNameValue();
        
        
        mav.addObject("title", "PC REPAIR | ADD PART");
        
        mav.addObject("sup_id", partsDto.getSupplier());
        mav.addObject("part_id", partsDto.getPartId());
        mav.addObject("name", partsDto.getPartName());
        mav.addObject("purchasedate", partsDto.getPurchaseDate());
        mav.addObject("remark", partsDto.getRemark());
        mav.addObject("serialId", partsDto.getSerialId());
        mav.addObject("value", partsDto.getValue());
        mav.addObject("warrenty_exp", partsDto.getWarrentyExp());
        mav.addObject("warrenty_per", partsDto.getWarrentyPeriod());
        mav.addObject("suppliers", suppliers);

        return mav;

    }
	
	@RequestMapping("/all_parts_dt")
	@ResponseBody
	public Map allErrorDetails() throws Exception {

		List entities = new ArrayList();

		List<PartsDto> partsDtos = partsService.getAll();

		if (partsDtos != null) {
			for (PartsDto partsDto : partsDtos) {
				List entity = new ArrayList<>();

				entity.add(partsDto.getPartId());
				entity.add(partsDto.getPartName());
				entity.add(partsDto.getValue());
				entity.add(partsDto.getSerialId());
				entity.add(partsDto.getRemark());
				entity.add(partsDto.getPurchaseDate());
				entity.add(partsDto.getWarrentyExp());
				entity.add(partsDto.getSupplier());

				entity.add("<button type=\"button\" class=\"btn btn-default\" id=\"" + partsDto.getPartId()
						+ "\" onclick = \"editPart('" + partsDto.getPartId()
						+ "')\" ><i class=\"fa fa-edit\" aria-hidden=\"true\"></i></button>");
				/*
				 * entity.add("<button type=\"button\" class=\"btn btn-default\" id=\"" +
				 * assigneeDto.getAssigneeId() + "\" onclick = \"deleteAssignee('" +
				 * assigneeDto.getAssigneeId() +
				 * "')\" ><i class=\"fa fa-trash\" aria-hidden=\"true\"></i></button>");
				 */

				entities.add(entity);
			}
		}

		Map responseMap = new HashMap();
		responseMap.put("data", entities);
		return responseMap;
	}
	
	@RequestMapping(value = "/parts", method = RequestMethod.POST)
    @ResponseBody
    public String addPart (@RequestBody PartsDto partsDto) throws Exception {
        return partsService.save(partsDto);
    }
	
	@RequestMapping(value = "/parts", method = RequestMethod.PUT)
    @ResponseBody
    public String editPart (@RequestBody PartsDto partsDto) throws Exception {
        return partsService.save(partsDto);
    }
	
}
