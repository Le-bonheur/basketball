package com.ssc.bkb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

/**
 * BackgroundEventEntity
 *
 * @author Lebonheur
 * @version 1.0, 新建
 * @date 17/7/2020 15:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BackgroundEvent {

    /**
     * 事件ID
     */
    private int eventId;

    /**
     * 事件类型
     */
    private String eventType;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Timestamp createTime;

}
