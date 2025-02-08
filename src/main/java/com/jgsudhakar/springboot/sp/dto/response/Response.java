package com.jgsudhakar.springboot.sp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.sp.dto.response.Response
 * Date    : 08-02-2025
 * Version : 1.0
 **************************************/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response implements Serializable {

    private Boolean status= Boolean.FALSE;

    private String remarks;

    public Response(Boolean status) {
        this.status = status;
    }
}
