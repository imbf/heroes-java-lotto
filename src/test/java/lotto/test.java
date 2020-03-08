package lotto;

import org.junit.Test;

import java.util.Arrays;

public class test {

    @Test
    public void test() {
        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(45), new LottoNumber(1), new LottoNumber(34),
                new LottoNumber(22), new LottoNumber(17), new LottoNumber(44)
        ));
        System.out.println(lotto.getLottoNumbers().contains(45));
    }
}
