package lesson3;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {

    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private String address;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("inn")
    private long inn;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date foundation;
    //@JsonIgnore
    @JsonProperty("securities")
    private List<Security> securities;

    @JsonProperty("id")
    public long getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }
    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }
    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("inn")
    public long getInn() {
        return inn;
    }
    @JsonProperty("inn")
    public void setInn(long inn) {
        this.inn = inn;
    }

    @JsonProperty("founded")
    public Date getFoundation() {
        return foundation;
    }
    @JsonProperty("founded")
    public void setFoundation(Date foundation) {
        this.foundation = foundation;
    }

    @JsonAnyGetter
    public List<Security> getSecurities() {
        return securities;
    }
    @JsonAnySetter
    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }

    /*   @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: " + getId() + "\n");
        sb.append("Name: '" + getName() + "'\n");
        sb.append("Address: '" + getAddress() + "'\n");
        sb.append("Phone Number: " + getPhoneNumber() + "\n");
        sb.append("INN: " + getInn() + "\n");
        sb.append("Foundation: " + getFoundation() + "\n");
        sb.append("Securities: " + securities.toString());
        return sb.toString();
    }*/

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", inn=" + inn +
                ", foundation=" + foundation +
                ", securities=" + securities +
                '}';
    }
}
