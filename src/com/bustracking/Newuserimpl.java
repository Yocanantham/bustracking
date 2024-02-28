package com.bustracking;

import java.sql.*;

public class Newuserimpl implements Newuserintrf
{
Connection con;
    @Override
    public void createuser(Newuser now) {
        con=Mysqlconnection.createDBconnection();
        String query="insert into user values(?,?,?)";
        try {
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,now.getMobile());
            pstm.setString(2,now.getEmailid());
            pstm.setString(3,now.getPassword());
            int count=pstm.executeUpdate();
            if(count!=0) {
                System.out.println();
                System.out.println("<~~~~~~~~~* !!!!User Creation Successfull!!!! *~~~~~~~~~>");
                System.out.println();
            }
        }
        catch (SQLIntegrityConstraintViolationException e) {
            System.out.println();
            System.out.println("<~~~~~~~~~* Mobile number already exists * Please enter correct mobile *~~~~~~~~~>");
            System.out.println();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String updatepassword(String mobile)
    {
        String validmobile="false";
        con=Mysqlconnection.createDBconnection();
        String query="select mobile from user where mobile=?";
        try {
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,mobile);
            ResultSet result= pstm.executeQuery();
            if (result.next())
            {
                validmobile = "true";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validmobile;
    }

//
    @Override
    public void updatepassword(String mobile, String newpassword) {
        con=Mysqlconnection.createDBconnection();
        String query="update user set password=? where mobile=?";
        try {
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,newpassword);
            pstm.setString(2,mobile);
            int count= pstm.executeUpdate();
            if(count!=0) {
                System.out.println();
                System.out.println("<~~~~~~~~~* !!!!Password Change Successfull!!!! *~~~~~~~~~>");
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteuser(String mobile,String currentpassword) {
        con=Mysqlconnection.createDBconnection();
        String query="delete from user where mobile=? AND password=?";
        try {
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,mobile);
            pstm.setString(2,currentpassword);
            int count=pstm.executeUpdate();
            if(count!=0)
            {
                System.out.println();
                System.out.println("<~~~~~~~~~* User Deletion Successfull!!!! *~~~~~~~~~>");
                System.out.println();
            }
            else{
                System.out.println();
                System.out.println("<~~~~~~~~~* ****Either mobile (or) password is incorrect**** *~~~~~~~~~>");
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
