package com.ssc.bkb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * BusinessParam
 *
 * @author Lebonheur
 * @date 3/7/2020 09:59
 * @version 1.0,新建
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessParam {

    private String paramType;

    private String paramCode;

    private String paramValue;

    private String manageUser;

    private Date createTime;

    private Date updateTime;
}