package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
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
        List<Rank> ranks = Arrays.stream(values())
                .filter(rank -> rank != SECOND)
                .collect(Collectors.toList());

        if (countOfMatch == 5 && matchBonus) {
            return SECOND;
        }

        if (countOfMatch >= 3) {
            return ranks.get(countOfMatch - 3);
        }
        return null;
    }
}
