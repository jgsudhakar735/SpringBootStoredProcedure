package com.jgsudhakar.springboot.sp.service.impl;

import com.jgsudhakar.springboot.sp.dto.request.StoredProcInputDto;
import com.jgsudhakar.springboot.sp.dto.response.Response;
import com.jgsudhakar.springboot.sp.iface.ProcIFace;
import com.jgsudhakar.springboot.sp.service.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.sp.service.impl.ProcedureServiceImpl
 * Date    : 08-02-2025
 * Version : 1.0
 **************************************/
@Service
public class ProcedureServiceImpl implements ProcedureService {

    @Autowired
    private ProcIFace defaultAbstractProceImpl;

    @Autowired
    private ProcIFace inParamProceImpl;


    /**
     * @return Response
     */
    @Override
    public Response getEmpData() {
        StoredProcInputDto storedProcInputDto = new StoredProcInputDto();
        storedProcInputDto.setProcName("NICK_NAME_PROC");
        storedProcInputDto.setSchemaName("LEARNING");
        return defaultAbstractProceImpl.executeProc(storedProcInputDto);
    }

    @Override
    public Response getEmpById(Long id) {
        StoredProcInputDto storedProcInputDto = new StoredProcInputDto();
        storedProcInputDto.setProcName("NICK_NAME_PROC_IN");
        storedProcInputDto.setSchemaName("LEARNING");
        Map<String,Object> inParams = new HashMap<>();
        inParams.put("NICK_ID", id.intValue());
        storedProcInputDto.setInParams(inParams);
        return inParamProceImpl.executeProc(storedProcInputDto);
    }
}
