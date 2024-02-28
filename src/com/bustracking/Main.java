package com.bustracking;
import java.util.*;
public class Main {
    public static void main(String[]args)
    {
        String password;
        String mobile;
        String emailid;
        Scanner s=new Scanner(System.in);
        Newuserintrf name=new Newuserimpl();
        System.out.println();
        System.out.println("<~~~~~~~~~* Welcome to Bustracking System!!!! *~~~~~~~~~>");
        System.out.println();
        do{
            System.out.println("""
                    Press
                    *********
                    
                    0 -> New user
                    1 -> Login
                    2 -> Delete existing user
                    3 -> Update the user password
                    9 -> Exit the application
                    """);
            System.out.print("Enter a choice : ");
            int ch=s.nextInt();
            switch(ch) {
                case 0:
                    String x;
                    System.out.println("*******************");
                    System.out.println();
                    Newuser now = new Newuser();
                    do {
                        System.out.println("Enter mobile : ");
                        mobile = s.next();
                        x = name.createuser(mobile);
                        if(x.equals("true")) {
                            System.out.println();
                            System.out.println("<~~~~~~~~~* Mobile number already exists * Please enter another mobile *~~~~~~~~~>");
                            System.out.println();
                        }
                    }while(x.equals("true"));
                    do {
                        System.out.println("Enter emailid you wanna register : ");
                        emailid = s.next();
                        x=name.validcreateuser(emailid);
                        if(x.equals("true")) {
                            System.out.println();
                            System.out.println("<~~~~~~~~~* Emailid already exists * Please enter another emailid *~~~~~~~~~>");
                            System.out.println();
                        }
                    }while(x.equals("true"));
                    System.out.println("Enter your password : ");
                    password = s.next();
                    now.setMobile(mobile);
                    now.setEmailid(emailid);
                    now.setPassword(password);
                    name.createuser(now);
                    break;
                case 3:
                    System.out.println("*******************");
                    System.out.println();
                    String z;
                    do {
                        System.out.println("Enter your mobile : ");
                        mobile = s.next();
                        z=name.updatepassword(mobile);
                        if(z.equals("false"))
                        {
                            System.out.println();
                            System.out.println("<~~~~~~~~~* ****Enter a valid mobile**** *~~~~~~~~~>");
                            System.out.println();
                        }
                    }while(z.equals("false"));
                    System.out.println("Enter your new password : ");
                    String newpassword = s.next();
                    name.updatepassword(mobile, newpassword);
                    break;
                case 2:
                    System.out.println("*******************");
                    System.out.println();
                    System.out.println("Enter the mobile to delete : ");
                    mobile = s.next();
                    System.out.println("Enter your current password : ");
                    String currentpassword=s.next();
                    name.deleteuser(mobile,currentpassword);
                    break;
                case 1:
                    System.out.println("*******************");
                    System.out.println();
                    String loginmail;
                    Userlogin mail = new Userlogin();
                    String correctmail;
                    do {
                        System.out.println("Enter your login emailid : ");
                        loginmail = s.next();
                        correctmail = mail.correctemailid(loginmail);
                        if(correctmail.equals("false")) {
                            System.out.println();
                            System.out.println("<~~~~~~~~~* ****USER MISMATCH (Enter a valid emailid)**** *~~~~~~~~~>");
                            System.out.println();
                        }
                    } while (correctmail.equals("false"));
                    String loginpassword = mail.userlogin(loginmail);
                    String passwordlogin;
                    do{
                        System.out.println("Enter your login password : ");
                        passwordlogin = s.next();
                        if(!passwordlogin.equals(loginpassword))
                        {
                            System.out.println();
                            System.out.println("<~~~~~~~~~* ****LOGIN INVALID (Your password is incorrect)**** *~~~~~~~~~>");
                            System.out.println();
                        }
                    }while(!passwordlogin.equals(loginpassword));
                    System.out.println();
                    System.out.println("<~~~~~~~~~* !!!!Login Successfull!!!!! *~~~~~~~~~>");
                    System.out.println();
                        Busdetails bus = new Busdetails();
                        int n;
                        do{
                        System.out.println("Enter the bus stop name : ");
                        String b = s.next();
                        System.out.println();
                        bus.getbusdetails(b);
                            System.out.println("*** Enter any other number to continue search ***");
                            System.out.println("*** Enter 9 to log out ***");
                            System.out.println();
                            System.out.print("Enter your choice : ");
                            n=s.nextInt();
                            System.out.println("*******************");
                            System.out.println();
                        }
                        while(n!=9);
                    System.out.println();
                    System.out.println("<~~~~~~~~~* !!!!Logout Successfull!!!!! *~~~~~~~~~>");
                    System.out.println();
                    break;
                case 9:
                    System.out.println();
                    System.out.println("<~~~~~~~~~* !!!! Thank you !!!!! *~~~~~~~~~>");
                    System.exit(0);
                    break;
                default:
                    System.out.println();
                    System.out.println("<**** Enter a valid choice(0 or 1 or 2 or 3 or 9) ****>");
                    System.out.println();

            }
        }
        while(true);
    }

}
