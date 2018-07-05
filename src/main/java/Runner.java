import DB.DBManager;
import models.Administrator;
import models.Department;
import models.Employee;
import models.Manager;

import java.util.List;
import DB.*;

public class Runner {

    public static void main(String[] args) {

        Manager manager = new Manager("Craig", "example132", 50000,2000);
        DBHelper.save(manager);

        Administrator administrator1 = new Administrator("Bob", "example123", 16000, manager);
        DBHelper.save(administrator1);

        Administrator administrator2 = new Administrator("Jen", "example432", 18000, manager);
        DBHelper.save(administrator2);

        Department department = new Department("IT", manager);
        DBHelper.save(department);

        List<Employee> allEmployees = DBHelper.getAll(Employee.class);
        List<Manager> managers = DBHelper.getAll(Manager.class);
        List<Administrator> administrators = DBHelper.getAll(Administrator.class);
        List<Department> departments = DBHelper.getAll(Department.class);

        List<Employee> departmentEmployees = DBManager.getEmployeesOfManger(manager);

        Manager departmentManager = DBManager.getManagerOfDepartment(department);

        Department managerDepartment = DBManager.getDepartmentForManager(manager);
    }

}
