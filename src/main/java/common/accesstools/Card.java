package common.accesstools;

import common.exception.BusinessCommonErrorCodes;
import common.exception.BusinessCommonException;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@NonNull
public class Card {

    private final String number;
    private final LocalDate expiryDate;
    private final String pin;

    public Card(String number, LocalDate expiryDate, String pin) throws BusinessCommonException {
        if (number.matches("^[0-9]{16}$"))
            this.number = number;
        else
            throw new BusinessCommonException(BusinessCommonErrorCodes.ERR_CARD_FORMAT, number);

        if (pin.matches("^[0-9]{4}$"))
            this.pin = pin;
        else
            throw new BusinessCommonException(BusinessCommonErrorCodes.ERR_PIN_FORMAT);

        this.expiryDate = expiryDate;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(number, card.number) &&
                Objects.equals(expiryDate, card.expiryDate) &&
                Objects.equals(pin, card.pin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, expiryDate, pin);
    }
}
