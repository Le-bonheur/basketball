package com.ssc.bkb.manager;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ssc.bkb.entity.BusinessParam;
import com.ssc.bkb.repository.BusinessParamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 业务参数Manager
 *
 * @author Lebonheur
 * @version 1.0, 新建
 * @date 2/7/2020 15:50
 */
@Component
public class BusinessParamManager {

    private static final Logger log = LoggerFactory.getLogger(BusinessParamManager.class);

    /**
     * 参数映射表，key1=参数类型，key2=参数码，key3=参数值
     */
    private static Map<String, Map<String, List<BusinessParam>>> params = new HashMap<>();

    private BusinessParamRepository businessParamRepository;

    public BusinessParamManager() {}

    @Autowired
    public BusinessParamManager(BusinessParamRepository businessParamRepository) {
        this.businessParamRepository = businessParamRepository;
    }

    /**
     * 刷新所有参数
     */
    public void loadParams() {
        log.debug("开始加载参数...");

        List<BusinessParam> paramList = businessParamRepository.getParamList();
        BusinessParamManager.params = paramList.stream().collect(
                Collectors.groupingBy(BusinessParam::getParamType,
                        Collectors.groupingBy(BusinessParam::getParamCode))
        );

        log.debug(paramList.size() + "条参数加载完成！");
    }

    /**
     * 获取参数码map
     *
     * @param paramType 参数类型
     * @return 参数码Map
     */
    public Map<String, List<BusinessParam>> getParamCodeMap(String paramType) {
        return BusinessParamManager.params.getOrDefault(paramType, Maps.newHashMap());
    }

    /**
     * 获取参数值List
     *
     * @param paramType 参数类型
     * @param paramCode 参数码
     * @return 参数值List
     */
    public List<BusinessParam> getParamValueList(String paramType, String paramCode) {
        return BusinessParamManager.params.getOrDefault(paramType, Maps.newHashMap())
                .getOrDefault(paramCode, Lists.newArrayList());
    }

    /**
     * 参数类型是否存在
     *
     * @param paramType 参数类型
     * @return 是否存在
     */
    public boolean hasParamType(String paramType) {
        return BusinessParamManager.params.containsKey(paramType);
    }

    /**
     * 参数类型+参数码是否存在
     *
     * @param paramType 参数类型
     * @param paramCode 参数码
     * @return 是否存在
     */
    public boolean hasParamTypeAndCode(String paramType, String paramCode) {
        return hasParamType(paramType) && BusinessParamManager.params.get(paramType).containsKey(paramCode);
    }

}
