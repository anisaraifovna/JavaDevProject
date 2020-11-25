package atm;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class Cassette {
    @Getter @NonNull
    Banknote banknote;
    @Getter @Setter @NonNull
    int currentAmount;

    public Cassette(Banknote banknote, int currentAmount) {
        this.banknote = banknote;
        this.currentAmount = currentAmount;
    }

    public void getBanknotes (int amount){
        currentAmount -= amount;
    }

}
