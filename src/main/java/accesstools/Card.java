package accesstools;

import accesstools.exceptions.CardFormatException;
import lombok.Getter;
import lombok.NonNull;
import java.util.Date;

@Getter @NonNull
public class Card {

    private String number;
    private Date expiryDate;
    private String pin;

    public Card(String number, Date expiryDate, String pin) throws CardFormatException {
        if (number.matches("^[0-9]{16}$"))
            this.number = number;
        else
            throw new CardFormatException("Неверный формат номера карты ");

        if (pin.matches("^[0-9]{4}$"))
            this.pin = pin;
        else
            throw new CardFormatException("Неверный формат пин-кода карты ");

        this.expiryDate = expiryDate;

    }
}
