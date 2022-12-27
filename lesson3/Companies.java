package lesson3;

import java.util.List;

public class Companies {
    private List<Company> companies;

    public List<Company> getCompanies() {
        return companies;
    }

    @Override
    public String toString() {
        return "Companies{" +
                "companies=" + companies +
                '}';
    }
}
