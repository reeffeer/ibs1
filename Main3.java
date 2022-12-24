package lesson3;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main3 {

    public static void main(String[] args) throws IOException {

        JSONParser parser = new JSONParser();
        Companies companies = parser.parse();
        //System.out.println(companies);

        //showCompanies(companies);
        showCompanyNamesFoundations(companies);
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

    public static void showExpiredSecurities(List<Date> foundations) {

        for (int i = 0; i < foundations.size(); i++) {
            Date date = foundations.get(i);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/uu");
            System.out.println(format.format(date));
        }
    }
}
