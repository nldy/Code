package com.dc.sec_kill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dc.sec_kill.dao")
public class SecKillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecKillApplication.class, args);
    }

}
