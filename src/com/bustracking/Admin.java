package com.bustracking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {
    Connection con;


    public void admin(String adminid, String adminpassword) {
        do{
            con = Mysqlconnection.createDBconnection();
            String now="select COUNT(mobile) from user";
            try {
                PreparedStatement pstm= con.prepareStatement(now);
                ResultSet result= pstm.executeQuery();
               while(result.next())
                {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Total no registered users till now : " + result.getInt(1));
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            String query = "select mobile, emailid from user";
            System.out.println("+----------------------+--------------------------------+");
            System.out.format("| %-20s | %-30s |\n", "MOBILE", "EMAILID");
            System.out.println("+----------------------+--------------------------------+");
            try {
                PreparedStatement pstm = con.prepareStatement(query);
                ResultSet result = pstm.executeQuery();
                while (result.next()) {
                    System.out.format("| %-20s | %-30s |\n",
                            result.getString(1),
                            result.getString(2));
                    System.out.println("+----------------------+--------------------------------+");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }while(!adminid.equals("admin123") || !adminpassword.equals("ADMIN123"));
//        else
//        {
//            System.out.println("Invalid Admin");
//        }
    }
}
