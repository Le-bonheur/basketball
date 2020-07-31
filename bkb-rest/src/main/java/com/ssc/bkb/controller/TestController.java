package com.ssc.bkb.controller;

import com.ssc.bkb.entity.BusinessParam;
import com.ssc.bkb.manager.BusinessParamManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * com.ssc.bkb.controller
 *
 * @author Lebonheur
 * @version 1.0, 新建
 * @date 30/7/2020 17:19
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private final BusinessParamManager businessParamManager;

    @Autowired
    public TestController(BusinessParamManager businessParamManager) {
        this.businessParamManager = businessParamManager;
    }

    @GetMapping("/param")
    public Map<String, List<BusinessParam>> getParam() {
        return businessParamManager.getParamCodeMap("wxconfig");
    }

    @GetMapping("/request")
    public Map<String, List<BusinessParam>> getRequest() throws IOException, ServletException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            System.out.println(attributes.getRequest().getRequestURI());
            System.out.println(attributes.getRequest().getRemoteAddr());
        }
        System.out.println(attributes);
        return businessParamManager.getParamCodeMap("wxconfig");
    }

}
