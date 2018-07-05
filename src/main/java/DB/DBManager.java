package DB;

import models.*;
import DB.*;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBManager {

    private static Session session;

    public static List<Employee> getEmployeesOfManger(Manager manager) {
        session = db.HibernateUtil.getSessionFactory().openSession();
        List<Employee> results = null;
        try {
            Criteria cr = session.createCriteria(Administrator.class);
            cr.add(Restrictions.eq("manager", manager));
            results =  cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static Manager getManagerOfDepartment(Department department) {
        session = db.HibernateUtil.getSessionFactory().openSession();
        Manager result = null;
        try {
            Criteria cr = session.createCriteria(Manager.class);
            cr.add(Restrictions.eq("id", department.getManager().getId()));
            result =  (Manager)cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static Department getDepartmentForManager(Manager manager){
        session = db.HibernateUtil.getSessionFactory().openSession();
        Department result = null;
        try {
            Criteria cr = session.createCriteria(Department.class);
            cr.add(Restrictions.eq("manager", manager));
            result =  (Department)cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
