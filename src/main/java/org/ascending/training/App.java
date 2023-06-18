package org.ascending.training;

import org.ascending.training.model.Department;
import org.ascending.training.repository.DepartmentDao;

import java.util.List;

public class App {
    public static void main(String[] args) {
        DepartmentDao departmentDao = new DepartmentDao();
        List<Department> departments = departmentDao.getDepartments();
        System.out.format("List department %s", departments);
    }
}
