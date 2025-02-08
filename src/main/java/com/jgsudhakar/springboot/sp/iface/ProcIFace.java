package com.jgsudhakar.springboot.sp.iface;

import com.jgsudhakar.springboot.sp.dto.request.StoredProcInputDto;
import com.jgsudhakar.springboot.sp.dto.response.Response;

/*************************************
 * This interface is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.sp.iface.ProcIFace
 * Date    : 08-02-2025
 * Version : 1.0
 **************************************/
public interface ProcIFace {

    public Response executeProc(StoredProcInputDto storedProcInputDto);
}
