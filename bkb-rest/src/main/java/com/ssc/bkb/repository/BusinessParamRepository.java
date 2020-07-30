package com.ssc.bkb.repository;


import com.ssc.bkb.entity.BusinessParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 参数加载Dao
 *
 * @author Lebonheur
 * @date 3/7/2020 09:28
 * @version 1.0,新建
 */
@Mapper
@Repository
public interface BusinessParamRepository {

    /**
     * 获取参数列表
     *
     * @return 参数列表
     */
    List<BusinessParam> getParamList();

    int insert(BusinessParam record);

    int insertSelective(BusinessParam record);
}