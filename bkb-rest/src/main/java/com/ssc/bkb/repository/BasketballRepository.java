package com.ssc.bkb.repository;

import com.ssc.bkb.entity.Basketball;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketballRepository extends JpaRepository<Basketball, Long> {

    int updateUserInfoByOpenId(String openId);

}
