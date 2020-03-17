package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private List<Integer> integers;

    public LottoMachine() {
        integers = new ArrayList<>();
        for (int number = MIN_LOTTO_NUMBER; number <= MAX_LOTTO_NUMBER; number++) {
            integers.add(number);
        }
    }

    public List<Lotto> createAutoLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int iteration = 0; iteration < count; iteration++) {
            lottos.add(new Lotto(createLottoNumbers()));
        }
        return lottos;
    }

    public List<Lotto> createManualLottos(List<String> strings) {
        List<Lotto> lottos = new ArrayList<>();
        for (String string : strings) {
            lottos.add(createManualLotto(string));
        }
        return lottos;
    }

    public Lotto createManualLotto(String string) {
        return new Lotto(Arrays.stream(string.split(","))
                .map(String::trim)
                .map(Integer::new)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    private List<LottoNumber> createLottoNumbers() {
        Collections.shuffle(integers);
        return integers.subList(0, LOTTO_SIZE).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}