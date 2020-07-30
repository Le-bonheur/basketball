package com.ssc.bkb.repository;

import com.ssc.bkb.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface UserInfoRepository {

    /**
     * 通过openId更新用户基本信息
     *
     * @param openId openId
     * @return 更新行数
     */
    int updateUserInfoByOpenId(String openId);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    Optional<UserInfo> selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    List<UserInfo> getAllUser();

}
