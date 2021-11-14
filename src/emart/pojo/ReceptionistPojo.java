/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.pojo;

/**
 *
 * @author KRATI VAISHNAO
 */
public class ReceptionistPojo {

    public ReceptionistPojo()
    {
        
    }
    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public ReceptionistPojo(String empid, String empname, String userid, String job, double salary) {
        this.empid = empid;
        this.empname = empname;
        this.userid = userid;
        this.job = job;
        this.salary = salary;
    }
    private String empid;
    private String empname;
    private String userid;
    private String job;
    private double salary;
}
