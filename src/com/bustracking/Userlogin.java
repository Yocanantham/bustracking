package com.bustracking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Userlogin
{
    Connection con;
    public String correctemailid(String loginmail)
    {
        String correct = "false";
        con=Mysqlconnection.createDBconnection();
        String query="select emailid from user where emailid=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,loginmail);
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
    public String userlogin(String loginmail)
    {
          con=Mysqlconnection.createDBconnection();
          String query="select password from user where emailid=?";
          String loginpassword="";
          try{
              PreparedStatement pstm=con.prepareStatement(query);
              pstm.setString(1,loginmail);
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

}
