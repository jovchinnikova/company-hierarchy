package com.solvd.companyhierarchy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Parser parsing = new ParserImpl();
        Company comp = parsing.parse();
        LOGGER.info(comp.getTitle());
        LOGGER.info(comp.getPhoneNumber());
        LOGGER.info(comp.getSite());
        LOGGER.info(comp.getDirector().getFirstName());
        LOGGER.info(comp.getDirector().getLastName());
    }
    }
