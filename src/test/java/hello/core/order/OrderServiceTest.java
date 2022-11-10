package hello.core.order;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig config = new AppConfig();
        memberService = config.memberService();
        orderService = config.orderService();
    }

    @Test
    void discount(){
        Member member = new Member(1L, "chan", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(1L, "gunpra", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }


}
