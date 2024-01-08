/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controler.DBManager;
import Model.Invoice;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gihan
 */
public class ViewInvoice extends javax.swing.JFrame {

    /**
     * Creates new form Bill
     */
    public ViewInvoice() {
        initComponents();
    }

    DefaultTableModel model;
    
    ViewInvoice(Invoice invoice) {
        initComponents();

        DBManager dbManager = new DBManager();
        invoice = dbManager.generateInvoice(invoice);

        lblInvoiceNoVal.setText(invoice.getJobId());
        lblInvoiceMonthVal.setText(invoice.getBillingMonth());
        lblInvoiceDateVal.setText(invoice.getJobDate());
        lblCustomerIdVal.setText(invoice.getClientCode());
        lblFaxVal.setText(invoice.getTaxNo());
        lblContacPersonVal.setText(invoice.getFirstName() + " " + invoice.getLastName());
        lblCompanyVal.setText(invoice.getClientName());
        lblAddressVal.setText(invoice.getNo() + " " + invoice.getStreet() + "" + invoice.getCity());
        lblContactNoVal.setText(invoice.getContactNo());
        txtSubTotal.setText(invoice.getSubTotal() + "");
        txtDiscount.setText(invoice.getDiscount() + "");
        txtNetTotal.setText(invoice.getNetValue() + "");
        
        ArrayList<Invoice> InvoiceItemList = new ArrayList<Invoice>();
        
        InvoiceItemList = dbManager.generateJobItems(invoice);
        
        model = (DefaultTableModel) tblJob.getModel();
                
        for (int i = 0; i < InvoiceItemList.size(); i++) {
            Invoice get = InvoiceItemList.get(i);
           
            System.out.println("job id="+get.getJobId());
            Object row[] = new Object[6];
            row[0] = get.getProductCategory();
            row[1] = get.getProductDetail();
            row[2] = get.getSqFeetArea();
            row[3] = get.getRate();
            row[4] = get.getUnits();
            row[5] = get.getItemTotal();
            
            model.addRow(row);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblComAddress = new javax.swing.JLabel();
        lblEmialVal = new javax.swing.JLabel();
        lblContactNoVal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lablClienName = new javax.swing.JLabel();
        lblContactNo = new javax.swing.JLabel();
        lblInvoiceNumber = new javax.swing.JLabel();
        lblInvoiceMonth = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JTextField();
        lblDiscount = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lblInvoiceNoVal = new javax.swing.JLabel();
        lblWebsite2 = new javax.swing.JLabel();
        lblComAddressVal = new javax.swing.JLabel();
        lblCompanyName = new javax.swing.JLabel();
        lblComPhoneVal = new javax.swing.JLabel();
        lblFaxVal = new javax.swing.JLabel();
        lblFax = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblComPhone = new javax.swing.JLabel();
        lblInvoiceDate = new javax.swing.JLabel();
        lblInvoiceDateVal = new javax.swing.JLabel();
        lblInvoiceMonthVal = new javax.swing.JLabel();
        lblCustomerID = new javax.swing.JLabel();
        lblCustomerIdVal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblJob = new javax.swing.JTable();
        lblAddress = new javax.swing.JLabel();
        lblCompany = new javax.swing.JLabel();
        lblContacPersonVal = new javax.swing.JLabel();
        lblCompanyVal = new javax.swing.JLabel();
        lblAddressVal = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        lblWebsite5 = new javax.swing.JLabel();
        lblInvoice = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JLabel();
        lbNetValue = new javax.swing.JLabel();
        txtNetTotal = new javax.swing.JTextField();
        lblClose = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Bill To:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 70, 20));

        lblComAddress.setText("Address:");
        jPanel1.add(lblComAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 60, 30));

        lblEmialVal.setText("info@smart-warehouse.com");
        jPanel1.add(lblEmialVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 200, 30));
        jPanel1.add(lblContactNoVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 320, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thank You");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 740, 1070, 40));

        lablClienName.setText("Client Name:");
        jPanel1.add(lablClienName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 80, 30));

        lblContactNo.setText("Contact No:");
        jPanel1.add(lblContactNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 80, 30));

        lblInvoiceNumber.setText("Invoice Number");
        jPanel1.add(lblInvoiceNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, 110, 30));

        lblInvoiceMonth.setText("Invoice Month");
        jPanel1.add(lblInvoiceMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, 110, 30));

        txtDiscount.setEditable(false);
        txtDiscount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDiscount.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 680, 170, 30));

        lblDiscount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDiscount.setText("Discount");
        jPanel1.add(lblDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 680, 110, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, 320, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 350, 20));

        lblInvoiceNoVal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lblInvoiceNoVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 100, 160, 30));

        lblWebsite2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblWebsite2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWebsite2.setText("Contact : +94 114 4565 25 | Email : info@smart-warehouse.com");
        jPanel1.add(lblWebsite2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 810, 1070, 20));

        lblComAddressVal.setText("370 High Level Rd, Pannipitiya ");
        jPanel1.add(lblComAddressVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 250, 30));

        lblCompanyName.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblCompanyName.setText("Smart Warehouse System Pvt Ltd.");
        jPanel1.add(lblCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 420, 40));

        lblComPhoneVal.setText("+94 114 5452 25");
        jPanel1.add(lblComPhoneVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 160, 30));
        jPanel1.add(lblFaxVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 160, 30));

        lblFax.setText("Fax:");
        jPanel1.add(lblFax, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 60, 30));

        lblEmail.setText("Email:");
        jPanel1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 60, 30));

        lblComPhone.setText("Phone:");
        jPanel1.add(lblComPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 60, 30));

        lblInvoiceDate.setText("Invoice Date");
        jPanel1.add(lblInvoiceDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 110, 30));

        lblInvoiceDateVal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lblInvoiceDateVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 180, 160, 30));

        lblInvoiceMonthVal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lblInvoiceMonthVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 140, 160, 30));

        lblCustomerID.setText("Customer ID");
        jPanel1.add(lblCustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, 110, 30));

        lblCustomerIdVal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lblCustomerIdVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 220, 160, 30));

        tblJob.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Type", "Description", "Sq. Ft. Area", "Rate", "No of Units", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblJob);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 1030, 210));

        lblAddress.setText("Address:");
        jPanel1.add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 80, 30));

        lblCompany.setText("Company:");
        jPanel1.add(lblCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 80, 30));
        jPanel1.add(lblContacPersonVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 320, 30));
        jPanel1.add(lblCompanyVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 320, 30));
        jPanel1.add(lblAddressVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 320, 30));

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo-icon.png"))); // NOI18N
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 100));

        txtSubTotal.setEditable(false);
        txtSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSubTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 650, 170, 30));

        lblWebsite5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblWebsite5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWebsite5.setText("If you have any inquiry in this invoice please contact");
        jPanel1.add(lblWebsite5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 790, 1070, 20));

        lblInvoice.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblInvoice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInvoice.setText("Invoice");
        jPanel1.add(lblInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 510, 40));

        lblSubTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSubTotal.setText("Sub Total");
        jPanel1.add(lblSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 650, 110, 30));

        lbNetValue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNetValue.setText("Net Total");
        jPanel1.add(lbNetValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 710, 110, 30));

        txtNetTotal.setEditable(false);
        txtNetTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtNetTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtNetTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 710, 170, 30));

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close-button-unfill.png"))); // NOI18N
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCloseMousePressed(evt);
            }
        });
        jPanel1.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 0, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 850));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMousePressed
        this.dispose();
    
    }//GEN-LAST:event_lblCloseMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ViewInvoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lablClienName;
    private javax.swing.JLabel lbNetValue;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddressVal;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblComAddress;
    private javax.swing.JLabel lblComAddressVal;
    private javax.swing.JLabel lblComPhone;
    private javax.swing.JLabel lblComPhoneVal;
    private javax.swing.JLabel lblCompany;
    private javax.swing.JLabel lblCompanyName;
    private javax.swing.JLabel lblCompanyVal;
    private javax.swing.JLabel lblContacPersonVal;
    private javax.swing.JLabel lblContactNo;
    private javax.swing.JLabel lblContactNoVal;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblCustomerIdVal;
    private javax.swing.JLabel lblDiscount;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmialVal;
    private javax.swing.JLabel lblFax;
    private javax.swing.JLabel lblFaxVal;
    private javax.swing.JLabel lblInvoice;
    private javax.swing.JLabel lblInvoiceDate;
    private javax.swing.JLabel lblInvoiceDateVal;
    private javax.swing.JLabel lblInvoiceMonth;
    private javax.swing.JLabel lblInvoiceMonthVal;
    private javax.swing.JLabel lblInvoiceNoVal;
    private javax.swing.JLabel lblInvoiceNumber;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblWebsite2;
    private javax.swing.JLabel lblWebsite5;
    private javax.swing.JTable tblJob;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtNetTotal;
    private javax.swing.JTextField txtSubTotal;
    // End of variables declaration//GEN-END:variables
}