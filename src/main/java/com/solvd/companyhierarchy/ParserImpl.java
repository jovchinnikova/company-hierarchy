package com.solvd.companyhierarchy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParserImpl extends DefaultHandler implements Parser {

    private static final Logger LOGGER = LogManager.getLogger(ParserImpl.class);

    private String element = "";
    private String firstName = "";
    private String lastName = "";
    private String firstNameDir = "";
    private String lastNameDir = "";
    private Set<Worker> workers = new HashSet<>();
    private List<Service> services = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();
    private double salary;
    private Integer vacDur;
    private LocalDateTime startVac;
    private Integer id;
    private String title;
    private double price;
    private Department department;

    Company company = new Company();

    @Override
    public void startDocument() throws SAXException {
        LOGGER.info("Parsing is started");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        element = qName;
        switch (element) {
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
        switch (element) {
            case "departments":
                department.setServices(services);
                departments.add(department);
                company.setDepartments(departments);
                break;
            case "worker":
                Worker worker = new Worker(id, firstName, lastName, salary);
                worker.setAverageSalary(salary);
                worker.setVacationDuration(vacDur);
                worker.setStartVacation(startVac);
                workers.add(worker);
                break;
            case "workers":
                company.setWorkers(workers);
                break;
            case "service":
                Service service = new Service(title, price);
                services.add(service);
                break;
            default:
                break;
        }
        element = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        switch (element) {
            case "company:title":
                company.setTitle(new String(ch, start, length));
                break;
            case "director:firstName":
                firstNameDir = new String(ch, start, length);
                break;
            case "director:lastName":
                lastNameDir = new String(ch, start, length);
                break;
            case "director":
                company.setDirector(new CEO(firstNameDir, lastNameDir));
                break;
            case "worker:firstName":
                firstName = new String(ch, start, length);
                break;
            case "worker:lastName":
                lastName = new String(ch, start, length);
                break;
            case "averageSalary":
                salary = Double.parseDouble(new String(ch, start, length));
                break;
            case "vacationDuration":
                vacDur = Integer.valueOf(new String(ch, start, length));
                break;
            case "startVacation":
                startVac = LocalDateTime.parse(new String(ch, start, length));
                break;
            case "service:title":
                title = new String(ch, start, length);
                break;
            case "price":
                price = Double.parseDouble(new String(ch, start, length));
                break;
            case "department:title":
                department = new Department(new String(ch, start, length));
                break;
            default:
                break;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        LOGGER.info("Parsing is ended");
    }

    @Override
    public Company parse() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        parser.parse(new File("D:\\Git\\git\\company-hierarchy\\src\\main\\resources\\company.xml"), this);
        return company;
    }
}
