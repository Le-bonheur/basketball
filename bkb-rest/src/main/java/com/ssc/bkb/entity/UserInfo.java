package com.ssc.bkb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * com.ssc.bkb.entity.UserInfo
 *
 * @author Lebonheur
 * @version 1.0, 新建
 * @date 2/7/2020 15:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserInfo {

     @Id
     @GeneratedValue
     private Long userId;

     private String openId;

     private String nickName;

     private String avatarUrl;

     private int gender;

     private String language;

     private String country;

     private String province;

     private String city;

     private int version;

     private Date createTime;

     private Date updateTime;

}
