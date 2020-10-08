package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BasicSalaryDao extends DBConnection {
    public static int getBasicSalary(){
        int basicSalary=0;
        try {
            Connection conection = DBConnection.getConnection();
            String sql="SELECT * FROM salary";
            PreparedStatement p = conection.prepareStatement(sql);
            ResultSet rs = p.executeQuery();

            if(rs.next()) {

                basicSalary= (rs.getInt(2));

            }


            conection.close();

        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return basicSalary;
    }
}
