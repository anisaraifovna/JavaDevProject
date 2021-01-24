package bank.accounts;

import bank.exception.BankingServerErrorCodes;
import bank.exception.BankingServerException;
import common.accesstools.DebitCard;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NonNull
public class AccountStorage {
    private List<Account<DebitCard>> accounts = new ArrayList<>();

    public Account<DebitCard> getAccountByCard(String cardNumber) throws BankingServerException {
        return accounts.stream()
                .filter(s -> s.getCard().getNumber().equals(cardNumber))
                .findAny()
                .orElseThrow(() -> new BankingServerException(BankingServerErrorCodes.ERR_NOT_FOUND_ACCOUNT, "*" + cardNumber.substring(12, 15)));
    }
}
