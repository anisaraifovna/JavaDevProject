package common.accesstools;

import common.Money;
import common.exception.BusinessCommonException;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter @NonNull
public class CreditCard extends Card{
    private Money limit;
    private BigDecimal interestRate;

    public CreditCard(String number, LocalDate expiryDate, String pin, Money limit, BigDecimal interestRate) throws BusinessCommonException {
        super(number, expiryDate, pin);
        this.limit = limit;
        this.interestRate = interestRate;
    }
}
