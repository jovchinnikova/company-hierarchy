package com.solvd.companyhierarchy.parsers;

import com.solvd.companyhierarchy.Company;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public interface Parser {

    Company parse(File file) throws ParserConfigurationException, SAXException, IOException, JAXBException;
}
