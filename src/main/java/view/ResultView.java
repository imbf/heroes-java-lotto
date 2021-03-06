package view;

import lotto.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private final static int PERCENTAGE = 100;

    public static void showAllLottos(LottoGame lottoGame) {
        System.out.println("\n수동으로 " + lottoGame.getManualLottoCount() + "장, 자동으로 " + lottoGame.getAutoLottoCount() + "개를 구매했습니다.");
        for (Lotto lotto : lottoGame.getTargetLottos().getLottos()) {
            showLotto(lotto);
        }
    }

    private static void showLotto(Lotto lotto) {
        List<Integer> integers = lotto.getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
        Collections.sort(integers);

        System.out.print("[");
        for (int index = 0; index < lotto.getLottoNumbers().size() - 1; index++) {
            System.out.print(integers.get(index) + ", ");
        }
        System.out.println(integers.get(integers.size() - 1) + "]");
    }

    public static void showGameResult(LottoResult lottoResult) {
        System.out.println("\n당첨 통계");
        System.out.println("----------");
        showRankResults(lottoResult.getLottoRankResults());
        showRateOfProfit(lottoResult.createRateOfProfit());
    }

    private static void showRankResults(List<LottoRankResult> lottoRankResults) {
        for (LottoRankResult lottoRankResult : lottoRankResults) {
            showRankResult(lottoRankResult);
        }
    }

    private static void showRankResult(LottoRankResult lottoRankResult) {
        if (lottoRankResult.getRank() == Rank.SECOND) {
            System.out.println(lottoRankResult.getRank().getCountOfMatch() + "개 일치, 보너스 볼 일치("
                    + lottoRankResult.getRank().getWinningMoney() + "원) - " + lottoRankResult.getCount() + "개");
            return;
        }
        System.out.println(lottoRankResult.getRank().getCountOfMatch() + "개 일치," +
                " (" + lottoRankResult.getRank().getWinningMoney() + "원) - " + lottoRankResult.getCount() + "개");
    }

    private static void showRateOfProfit(Double rateOfProfit) {
        System.out.println("총 수익률은 " + String.format("%.1f", rateOfProfit * PERCENTAGE) + "%입니다.");
    }
}
