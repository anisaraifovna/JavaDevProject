package accesstools;

import common.BusinessException;
import lombok.Getter;
import lombok.NonNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @NonNull
public class DebitCard extends Card {
    BigDecimal returnPercent;

    public DebitCard(String number, LocalDate expiryDate, String pin) throws BusinessException {
        super(number, expiryDate, pin);
        returnPercent = BigDecimal.ZERO;
    }

    public DebitCard(String number, LocalDate expiryDate, String pin, BigDecimal returnPercent) throws BusinessException {
        super(number, expiryDate, pin);
        this.returnPercent = returnPercent;
    }
}
