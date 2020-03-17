package lotto;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    public void 로또번호와_보너스번호중복시_당첨로또객체생성_예외테스트() {


        assertThatThrownBy(() -> new WinningLotto(new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
                )), 4)
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("보너스 번호와 로또 번호는 중복되면 안됩니다.");

    }

    @Test
    public void 정상적인_당첨로또객체생성_테스트() {
        new WinningLotto(new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        )), 42);
    }
}
