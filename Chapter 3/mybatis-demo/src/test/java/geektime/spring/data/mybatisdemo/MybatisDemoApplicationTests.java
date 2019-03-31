package geektime.spring.data.mybatisdemo;

import geektime.spring.data.mybatisdemo.mapper.CoffeeMapper;
import geektime.spring.data.mybatisdemo.model.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("classpath:schemaq.sql")
@Slf4j
public class MybatisDemoApplicationTests {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private CoffeeMapper coffeeMapper;

    @Test
    public void contextLoads() {
        DataSource bean = applicationContext.getBean(DataSource.class);

        Coffee c = Coffee.builder().name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0)).build();
        Long id = coffeeMapper.save(c);
        log.info("Coffee {} => {}", id, c);

        c = coffeeMapper.findById(id);
        log.info("Coffee {}", c);
    }

}

