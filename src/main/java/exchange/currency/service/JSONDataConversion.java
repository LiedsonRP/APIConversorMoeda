package exchange.currency.service;

public interface JSONDataConversion {

    <T> T getData(String json, Class<T> finalClass);
}
