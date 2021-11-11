package com.solvd.companyhierarchy;

import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class JaxbParser implements Parser {

    @Override
    public Company parse(File file) throws ParserConfigurationException, SAXException, IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (Company) unmarshaller.unmarshal(file);
    }
}
