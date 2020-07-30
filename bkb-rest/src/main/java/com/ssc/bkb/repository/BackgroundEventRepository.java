package com.ssc.bkb.repository;

import com.ssc.bkb.entity.BackgroundEvent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * com.ssc.bkb.repository
 *
 * @author Lebonheur
 * @version 1.0, 新建
 * @date 17/7/2020 15:27
 */
@Mapper
@Repository
public interface BackgroundEventRepository {

    /**
     * 获取事件
     *
     * @return 事件集合
     */
    List<BackgroundEvent> getEventList();

    /**
     * 按id集合删除记录
     *
     * @param records id集合
     * @return 删除行数
     */
    int deleteById(List<Integer> records);

    /**
     * 插入单条记录
     *
     * @param event 事件对象
     * @return rows
     */
    int insert(BackgroundEvent event);

    /**
     * 插入备份表
     *
     * @param eventList 事件对象集合
     * @return rows
     */
    int insertToBak(List<BackgroundEvent> eventList);

}
