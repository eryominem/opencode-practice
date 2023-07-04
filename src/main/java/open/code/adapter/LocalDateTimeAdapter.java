package open.code.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {
    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    @Override
    public String marshal(LocalDateTime localDateTime) throws Exception {
        return localDateTime.format(dateFormat);
    }

    @Override
    public LocalDateTime unmarshal(String localDateTime) throws Exception {
        return LocalDateTime.parse(localDateTime, dateFormat);
    }
}
