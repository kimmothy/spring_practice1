package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefullServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefullService statefulService1 = ac.getBean(StatefullService.class);
        StatefullService statefulService2 = ac.getBean(StatefullService.class);

        int userAPrice = statefulService1.order("userA", 10000);
        int userBPrice = statefulService2.order("userB", 20000);

        //ThreadA: 사용자A 주문 금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("userAPrice = " + userAPrice);
        System.out.println("userBPrice = " + userBPrice);

        assertThat(userAPrice).isEqualTo(10000);


    }

    static class TestConfig {

        @Bean
        public StatefullService statefullService() {
            return new StatefullService();
        }
    }
}