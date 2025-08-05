package contactlist;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojoClass.CompanyDetails;
import pojoClass.CompanyPFDeails;
import pojoClass.Contractors;
import pojoClass.Employee;

import java.util.ArrayList;
import java.util.List;

public class Company {
    @Test
    public void createNestedPojo() throws JsonProcessingException {

        CompanyDetails company=new CompanyDetails();
        company.setCompanyName("");
        company.setCompanyId("");
        company.setSASNO("");

        Employee employee=new Employee();
        //list 1
        employee.setFirstName("");
        employee.setLastName("");
        employee.setEmail("");
        employee.setEmployeeId("");
        employee.setDestination("");

        //list 2
        Employee employee1=new Employee();
        employee1.setFirstName("");
        employee1.setLastName("");
        employee1.setEmail("");
        employee1.setEmployeeId("");
        employee1.setDestination("");

        List<Employee>listEmp=new ArrayList<Employee>();
        listEmp.add(employee);
        listEmp.add(employee1);

        company.setEmployees(listEmp);

        //Contractors
        Contractors contractEmp=new Contractors();

        //list 1
        contractEmp.setFirstName("");
        contractEmp.setLastName("");
        contractEmp.setEmail("");
        contractEmp.setDestination("");
        contractEmp.setContractMonth("");

        Contractors contractEmp2=new Contractors();
        //list 2
        contractEmp2.setFirstName("");
        contractEmp2.setLastName("");
        contractEmp2.setEmail("");
        contractEmp2.setDestination("");
        contractEmp2.setContractMonth("");

        //convert to array list

        List<Contractors>listcont=new ArrayList<Contractors>();
        listcont.add(contractEmp);
        listcont.add(contractEmp2);
        //set the consolated lsit in the nestedpojo class
        company.setContractors(listcont);

        //pfDetails
        CompanyPFDeails pf=new CompanyPFDeails();
        pf.setNoOfEmployee("");
        pf.setPfNumber("");
        pf.setYear("");
        company.setPfdetails(pf);

        ObjectMapper pojo=new ObjectMapper();
        String nestPojo = pojo.writerWithDefaultPrettyPrinter().writeValueAsString(company);
        System.out.println(nestPojo);


    }

}
