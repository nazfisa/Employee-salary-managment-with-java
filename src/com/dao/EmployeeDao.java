package com.dao;

import com.domain.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao  {
    //Data Insert into user table
    public static int save(Employee e) {
        int status=0;
        try {
            Connection connection = DBConnection.getConnection();
            String sql="INSERT INTO employee (name,grade,address,mobileNo,bankAccount) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement p = connection.prepareStatement(sql);

            p.setString(1, e.getName());
            p.setInt(2, e.getGrade());
            p.setString(3, e.getAddress());
            p.setString(4, e.getMobileNo());
            p.setString(5, e.getBankAccount());

            status = p.executeUpdate();
            connection.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return status;

    }

    public static List<Employee> getAll(){
        List<Employee> list = new ArrayList<Employee>();
        try {
            Connection conection = DBConnection.getConnection();
            String sql="SELECT * FROM employee";
            PreparedStatement p = conection.prepareStatement(sql);
            ResultSet rs = p.executeQuery();

            while(rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setGrade(rs.getInt(3));
                e.setAddress(rs.getString(4));
                e.setMobileNo(rs.getString(5));

                e.setBankAccount(rs.getString(6));

                list.add(e);


            }
            conection.close();

        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public static int update(Employee e) {
        int status = 0;
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "update employee set name=?,grade=?,address=?,mobileNo=?,bankAccount=? where id=?";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, e.getName());
            p.setInt(2, e.getGrade());
            p.setString(3, e.getAddress());
            p.setString(4, e.getMobileNo());
            p.setString(5, e.getBankAccount());
            p.setInt(6, e.getId());

            status= p.executeUpdate();
            connection.close();

        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    public static int delete(Employee e) {
        int status = 0;
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "DELETE FROM employee WHERE id=?";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, e.getId());
            status = p.executeUpdate();
            connection.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    public static Employee getInfoById(int id) {
        Employee e = new Employee();
        int status =0;
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT * FROM employee WHERE id=?";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet rs = p.executeQuery();
            if(rs.next()) {

                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setGrade(rs.getInt(3));
                e.setAddress(rs.getString(4));
                e.setMobileNo(rs.getString(5));
                e.setBankAccount(rs.getString(6));
            }
            status = p.executeUpdate();
            connection.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return e;

    }
}
