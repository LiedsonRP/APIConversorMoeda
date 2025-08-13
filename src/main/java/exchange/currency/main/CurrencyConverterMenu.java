package exchange.currency.main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.*;


import exchange.currency.dto.DataCurrencyConversion;
import exchange.currency.model.Currency;
import exchange.currency.service.ExchangeRateApi;

public class CurrencyConverterMenu {

    private static final Scanner scanner = new Scanner(System.in);
    private List<Currency> currentList;

    private BigDecimal value;
    private Currency initialCoinSymbol;
    private Currency finalCoinSymbol;
    private BigDecimal conversionRate;
    private BigDecimal finalValue;

    public void runProgram() {

        String userSymbol;

        this.currentList = Arrays.stream(Currency.values()).toList();

        System.out.println("Qual valor deseja converter? (Apenas número)");
        this.value = scanner.nextBigDecimal();

        showMenu();

        System.out.println("\nQual a sigla da moeda desse valor?");
        userSymbol = scanner.next();

        this.initialCoinSymbol = getCurrencyCode(userSymbol);

        showMenu();

        System.out.println("\npara qual moeda deseja converter este valor (sigla)?");
        userSymbol = scanner.next();

        this.finalCoinSymbol = getCurrencyCode(userSymbol);

        System.out.println(value + " - " + initialCoinSymbol.getCode() + " - " + finalCoinSymbol.getCode());

        DataCurrencyConversion data = new ExchangeRateApi().getConversionRateBetween(initialCoinSymbol.getCode(), finalCoinSymbol.getCode());
        this.conversionRate = new BigDecimal(data.conversionRate());

        this.finalValue = value.multiply(conversionRate);

        System.out.println("RESULTADO DA CONVERSÃO\n------------------------------------------");
        System.out.println("Valor original: " + value.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Taxa de Conversão: " + conversionRate.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Valor convertido: " + finalValue.setScale(2, RoundingMode.HALF_UP));

    }

    private void showMenu() {
        System.out.println("""
                -----------------------------
                Moedas disponíveis
                -----------------------------
                """);
        for (Currency currency : currentList) {
            System.out.println(currency.getCode() + " - " + currency.getCurrencyName());
        }
    }

    private Currency getCurrencyCode(String currencyCode) {

        Optional<Currency> findedCurrency = currentList.stream()
                .filter(currency -> currency.getCode().equals(currencyCode))
                .findFirst();

        if (findedCurrency.isPresent()) {
            return findedCurrency.get();
        } else {
            throw new RuntimeException("A moeda informada não está registrada no sistema");
        }
    }

}
