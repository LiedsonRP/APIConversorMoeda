package exchange.currency.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataCurrencyConversion (
    @JsonAlias("conversion_rate") Double conversionRate
) {

}
