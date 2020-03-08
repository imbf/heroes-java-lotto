package lotto;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

public class LottoTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void 일곱개이상의_로또번호를가진_객체생성시_예외테스트() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("로또 번호는 6개로 이루어져야 합니다.");

        new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6), new LottoNumber(7))
        );
    }

    @Test
    public void 중복된_로또번호를가진_객체생성시_예외테스트() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("로또 번호는 중복될 수 없습니다.");

        new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(5))
        );
    }

    @Test
    public void 정상적인_로또객체생성_테스트() {
        new Lotto(Arrays.asList(
                new LottoNumber(45), new LottoNumber(1), new LottoNumber(34),
                new LottoNumber(22), new LottoNumber(17), new LottoNumber(44)
        ));
    }
}
