import lotto.*;
import view.ResultView;

import java.util.List;

import static util.StringConverter.*;
import static view.InputView.*;

public class Application {

    public static void main(String[] args) {
        PurchaseMoney purchaseMoney = new PurchaseMoney(inputPurchaseMoney());
        LottoGame lottoGame = new LottoGame(purchaseMoney, inputManualLottoCount());
        List<Lotto> manualLottos = convertStringsToLottos(inputLottoStrings(lottoGame.getManualLottoCount()));

        lottoGame.setLottos(manualLottos);
        lottoGame.setLottos(new AutoLottoGenerator().createLottos(lottoGame.getAutoLottoCount()));

        ResultView.showAllLottos(lottoGame);
        lottoGame.setWinningLotto(new WinningLotto(convertStringToLotto(inputWinningLotto()),inputBonusNumber()));
        ResultView.showGameResult(lottoGame.createResult());
    }
}
