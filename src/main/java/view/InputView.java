package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputManualLottoCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<String> inputLottoStrings(int manualLottoCount) {
        List<String> strings = new ArrayList<>();
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        for (int count = 0; count < manualLottoCount; count++) {
            strings.add(scanner.nextLine());
        }
        return strings;
    }

    public static String inputWinningLotto() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
