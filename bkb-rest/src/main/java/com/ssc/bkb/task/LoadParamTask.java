package com.ssc.bkb.task;

import com.ssc.bkb.manager.BusinessParamManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 加载参数到内存
 * 定时任务--每天凌晨1点执行
 *
 * @author Lebonheur
 * @version 1.0, 新建
 * @date 2/7/2020 15:39
 */
@Component
public class LoadParamTask {

    private static final Logger log = LoggerFactory.getLogger(LoadParamTask.class);

    private BusinessParamManager businessParamManager;

    @Autowired
    public LoadParamTask(BusinessParamManager businessParamManager) {
        this.businessParamManager = businessParamManager;
    }

    @Scheduled(cron = "0 0 1 * * ?")
    public void downloadParams() {
        log.debug("开始刷新参数");
        businessParamManager.downloadParams();
        log.debug("刷新参数完成");
    }

}
