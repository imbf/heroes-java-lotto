package lotto;

import java.util.*;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private int autoLottoCount;
    private int manualLottoCount;
    private TargetLottos targetLottos;

    public LottoGame(int money, int manualLottoCount) {
        this.manualLottoCount = manualLottoCount;
        this.autoLottoCount = money / LOTTO_PRICE - manualLottoCount;
    }

    public TargetLottos getTargetLottos() {
        return targetLottos;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }

    public void registerTargetLottos(TargetLottos targetLottos) {
        this.targetLottos = targetLottos;
    }

    public LottoResult createResult(WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult((autoLottoCount + manualLottoCount) * LOTTO_PRICE);
        for (Lotto lotto : targetLottos.getLottos()) {
            checkLotto(lotto, lottoResult.getLottoRankResults(), winningLotto);
        }
        return lottoResult;
    }

    private void checkLotto(Lotto lotto, List<LottoRankResult> lottoRankResults, WinningLotto winningLotto) {
        int countOfMatch = 0;
        for (LottoNumber lottoNumber : winningLotto.getLotto().getLottoNumbers()) {
            countOfMatch += checkNumberMatch(lotto, lottoNumber.getNumber());
        }
        boolean matchBonus = isBonusMatch(lotto, winningLotto.getBonusNumber());
        for (LottoRankResult lottoRankResult : lottoRankResults) {
            lottoRankResult.increaseCount(Rank.valueOf(countOfMatch, matchBonus));
        }
    }

    private int checkNumberMatch(Lotto lotto, int number) {
        for (int index = 0; index < lotto.getLottoNumbers().size(); index++) {
            if (lotto.getLottoNumbers().get(index).getNumber() == number) {
                return 1;
            }
        }
        return 0;
    }

    private boolean isBonusMatch(Lotto lotto, int bonusNumber) {
        for (int index = 0; index < lotto.getLottoNumbers().size(); index++) {
            if (lotto.getLottoNumbers().get(index).getNumber() == bonusNumber) {
                return true;
            }
        }
        return false;
    }
}
