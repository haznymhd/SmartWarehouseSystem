/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Gihan
 */
public class Job {

    private String jobId;
    private String clientCode;
    private String jobDate;
    private String billingMonth;
    private String taxNo;
    private double subTotal;
    private double discount;
    private double netValue;
    private String clseDate;
    private int jobStatus;
    private String itemID;
    private String productCategory;
    private String productDetail;
    private double sqFeetArea;
    private int units;
    private double rate;
    private String fromDate;
    private String toDate;
    private int noOfDays;
    private double itemTotal;

    public Job() {
    }

    public Job(String jobId, String clseDate, int jobStatus) {
        this.jobId = jobId;
        this.clseDate = clseDate;
        this.jobStatus = jobStatus;
    }

    
    
    public Job(String jobId, String clientCode, String jobDate, String billingMonth, String taxNo, double subTotal, double discount, double netValue, int jobStatus) {
        this.jobId = jobId;
        this.clientCode = clientCode;
        this.jobDate = jobDate;
        this.billingMonth = billingMonth;
        this.taxNo = taxNo;
        this.subTotal = subTotal;
        this.discount = discount;
        this.netValue = netValue;
        this.jobStatus = jobStatus;
    }

    public Job(String jobId, String productCategory, String productDetail, double sqFeetArea, int units, double rate, String fromDate, String toDate, int noOfDays, double itemTotal) {
        this.jobId = jobId;
        this.productCategory = productCategory;
        this.productDetail = productDetail;
        this.sqFeetArea = sqFeetArea;
        this.units = units;
        this.rate = rate;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.noOfDays = noOfDays;
        this.itemTotal = itemTotal;
    }

    public Job(String fromDate, String toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getJobDate() {
        return jobDate;
    }

    public void setJobDate(String jobDate) {
        this.jobDate = jobDate;
    }

    public String getBillingMonth() {
        return billingMonth;
    }

    public void setBillingMonth(String billingMonth) {
        this.billingMonth = billingMonth;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getNetValue() {
        return netValue;
    }

    public void setNetValue(double netValue) {
        this.netValue = netValue;
    }

    public String getClseDate() {
        return clseDate;
    }

    public void setClseDate(String clseDate) {
        this.clseDate = clseDate;
    }

    public int getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(int jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public double getSqFeetArea() {
        return sqFeetArea;
    }

    public void setSqFeetArea(double sqFeetArea) {
        this.sqFeetArea = sqFeetArea;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public double getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }

}
