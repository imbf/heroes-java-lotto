package lotto;

public class LottoRankResult {

    Rank rank;
    int count;

    public LottoRankResult(Rank rank) {
        this.rank = rank;
        this.count = 0;
    }

    public Rank getRank() {
        return rank;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount(Rank rank){
        if (this.rank == rank){
            count++;
        }
    }

    public int getWinningMoney() {
        return rank.getWinningMoney() * count;
    }
}
