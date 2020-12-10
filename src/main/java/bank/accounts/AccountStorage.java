package bank.accounts;

import accesstools.DebitCard;
import bank.accounts.exceptions.NotFoundAccountException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NonNull
public class AccountStorage {
    private List<Account<DebitCard>> accounts = new ArrayList<>();

    public Account<DebitCard> getAccountByCard(DebitCard card) throws NotFoundAccountException {
        return accounts.stream()
                .filter(s -> s.getCard().equals(card))
                .findAny()
                .orElseThrow(NotFoundAccountException::new);
    }
}
