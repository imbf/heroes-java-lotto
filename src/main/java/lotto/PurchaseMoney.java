package lotto;

public class PurchaseMoney {

    private static final int LOTTO_PRICE = 1000;

    private int money;

    public PurchaseMoney(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 구입하기위한 최소금액은 천원입니다.");
        }

        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또 금액은 천원 단위여야만 합니다.");
        }
    }

    public int getMoney() {
        return money;
    }
}
