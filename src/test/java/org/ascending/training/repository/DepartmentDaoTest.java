package org.ascending.training.repository;

import static junit.framework.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class DepartmentDaoTest {
    private DepartmentDao departmentDao;

    @Before
    public void setUp() {
        departmentDao = new DepartmentDao();
    }

    @After
    public void tearDown() {
        departmentDao = null;
    }


    @Test
    public void getDepartmentsTest() {
        //DepartmentDao departmentDao = new DepartmentDao();
        assertEquals(0, departmentDao.getDepartments().size());
    }

//    @Test
//    public void getDepartmentsByName() {
//        DepartmentDao departmentDao = new DepartmentDao(); //-> 为了精简，引入before/after
//        departmentDao.getDepartments();
//    }
}
