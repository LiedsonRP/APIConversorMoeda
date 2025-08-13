package exchange.currency.model;

import java.util.Arrays;

/**
 * Determina quais as moedas disponíveis no sistema
 */
public enum Currency {
    
    USD("USD", "Dolar Americano"),
    BRL("BRL", "Real Brasileiro"),
    ARS("ARS", "Peso Argentino"),
    COP("COP", "Peso Colombiano");

    private final String code;
    private final String currencyName;

    Currency(String code, String currencyName) {
        this.code = code;
        this.currencyName = currencyName;
    }

    public String getCode() {
        return this.code;
    }

    public String getCurrencyName() {
        return this.currencyName;
    }
}
