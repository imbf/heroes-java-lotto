package lotto;

import java.util.ArrayList;
import java.util.List;

public class TargetLottos {

    List<Lotto> lottos;

    public TargetLottos(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        this.lottos = new ArrayList<>();
        lottos.addAll(manualLottos);
        lottos.addAll(autoLottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
