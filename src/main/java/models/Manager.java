package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "managers")
public class Manager extends Employee {

    private int budget;
    private Department department;
    private List<Administrator> employees;

    public Manager(){

    }

    public Manager(String name, String nI, int salary, int budget) {
        super(name, nI, salary);
        this.budget = budget;
        this.employees = new ArrayList<Administrator>();
    }

    public int getBudget() {
        return budget;
    }

    @OneToOne(mappedBy = "manager", fetch = FetchType.LAZY)
    public Department getDepartment() {
        return department;
    }

    @OneToMany(mappedBy="manager", fetch = FetchType.LAZY)
    public List<Administrator> getEmployees() {
        return employees;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setEmployees(List<Administrator> employees) {
        this.employees = employees;
    }
}
