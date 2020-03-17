package lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TargetLottosTest {

    LottoMachine lottoMachine;
    List<Lotto> manualLottos;
    List<Lotto> autoLottos;

    @Before
    public void setUp() {
        lottoMachine = new LottoMachine();
        manualLottos = lottoMachine.createManualLottos(Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,6"));
        autoLottos = lottoMachine.createAutoLottos(4);
    }

    @Test
    public void 정상객체_생성테스트() {
        new TargetLottos(manualLottos, autoLottos);
    }
}
