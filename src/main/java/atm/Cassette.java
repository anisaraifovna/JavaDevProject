package atm;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class Cassette {
    @Getter @NonNull
    private Banknote banknote;
    @Getter @Setter @NonNull
    private int currentAmount;

    public Cassette(Banknote banknote, int currentAmount) {
        this.banknote = banknote;
        this.currentAmount = currentAmount;
    }

    public void getBanknotes (int amount){
        currentAmount -= amount;
    }

}
