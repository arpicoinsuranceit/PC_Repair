package com.arpico.groupit.pc_repair.controller;

import com.arpico.groupit.pc_repair.dto.SupplierDto;
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
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @RequestMapping("/all_supplier")
    public ModelAndView manageSupplier () throws Exception {
        ModelAndView mav = new ModelAndView("pages/supplier/managesupplier");
        mav.addObject("title", "PC REPAIR | MANAGE SUPPLIER");

        return mav;

    }

    @RequestMapping("/add_supplier")
    public ModelAndView addSupplier () throws Exception {
        ModelAndView mav = new ModelAndView("pages/supplier/addsupplier");
        mav.addObject("title", "PC REPAIR | ADD SUPPLIER");

        return mav;

    }

    @RequestMapping("/edit_supplier/{id}")
    public ModelAndView editSupplier (@PathVariable String id) throws Exception {

        SupplierDto supplierDto = supplierService.get(id);

        ModelAndView mav = new ModelAndView("pages/supplier/editsupplier");
        mav.addObject("title", "PC REPAIR | EDIT SUPPLIER");
        mav.addObject("sup_id",supplierDto.getSupplierId());
        mav.addObject("sup_name",supplierDto.getSupplierName());

        return mav;

    }

    @RequestMapping("/all_supplier_dt")
    @ResponseBody
    public Map allsupplierDetails() throws Exception{

        List entities = new ArrayList();

        List<SupplierDto> supplierDtos = supplierService.getAll();

        for (SupplierDto supplierDto : supplierDtos){
            List entity = new ArrayList<>();

            entity.add(supplierDto.getSupplierId());
            entity.add(supplierDto.getSupplierName());
            entity.add("<button type=\"button\" class=\"btn btn-default\" id=\"" + supplierDto.getSupplierId()
                    + "\" onclick = \"editSupplier('"+ supplierDto.getSupplierId() +"')\" ><i class=\"fa fa-edit\" aria-hidden=\"true\"></i><span>&nbsp;&nbsp;EDIT</span></button>");
          /*  entity.add("<button type=\"button\" class=\"btn btn-default\" id=\"" + supplierDto.getSupplierId()
                    + "\" onclick = \"deleteSupplier('"+ supplierDto.getSupplierId() +"')\" ><i class=\"fa fa-trash\" aria-hidden=\"true\"></i><span>&nbsp;&nbsp;DELETE</span></button>");*/

            entities.add(entity);
        }

        Map responseMap = new HashMap();
        responseMap.put("data", entities);
        return responseMap;
    }

    @RequestMapping(value = "/supplier", method = RequestMethod.POST)
    @ResponseBody
    public String addSupplier (@RequestBody SupplierDto supplierDto) throws Exception {

        System.out.println(supplierDto.getSupplierId());
        System.out.println(supplierDto.getSupplierName());


        return supplierService.save(supplierDto);
    }

    @RequestMapping(value = "/supplier", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteSupplier (@RequestBody String supplierId) throws Exception {

        System.out.println(supplierId);

        return supplierService.delete(supplierId);
    }

    @RequestMapping(value = "/supplier", method = RequestMethod.PUT)
    @ResponseBody
    public String updateSupplier (@RequestBody SupplierDto supplierDto) throws Exception {

        return supplierService.save(supplierDto);
    }
}
