package com.solvd.companyhierarchy;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;

public class DateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    @Override
    public LocalDateTime unmarshal(String dateTime){
        return LocalDateTime.parse(dateTime);
    }

    @Override
    public String marshal(LocalDateTime dateTime){
        return dateTime.toString();
    }
}
