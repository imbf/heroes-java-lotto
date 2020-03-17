package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private List<LottoRankResult> lottoRankResults;
    private int money;

    public LottoResult(int money) {
        this.money = money;
        lottoRankResults = new ArrayList<>();
        for (int index = 0; index < Rank.values().length; index++) {
            lottoRankResults.add(new LottoRankResult(Rank.values()[index]));
        }
    }

    public List<LottoRankResult> getLottoRankResults() {
        return lottoRankResults;
    }

    public double createRateOfProfit() {
        int profit = 0;
        for (LottoRankResult lottoRankResult : lottoRankResults) {
            profit += lottoRankResult.getWinningMoney();
        }
        return (double) profit / money;
    }

}
