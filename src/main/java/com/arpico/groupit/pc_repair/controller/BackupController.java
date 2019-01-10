package com.arpico.groupit.pc_repair.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.arpico.groupit.pc_repair.dto.AssetDto;
import com.arpico.groupit.pc_repair.dto.BackupDto;
import com.arpico.groupit.pc_repair.dto.BackupGridDto;
import com.arpico.groupit.pc_repair.dto.ErrorDto;
import com.arpico.groupit.pc_repair.dto.RepairDto;
import com.arpico.groupit.pc_repair.service.AssetService;
import com.arpico.groupit.pc_repair.service.BackupService;
import com.arpico.groupit.pc_repair.service.RepairService;

@Controller
@PropertySource("classpath:application.properties")
public class BackupController {
	

    @Value("${server.context-path}")
	private String path;
    
    @Autowired
	private ServletContext context;
    
    @Autowired
   	private AssetService assetService;  
   	
    @Autowired
    private BackupService backupService;
    
    @Autowired
    private RepairService repairService;
    
    @RequestMapping("/all_backup")
    public ModelAndView allBackup () throws Exception {
    	
    	System.out.println("AllBackups");
    	
    	context.setAttribute("path", path);
        ModelAndView mav = new ModelAndView("pages/backup/allbackup");
        mav.addObject("title", "PC REPAIR | ALL BACKUP");

        return mav;

    }
    
    @RequestMapping("/add_backup")
    public ModelAndView addBackup () throws Exception {
    	context.setAttribute("path", path);
    	
    	List<AssetDto> assetDtos = assetService.getAll();
    	List<RepairDto> repairDtos = repairService.getRepairForDashboard();
    	
    	
        ModelAndView mav = new ModelAndView("pages/backup/addbackup");
        mav.addObject("title", "PC REPAIR | ADD BACKUP");
        mav.addObject("assets", assetDtos);
        mav.addObject("repairs", repairDtos);
        
        return mav;

    }
    
    @RequestMapping("/all_backup_dt")
	@ResponseBody
	public Map allBackupDetails() throws Exception {

    	List entities = new ArrayList();

    	List<BackupGridDto> dtos = backupService.getAll();
    	
    	if(dtos != null) {
    		dtos.forEach(e -> {
    			List entity = new ArrayList<>();
    			
    			entity.add(e.getRepairId());
    			entity.add(e.getAssetId());
    			entity.add(e.getSendDate());
    			entity.add(e.getReturnDate());
    			entity.add(e.getRemark());
    			entity.add(e.getHandoverTo());
    			
    			entity.add("<button type=\"button\" class=\"btn btn-default\" id=\"" + e.getBackupId()
				+ "\" onclick = \"editBackup('" + e.getBackupId()
				+ "')\" ><i class=\"fa fa-edit\" aria-hidden=\"true\"></i></button>");
    			
    			entities.add(entity);
    		});
    	}
    	
    	Map responseMap = new HashMap();
		responseMap.put("data", entities);
		return responseMap;
    }

    @RequestMapping(value = "/backup", method = RequestMethod.POST)
	@ResponseBody
	public String addError(@RequestBody BackupDto backupDto) throws Exception {

    	
    	
		return backupService.save(backupDto);
		
	}
	
}
