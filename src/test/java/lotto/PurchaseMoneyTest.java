package lotto;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PurchaseMoneyTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    @Test
    public void 천원미만의_로또구입금액_객채생성_예외테스트() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("로또를 구입하기위한 최소금액은 천원입니다.");

        new PurchaseMoney(999);
    }

    @Test
    public void 천원단위가아닌_로또구입금액_객체생성_예외테스트() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("로또 금액은 천원 단위여야만 합니다.");

        new PurchaseMoney(1111);
    }

    @Test
    public void 정상적인_로또구입금액_객체생성_테스트() {
        new PurchaseMoney(1000);
        new PurchaseMoney(14000);
        new PurchaseMoney(5000);
    }

}
