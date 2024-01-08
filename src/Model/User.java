/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Gihan
 */
public class User {
    
    private String EmpId;
    private String fName;
    private String lName;
    private String mobileNo;
    private String email;
    private String username;
    private String password;
    private String userRole;
    private int status;

    public User(String EmpId, String fName, String lName, String mobileNo, String email, String username, String password, String userRole, int status) {
        this.EmpId = EmpId;
        this.fName = fName;
        this.lName = lName;
        this.mobileNo = mobileNo;
        this.email = email;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.status = status;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String EmpId) {
        this.EmpId = EmpId;
    }
            
    public String getEmpId() {
        return EmpId;
    }

    public void setEmpId(String EmpId) {
        this.EmpId = EmpId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
}
