package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: boot-admin-demo
 * @Description:
 * @date 2022/3/25 14:00
 */
@RestController
@SpringBootApplication
public class AdminClientApplication {

    private Logger log = LoggerFactory.getLogger(AdminClientApplication.class);

    private AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        SpringApplication.run(AdminClientApplication.class, args);
    }

    @GetMapping("hi")
    private String sayHi() {
        // 每次进来如打印下日志
        log.info("{} 啪...我第{}次进来了.", LocalDateTime.now(), count.addAndGet(1));
        // 每次进来new 个大对象，便于监控观察堆内存变化
        byte[] bytes = new byte[100 * 1024 * 1024];
        log.info("new了 100MB");
        return "hi springboot addmin " + LocalDateTime.now();
    }
}
