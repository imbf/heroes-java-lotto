package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseMoneyTest {

    @Test
    public void 천원미만의_로또구입금액_객채생성_예외테스트() {
        assertThatThrownBy(() -> new PurchaseMoney(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또를 구입하기위한 최소금액은 천원입니다.");
    }

    @Test
    public void 천원단위가아닌_로또구입금액_객체생성_예외테스트() {
        assertThatThrownBy(() -> new PurchaseMoney(1111))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 금액은 천원 단위여야만 합니다.");

    }

    @Test
    public void 정상적인_로또구입금액_객체생성_테스트() {
        new PurchaseMoney(1000);
        new PurchaseMoney(14000);
        new PurchaseMoney(5000);
    }

}
