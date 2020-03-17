package lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    LottoMachine lottoMachine;

    @Before
    public void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    public void 자동생성로또_숫자범위테스트() {
        List<Lotto> lottos = lottoMachine.createAutoLottos(100);

        for (Lotto lotto : lottos) {
            for (int index = 0; index < lotto.getLottoNumbers().size(); index++) {
                assertThat(lotto.getLottoNumbers().get(index).getNumber())
                        .isLessThanOrEqualTo(45)
                        .isGreaterThanOrEqualTo(1);
            }
        }
    }

    @Test
    public void 자동생성로또_개수테스트() {
        List<Lotto> lottos = lottoMachine.createAutoLottos(3);

        assertThat(lottos.size()).isEqualTo(3);
    }

    @Test
    public void 수동생성로또_테스트() {
        List<Lotto> lottos = lottoMachine.createManualLottos(Arrays.asList("1,2,3,4,5,6", "7,8,9,10,11,12"));
        List<List<Integer>> lists = new ArrayList<>(Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(7, 8, 9, 10, 11, 12)));

        for (int i = 0; i < lottos.size(); i++) {
            List<LottoNumber> lottoNumbers = lottos.get(i).getLottoNumbers();
            List<Integer> integers = lists.get(i);

            for (int j = 0; j < lottoNumbers.size(); j++) {
                assertThat(lottoNumbers.get(j).getNumber()).isEqualTo(integers.get(j));
            }
        }
    }
}
