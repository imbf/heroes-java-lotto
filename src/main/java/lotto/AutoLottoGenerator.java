package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutoLottoGenerator {

    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private List<Integer> integers;

    public AutoLottoGenerator() {
        integers = new ArrayList<>();
        for (int number = MIN_LOTTO_NUMBER; number <= MAX_LOTTO_NUMBER; number++) {
            integers.add(number);
        }
    }

    public List<Lotto> createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int iteration = 0; iteration < count; iteration++) {
            lottos.add(new Lotto(createLottoNumbers()));
        }
        return lottos;
    }

    private List<LottoNumber> createLottoNumbers() {
        Collections.shuffle(integers);
        return integers.subList(0, LOTTO_SIZE).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
