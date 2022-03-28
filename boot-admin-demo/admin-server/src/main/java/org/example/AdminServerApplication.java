package org.example;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: boot-admin-demo
 * @Description:
 * @date 2022/3/25 12:58
 */
@EnableAdminServer // 开启 springboot admin 服务端
@SpringBootApplication
public class AdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServerApplication.class, args);
    }
}
