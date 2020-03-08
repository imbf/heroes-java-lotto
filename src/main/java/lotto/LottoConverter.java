package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoConverter {

    public static List<Integer> convertLottoToIntegers(Lotto lotto) {
        return lotto.getLottoNumbers().stream().map(LottoNumber::getNumber).collect(Collectors.toList());
    }
}
