package com.leda;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.leda.**.mapper")
public class LedaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LedaBackendApplication.class, args);
    }

}
