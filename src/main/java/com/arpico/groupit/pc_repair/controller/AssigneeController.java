package com.arpico.groupit.pc_repair.controller;

import com.arpico.groupit.pc_repair.dto.AssigneeDto;
import com.arpico.groupit.pc_repair.service.AssigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

@Controller
@PropertySource("classpath:application.properties")
public class AssigneeController {

    @Autowired
    private AssigneeService assigneeService;
    
    @Value("${server.context-path}")
	private String path;
    
    @Autowired
	ServletContext context;

    @RequestMapping("/all_assignees")
    public ModelAndView manageAssignee () throws Exception {
    	context.setAttribute("path", path);
        ModelAndView mav = new ModelAndView("pages/assignee/manageassignee");
        mav.addObject("title", "PC REPAIR | MANAGE ASSIGNEE");

        return mav;

    }

    @RequestMapping("/add_assignee")
    public ModelAndView addAssignee () throws Exception {
    	context.setAttribute("path", path);
        ModelAndView mav = new ModelAndView("pages/assignee/addassignee");
        mav.addObject("title", "PC REPAIR | ADD ASSIGNEE");

        return mav;

    }

    @RequestMapping("/edit_assignee/{id}")
    public ModelAndView editAssignee (@PathVariable String id) throws Exception {
    	context.setAttribute("path", path);
        ModelAndView mav = new ModelAndView("pages/assignee/editassignee");
        AssigneeDto assigneeDto = assigneeService.get(id);

        mav.addObject("title", "PC REPAIR | EDIT ASSIGNEE");

        mav.addObject("name", assigneeDto.getAssigneeName());
        mav.addObject("id", assigneeDto.getAssigneeId());

        return mav;

    }

    @RequestMapping("/all_assignee_dt")
    @ResponseBody
    public Map allAssigneeDetails() throws Exception{

        List entities = new ArrayList();

        List<AssigneeDto> assigneeDtos = assigneeService.getAll();

        if(assigneeDtos != null) {
            for (AssigneeDto assigneeDto : assigneeDtos) {
                List entity = new ArrayList<>();

                entity.add(assigneeDto.getAssigneeId());
                entity.add(assigneeDto.getAssigneeName());

                entity.add("<button type=\"button\" class=\"btn btn-info\" id=\"" + assigneeDto.getAssigneeId()
                        + "\" onclick = \"editAssignee('" + assigneeDto.getAssigneeId() + "')\" ><i class=\"fa fa-edit\" aria-hidden=\"true\"></i>&nbsp;Edit</button>");
                
                entity.add("<button type=\"button\" disabled=\"true\"  class=\"btn btn-default btn-danger del\" id=\"adelete" + assigneeDto.getAssigneeId()
                        + "\" onclick = \"deleteAssignee('" + assigneeDto.getAssigneeId() + "')\" ><i class=\"fa fa-trash\" aria-hidden=\"true\"></i>&nbsp;Delete</button>");


                entities.add(entity);
            }
        }

        Map responseMap = new HashMap();
        responseMap.put("data", entities);
        return responseMap;
    }

    @RequestMapping(value = "/assignee", method = RequestMethod.POST)
    @ResponseBody
    public String addAssignee (@RequestBody AssigneeDto assigneeDto) throws Exception {

        return assigneeService.save(assigneeDto);
    }

    @RequestMapping(value = "/assignee", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteAssignee (@RequestBody String assigneeId) throws Exception {

        return assigneeService.delete(assigneeId);
    }

    @RequestMapping(value = "/assignee", method = RequestMethod.PUT)
    @ResponseBody
    public String editAssignee (@RequestBody AssigneeDto assigneeDto) throws Exception {

        return assigneeService.save(assigneeDto);
    }


}
