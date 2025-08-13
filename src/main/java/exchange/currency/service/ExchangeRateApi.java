package exchange.currency.service;

import exchange.currency.dto.DataCurrencyConversion;
import exchange.currency.service.API;

import java.math.BigDecimal;

public class ExchangeRateApi {

    public static final String EXCHANGEURL = "https://v6.exchangerate-api.com/v6/";
    public static final String API_KEY = System.getenv("EXCHANGEURL");

    public DataCurrencyConversion getConversionRateBetween(String originCurrencyCode, String finalCurrencyCode) {

        API api = new API();
        JSONConverter jsonConverter = new JSONConverter();
        String apiLink = this.buildAPIConversionLink(originCurrencyCode, finalCurrencyCode);

        String json = api.getData(apiLink);
        return jsonConverter.getData(json, DataCurrencyConversion.class);

    }

    /**
     * Constroi o link de conversão da API
     * @param originCurrencyCode
     * @param finalCurrencyCode
     * @return
     */
    private String buildAPIConversionLink(String originCurrencyCode, String finalCurrencyCode) {
        return EXCHANGEURL + API_KEY + "/pair/" + originCurrencyCode + "/" + finalCurrencyCode;
    }
}
