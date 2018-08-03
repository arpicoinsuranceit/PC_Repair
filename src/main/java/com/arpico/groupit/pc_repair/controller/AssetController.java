package com.arpico.groupit.pc_repair.controller;

import com.arpico.groupit.pc_repair.dto.AssetDto;
import com.arpico.groupit.pc_repair.dto.NameValueDto;
import com.arpico.groupit.pc_repair.service.AssetService;
import com.arpico.groupit.pc_repair.service.LocationService;
import com.arpico.groupit.pc_repair.service.OperatingSystemService;
import com.arpico.groupit.pc_repair.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AssetController {

    @Autowired
    private AssetService assetService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private LocationService locationService;
    
    @Autowired
    private OperatingSystemService operatingSystemService;
    
    @RequestMapping("/all_assets")
    public ModelAndView manageAsset () throws Exception {
        ModelAndView mav = new ModelAndView("pages/asset/manageasset");
        mav.addObject("title", "PC REPAIR | MANAGE ASSETS");

        return mav;

    }

    @RequestMapping("/edit_asset/{id}")
    public ModelAndView editAsset (@PathVariable String id) throws Exception {

        AssetDto assetDto = assetService.get(id);
        List<NameValueDto> suppliers = supplierService.getAllNameValue();
        List<NameValueDto> locations = locationService.getAllNameValue();
        List<NameValueDto> osList = operatingSystemService.getAllNameValue();
        
        ModelAndView mav = new ModelAndView("pages/asset/editasset");
        
        
        mav.addObject("title", "PC REPAIR | EDIT ASSET");
        mav.addObject("asset_id",assetDto.getAssetId());
        mav.addObject("description",assetDto.getDescription());
        mav.addObject("sup_id" , assetDto.getSupplier());
        mav.addObject("location", assetDto.getLocation());
        mav.addObject("serial_no", assetDto.getSerialNo());
        mav.addObject("ip", assetDto.getIpAddress());
        mav.addObject("os", assetDto.getOs());
        mav.addObject("value", assetDto.getValue());
        mav.addObject("purchase_date", assetDto.getPurchaseDate());
        mav.addObject("remark", assetDto.getRemark());
        mav.addObject("warranty", assetDto.getWarranty());
        mav.addObject("warrantyExp", assetDto.getWarrantyExp());
        mav.addObject("suppliers", suppliers);
        mav.addObject("locations", locations);
        mav.addObject("osList", osList);
        return mav;

    }
    @RequestMapping("/add_asset")
    public ModelAndView addAsset () throws Exception {
        ModelAndView mav = new ModelAndView("pages/asset/addasset");

        List<NameValueDto> suppliers = supplierService.getAllNameValue();
        List<NameValueDto> locations = locationService.getAllNameValue();
        List<NameValueDto> osList = operatingSystemService.getAllNameValue();
        
        locations.forEach(System.out::println);
        
        mav.addObject("title", "PC REPAIR | ADD ASSET");
        mav.addObject("suppliers", suppliers);
        mav.addObject("locations", locations);
        mav.addObject("osList", osList);

        return mav;

    }

    @RequestMapping("/all_assets_dt")
    @ResponseBody
    public Map allAssetDetails() throws Exception{

        List entities = new ArrayList();

        List<AssetDto> assetDtos = assetService.getAll();

        if(assetDtos != null) {
            for (AssetDto assetDto : assetDtos) {
                List entity = new ArrayList<>();

                entity.add(assetDto.getAssetId());
                entity.add(assetDto.getDescription());
                entity.add(assetDto.getValue());
                entity.add(assetDto.getIpAddress());
                entity.add(assetDto.getOs());
                entity.add(assetDto.getSerialNo());
                entity.add(assetDto.getRemark());
                entity.add(assetDto.getPurchaseDate());
                entity.add(assetDto.getWarranty());
                entity.add(assetDto.getSupplier());

                entity.add("<button type=\"button\" class=\"btn btn-default\" id=\"" + assetDto.getAssetId()
                        + "\" onclick = \"editAsset('" + assetDto.getAssetId() + "')\" ><i class=\"fa fa-edit\" aria-hidden=\"true\"></i></button>");
                /*entity.add("<button type=\"button\" class=\"btn btn-default\" id=\"" + assetDto.getAssetId()
                        + "\" onclick = \"deleteAsset('" + assetDto.getAssetId() + "')\" ><i class=\"fa fa-trash\" aria-hidden=\"true\"></i></button>");*/

                entities.add(entity);
            }
        }

        Map responseMap = new HashMap();
        responseMap.put("data", entities);
        return responseMap;
    }

    @RequestMapping(value = "/asset", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteAsset (@RequestBody String assetId) throws Exception {
        System.out.println(assetId);
        return assetService.delete(assetId);
    }

    @RequestMapping(value = "/asset", method = RequestMethod.POST)
    @ResponseBody
    public String addAsset (@RequestBody AssetDto assetDto) throws Exception {
        return assetService.save(assetDto);
    }

    @RequestMapping(value = "/asset", method = RequestMethod.PUT)
    @ResponseBody
    public String editAsset (@RequestBody AssetDto assetDto) throws Exception {
        return assetService.save(assetDto);
    }

}
