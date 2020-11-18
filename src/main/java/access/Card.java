package access;

import java.util.Date;

public class Card {
    private int number;
    private Date expiryDate;
    private int pin;

    public Card(int number, Date expiryDate, int pin) {
        this.number = number;
        this.expiryDate = expiryDate;
        this.pin = pin;
    }
}
