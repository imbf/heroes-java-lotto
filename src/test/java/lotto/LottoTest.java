package lotto;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    public void 일곱개이상의_로또번호를가진_객체생성시_예외테스트() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6), new LottoNumber(7)))
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("로또 번호는 6개로 이루어져야 합니다.");
    }

    @Test
    public void 중복된_로또번호를가진_객체생성시_예외테스트() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(5)))
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("로또 번호는 중복될 수 없습니다.");
    }

    @Test
    public void 정상적인_로또객체생성_테스트() {
        new Lotto(Arrays.asList(
                new LottoNumber(45), new LottoNumber(1), new LottoNumber(34),
                new LottoNumber(22), new LottoNumber(17), new LottoNumber(44)
        ));
    }
}
