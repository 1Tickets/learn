package com.jiaxi.tickets.starter;

import com.jiaxi.tickets.common.feign.annotation.EnableTicketsFeignClients;
import com.jiaxi.tickets.common.security.annotation.EnableTicketsResourceServer;
import com.jiaxi.tickets.common.swagger.annotation.EnableTicketsSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
* @author pig archetype
* <p>
* 项目启动类
*/
@EnableTicketsSwagger2
@EnableTicketsFeignClients
@EnableTicketsResourceServer
@EnableDiscoveryClient
@SpringBootApplication
public class StarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarterApplication.class, args);
    }

}
