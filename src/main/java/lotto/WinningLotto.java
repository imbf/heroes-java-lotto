package lotto;

import java.util.stream.Collectors;

public class WinningLotto {

    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        validateBonusNumber(lotto, bonusNumber);
    }

    private void validateBonusNumber(Lotto lotto, int bonusNumber) {
        for (int index = 0; index < lotto.getLottoNumbers().size(); index++) {
            if (lotto.getLottoNumbers().get(index).getNumber() == bonusNumber) {
                throw new IllegalArgumentException("보너스 번호와 로또 번호는 중복되면 안됩니다.");
            }
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
