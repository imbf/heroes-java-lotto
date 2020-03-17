import lotto.*;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        PurchaseMoney purchaseMoney = new PurchaseMoney(InputView.inputPurchaseMoney());
        LottoGame lottoGame = new LottoGame(purchaseMoney.getMoney(), InputView.inputManualLottoCount());
        List<String> strings = InputView.inputLottoStrings(lottoGame.getManualLottoCount());


        LottoMachine lottoMachine = new LottoMachine();
        TargetLottos targetLottos = new TargetLottos(lottoMachine.createManualLottos(strings), lottoMachine.createAutoLottos(lottoGame.getAutoLottoCount()));
        lottoGame.registerTargetLottos(targetLottos);

        ResultView.showAllLottos(lottoGame);
        WinningLotto winningLotto = new WinningLotto(lottoMachine.createManualLotto(InputView.inputWinningLotto()), InputView.inputBonusNumber());
        ResultView.showGameResult(lottoGame.createResult(winningLotto));
    }
}
