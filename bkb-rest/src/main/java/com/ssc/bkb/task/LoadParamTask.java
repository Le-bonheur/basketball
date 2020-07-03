package com.ssc.bkb.task;

import com.ssc.bkb.manager.ParamDownloadManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 加载参数到内存
 *
 * @author Lebonheur
 * @version 1.0, 新建
 * @date 2/7/2020 15:39
 */
@Component
public class LoadParamTask {

    private static final Logger log = LoggerFactory.getLogger(LoadParamTask.class);

    private ParamDownloadManager paramDownloadManager;

    @Autowired
    public LoadParamTask(ParamDownloadManager paramDownloadManager) {
        this.paramDownloadManager = paramDownloadManager;
    }

    @Scheduled(cron = "0 0 1 * * ?")
    public void downloadParams() {
        log.debug("开始下载参数");
        paramDownloadManager.downloadParams();
        log.debug("参数下载完成");
    }

}
