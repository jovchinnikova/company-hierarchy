package com.solvd.companyhierarchy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class XMLHandler extends DefaultHandler {

    private static final Logger LOGGER = LogManager.getLogger(XMLHandler.class);

    private String element = "";
    private String firstName = "";
    private String lastName = "";
    private String firstNameDir = "";
    private String lastNameDir = "";
    Set<Worker> workers  = new HashSet<>();
    List<Service> services = new ArrayList<>();
    List<Department> departments = new ArrayList<>();
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
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException{
        element = qName;
        switch(element) {
            case "company":
                int phoneNumber = Integer.parseInt(atts.getValue("phoneNumber"));
                String site = atts.getValue("site");
                company.setPhoneNumber(phoneNumber);
                company.setSite(site);
                break;
            case "worker":
                Integer id = Integer.valueOf(atts.getValue("id"));
                this.id = id;
                Worker worker = new Worker(id, firstName, lastName, salary);
                worker.setAverageSalary(salary);
                worker.setVacationDuration(vacDur);
                worker.setStartVacation(startVac);
                workers.add(worker);
                break;
            case "workers":
                company.setWorkers(workers);
            case "service":
                Service service = new Service(title, price);
                services.add(service);
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException{
        if(element.equals("departments")){
                department.setServices(services);
                departments.add(department);
                company.setDepartments(departments);
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
        }
    }

    @Override
    public void endDocument() throws SAXException{
        LOGGER.info("Parsing is ended");
    }
}
