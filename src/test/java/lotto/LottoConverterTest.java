package lotto;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoConverterTest {

    @Test
    public void convertLottoToIntegersTest() {

        List<Integer> integers = Arrays.asList(45,1,34,22,17,44);

        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(45), new LottoNumber(1), new LottoNumber(34),
                new LottoNumber(22), new LottoNumber(17), new LottoNumber(44)
        ));
        assertThat(LottoConverter.convertLottoToIntegers(lotto).containsAll(integers)).isEqualTo(true);
    }


}
