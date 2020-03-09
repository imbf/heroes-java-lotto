package lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoGeneratorTest {

    AutoLottoGenerator autoLottoGenerator;

    @Before
    public void setUp() {
        autoLottoGenerator = new AutoLottoGenerator();
    }

    @Test
    public void AutoLottoGenerator클래스_로또객체생성_테스트() {
        List<Lotto> lottos = autoLottoGenerator.createLottos(3);
        assertThat(lottos.size()).isEqualTo(3);
    }
}
