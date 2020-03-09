package lotto;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankResultTest {
    LottoRankResult lottoRankResult;

    @Before
    public void setUp() {
        lottoRankResult = new LottoRankResult(Rank.SECOND);
    }

    @Test
    public void increaseCountTest() {
        lottoRankResult.increaseCount(Rank.SECOND);
        lottoRankResult.increaseCount(Rank.THIRD);
        assertThat(lottoRankResult.getCount()).isEqualTo(1);
        lottoRankResult.increaseCount(Rank.FOURTH);
        lottoRankResult.increaseCount(Rank.SECOND);
        assertThat(lottoRankResult.getCount()).isEqualTo(2);
    }

    @Test
    public void getWinningMoneyTest() {
        lottoRankResult.increaseCount(Rank.SECOND);
        lottoRankResult.increaseCount(Rank.SECOND);
        assertThat(lottoRankResult.getWinningMoney()).isEqualTo(60000000);
    }
}
