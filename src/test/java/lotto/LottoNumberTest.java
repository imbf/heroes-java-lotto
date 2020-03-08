package lotto;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class LottoNumberTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void 범위에_맞지않는_로또번호_객체생성_예외테스트() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("로또 번호는 1이상 45이하의 자연수만 가능합니다.");
        new LottoNumber(46);
        new LottoNumber(-1);
    }

    @Test
    public void 범위에_맞는_로또번호_객체생성_테스트() {
        new LottoNumber(1);
        new LottoNumber(45);
    }
}
