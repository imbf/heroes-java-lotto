package lotto;

public class LottoStatistical {
    public static double createRateOfProfit(LottoGame lottoGame) {
        long profit = 0;
        for (LottoRankResult rankResult : lottoGame.createRankResults()) {
            profit += rankResult.getWinningMoney();
        }
        return profit/(double)lottoGame.getPurchaseMoney().getMoney();
    }
}
