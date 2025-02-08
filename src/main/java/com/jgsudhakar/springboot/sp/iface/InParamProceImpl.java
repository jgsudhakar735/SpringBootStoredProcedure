package com.jgsudhakar.springboot.sp.iface;

import com.jgsudhakar.springboot.sp.dto.response.Response;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.sp.iface.DefaultAbstractProceImpl
 * Date    : 08-02-2025
 * Version : 1.0
 **************************************/
@Service
@Log4j2
public class InParamProceImpl extends AbstractProcImpl{

    public InParamProceImpl(DataSource dataSource) {
        super(dataSource);
    }

    /**
     * @param output
     * @return
     */
    @Override
    public Response processOutPut(Map<String, Object> output) {
        log.info("Procedure Invoked and processing the Out Data InParamProceImpl");
        if(MapUtils.isNotEmpty(output)) {
            List nick_list = (List) output.get("NICK_LIST");
            if(CollectionUtils.isNotEmpty(nick_list)) {
                nick_list.forEach(data -> {
                    Map<String,Object> details = (Map<String, Object>) data;
                    log.info("Details Are {} :: {} :: {} :: {} ",details.get("NICKNAME_ID"),
                            details.get("NAME"),
                            details.get("REC_CRE_DATE"),
                            details.get("ADDRESS"));
                });

            }
        }
        return new Response(Boolean.TRUE);
    }
}
