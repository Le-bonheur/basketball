package com.ssc.bkb.service;

import com.ssc.bkb.entity.UserInfo;
import com.ssc.bkb.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * com.ssc.bkb.service
 *
 * @author Lebonheur
 * @version 1.0, 新建
 * @date 31/7/2020 17:25
 */
@Service
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;

    @Autowired
    public UserInfoService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public String getOpenId() {
        return null; //TODO
    }

}
