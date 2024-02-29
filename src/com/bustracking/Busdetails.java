package com.bustracking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLSyntaxErrorException;

public class Busdetails {
    Connection con;


    //    @Override
    public void getbusdetails(String b) {
        con = Mysqlconnection.createDBconnection();
        b=b.replaceAll(" ","").toLowerCase();
        String query = "select busname,busroute, " + b + " from busdetails where " + b + " IS NOT NULL";
       try {

            PreparedStatement pstm = con.prepareStatement(query);
            ResultSet result = pstm.executeQuery();
            if(result.next())
            {
                System.out.println("+----------------------+--------------------------------+--------------------------------+");
                b = b.toUpperCase();
                System.out.format("| %-20s | %-30s | %-30s |\n", "BUSNAME", "BUSROUTE", b);
                System.out.println("+----------------------+--------------------------------+--------------------------------+");
            }
            while (result.next()) {

                System.out.format("| %-20s | %-30s | %-30s |\n", result.getString(1),
                        result.getString(2),
                        result.getString(3));
                System.out.println("+----------------------+--------------------------------+--------------------------------+");
            }
        } catch (SQLSyntaxErrorException e) {
            Busdetails busdetails = new Busdetails();
            System.out.println("<~~~~~~~~~* Sorry for the inconvenience we are expanding our service! *~~~~~~~~~>");
            System.out.println("       <~~~~~~~~~* Try searching for the stops mentioned below *~~~~~~~~~>");
            System.out.println();
            busdetails.bustop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
    }

    public void bustop() {
        con = Mysqlconnection.createDBconnection();
        String query = "select * from bustop";
        System.out.println("+------------+--------------------------------+--------------------------------+--------------------------------+--------------------------------+--------------------------------+");
        System.out.format("| %-10s | %-30s | %-30s | %-30s | %-30s | %-30s |\n", "Count", "Sulur Aerodrome - Singanallur", "Singanallur - Ukkadam", "Singanllur - Gandhipuram", "Gandhipuram - Ukkadam", "Gandhipuram - Neelambur");
        System.out.println("+------------+--------------------------------+--------------------------------+--------------------------------+--------------------------------+--------------------------------+");
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            ResultSet result = pstm.executeQuery();
            while (result.next()) {

                System.out.format("| %-10d | %-30s | %-30s | %-30s | %-30s | %-30s |\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6));
                System.out.println("+------------+--------------------------------+--------------------------------+--------------------------------+--------------------------------+--------------------------------+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

