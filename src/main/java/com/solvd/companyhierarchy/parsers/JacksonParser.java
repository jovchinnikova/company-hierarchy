package com.solvd.companyhierarchy.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.companyhierarchy.Company;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class JacksonParser implements Parser {

    @Override
    public Company parse(File file) throws ParserConfigurationException, SAXException, IOException, JAXBException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file,Company.class);
    }
}
