package atm;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@NonNull
public class Cassette {

    private final int cassetteId;
    private final Banknote banknote;
    @Setter
    @Min(value = 0)
    @Max(value = 2000)
    private int currentAmount;
    @Setter
    @Min(value = 0)
    @Max(value = 2000)
    private int cache;

    public Cassette(int cassetteId, Banknote banknote, @Min(value = 0) @Max(value = 2000) int currentAmount) {
        this.cassetteId = cassetteId;
        this.banknote = banknote;
        this.currentAmount = currentAmount;
    }

    public void popBanknotes() {
        setCurrentAmount(currentAmount - cache);
        cache = 0;
    }

}
