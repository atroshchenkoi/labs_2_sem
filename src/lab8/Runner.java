package lab8;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args)  {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/XmlExRates.aspx"));
            String body = br.lines().collect(Collectors.joining());
            StringReader reader = new StringReader(body);
            try {
                JAXBContext context = JAXBContext.newInstance(DailyExRate.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                DailyExRate dailyExRate = (DailyExRate) unmarshaller.unmarshal(reader);
                System.out.println(dailyExRate);
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}