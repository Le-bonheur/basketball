package com.ssc.bkb.config;

import com.ssc.bkb.entity.Basketball;
import com.ssc.bkb.repository.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * LoadDatabase
 *
 * @author Lebonheur
 * @date 1/7/2020 15:48
 * @version 1.0,新建
 */
@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    public CommandLineRunner initDatabaseB(UserInfoRepository repository) {
        System.out.println("UserInfoRepository initial");
        return args -> {
            log.info("Preloading " + repository.save(new Basketball("Lebonheur", "Power Forward")));
            log.info("Preloading " + repository.save(new Basketball("Kobe Bryant", "Shooting guard")));
        };
    }
}
