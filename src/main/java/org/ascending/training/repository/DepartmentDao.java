package org.ascending.training.repository;

import org.ascending.training.model.Department;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DepartmentDao {
    //不管从flyway还是pgadmin还是dao连接数据库都是5大要素
    static final String DBURL = "jdbc:postgresql://localhost:5431/training_db";
    static final String USER = "admin";
    static final String PASS = "Training123!";


    //CRUD
    //retrieve, return type?
    public List<Department> getDepartments() {
        Logger logger = LoggerFactory.getLogger(getClass()); //factory design pattern 创造出logger instance

        //创建空department放数据
        List<Department> departments = new ArrayList<Department>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //Step2: Open a connection
            logger.debug("Connecting to database");
            //System.out.println("Connecting to database"); 打印缺点：耗费cpu, 在production环境中不想打印出来->引入第三方logger library
            conn = DriverManager.getConnection(DBURL, USER, PASS);

            //Step3: Execute a query
            logger.info("Creating statement");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM departments";
            rs = stmt.executeQuery(sql);
            logger.info("Converting database");

            //Step4: Extract data from result set
            while(rs.next()) {
                //retrieve by column name
                 Long id = rs.getLong("id");
                 String name = rs.getString("name");
                 String description = rs.getString("description");
                 String location = rs.getString("location");

                 //fill the object
                Department department = new Department();
                department.setId(id);
                department.setName(name);
                department.setDescription(description);
                department.setLocation(location);
                departments.add(department);
            }

        } catch (SQLException e) { //解释下catch
            e.printStackTrace();
            logger.error("failed to retrieve department ", e);
        } finally { //不管进不进catch 都会执行finally
            //Step6: finally block used to close resources
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return departments;
    }
}
