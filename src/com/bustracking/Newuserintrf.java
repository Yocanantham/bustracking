package com.bustracking;

public interface Newuserintrf
{
     //create user
     String createuser(String mobile);
    String validcreateuser(String emailid);
    void createuser(Newuser now);
    //update password
    String updatepassword(String mobile);
    void updatepassword(String mobile, String newpassword);
//delete password
void deleteuser(String mobile, String currentpassword);

}
