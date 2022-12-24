package lesson3;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class Main3 {

    public static void main(String[] args) throws IOException {

        JSONParser parser = new JSONParser();
        Companies companies = parser.parse();
        //System.out.println(companies.getCompanies().get((int) companies.getCompanies().iterator().next().getId()));

        System.out.println(companies);

        showCompanies(companies);
    }

    public static void showCompanies (Companies companies) {
        Iterator<Company> iter = companies.getCompanies().iterator();
        while (iter.hasNext()) {
            
            System.out.println(iter.next().getName() + " - " + iter.next().getFoundation());
        }
        //System.out.println(companies.getCompanies().listIterator().next().getName());
    }
}
