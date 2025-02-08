package com.jgsudhakar.springboot.sp.service.impl;

import com.jgsudhakar.springboot.sp.dto.request.StoredProcInputDto;
import com.jgsudhakar.springboot.sp.dto.response.Response;
import com.jgsudhakar.springboot.sp.iface.ProcIFace;
import com.jgsudhakar.springboot.sp.service.ProcedureService;
import org.springframework.stereotype.Service;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.sp.service.impl.ProcedureServiceImpl
 * Date    : 08-02-2025
 * Version : 1.0
 **************************************/
@Service
public class ProcedureServiceImpl implements ProcedureService {

    private final ProcIFace procIFace;

    public ProcedureServiceImpl(ProcIFace procIFace) {
        this.procIFace = procIFace;
    }

    /**
     * @return Response
     */
    @Override
    public Response getEmpData() {
        StoredProcInputDto storedProcInputDto = new StoredProcInputDto();
        storedProcInputDto.setProcName("NICK_NAME_PROC");
        return procIFace.executeProc(storedProcInputDto);
    }
}
