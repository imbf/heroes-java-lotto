package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplication(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개로 이루어져야 합니다.");
        }
    }

    private void validateDuplication(List<LottoNumber> lottoNumbers) {
        Set<Integer> integers = new HashSet<>(lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList()));
        if (integers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

}
