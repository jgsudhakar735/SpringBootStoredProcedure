package com.jgsudhakar.springboot.sp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.sp.dto.request.StoredProcInputDto
 * Date    : 08-02-2025
 * Version : 1.0
 **************************************/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoredProcInputDto implements Serializable {

    private String procName;

    private String schemaName;

    private Map<String, Object> inParams;

}
