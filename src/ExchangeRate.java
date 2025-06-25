import java.util.Map;

/**
 * ExchangeRate
 */

public class ExchangeRate {
    private String result;
    private String documentation;
    private String terms_of_use;
    private Long time_last_update_unix;
    private String time_last_update_utc;
    private Long time_next_update_unix;
    private String time_next_update_utc;
    private String base_code;
    public Map<String, Double> conversion_rates;

    public ExchangeRate(String result,
                        String documentation,
                        String terms_of_use,
                        Long time_last_update_unix,
                        String time_last_update_utc,
                        Long time_next_update_unix,
                        String time_next_update_utc,
                        String base_code,
                        Map<String, Double> conversion_rates
    ){
        this.result = result;
        this.documentation = documentation;
        this.terms_of_use = terms_of_use;
        this.time_last_update_unix = time_last_update_unix;
        this.time_last_update_utc = time_last_update_utc;
        this.time_next_update_unix = time_next_update_unix;
        this.time_next_update_utc = time_next_update_utc;
        this.base_code = base_code;
        this.conversion_rates = conversion_rates;
    }

    public ExchangeRate(String _baseCode)
    {
        this.base_code = _baseCode;
    }

    public Boolean getResult() {
        if (this.result.equals("success")) {
            return true;
        }
        else {
            return false;
        }
    }

    public Double getExchangerate(String _code)
    {
        return this.conversion_rates.get(_code);
    }

    public Boolean monedaExiste(String _code)
    {
        if( this.conversion_rates.containsKey(_code) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}