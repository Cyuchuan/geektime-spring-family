package geektime.spring.data.mybatisdemo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@MapperScan("geektime.spring.data.mybatisdemo.mapper")
public class MybatisDemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }


}

