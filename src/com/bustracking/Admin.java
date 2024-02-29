package com.bustracking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Admin {
    Connection con;
    public String correctadminmailid(String adminid)
    {
        String correct = "false";
        con=Mysqlconnection.createDBconnection();
        String query="select adminid from admin where adminid=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,adminid);
            ResultSet result= pstm.executeQuery();
            if (result.next())
            {
                correct = "true";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return correct;
    }
    public String adminlogin(String adminid)
    {
        con=Mysqlconnection.createDBconnection();
        String query="select adminpassword from admin where adminid=?";
        String loginpassword="";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,adminid);
            ResultSet result= pstm.executeQuery();
            while(result.next())
            {
                loginpassword=result.getString(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginpassword;
    }
    public void admin() {
        con = Mysqlconnection.createDBconnection();
            String now="select COUNT(mobile) from user";
            try {
                PreparedStatement pstm= con.prepareStatement(now);
                ResultSet result= pstm.executeQuery();
               while(result.next())
                {
                    System.out.println();
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
            System.out.println();
    }
}
