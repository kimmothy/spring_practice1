package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;

import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = orderService.getMemberRepository();
        System.out.println("memberRepository = " + memberRepository);
    }

    @Test
    void policyScan() {

//        Assertions.assertThrows(UnsatisfiedDependencyException.class, () -> new AnnotationConfigApplicationContext(AutoAppConfig.class));
//        assertThat(memberService).isInstanceOf(DiscountPolicy.class);
//        assertThat(memberService).isInstanceOf(FixDiscountPolicy.class);
//        assertThat(memberService).isInstanceOf(RateDiscountPolicy.class);
    }
}
