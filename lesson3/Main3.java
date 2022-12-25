package lesson3;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Currency;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main3 {

    public static void main(String[] args) throws IOException {

        JSONParser parser = new JSONParser();
        Companies companies = parser.parse();
        //System.out.println(companies);

        //showCompanies(companies);
        //showCompanyNamesFoundations(companies);
        showExpiredSecurities(companies);
    }

    public static void showCompanies (Companies companies) {
        Iterator<Company> iter = companies.getCompanies().iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public static void showCompanyNamesFoundations(Companies companies) {
        List<String> names = companies.getCompanies().stream().map(Company::getName).collect(Collectors.toList());
       // names.forEach(System.out::println);

        List<Date> foundations = companies.getCompanies().stream().map(Company::getFoundation).collect(Collectors.toList());
        //foundations.forEach(System.out::println);

        /*Map<String, Date> companiesMap = new HashMap<>();//Map.Entry<String, Date> e : companiesMap.entrySet()
        for (int i = 0; i < names.size(); i++) {
            companiesMap.put(names.get(i), foundations.get(i));
        }
        System.out.println(companiesMap);*/

        for (int i = 0; i < names.size(); i++) {
            SimpleDateFormat formatt = new SimpleDateFormat("dd/MM/uu");
            System.out.println("Краткое имя " + names.get(i) + " - Дата основания " + formatt.format(foundations.get(i)));
        }
    }

    public static void showExpiredSecurities(Companies companies) {
        AtomicInteger count = new AtomicInteger();
        Date currentDate = new Date();
        companies.getCompanies().stream().forEach(company -> company.getSecurities().stream()
                .filter(security -> security.getDate().before(currentDate))
                .forEach(security -> System.out.println("Code - " + security.getCode() +
                        " Expiration date - " + security.getDate() +
                        " Owner company - " + security.getSecurityName())));
        System.out.println("\nTotal expired securities " + getCountExpiredSecurities(companies, count, currentDate));
    }

    public static AtomicInteger getCountExpiredSecurities (Companies companies, AtomicInteger count, Date currentDate) {
        companies.getCompanies().stream().forEach(company -> company.getSecurities().stream().filter(security -> security.getDate().before(currentDate))
                .forEach(security -> count.getAndIncrement()));
        return count;
    }
}
