package lab8;

import lombok.Data;
import javax.xml.bind.annotation.*;


@Data
@XmlRootElement(name = "by.gsu.pm.Currency")
@XmlAccessorType(XmlAccessType.FIELD)
public class Currency {
    @XmlAttribute(name = "Id")
    private String id;
    @XmlElement(name = "NumCode")
    private String numCode;
    @XmlElement(name = "CharCode")
    private String charCode;
    @XmlElement(name = "Scale")
    private String scale;
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "Rate")
    private String rate;

    @Override
    public String toString() {
        return "\nid = " + id + "\n" +
                "Номер = " + numCode + "\n" +
                "Символьный код = " + charCode + "\n" +
                "Кол-во = " + scale + "\n" +
                "Название = " + name + "\n" +
                "Курс (с учётом кол-ва) = " + rate + "\n";

    }
}
