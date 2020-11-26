package atm;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter @NonNull
public class Cassette {

    private Banknote banknote;
    @Setter
    private int currentAmount;

    public Cassette(Banknote banknote, int currentAmount) {
        this.banknote = banknote;
        this.currentAmount = currentAmount;
    }

    public void getBanknotes (int amount){
        currentAmount -= amount;
    }

}
