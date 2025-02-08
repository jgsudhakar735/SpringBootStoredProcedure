package com.jgsudhakar.springboot.sp.resource;

import com.jgsudhakar.springboot.sp.service.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.sp.resource.InvokeSPResource
 * Date    : 08-02-2025
 * Version : 1.0
 **************************************/
@RestController
@RequestMapping("api/sp")
public class InvokeSPResource {

    @Autowired
    private ProcedureService procedureService;

    @GetMapping
    public void getEmpList() {
      procedureService.getEmpData();
    }

}
