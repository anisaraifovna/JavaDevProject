package common;

public enum Currency {
    RUR("RUR"),
    USD("USD"),
    EUR("EUR");

    private String code;

    Currency(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}