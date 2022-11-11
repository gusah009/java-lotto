package lotto.domain;

import static lotto.domain.Lotto.END_LOTTO_NUMBER;
import static lotto.domain.Lotto.START_LOTTO_NUMBER;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    static void validate(Lotto lotto, int bonusNumber) {
        if (isInvalidRange(bonusNumber)) {
            System.out.printf("[ERROR] 보너스 숫자는 %d부터 %d 사이의 숫자여야 합니다.\n", START_LOTTO_NUMBER, END_LOTTO_NUMBER);
            throw new IllegalArgumentException();
        }
        if (isDuplicateNumber(lotto, bonusNumber)) {
            System.out.printf("[ERROR] 보너스 숫자(%d)가 중복됩니다.\n", bonusNumber);
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInvalidRange(int bonusNumber) {
        return START_LOTTO_NUMBER > bonusNumber || bonusNumber > END_LOTTO_NUMBER;
    }

    private static boolean isDuplicateNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
