package com.ssc.bkb.task;

import com.ssc.bkb.manager.BackgroundEventManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * com.ssc.bkb.task
 *
 * @author Lebonheur
 * @version 1.0, 新建
 * @date 17/7/2020 15:23
 */
@Component
public class BackgroundEventTask {

    private static final Logger log = LoggerFactory.getLogger(BackgroundEventTask.class);

    private final BackgroundEventManager backgroundEventManager;

    @Autowired
    public BackgroundEventTask(BackgroundEventManager backgroundEventManager) {
        this.backgroundEventManager = backgroundEventManager;
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void handleEvent() {
        log.debug("handleEvent runs!");
        backgroundEventManager.handleEvent();
    }

}
