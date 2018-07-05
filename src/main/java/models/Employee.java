package models;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {

    private int id;
    private String name;
    private String nI;
    private int salary;

    public Employee(){

    }

    public Employee(String name, String nI, int salary) {
        this.name = name;
        this.nI = nI;
        this.salary = salary;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "national_insurance")
    public String getnI() {
        return nI;
    }

    @Column(name = "salary")
    public int getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setnI(String nI) {
        this.nI = nI;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
