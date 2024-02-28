package com.bustracking;
import java.sql.Connection;
import java.sql.DriverManager;

public class Mysqlconnection
{
    static Connection con;
    public static Connection createDBconnection()
    {
        try
        {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/userdb";
            String username="root";
            String password="Qwerty123#";
            con=DriverManager.getConnection(url,username,password);

        }
        catch (Exception e){
        e.printStackTrace();
    }
        return con;
    }
}
