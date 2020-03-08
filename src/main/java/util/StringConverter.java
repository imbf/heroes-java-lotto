package util;

import lotto.Lotto;
import lotto.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringConverter {

    public static List<Lotto> convertStringsToLottos(List<String> strings) {
        List<Lotto> lottos = new ArrayList<>();
        for (String string : strings) {
            lottos.add(convertStringToLotto(string));
        }
        return lottos;
    }

    public static Lotto convertStringToLotto(String string) {
        return new Lotto(Arrays.stream(string.split(","))
                .map(String::trim)
                .map(Integer::new)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }
}
