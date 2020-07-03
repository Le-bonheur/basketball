package com.ssc.bkb.manager;

import com.ssc.bkb.entity.BusinessParam;
import com.ssc.bkb.repository.BusinessParamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 刷新业务参数Manager
 *
 * @author Lebonheur
 * @version 1.0, 新建
 * @date 2/7/2020 15:50
 */
@Component
public class ParamDownloadManager {

    private BusinessParamRepository businessParamRepository;

    @Autowired
    public ParamDownloadManager(BusinessParamRepository businessParamRepository) {
        this.businessParamRepository = businessParamRepository;
    }

    /**
     * 刷新所有参数
     */
    public void downloadParams() {
        List<BusinessParam> paramList = businessParamRepository.getParamList();

    }



}
