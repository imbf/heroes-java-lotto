package view;

import lotto.Lotto;
import lotto.LottoGame;
import lotto.LottoRankResult;
import lotto.Rank;

import java.util.List;

public class ResultView {

    public static void showAllLottos(LottoGame lottoGame) {
        System.out.println("\n수동으로 " + lottoGame.getManualLottoCount() + "장, 자동으로 " + lottoGame.getAutoLottoCount() + "개를 구매했습니다.");
        for (Lotto lotto : lottoGame.getLottos()) {
            showLotto(lotto);
        }
    }

    private static void showLotto(Lotto lotto) {
        System.out.print("[");
        for (int index = 0; index < lotto.getLottoNumbers().size() - 1; index++) {
            System.out.print(lotto.getLottoNumbers().get(index).getNumber() + ", ");
        }
        System.out.println(lotto.getLottoNumbers().get(lotto.getLottoNumbers().size() - 1).getNumber() + "]");
    }

    public static void showRankResult(List<LottoRankResult> lottoRankResults) {
        System.out.println("\n당첨 통계");
        System.out.println("----------");
        for (LottoRankResult lottoRankResult : lottoRankResults) {
            showlottoRankResult(lottoRankResult);
        }
    }

    private static void showlottoRankResult(LottoRankResult lottoRankResult) {
        if (lottoRankResult.getRank() == Rank.SECOND) {
            System.out.println(lottoRankResult.getRank().getCountOfMatch() + "개 일치, 보너스 볼 일치("
                    + lottoRankResult.getRank().getWinningMoney() + "원) - " + lottoRankResult.getCount() + "개");
            return;
        }
        System.out.println(lottoRankResult.getRank().getCountOfMatch()+"개 일치," +
                " (" + lottoRankResult.getRank().getWinningMoney() + "원) - " + lottoRankResult.getCount() + "개");
    }

    public static void showRateOfProfit(Double rateOfProfit) {
        System.out.println("총 수익률은 " + String.format("%.1f", rateOfProfit) + "%입니다.");
    }

}
