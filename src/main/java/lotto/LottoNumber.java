package lotto;

public class LottoNumber  implements Comparable<LottoNumber>{


    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;

    private int number;

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number > MAX_LOTTO_NUMBER || number < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1이상 45이하의 자연수만 가능합니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        if(this.number > lottoNumber.getNumber()){
            return 1;
        }
        return -1;
    }
}
