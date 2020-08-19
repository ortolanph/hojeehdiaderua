package org.hojeehdiaderua;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class HojeEhDiaDeRuaApplication {

    public static void main(String[] args) {
        log.info("HOJE EH DIA DE RUA!");
        SpringApplication.run(HojeEhDiaDeRuaApplication.class, args);
    }

}
