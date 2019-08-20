package org.hojeehdiaderua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.logging.Logger;

@SpringBootApplication
@EnableAutoConfiguration
public class HojeEhDiaDeRua {

    private static final Logger LOGGER = Logger.getLogger(HojeEhDiaDeRua.class.getName());

    public static void main(String[] args) {
        LOGGER.fine("Hoje é dia de Rua! is running!");
        ApplicationContext ctx = SpringApplication.run(HojeEhDiaDeRua.class, args);
    }

}
