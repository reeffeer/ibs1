package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main3 {
private final static  List<String> FORMATS = List.of(
        "dd.MM.yyyy",
        "dd.MM.yy",
        "dd/MM/yyyy",
        "dd/MM/yy");

    public static void main(String[] args) throws IOException {
        JSONParser parser = new JSONParser();
        Companies companies = parser.parse();
        //System.out.println(companies);

        //showCompanies(companies);
        //showCompanyNamesFoundations(companies);
        //showExpiredSecurities(companies);
//        try {
//            showNamesAndFoundationsOfCompaniesCreatedAfterInsertedDate(companies);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }

        showSecuritiesByCurrency(companies);
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

    public static void showNamesAndFoundationsOfCompaniesCreatedAfterInsertedDate(Companies companies) throws ParseException {
        System.out.println("Введите дату");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Insert data (String)
        String date = null;
        try {
            date = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Parsing String date to onlyDate using String pattern
        Date onlyDate = new SimpleDateFormat("dd.MM.yy").parse(date);

        // TODO Не знаю, как использовать свой List<String> FORMATS
        //ведь тут нужно сравнивать не введенную пользователем строку, а ее шаблоню
        // А как мы получим шаблон из введенной строки?
        companies.getCompanies().stream().filter(c -> c.getFoundation().after(onlyDate)).forEach(System.out::println);


        /*//Get pattern from the line
        String pattern;
        SimpleDateFormat sdf = new SimpleDateFormat(parse);


        if (date != null) {
            for (String parse : FORMATS) {
                SimpleDateFormat sd = new SimpleDateFormat(parse);
                try {
                    if (sd.parse(date).equals(parse)) {
                        companies.getCompanies().stream().filter(c -> c.getFoundation().after(sd.get2DigitYearStart())).forEach(System.out::println);
                    }
                } catch (ParseException e) {
                    System.out.println("Cannot parse the line");
                }
            }
        }*/
    }

    public static void showSecuritiesByCurrency(Companies companies) throws IOException {
        System.out.println("Введите код валюты");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String currencyCode = reader.readLine();
        companies.getCompanies().stream().forEach(company -> company.getSecurities().stream()
                .filter(security -> security.getCurrency().stream().filter(currency -> currency.getCurrencyType().equals(currencyCode.toUpperCase()))
                                .forEach())); //TODO как здесь вывести коды акций (то есть подняться по потоку на уровень вверх, после фильтрации валют) на экран?

    }
}