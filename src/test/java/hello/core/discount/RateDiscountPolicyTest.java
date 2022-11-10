package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%의 할이니 적용되어야 한다.")
    void vip_o() {
        //given
        Member member = new Member(1L, "chan", Grade.VIP);

        //when
        int discountPrice = discountPolicy.discount(member, 10001);

        //then
        assertThat(discountPrice).isEqualTo(1000);
    }
    @Test
    @DisplayName("VIP가 아니면 안돼")
    void vip_x() {
        //given
        Member member = new Member(2L, "chan", Grade.BASIC);

        //when
        int discountPrice = discountPolicy.discount(member, 10001);

        //then
        assertThat(discountPrice).isEqualTo(0);
    }
}