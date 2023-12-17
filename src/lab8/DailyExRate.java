package lab8;

import lombok.Data;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@Data
@XmlRootElement(name = "DailyExRates")
@XmlAccessorType(XmlAccessType.FIELD)
public class DailyExRate {
    @XmlAttribute(name = "Date")
    private String date;
    @XmlElementWrapper(name = "Currencies")
    @XmlElement(name="Currency")
    private ArrayList<Currency> currencies;

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Currency currency : currencies) {
            str.append(currency.toString());
        }
        return " урсы на " + date + ":" + str;
    }
}
