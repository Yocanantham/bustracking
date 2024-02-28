package com.bustracking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Busdetails
{
     Connection con;



//    @Override
    public void getbusdetails(String b) {
        con=Mysqlconnection.createDBconnection();
        String query="select busname,busroute, "+b+" from busdetails where "+b+" IS NOT NULL";
        System.out.println("+----------------------+--------------------------------+--------------------------------+");
        b=b.toUpperCase();
        System.out.format("| %-20s | %-30s | %-30s |\n", "BUSNAME", "BUSROUTE", b);
        System.out.println("+----------------------+--------------------------------+--------------------------------+");
        try {
            PreparedStatement pstm=con.prepareStatement(query);
            ResultSet result= pstm.executeQuery();
            while(result.next())
            {
                System.out.format("| %-20s | %-30s | %-30s |\n", result.getString(1),
                        result.getString(2),
                        result.getString(3));
                System.out.println("+----------------------+--------------------------------+--------------------------------+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
    }
}
