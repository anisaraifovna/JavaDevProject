package bank.accounts;

import accesstools.DebitCard;
import common.BusinessException;
import common.ErrorCodes;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NonNull
public class AccountStorage {
    private List<Account<DebitCard>> accounts = new ArrayList<>();

    public Account<DebitCard> getAccountByCard(DebitCard card) throws BusinessException {
        return accounts.stream()
                .filter(s -> s.getCard().equals(card))
                .findAny()
                .orElseThrow(() -> new BusinessException(ErrorCodes.ERR_NOT_FOUND_ACCOUNT, "*"+card.getNumber().substring(12,15)));
    }
}
