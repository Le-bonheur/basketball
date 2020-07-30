package com.ssc.bkb.manager;

import com.ssc.bkb.entity.BackgroundEvent;
import com.ssc.bkb.repository.BackgroundEventRepository;
import com.ssc.bkb.task.LoadParamTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * com.ssc.bkb.manager
 *
 * @author Lebonheur
 * @version 1.0, 新建
 * @date 17/7/2020 15:26
 */
@Component
public class BackgroundEventManager {

    private final BackgroundEventRepository backgroundEventRepository;

    private final LoadParamTask loadParamTask;

    @Autowired
    public BackgroundEventManager(BackgroundEventRepository backgroundEventRepository, LoadParamTask loadParamTask) {
        this.backgroundEventRepository = backgroundEventRepository;
        this.loadParamTask = loadParamTask;
    }

    /**
     * 处理事件
     */
    @Transactional(rollbackFor = Exception.class)
    public void handleEvent() {
        List<BackgroundEvent> eventList = backgroundEventRepository.getEventList()
                .stream().peek(this::execute).collect(Collectors.toList());
        if (eventList.isEmpty()) {
            return;
        }
        backgroundEventRepository.insertToBak(eventList);
        List<Integer> eventIdList = eventList.stream()
                .map(BackgroundEvent::getEventId).collect(Collectors.toList());
        backgroundEventRepository.deleteById(eventIdList);
    }

    /**
     * 根据事件类型处理事件
     *
     * @param event 事件
     */
    private void execute(BackgroundEvent event) {
        switch (event.getEventType()) {
            case "params" :
                loadParamTask.downloadParams();
            default:
        }
    }

}
