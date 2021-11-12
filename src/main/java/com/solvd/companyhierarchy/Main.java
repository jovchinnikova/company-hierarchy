package com.solvd.companyhierarchy;

import com.solvd.companyhierarchy.parsers.JacksonParser;
import com.solvd.companyhierarchy.parsers.JaxbParser;
import com.solvd.companyhierarchy.parsers.Parser;
import com.solvd.companyhierarchy.parsers.SAXParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, JAXBException {
        File file = new File("D:\\Git\\git\\company-hierarchy\\src\\main\\resources\\company.xml");
        Parser SAXParser = new SAXParser();
        Company company = SAXParser.parse(file);
        LOGGER.info("SAX parser");
        LOGGER.info(company.getTitle());
        LOGGER.info(company.getPhoneNumber());
        LOGGER.info(company.getSite());
        LOGGER.info(company.getDirector());
        company.getWorkers()
                .forEach(worker -> LOGGER.info(worker));
        company.getDepartments()
                .forEach(department -> LOGGER.info(department));
        System.out.println();

        LOGGER.info("Jaxb parser");
        Parser jaxbParser = new JaxbParser();
        Company company2 = jaxbParser.parse(file);
        LOGGER.info(company2.getTitle());
        LOGGER.info(company2.getPhoneNumber());
        LOGGER.info(company2.getSite());
        LOGGER.info(company2.getDirector());
        company2.getWorkers()
                .forEach(worker -> LOGGER.info(worker));
        company2.getDepartments()
                .forEach(department -> LOGGER.info(department));
        System.out.println();

        LOGGER.info("Jackson parser");
        Parser jacksonParser = new JacksonParser();
        File file2 = new File("D:\\Git\\git\\company-hierarchy\\src\\main\\resources\\company.json");
        Company company3 = jacksonParser.parse(file2);
        LOGGER.info(company3.getTitle());
        LOGGER.info(company3.getPhoneNumber());
        LOGGER.info(company3.getSite());
        LOGGER.info(company3.getDirector());
        company3.getWorkers()
                .forEach(worker -> LOGGER.info(worker));
        company3.getDepartments()
                .forEach(department -> LOGGER.info(department));
    }
    }
