package util;

import lotto.Lotto;
import lotto.LottoNumber;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringConverterTest {

    private static final int LOTTO_NUMBER_SIZE = 6;

    @Test
    public void convertStringToLottosTest() {
        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(8, 21, 23, 41, 42, 43),
                Arrays.asList(3, 5, 11, 16, 32, 38));

        List<String> strings = Arrays.asList("8, 21, 23, 41, 42, 43", "3, 5, 11, 16, 32, 38");
        List<Lotto> lottos = StringConverter.convertStringsToLottos(strings);

        for (int i = 0; i < lottos.size(); i++) {
            for (int j = 0; j < LOTTO_NUMBER_SIZE; j++) {
                Lotto lotto = lottos.get(i);
                LottoNumber lottoNumbers = lotto.getLottoNumbers().get(j);

                assertThat(lottoNumbers.getNumber()).isEqualTo(lists.get(i).get(j));
            }
        }
    }
}
