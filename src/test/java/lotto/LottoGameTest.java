package lotto;

import lotto.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LottoGameTest {

    LottoGame lottoGame;

    @Before
    public void setUp() {
        lottoGame = new LottoGame(new PurchaseMoney(3000), 1);
        List<Lotto> manualLottos = Arrays.asList(new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        )));
        lottoGame.setLottos(manualLottos);
        AutoLottoGenerator autoLottoGenerator = mock(AutoLottoGenerator.class);
        when(autoLottoGenerator.createLottos(eq(lottoGame.getAutoLottoCount())))
                .thenReturn(Arrays.asList(
                        new Lotto(Arrays.asList(
                                new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                                new LottoNumber(5), new LottoNumber(6), new LottoNumber(7))),
                        new Lotto(Arrays.asList(
                                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                                new LottoNumber(6), new LottoNumber(7), new LottoNumber(8)))
                ));
        lottoGame.setLottos(autoLottoGenerator.createLottos(lottoGame.getAutoLottoCount()));
        lottoGame.setWinningLotto(
                new WinningLotto(new Lotto(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(3), new LottoNumber(5),
                        new LottoNumber(7), new LottoNumber(9), new LottoNumber(11)
                )), 42));
    }

    @Test
    public void getAutoLottoCountTest() {
        assertThat(lottoGame.getAutoLottoCount()).isEqualTo(2);
    }

    @Test
    public void getManualLottoCountTest() {
        assertThat(lottoGame.getManualLottoCount()).isEqualTo(1);
    }

    @Test
    public void getLottosTest() {
        List<List<Integer>> numberLists = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(2, 3, 4, 5, 6, 7),
                Arrays.asList(3, 4, 5, 6, 7, 8)
        );
        for (int index = 0; index < lottoGame.getLottos().size(); index++) {
            Lotto lotto = lottoGame.getLottos().get(index);
            List<Integer> integers = numberLists.get(index);

            assertThat(LottoConverter.convertLottoToIntegers(lotto)).isEqualTo(integers);
        }
    }

    @Test
    public void createResultTest() {
        LottoResult lottoResultTest = new LottoResult(lottoGame.getPurchaseMoney());
        for (int count = 0; count < 3; count++) {
            lottoResultTest.getLottoRankResults().get(0).increaseCount(Rank.FIFTH);
        }
        LottoResult lottoResult = lottoGame.createResult();

        assertThat(lottoResult.createRateOfProfit()).isEqualTo(lottoResultTest.createRateOfProfit());

        List<LottoRankResult> lottoRankResults = lottoResult.getLottoRankResults();
        List<LottoRankResult> lottoRankResultsTest = lottoResultTest.getLottoRankResults();

        for (int index = 0; index < lottoRankResults.size(); index++) {
            Rank rank = lottoRankResults.get(index).getRank();
            int count = lottoRankResults.get(index).getCount();
            Rank rankTest = lottoRankResultsTest.get(index).getRank();
            int countTest = lottoRankResultsTest.get(index).getCount();

            assertThat(rank).isEqualTo(rankTest);
            assertThat(count).isEqualTo(countTest);
        }
    }
}
