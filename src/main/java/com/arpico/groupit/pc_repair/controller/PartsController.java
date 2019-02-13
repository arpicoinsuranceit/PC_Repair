package com.arpico.groupit.pc_repair.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
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
import com.arpico.groupit.pc_repair.util.AppConstant;

@Controller
@PropertySource("classpath:application.properties")
public class PartsController {
	
	@Value("${server.context-path}")
	private String path;
	
	@Autowired
	private PartsService partsService;

	@Autowired
	ServletContext context;
	
	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping("/all_parts")
	public ModelAndView manageError() throws Exception {
		context.setAttribute("path", path);
		ModelAndView mav = new ModelAndView("pages/parts/manageparts");
		mav.addObject("title", "PC REPAIR | MANAGE PARTS");

		return mav;

	}
	
	@RequestMapping("/add_part")
    public ModelAndView addPart () throws Exception {
		context.setAttribute("path", path);
        ModelAndView mav = new ModelAndView("pages/parts/addparts");

        List<NameValueDto> suppliers = supplierService.getAllNameValue();
        
        
        mav.addObject("title", "PC REPAIR | ADD PART");
        mav.addObject("suppliers", suppliers);

        return mav;

    }
	
	@RequestMapping("/edit_part/{id}")
    public ModelAndView editPart (@PathVariable String id) throws Exception {
		context.setAttribute("path", path);
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
        mav.addObject("partStatus", AppConstant.PART_STATUS);
        mav.addObject("currentStatus", partsDto.getStatus());

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

				/*entity.add(partsDto.getPartId());*/
				entity.add(partsDto.getPartName());
				entity.add(partsDto.getValue());
				entity.add(partsDto.getSerialId());
				entity.add(partsDto.getRemark());
				entity.add(partsDto.getPurchaseDate());
				entity.add(partsDto.getWarrentyExp());
				entity.add(partsDto.getSupplier());

				entity.add("<button type=\"button\" class=\"btn btn-info\" id=\"" + partsDto.getPartId()
						+ "\" onclick = \"editPart('" + partsDto.getPartId()
						+ "')\" ><i class=\"fa fa-edit\" aria-hidden=\"true\"></i>&nbsp;Edit</button>");

				  entity.add("<button type=\"button\" disabled=\"true\" class=\"btn btn-danger\" id=\"" +
						  partsDto.getPartId() + "\" onclick = \"deletePart('" +
						  partsDto.getPartId() +
				 "')\" ><i class=\"fa fa-trash\" aria-hidden=\"true\"></i>&nbsp;Delete</button>");


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
		partsDto.setStatus(AppConstant.PARTSTATUS_AVAILABLE);
		partsDto.setPartId(UUID.randomUUID().toString());
        return partsService.save(partsDto);
    }
	
	@RequestMapping(value = "/parts", method = RequestMethod.PUT)
    @ResponseBody
    public String editPart (@RequestBody PartsDto partsDto) throws Exception {
        return partsService.save(partsDto);
    }

    @RequestMapping(value = "/parts",method = RequestMethod.DELETE)
	@ResponseBody
    public String deletePart(@RequestBody String partId)throws Exception{
		return partsService.delete(partId);
	}

	@RequestMapping(value = "/searchPartSerial/{value}", method = RequestMethod.GET)
	@ResponseBody
	public List<PartsDto> searchPartSerial(@PathVariable String value) throws Exception {
		return partsService.findBySerial(value);
	}
	
	
}
