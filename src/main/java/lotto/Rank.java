package lotto;

public enum Rank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(4, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);
    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == 6) {
            return Rank.FIRST;
        }
        if (countOfMatch == 5 && matchBonus) {
            return Rank.SECOND;
        }
        if (countOfMatch == 5 && !matchBonus) {
            return Rank.THIRD;
        }
        if (countOfMatch == 4) {
            return Rank.FOURTH;
        }
        if (countOfMatch == 3) {
            return Rank.FIFTH;
        }
        return null;
    }
}
