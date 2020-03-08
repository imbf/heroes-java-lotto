package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private PurchaseMoney purchaseMoney;
    private int manualLottoCount;
    private List<Lotto> lottos;
    private WinningLotto winningLotto;

    public LottoGame(PurchaseMoney purchaseMoney, int manualLottoCount) {
        this.purchaseMoney = purchaseMoney;
        this.manualLottoCount = manualLottoCount;
        this.lottos = new ArrayList<>();
    }

    public PurchaseMoney getPurchaseMoney() {
        return purchaseMoney;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public int getAutoLottoCount() {
        return purchaseMoney.getMoney() / LOTTO_PRICE - manualLottoCount;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public void setWinningLotto(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public List<LottoRankResult> createRankResults() {
        List<LottoRankResult> lottoRankResults = new ArrayList<>();
        for (int index = 0; index < Rank.values().length; index++) {
            lottoRankResults.add(new LottoRankResult(Rank.values()[index]));
        }
        for (Lotto lotto : lottos) {
            checkLotto(lotto, lottoRankResults);
        }
        return lottoRankResults;
    }

    private void checkLotto(Lotto lotto, List<LottoRankResult> lottoRankResults) {
        List<Integer> integers = LottoConverter.convertLottoToIntegers(lotto);
        int countOfMatch = 0;
        for (LottoNumber lottoNumber : winningLotto.getLotto().getLottoNumbers()) {
            countOfMatch += checkNumberMatch(integers, lottoNumber.getNumber());
        }
        boolean matchBonus = isMatchBonus(integers);
        for (LottoRankResult lottoRankResult : lottoRankResults) {
            lottoRankResult.win(Rank.valueOf(countOfMatch, matchBonus));
        }

    }

    private int checkNumberMatch(List<Integer> integers, int number) {
        if (integers.contains(number)) {
            return 1;
        }
        return 0;
    }

    private boolean isMatchBonus(List<Integer> integers) {
        if (integers.contains(winningLotto.getBonusNumber())) {
            return true;
        }
        return false;
    }
}
