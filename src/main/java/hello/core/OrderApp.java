package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig config = new AppConfig();
//        MemberService memberService = config.memberService();
//
//        OrderService orderService = config.orderService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        DiscountPolicy discountPolicy = new FixDiscountPolicy();

        int itemPrice = 20000;

        Order order = orderService.createOrder(memberId, "mamratang_milkit", itemPrice);
        System.out.println("order = " + order.toString());
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
        System.out.println("itemPrice = " + itemPrice);

    }
}
