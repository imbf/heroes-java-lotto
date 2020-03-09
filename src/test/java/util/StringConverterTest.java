package util;

import lotto.Lotto;
import lotto.LottoNumber;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringConverterTest {

    @Test
    public void convertStringToLottosTest() {
        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(8, 21, 23, 41, 42, 43),
                Arrays.asList(3, 5, 11, 16, 32, 38));

        List<String> strings = Arrays.asList("8, 21, 23, 41, 42, 43", "3, 5, 11, 16, 32, 38");
        List<Lotto> lottos = StringConverter.convertStringsToLottos(strings);

        for (int index = 0; index < lottos.size(); index++) {
            Lotto lotto = lottos.get(index);
            lottoNumbersTest(lotto.getLottoNumbers(), lists.get(index));
        }
    }

    private void lottoNumbersTest(List<LottoNumber> lottoNumbers, List<Integer> integers) {
        for (int index = 0; index < lottoNumbers.size(); index++) {
            LottoNumber lottoNumber = lottoNumbers.get(index);
            assertThat(lottoNumber.getNumber()).isEqualTo(integers.get(index));
        }
    }
}
