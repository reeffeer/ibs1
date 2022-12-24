package lesson3;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Security {
    @JsonProperty("name")
    private String securityName;
    @JsonProperty("currency")
    private List<Currency> currency;
    @JsonProperty("code")
    private BigInteger code;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date date;

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String name) {
        this.securityName = name;
    }

    public List<Currency> getCurrency() {
        return currency;
    }

    public void setCurrency(List<Currency> currency) {
        this.currency = currency;
    }

    public BigInteger getCode() {
        return code;
    }

    public void setCode(BigInteger code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Security{" +
                "name='" + securityName + '\'' +
                ", currency='" + currency + '\'' +
                ", code=" + code +
                ", date=" + date +
                '}';
    }
}
