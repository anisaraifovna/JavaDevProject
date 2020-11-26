package accesstools;

import accesstools.exceptions.CardFormatException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import java.util.Date;

@Getter @NonNull
public class Card {

    private String number;
    @Setter
    private Date expiryDate;
    private String pin;

    public Card(String number, Date expiryDate) throws CardFormatException {
        if (number.matches("^[0-9]{16}$"))
            this.number = number;
        else
            throw new CardFormatException("Неверный формат номера карты ");
        this.expiryDate = expiryDate;
    }

    public void setPin(String pin) throws CardFormatException {
        if (pin.matches("^[0-9]{4}$"))
            this.pin = pin;
        else
            throw new CardFormatException("Неверный формат пин-кода карты ");
    }
}
