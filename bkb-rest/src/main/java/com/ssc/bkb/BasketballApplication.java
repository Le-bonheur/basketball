package com.ssc.bkb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@MapperScan("mapper")
public class BasketballApplication {

	public static void main(String... args) {
		SpringApplication.run(BasketballApplication.class, args);
	}
}
