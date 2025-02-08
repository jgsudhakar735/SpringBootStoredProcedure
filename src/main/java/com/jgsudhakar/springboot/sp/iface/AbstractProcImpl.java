package com.jgsudhakar.springboot.sp.iface;

import com.jgsudhakar.springboot.sp.dto.request.StoredProcInputDto;
import com.jgsudhakar.springboot.sp.dto.response.Response;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import javax.sql.DataSource;
import java.util.Map;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.sp.iface.AbstractProcImpl
 * Date    : 08-02-2025
 * Version : 1.0
 **************************************/
@Log4j2
public abstract class AbstractProcImpl implements ProcIFace{

    private DataSource dataSource;

    public AbstractProcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Response executeProc(StoredProcInputDto storedProcInputDto) {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.dataSource);
            simpleJdbcCall.withProcedureName(storedProcInputDto.getProcName());
            simpleJdbcCall.compile();
            log.info("Procedure Compiled Successfully");
            Map<String, Object> execute = simpleJdbcCall.withSchemaName("LEARNING").execute();

            return processOutPut(execute);
        }catch (Exception exception) {
            log.info("Exception ::{} ", exception.getLocalizedMessage());
            return  new Response(Boolean.FALSE);
        }
    }

    public abstract Response processOutPut(Map<String, Object> output);
}
