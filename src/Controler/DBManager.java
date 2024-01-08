/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Client;
import Model.Invoice;
import Model.Job;
import Model.User;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gihan
 */
public class DBManager {

    /*
    validate TextField letters only
     */
    public static void textFieldLettersOnly(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_ENTER
                || c == KeyEvent.VK_SPACE || c == KeyEvent.VK_PERIOD)) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }

    /*
    validate TextField numbers only
     */
    public static void textFieldNumberOnly(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!(c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_ENTER || c == KeyEvent.VK_SPACE || (c >= '0' && c <= '9'))) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }

    /*
    Validate TextField telephone number
     */
    public static boolean textFieldTelephoneNumber(String telephoneNo) {
        return telephoneNo.length() == 10 && telephoneNo.matches("^\\d{10}$");
    }

    /*
    Validate TextField email address
     */
    public static boolean textFieldEmailAddress(String email) {

        return email.matches("^(.+)@(.+)$");
    }

    /*
    check the user existence by user user_id
     */
    public boolean checkUserExistence(User checkUser) {
        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tbl_user where user_id = '" + checkUser.getEmpId() + "'");
            if (rs.next()) {
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return false;
    }

    /*
    save new user informataion
     */
    public boolean insertNewUser(User user) {
        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();
        try {

            PreparedStatement stmt = con.prepareStatement("insert into tbl_user(user_id, f_name, l_name, mobile_no, email, username, password, user_role, status) "
                    + "values(?,?,?,?,?,?,?,?,?)");

            stmt.setString(1, user.getEmpId());
            stmt.setString(2, user.getfName());
            stmt.setString(3, user.getlName());
            stmt.setString(4, user.getMobileNo());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, user.getUsername());
            stmt.setString(7, user.getPassword());
            stmt.setString(8, user.getUserRole());
            stmt.setInt(9, user.getStatus());

            stmt.execute();
            con.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return false;
    }

    /*
    indentify the loged in user
     */
    public static String userName;
    public static String userRole;

    /*
    check user authentication by username & password
    If the given name and password have a existing user
    then return true
    otherwise return false
     */
    public boolean checkUser(User user) {
        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tbl_user where username = '" + user.getUsername() + "' and password = '" + user.getPassword() + "'");
            if (rs.next()) {

                userName = rs.getString("f_name") + " " + rs.getString("l_name");
                userRole = rs.getString("user_role");

                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return false;
    }

    /*
    Search user details by user_id
     */
    public User searchUser(User user) {
        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();

        User u = null;
        try {

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from tbl_user where user_id = '" + user.getEmpId() + "'");
            if (rs.next()) {

                u = new User(rs.getString("user_id"), rs.getString("f_name"), rs.getString("l_name"), rs.getString("mobile_no"), rs.getString("email"),
                        rs.getString("username"), rs.getString("password"), rs.getString("user_role"), rs.getInt("status"));
                return u;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return u;
    }

    /*
    update user information by the user_idF
     */
    public boolean updateUser(User user) {

        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();
        try {

            PreparedStatement stmt = con.prepareStatement("update tbl_user set f_name = ?, l_name = ?, mobile_no = ?, email = ?, username = ?, password = ?,"
                    + " user_role = ?, status = ? where user_id = ?");

            stmt.setString(1, user.getfName());
            stmt.setString(2, user.getlName());
            stmt.setString(3, user.getMobileNo());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getUsername());
            stmt.setString(6, user.getPassword());
            stmt.setString(7, user.getUserRole());
            stmt.setInt(8, user.getStatus());
            stmt.setString(9, user.getEmpId());

            stmt.execute();
            con.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return false;
    }

    /*
    remove the user information by user_id
     */
    public boolean removeUser(User user) {
        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();

        try {

            PreparedStatement stmt = con.prepareStatement("delete from tbl_user where user_id = ?");
            stmt.setString(1, user.getEmpId());

            stmt.execute();
            con.close();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return false;
    }

    /*
    New client code generate using last client code in the database
     */
    public String getNewClientCode() {
        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();

        int parsInt;
        String newClientCode = "C0001";
        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(client_code) as client_code from  tbl_client");
            rs.next();

            if (rs.getString("client_code") == null) {

                newClientCode = "C0001";

            } else {

                parsInt = Integer.parseInt(rs.getString("client_code").substring(1, 5));
                parsInt++;

                if (parsInt >= 100 && parsInt < 1000) {

                    newClientCode = "C0" + parsInt;
                } else if (parsInt >= 10 && parsInt < 100) {
                    newClientCode = "C00" + parsInt;
                } else if (parsInt < 10) {
                    newClientCode = "C000" + parsInt;
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return newClientCode;
    }

    /*
    register New client details
     */
    public static boolean registerClient(Client client) {

        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();

        try {

            PreparedStatement stmt = con.prepareStatement("insert into tbl_client(client_code, client_name, no, street, city, email, contact_no, fax_no, "
                    + "first_name, last_name, mobile_no, register_person, register_date, client_status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            stmt.setString(1, client.getClientCode());
            stmt.setString(2, client.getClientName());
            stmt.setString(3, client.getNo());
            stmt.setString(4, client.getStreet());
            stmt.setString(5, client.getCity());
            stmt.setString(6, client.getEmail());
            stmt.setString(7, client.getContactNo());
            stmt.setString(8, client.getFax());
            stmt.setString(9, client.getFirstName());
            stmt.setString(10, client.getLastName());
            stmt.setString(11, client.getMobileNo());
            stmt.setString(12, client.getRegisterPerson());
            stmt.setString(13, client.getRegisterDate());
            stmt.setInt(14, client.getClientStatus());

            stmt.execute();
            con.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return false;

    }

    public ArrayList<Client> getClientsByClientName(Client client) {

        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();

        ArrayList<Client> clientArray = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from  tbl_client where client_name like '%" + client.getClientName() + "%'");
            while (rs.next()) {

                client = new Client();

                client.setClientCode(rs.getString("client_code"));
                client.setClientName(rs.getString("client_name"));
                client.setNo(rs.getString("no"));
                client.setStreet(rs.getString("street"));
                client.setCity(rs.getString("city"));
                client.setRegisterPerson(rs.getString("register_person"));
                clientArray.add(client);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return clientArray;
    }

    public Client searchClientByClientCode(Client client) {

        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();

        Client c = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tbl_client where client_code = '" + client.getClientCode() + "' ");
            if (rs.next()) {

                c = new Client(rs.getString("client_code"), rs.getString("client_name"), rs.getString("no"), rs.getString("street"), rs.getString("city"), rs.getString("email"),
                        rs.getString("contact_no"), rs.getString("fax_no"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("mobile_no"));
                return c;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return c;
    }

    /*
    Search client details by using client name
     */
    public Client searchClientByClientName(Client client) {

        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();

        Client c = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tbl_client where client_name = '" + client.getClientName() + "'");
            if (rs.next()) {

                c = new Client(rs.getString("client_code"), rs.getString("client_name"), rs.getString("no"), rs.getString("street"), rs.getString("city"), rs.getString("email"),
                        rs.getString("contact_no"), rs.getString("fax_no"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("mobile_no"));
                return c;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return c;
    }

    /*
    get all client details in the client table
     */
    public ArrayList<Client> getAllClientDetails() {
        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();

        ArrayList<Client> clientArray = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from  tbl_client");
            while (rs.next()) {

                Client client = new Client();

                client.setClientCode(rs.getString("client_code"));
                client.setClientName(rs.getString("client_name"));
                client.setNo(rs.getString("no"));
                client.setStreet(rs.getString("street"));
                client.setCity(rs.getString("city"));
                client.setEmail(rs.getString("email"));
                client.setContactNo(rs.getString("contact_no"));
                client.setFirstName(rs.getString("first_name"));
                client.setLastName(rs.getString("last_name"));
                client.setMobileNo(rs.getString("mobile_no"));
                client.setRegisterPerson(rs.getString("register_person"));
                clientArray.add(client);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return clientArray;

    }

    public static boolean updateClient(Client client) {
        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();
        try {

            PreparedStatement stmt = con.prepareStatement("UPDATE tbl_client SET client_name = ?, no = ?, street = ?, city = ?, email = ?, contact_no = ?, fax_no = ?, "
                    + "first_name = ?, last_name = ?, mobile_no = ?, update_person = ?, update_date = ? WHERE (client_code = ?)");

            stmt.setString(1, client.getClientName());
            stmt.setString(2, client.getNo());
            stmt.setString(3, client.getStreet());
            stmt.setString(4, client.getCity());
            stmt.setString(5, client.getEmail());
            stmt.setString(6, client.getContactNo());
            stmt.setString(7, client.getFax());
            stmt.setString(8, client.getFirstName());
            stmt.setString(9, client.getLastName());
            stmt.setString(10, client.getMobileNo());
            stmt.setString(11, client.getUpdatePerson());
            stmt.setString(12, client.getUpdateDate());
            stmt.setString(13, client.getClientCode());

            stmt.execute();
            con.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return false;
    }

    public int getNumberOfDays(int fromDate, int toDate) {

        int days = (toDate - fromDate) / (1000 * 60 * 60 * 24);
        return days;

    }

    public double getSqFtArea(double sqFeetArea) {

        double rate = 0.0;

        if (sqFeetArea == 1000.00) {
            rate = 10000.0;
        } else if (sqFeetArea == 500.00) {
            rate = 5000.0;
        }
        return rate;
    }

    public boolean InsertNewJob(Job job) {

        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement("insert into tbl_job(job_id, client_code, job_date, billing_month, tax_no, sub_total, discount, net_val, job_status) values(?,?,?,?,?,?,?,?,?)");

            stmt.setString(1, job.getJobId());
            stmt.setString(2, job.getClientCode());
            stmt.setString(3, job.getJobDate());
            stmt.setString(4, job.getBillingMonth());
            stmt.setString(5, job.getTaxNo());
            stmt.setDouble(6, job.getSubTotal());
            stmt.setDouble(7, job.getDiscount());
            stmt.setDouble(8, job.getNetValue());
            stmt.setInt(9, job.getJobStatus());

            stmt.execute();
            con.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return false;
    }

    public void insertNewItem(Job itemJob) {

        DBConnector dbConnection = new DBConnector();
        Connection con = dbConnection.getConnection();

        try {

            PreparedStatement statement = con.prepareStatement("Insert into tbl_item (job_id, product_category, product_details, sq_ft_area, units, rate, from_date, to_date, days, total) values (?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1, itemJob.getJobId());
            statement.setString(2, itemJob.getProductCategory());
            statement.setString(3, itemJob.getProductDetail());
            statement.setDouble(4, itemJob.getSqFeetArea());
            statement.setInt(5, itemJob.getUnits());
            statement.setDouble(6, itemJob.getRate());
            statement.setString(7, itemJob.getFromDate());
            statement.setString(8, itemJob.getToDate());
            statement.setInt(9, itemJob.getNoOfDays());
            statement.setDouble(10, itemJob.getItemTotal());

            statement.execute();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
    }

    public Invoice generateInvoice(Invoice invoice) {

        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();

        Invoice inv = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select tbl_job.*, tbl_client.* from tbl_job inner join tbl_client on tbl_job.client_code = tbl_client.client_code where tbl_job.job_id = '" + invoice.getJobId() + "'");
            if (rs.next()) {

                invoice.setJobId(rs.getString("tbl_job.job_id"));
                invoice.setBillingMonth(rs.getString("tbl_job.billing_month"));
                invoice.setClientCode(rs.getString("tbl_job.client_code"));
                invoice.setJobDate(rs.getString("tbl_job.job_date"));
                invoice.setTaxNo(rs.getString("tbl_job.tax_no"));
                invoice.setSubTotal(rs.getDouble("tbl_job.sub_total"));
                invoice.setDiscount(rs.getDouble("tbl_job.discount"));
                invoice.setNetValue(rs.getDouble("tbl_job.net_val"));

                invoice.setClientName(rs.getString("tbl_client.client_name"));
                invoice.setFirstName(rs.getString("tbl_client.first_name"));
                invoice.setLastName(rs.getString("tbl_client.last_name"));
                invoice.setNo(rs.getString("tbl_client.no"));
                invoice.setStreet(rs.getString("tbl_client.street"));
                invoice.setCity(rs.getString("tbl_client.city"));
                invoice.setMobileNo(rs.getString("tbl_client.mobile_no"));

                inv = invoice;
                return inv;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return inv;
    }

    public ArrayList<Invoice> generateJobItems(Invoice invoice) {

        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();

        ArrayList<Invoice> InvoiceItemList = new ArrayList<Invoice>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tbl_item where job_id = '" + invoice.getJobId() + "'");
            while (rs.next()) {

                Invoice inv = new Invoice();

                inv.setProductCategory(rs.getString("product_category"));
                inv.setProductDetail(rs.getString("product_details"));
                inv.setSqFeetArea(rs.getDouble("sq_ft_area"));
                inv.setRate(rs.getDouble("rate"));
                inv.setUnits(rs.getInt("units"));
                inv.setFromDate(rs.getString("from_date"));
                inv.setToDate(rs.getString("to_date"));
                inv.setNoOfDays(rs.getInt("days"));
                inv.setItemTotal(rs.getDouble("total"));

                InvoiceItemList.add(inv);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return InvoiceItemList;
    }

    public ArrayList<Invoice> getAllActiveJobs() {

        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();

        ArrayList<Invoice> JobList = new ArrayList<Invoice>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select tbl_job.*, tbl_client.* from tbl_job inner join tbl_client on tbl_job.client_code = tbl_client.client_code where tbl_job.job_status = '1'");
            while (rs.next()) {

                Invoice inv = new Invoice();

                inv.setJobId(rs.getString("tbl_job.job_id"));
                inv.setClientName(rs.getString("tbl_client.client_name"));
                inv.setFirstName(rs.getString("tbl_client.first_name"));
                inv.setLastName(rs.getString("tbl_client.last_name"));
                inv.setJobDate(rs.getString("tbl_job.job_date"));
                inv.setBillingMonth(rs.getString("tbl_job.billing_month"));
                inv.setSubTotal(rs.getDouble("tbl_job.sub_total"));
                inv.setDiscount(rs.getDouble("tbl_job.discount"));
                inv.setNetValue(rs.getDouble("tbl_job.net_val"));

                JobList.add(inv);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return JobList;
    }

    public boolean closeJob(Job job) {

        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement("update tbl_job set close_date = ?, job_status = ? where job_id = ?");

            stmt.setString(1, job.getClseDate());
            stmt.setInt(2, job.getJobStatus());
            stmt.setString(3, job.getJobId());

            stmt.execute();
            con.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return false;
    }

    public boolean updateJob(Job job) {
        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE tbl_job SET client_code = ?, job_date = ?, billing_month = ?, tax_no = ?, sub_total = ?, discount = ?, net_val = ? WHERE (job_id = ?)");

            stmt.setString(1, job.getClientCode());
            stmt.setString(2, job.getJobDate());
            stmt.setString(3, job.getBillingMonth());
            stmt.setString(4, job.getTaxNo());
            stmt.setDouble(5, job.getSubTotal());
            stmt.setDouble(6, job.getDiscount());
            stmt.setDouble(7, job.getNetValue());
            stmt.setString(8, job.getJobId());

            stmt.execute();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delateItemDetailsByJobId(Job job) {
        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();

        try {

            PreparedStatement stmt = con.prepareStatement("delete from tbl_item where job_id = ?");
            stmt.setString(1, job.getJobId());

            stmt.execute();
            con.close();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return false;
    }

    public ArrayList<Invoice> getAllJobs() {

        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();

        ArrayList<Invoice> JobList = new ArrayList<Invoice>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select tbl_job.*, tbl_client.* from tbl_job inner join tbl_client on tbl_job.client_code = tbl_client.client_code ");
            while (rs.next()) {

                Invoice inv = new Invoice();

                inv.setJobId(rs.getString("tbl_job.job_id"));
                inv.setClientName(rs.getString("tbl_client.client_name"));
                inv.setFirstName(rs.getString("tbl_client.first_name"));
                inv.setLastName(rs.getString("tbl_client.last_name"));
                inv.setJobDate(rs.getString("tbl_job.job_date"));
                inv.setBillingMonth(rs.getString("tbl_job.billing_month"));
                inv.setSubTotal(rs.getDouble("tbl_job.sub_total"));
                inv.setDiscount(rs.getDouble("tbl_job.discount"));
                inv.setNetValue(rs.getDouble("tbl_job.net_val"));
                inv.setJobStatus(rs.getInt("tbl_job.job_status"));

                JobList.add(inv);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return JobList;
    }

    public ArrayList<Invoice> searchJobsByDateRange(Invoice invoice) {
        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();

        ArrayList<Invoice> JobList = new ArrayList<Invoice>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select tbl_job.*, tbl_client.* from tbl_job inner join tbl_client on tbl_job.client_code = tbl_client.client_code where job_date between '" + invoice.getFromDate() + "' and '" + invoice.getToDate() + "'");
            while (rs.next()) {

                Invoice inv = new Invoice();

                inv.setJobId(rs.getString("tbl_job.job_id"));
                inv.setClientName(rs.getString("tbl_client.client_name"));
                inv.setFirstName(rs.getString("tbl_client.first_name"));
                inv.setLastName(rs.getString("tbl_client.last_name"));
                inv.setJobDate(rs.getString("tbl_job.job_date"));
                inv.setBillingMonth(rs.getString("tbl_job.billing_month"));
                inv.setSubTotal(rs.getDouble("tbl_job.sub_total"));
                inv.setDiscount(rs.getDouble("tbl_job.discount"));
                inv.setNetValue(rs.getDouble("tbl_job.net_val"));
                inv.setJobStatus(rs.getInt("tbl_job.job_status"));

                JobList.add(inv);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return JobList;
    }

    public ArrayList<Client> getAllClients() {
        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();

        ArrayList<Client> clientList = new ArrayList<Client>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tbl_client");
            while (rs.next()) {

                Client client = new Client();

                client.setClientCode(rs.getString("client_code"));
                client.setClientName(rs.getString("client_name"));
                client.setNo(rs.getString("no"));
                client.setStreet(rs.getString("street"));
                client.setCity(rs.getString("city"));
                client.setContactNo(rs.getString("contact_no"));
                client.setFirstName(rs.getString("first_name"));
                client.setLastName(rs.getString("last_name"));
                client.setMobileNo(rs.getString("mobile_no"));
                client.setRegisterPerson(rs.getString("register_person"));

                clientList.add(client);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return clientList;
    }

    public ArrayList<Invoice> getAllItems() {
        DBConnector dbCon = new DBConnector();
        Connection con = dbCon.getConnection();

        ArrayList<Invoice> itemList = new ArrayList<Invoice>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tbl_item");
            while (rs.next()) {

                Invoice inv = new Invoice();

                inv.setJobId(rs.getString("job_id"));
                inv.setProductCategory(rs.getString("product_category"));
                inv.setProductDetail(rs.getString("product_details"));
                inv.setSqFeetArea(rs.getDouble("sq_ft_area"));
                inv.setUnits(rs.getInt("units"));
                inv.setRate(rs.getDouble("rate"));
                inv.setFromDate(rs.getString("from_date"));
                inv.setToDate(rs.getString("to_date"));
                inv.setNoOfDays(rs.getInt("days"));
                inv.setItemTotal(rs.getDouble("total"));

                itemList.add(inv);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message!", 0);
        }
        return itemList;
    }

}
