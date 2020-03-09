package lotto;

import lotto.*;
import org.junit.Before;
import org.junit.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    LottoResult lottoResult;

    @Before
    public void setUp() {
        lottoResult = new LottoResult(new PurchaseMoney(3000));
        lottoResult.getLottoRankResults().get(2).increaseCount(Rank.THIRD);
        lottoResult.getLottoRankResults().get(2).increaseCount(Rank.FOURTH);
        lottoResult.getLottoRankResults().get(2).increaseCount(Rank.FIRST);
    }

    @Test
    public void createRateOfProfit() {
        assertThat(lottoResult.createRateOfProfit()).isEqualTo((double)1500000/3000);
    }

}
