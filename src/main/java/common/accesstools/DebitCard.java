package common.accesstools;

import common.exception.BusinessCommonException;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Getter @NonNull
public class DebitCard extends Card {
    BigDecimal returnPercent;

    public DebitCard(String number, LocalDate expiryDate, String pin) throws BusinessCommonException {
        super(number, expiryDate, pin);
        returnPercent = BigDecimal.ZERO;
    }

    public DebitCard(String number, LocalDate expiryDate, String pin, BigDecimal returnPercent) throws BusinessCommonException {
        super(number, expiryDate, pin);
        this.returnPercent = returnPercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DebitCard debitCard = (DebitCard) o;
        return Objects.equals(returnPercent, debitCard.returnPercent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(returnPercent);
    }
}
