package com.arpico.groupit.pc_repair.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.arpico.groupit.pc_repair.dto.AssigneeDto;
import com.arpico.groupit.pc_repair.dto.ErrorDto;
import com.arpico.groupit.pc_repair.dto.SupplierDto;
import com.arpico.groupit.pc_repair.service.ErrorService;

@Controller
public class ErrorController {

	@Autowired
	private ErrorService errorService;
	
	@Value("${server.context-path}")
	private String path;
	
	@Autowired
	ServletContext context;

	@RequestMapping("/all_errors")
	public ModelAndView manageError() throws Exception {
		context.setAttribute("path", path);
		ModelAndView mav = new ModelAndView("pages/error/manageerror");
		mav.addObject("title", "PC REPAIR | MANAGE ERROR");

		return mav;

	}

	@RequestMapping("/add_error")
	public ModelAndView addError() throws Exception {
		context.setAttribute("path", path);
		ModelAndView mav = new ModelAndView("pages/error/adderror");
		mav.addObject("title", "PC REPAIR | ADD ERROR");

		return mav;

	}
	
	@RequestMapping("/edit_error/{id}")
	public ModelAndView editError(@PathVariable String id) throws Exception {
		context.setAttribute("path", path);
		ModelAndView mav = new ModelAndView("pages/error/editerror");
		
		ErrorDto dto = errorService.get(id);
		
		mav.addObject("title", "PC REPAIR | EDIT ERROR");
		mav.addObject("id", dto.getId());
		mav.addObject("name", dto.getName());
		mav.addObject("description", dto.getDescription());

		return mav;

	}

	@RequestMapping("/all_error_dt")
	@ResponseBody
	public Map allErrorDetails() throws Exception {

		List entities = new ArrayList();

		List<ErrorDto> errorDtos = errorService.getAll();

		if (errorDtos != null) {
			for (ErrorDto errorDto : errorDtos) {
				List entity = new ArrayList<>();

				entity.add(errorDto.getId());
				entity.add(errorDto.getName());
				entity.add(errorDto.getDescription());

				entity.add("<button type=\"button\" class=\"btn btn-default\" id=\"" + errorDto.getId()
						+ "\" onclick = \"editError('" + errorDto.getId()
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

	@RequestMapping(value = "/error", method = RequestMethod.POST)
	@ResponseBody
	public String addError(@RequestBody ErrorDto errorDro) throws Exception {

		System.out.println(errorDro.getId());
		System.out.println(errorDro.getDescription());

		return errorService.save(errorDro);
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.PUT)
	@ResponseBody
	public String editError(@RequestBody ErrorDto errorDro) throws Exception {

		System.out.println(errorDro.getId());
		System.out.println(errorDro.getDescription());

		return errorService.save(errorDro);
	}

}
