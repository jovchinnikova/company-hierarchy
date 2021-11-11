package com.solvd.companyhierarchy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class SAXParser extends DefaultHandler implements Parser {

    private static final Logger LOGGER = LogManager.getLogger(SAXParser.class);

    private StringBuilder value;
    private String depTitle;
    private double salary;
    private String name;
    private double price;
    private String firstName = "";
    private String lastName = "";
    private String firstNameDir = "";
    private String lastNameDir = "";
    private Set<Worker> workers = new HashSet<>();
    private List<Service> services = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();
    private Integer vacDur;
    private LocalDateTime startVac;
    private Integer id;

    Company company = new Company();

    @Override
    public void startDocument() throws SAXException {
        LOGGER.info("Parsing is started");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        value = new StringBuilder();
        switch (qName) {
            case "company":
                int phoneNumber = Integer.parseInt(atts.getValue("phoneNumber"));
                company.setPhoneNumber(phoneNumber);
                String site = atts.getValue("site");
                company.setSite(site);
                break;
            case "worker":
                Integer id = Integer.valueOf(atts.getValue("id"));
                this.id = id;
                break;
            default:
                break;
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        switch (qName) {
            case "compTitle":
                company.setTitle(value.toString());
                break;
            case "firstNameDir":
                firstNameDir = value.toString();
                break;
            case "lastNameDir":
                lastNameDir = value.toString();
                break;
            case "director":
                company.setDirector(new CEO(firstNameDir, lastNameDir));
                break;
            case "firstName":
                firstName = value.toString();
                break;
            case "lastName":
                lastName = value.toString();
                break;
            case "averageSalary":
                salary = Double.parseDouble(value.toString());
                break;
            case "startVacation":
                startVac = LocalDateTime.parse(value.toString());
                break;
            case "vacationDuration":
                vacDur = Integer.valueOf(value.toString());
                break;
            case "worker":
                Worker worker = new Worker(id, firstName, lastName);
                worker.setStartVacation(startVac);
                worker.setVacationDuration(vacDur);
                worker.setAverageSalary(salary);
                workers.add(worker);
                break;
            case "workers":
                company.setWorkers(workers);
                break;
            case "name":
                name = value.toString();
                break;
            case "price":
                price = Double.parseDouble(value.toString());
                break;
            case "service":
                Service service = new Service(name, price);
                services.add(service);
                break;
            case "depTitle":
                depTitle = value.toString();
                break;
            case "department":
                Department department = new Department(depTitle);
                department.setServices(services);
                departments.add(department);
                break;
            case "departments":
                company.setDepartments(departments);
                break;
            default:
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        value.append(ch, start, length);
    }

    @Override
    public void endDocument() throws SAXException {
        LOGGER.info("Parsing is ended");
    }

    @Override
    public Company parse(File file) throws ParserConfigurationException, SAXException, IOException, JAXBException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser parser = factory.newSAXParser();

        parser.parse(file, this);
        return company;
    }
}
