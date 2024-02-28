package com.bustracking;

public class Newuser
{
    private String mobile;
    private String emailid;

    private String password;
    public Newuser()
    {

    }
    public Newuser(String mobile, String emailid, String password) {
        this.mobile = mobile;
        this.emailid = emailid;
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Newuser{" +
                "mobile=" + mobile +
                ", emailid='" + emailid + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
