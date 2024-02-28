package com.bustracking;

public interface Newuserintrf
{
     //create user
    public void createuser(Newuser now);
    //update password
    public String updatepassword(String mobile);
    public void updatepassword(String mobile,String newpassword);
//delete password
    public void deleteuser(String mobile,String currentpassword);

}
