package com.solvd.companyhierarchy;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface Parser {

    Company parse() throws ParserConfigurationException, SAXException, IOException;
}
