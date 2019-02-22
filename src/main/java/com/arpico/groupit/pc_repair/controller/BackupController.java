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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.arpico.groupit.pc_repair.dto.AssetDto;
import com.arpico.groupit.pc_repair.dto.BackupDto;
import com.arpico.groupit.pc_repair.dto.BackupGridDto;
import com.arpico.groupit.pc_repair.dto.ErrorDto;
import com.arpico.groupit.pc_repair.dto.NameValueDto;
import com.arpico.groupit.pc_repair.dto.RepairDto;
import com.arpico.groupit.pc_repair.service.AssetService;
import com.arpico.groupit.pc_repair.service.BackupService;
import com.arpico.groupit.pc_repair.service.RepairService;
import com.arpico.groupit.pc_repair.util.AppConstant;

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
    	
    	
    	
    	context.setAttribute("path", path);
        ModelAndView mav = new ModelAndView("pages/backup/allbackup");
        mav.addObject("title", "PC REPAIR | ALL BACKUP");

        return mav;

    }
    
    @RequestMapping("/recived_backup")
    public ModelAndView recivedBackup()throws Exception{
    	 
    	context.setAttribute("path", path);
    	ModelAndView mav = new ModelAndView("pages/backup/recivedbackup");
    	mav.addObject("title", "PC REPAIR | RECIVED BACKUPS");
    	 
    	 return mav;
    }
    
    @RequestMapping("/add_backup")
    public ModelAndView addBackup () throws Exception {
    	context.setAttribute("path", path);
    	
    	List<AssetDto> assetDtos = assetService.getAll();
    	List<RepairDto> repairDtos = repairService.getAll();
    	
        ModelAndView mav = new ModelAndView("pages/backup/addbackup");
        mav.addObject("title", "PC REPAIR | ADD BACKUP");
        mav.addObject("assets", assetDtos);
        mav.addObject("repairs", repairDtos);
       
        return mav;

    }
    
    @RequestMapping("/edit_backup/{id}")
    public ModelAndView editBackup(@PathVariable String id)throws Exception{
    	
    	context.setAttribute("path", path);
    	
    	ModelAndView mav = new ModelAndView("pages/backup/editbackup");
    	
		/* BackupDto backupDto = backupService.get(id); */
    	
    	List<AssetDto> assetDtos = assetService.getAll();
    	List<RepairDto> repairDtos = repairService.getAll();
    	
    	mav.addObject("title", "PC REPAIR | EDIT BACKUP");
    	
		mav.addObject("repairs", repairDtos);
    	mav.addObject("assets", assetDtos);
		/*
		 * mav.addObject("remark", backupDto.getRemark()); mav.addObject("handOver",
		 * backupDto.getHandOver()); mav.addObject("sendDate", backupDto.getSendDate());
		 * mav.addObject("returnDate", backupDto.getReturnDate());
		 */
    	
    	
    	return mav;
    }
    
    @RequestMapping("all_backup_recived_dt")
    @ResponseBody
    public Map allBackupRecived()throws Exception{
    	
    	List entity = new ArrayList<>();
    	
    	List<BackupDto> backupDtos = backupService.getRecivedBackup();
    	
    	for (BackupDto backupDto : backupDtos) {
			
    		List entitys = new ArrayList<>();
    		
    		entitys.add(backupDto.getRepairId());
    		
    		entitys.add(backupDto.getAssetId());
    		
    		entitys.add(backupDto.getSendDate());
    		
			entitys.add(backupDto.getReturnDate());
    		
    		entitys.add(backupDto.getRemark());
    		
    		entitys.add(backupDto.getHandOver());
    		
			entity.add(entitys);
    		
    		
		}
    	Map responseMap = new HashMap();
    	responseMap.put("data", entity);
    	
    	return responseMap;
    }
    
    @RequestMapping("/all_backup_dt")
	@ResponseBody
	public Map allBackupDetails() throws Exception {

    	List entities = new ArrayList();

    	List<BackupGridDto> dtos = backupService.getSendBackup();
    	
    	if(dtos != null) {
    		dtos.forEach(e -> {
    			List entity = new ArrayList<>();
    			
    			entity.add(e.getRepairId());
    			entity.add(e.getAssetId());
    			entity.add(e.getSendDate());
    			entity.add(e.getReturnDate());
    			entity.add(e.getRemark());
    			entity.add(e.getHandoverTo());
    			
    			
    			
				/*
				 * entity.add("<button type=\"button\" class=\"btn btn-info\" id=\"" +
				 * e.getBackupId() + "\" onclick = \"editBackup('" + e.getBackupId() +
				 * "')\" ><i class=\"fa fa-edit\" aria-hidden=\"true\"></i>&nbsp;Edit</button>"
				 * );
				 */

				entity.add("<button type=\"button\" class=\"btn btn-success\"  id=\"" + e.getBackupId()
						+ "\" onclick = \"receivedBackup('" + e.getBackupId()
						+ "')\" ><i class=\"fa fa-mail-reply\" aria-hidden=\"true\"></i>&nbsp;Recived</button>");
				
				
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

	@RequestMapping(value = "/backup",method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteBackup(@RequestBody String backupId)throws Exception{
    	return backupService.delete(backupId);
	}

	@RequestMapping(value="/backup",method = RequestMethod.PUT)
	@ResponseBody
	public String editBackup(@RequestBody BackupDto backupDto) throws Exception{
		
		return backupService.editBackup(backupDto);
	}
	@RequestMapping(value="/backup/{id}",method = RequestMethod.GET)
	@ResponseBody
	public String received(@PathVariable String id)throws Exception{
		
		
		return backupService.received(id, AppConstant.SEND_BACK);
		
	}
}
