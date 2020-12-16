package accesstools;

import common.BusinessException;
import common.ErrorCodes;
import lombok.Getter;
import lombok.NonNull;
import java.util.Date;

@Getter @NonNull
public class Card {

    private String number;
    private Date expiryDate;
    private String pin;

    public Card(String number, Date expiryDate, String pin) throws BusinessException {
        if (number.matches("^[0-9]{16}$"))
            this.number = number;
        else
            throw new BusinessException(ErrorCodes.ERR_CARD_FORMAT,number);

        if (pin.matches("^[0-9]{4}$"))
            this.pin = pin;
        else
            throw new BusinessException(ErrorCodes.ERR_PIN_FORMAT);

        this.expiryDate = expiryDate;

    }
}
