package utilities;

import Models.Objects.ContactUs;
import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class utils {
    public static String BASE_URL="https://www.musala.com";

  public static List<ContactUs> readContactUsCsvFile() throws IOException {
        String csvCell[];
        CSVReader reader =new CSVReader(new FileReader("src/main/java/utilities/contactUsFormData.csv"));
        ArrayList<ContactUs> contactUsList=new ArrayList<>();
        while((csvCell =reader.readNext())!= null) {
            ContactUs contactUs=new ContactUs();
            contactUs.setName(csvCell[0]);
            contactUs.setMobile(csvCell[1]);
            contactUs.setEmail(csvCell[2]);
            contactUs.setSubject(csvCell[3]);
            contactUs.setMessage(csvCell[4]);
            contactUsList.add(contactUs);
        }
        return contactUsList;
    }
}
