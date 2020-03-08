package lotto;

public class WinningLotto {

    private Lotto lotto;
    private int BonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        BonusNumber = bonusNumber;
        validateBonusNumber(lotto, bonusNumber);
    }

    private void validateBonusNumber(Lotto lotto, int BonusNumber) {
        if(LottoConverter.convertLottoToIntegers(lotto).contains(BonusNumber)){
            throw new IllegalArgumentException("보너스 번호와 로또 번호는 중복되면 안됩니다.");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return BonusNumber;
    }
}
