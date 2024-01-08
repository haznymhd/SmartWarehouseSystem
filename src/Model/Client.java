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
public class Client {

    private String clientCode;
    private String clientName;
    private String no;
    private String street;
    private String city;
    private String email;
    private String fax;
    private String contactNo;
    private String firstName;
    private String lastName;
    private String mobileNo;
    private String registerPerson;
    private String registerDate;
    private String updatePerson;
    private String updateDate;
    private int clientStatus;

    
    public Client(String clientName) {
        this.clientName = clientName;
    }
    
       public Client(String clientCode, String clientName, String no, String street, String city, String email, String fax, String contactNo, String firstName, String lastName, String mobileNo) {
        this.clientCode = clientCode;
        this.clientName = clientName;
        this.no = no;
        this.street = street;
        this.city = city;
        this.email = email;
        this.fax = fax;
        this.contactNo = contactNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNo = mobileNo;
    }
       

      public Client(String clientCode, String clientName, String no, String street, String city, String email, String fax, String contactNo, String firstName, String lastName, String mobileNo, String registerPerson, String registerDate, int clientStatus) {
        this.clientCode = clientCode;
        this.clientName = clientName;
        this.no = no;
        this.street = street;
        this.city = city;
        this.email = email;
        this.fax = fax;
        this.contactNo = contactNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNo = mobileNo;
        this.registerPerson = registerPerson;
        this.registerDate = registerDate;
        this.clientStatus = clientStatus;
    }
    
    public Client() {
    }

    public Client(String clientCode, String clientName, String no, String street, String city, String email, String fax, String contactNo, String firstName, String lastName, String mobileNo, String updatePerson, String updateDate) {
        this.clientCode = clientCode;
        this.clientName = clientName;
        this.no = no;
        this.street = street;
        this.city = city;
        this.email = email;
        this.fax = fax;
        this.contactNo = contactNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNo = mobileNo;
        this.updatePerson = updatePerson;
        this.updateDate = updateDate;
    }
    
    

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    
    

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getRegisterPerson() {
        return registerPerson;
    }

    public void setRegisterPerson(String registerPerson) {
        this.registerPerson = registerPerson;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public int getClientStatus() {
        return clientStatus;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    
    public void setClientStatus(int clientStatus) {
        this.clientStatus = clientStatus;
    }

}
