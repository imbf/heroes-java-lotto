package lotto;

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
    WinningLotto winningLotto;

    @Before
    public void setUp() {

        lottoGame = new LottoGame(3000, 1);
        winningLotto = new WinningLotto(new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(3), new LottoNumber(5),
                new LottoNumber(7), new LottoNumber(9), new LottoNumber(11)
        )), 42);

        LottoMachine lottoMachine = mock(LottoMachine.class);
        when(lottoMachine.createManualLottos(eq(Arrays.asList("1,2,3,4,5,6"))))
                .thenReturn(Arrays.asList(
                        new Lotto(Arrays.asList(
                                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))));
        when(lottoMachine.createAutoLottos(eq(lottoGame.getAutoLottoCount())))
                .thenReturn(Arrays.asList(
                        new Lotto(Arrays.asList(
                                new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                                new LottoNumber(5), new LottoNumber(6), new LottoNumber(7))),
                        new Lotto(Arrays.asList(
                                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                                new LottoNumber(6), new LottoNumber(7), new LottoNumber(8)))
                ));

        List<Lotto> manualLottos = lottoMachine.createManualLottos(Arrays.asList("1,2,3,4,5,6"));
        TargetLottos targetLottos = new TargetLottos(manualLottos, lottoMachine.createAutoLottos(lottoGame.getAutoLottoCount()));
        lottoGame.registerTargetLottos(targetLottos);

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
        for (int index = 0; index < lottoGame.getTargetLottos().getLottos().size(); index++) {
            Lotto lotto = lottoGame.getTargetLottos().getLottos().get(index);
            List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
            List<Integer> integers = numberLists.get(index);

            for (int i = 0; i < lottoNumbers.size(); i++) {
                assertThat(lottoNumbers.get(i).getNumber()).isEqualTo(integers.get(i));
            }
        }
    }

    @Test
    public void createResultTest() {
        LottoResult lottoResult = lottoGame.createResult(winningLotto);
        List<LottoRankResult> lottoRankResults = lottoResult.getLottoRankResults();

        LottoResult lottoResultTest = new LottoResult(3000);
        List<LottoRankResult> lottoRankResultsTest = lottoResultTest.getLottoRankResults();

        lottoRankResultsTest.get(0).increaseCount(Rank.FIFTH);
        lottoRankResultsTest.get(0).increaseCount(Rank.FIFTH);
        lottoRankResultsTest.get(0).increaseCount(Rank.FIFTH);

        assertThat(lottoResult.createRateOfProfit()).isEqualTo(lottoResultTest.createRateOfProfit());
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

