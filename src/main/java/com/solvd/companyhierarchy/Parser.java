package com.solvd.companyhierarchy;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public interface Parser {

    Company parse(File file) throws ParserConfigurationException, SAXException, IOException;
}
