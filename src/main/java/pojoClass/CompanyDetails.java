package pojoClass;

import java.util.List;

public class CompanyDetails {
    private String companyName;
    private String companyId;
    private String SASNO;
    List<Employee> employees;
    List<Contractors> contractors;
    CompanyPFDeails pfdetails;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Contractors> getContractors() {
        return contractors;
    }

    public void setContractors(List<Contractors> contractors) {
        this.contractors = contractors;
    }

    public CompanyPFDeails getPfdetails() {
        return pfdetails;
    }

    public void setPfdetails(CompanyPFDeails pfdetails) {
        this.pfdetails = pfdetails;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getSASNO() {
        return SASNO;
    }

    public void setSASNO(String SASNO) {
        this.SASNO = SASNO;
    }
}

