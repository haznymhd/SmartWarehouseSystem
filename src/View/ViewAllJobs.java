/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static Controler.DBManager.userRole;
import Controler.DBManager;
import Model.Invoice;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gihan
 */
public class ViewAllJobs extends javax.swing.JFrame {

    /**
     * Creates new form CloseJob
     */
    DefaultTableModel model;
    Date date;
    SimpleDateFormat dateFormat;

    public ViewAllJobs() {
        initComponents();

        date = new Date();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        dcFromDate.setDateFormatString(dateFormat.toLocalizedPattern());
        dcFromDate.setDate(date);

        dcToDate.setDateFormatString(dateFormat.toLocalizedPattern());
        dcToDate.setDate(date);

        loadTableData();

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
        lblFrameName = new javax.swing.JLabel();
        lblHeadBanner = new javax.swing.JLabel();
        panelHeader = new javax.swing.JPanel();
        lblBackButtn = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblJob = new javax.swing.JTable();
        butnHome = new javax.swing.JLabel();
        lblHom = new javax.swing.JLabel();
        lblButnPreview = new javax.swing.JLabel();
        lblHom1 = new javax.swing.JLabel();
        dcFromDate = new com.toedter.calendar.JDateChooser();
        dcToDate = new com.toedter.calendar.JDateChooser();
        lblToDate = new javax.swing.JLabel();
        lblFromDate = new javax.swing.JLabel();
        lblButnSearch = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrameName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblFrameName.setForeground(new java.awt.Color(255, 255, 255));
        lblFrameName.setText("View All Job Details");
        jPanel1.add(lblFrameName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 370, 40));

        lblHeadBanner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/main-pic.jpg"))); // NOI18N
        jPanel1.add(lblHeadBanner, new org.netbeans.lib.awtextra.AbsoluteConstraints(-350, 40, 1370, 110));

        panelHeader.setBackground(new java.awt.Color(255, 255, 255));
        panelHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBackButtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit-butn-small.png"))); // NOI18N
        lblBackButtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblBackButtnMousePressed(evt);
            }
        });
        panelHeader.add(lblBackButtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 40, 40));

        jPanel1.add(panelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 40));

        tblJob.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tblJob.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job ID", "Company ", "Client Name", "Job Date", "Billing Month", "Sub Total", "Discount", "Net Total", "Job Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblJob.setRowHeight(20);
        tblJob.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblJob.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblJob);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 970, 250));

        butnHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home-butn.png"))); // NOI18N
        butnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                butnHomeMousePressed(evt);
            }
        });
        jPanel1.add(butnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 510, 70, 70));

        lblHom.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblHom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHom.setText("Home");
        jPanel1.add(lblHom, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 590, 70, -1));

        lblButnPreview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblButnPreview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/print-icon.png"))); // NOI18N
        lblButnPreview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblButnPreviewMousePressed(evt);
            }
        });
        jPanel1.add(lblButnPreview, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 510, 70, 70));

        lblHom1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblHom1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHom1.setText("Preview");
        jPanel1.add(lblHom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 590, 70, -1));
        jPanel1.add(dcFromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 150, 30));
        jPanel1.add(dcToDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 150, 30));

        lblToDate.setText("To Date");
        jPanel1.add(lblToDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 70, 30));

        lblFromDate.setText("From Date");
        jPanel1.add(lblFromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 80, 30));

        lblButnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search-butn.png"))); // NOI18N
        lblButnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblButnSearchMousePressed(evt);
            }
        });
        jPanel1.add(lblButnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 40, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/wave-back2.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 1010, 270));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 590, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblBackButtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackButtnMousePressed

        this.setAlwaysOnTop(false);
        if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close?", "Warning", JOptionPane.YES_NO_OPTION) == 0) {

            this.dispose();
        }
    }//GEN-LAST:event_lblBackButtnMousePressed

    private void butnHomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butnHomeMousePressed

        this.setAlwaysOnTop(false);
        if (JOptionPane.showConfirmDialog(null, "Are you sure you want go to home ?", "Message", JOptionPane.YES_NO_OPTION) == 0) {
            Home home = new Home(userRole);
            home.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_butnHomeMousePressed

    private void lblButnPreviewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblButnPreviewMousePressed

        if (this.tblJob.getSelectedRow() != -1) {

            String jobId = this.tblJob.getValueAt(this.tblJob.getSelectedRow(), 0).toString();
            Invoice invoice = new Invoice(jobId);

            ViewInvoice viewInvoice = new ViewInvoice(invoice);
            viewInvoice.setVisible(true);
        }


    }//GEN-LAST:event_lblButnPreviewMousePressed

    private void lblButnSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblButnSearchMousePressed

        String fromDate = dateFormat.format(dcFromDate.getDate());
        String toDate = dateFormat.format(dcToDate.getDate());

        Invoice invoice = new Invoice(fromDate, toDate);
        ArrayList<Invoice> jobList = new ArrayList<Invoice>();
        DBManager dbManager = new DBManager();

        jobList = dbManager.searchJobsByDateRange(invoice);

        model = (DefaultTableModel) tblJob.getModel();

        model.setRowCount(0);

        for (int i = 0; i < jobList.size(); i++) {
            Invoice get = jobList.get(i);

            Object row[] = new Object[9];
            row[0] = get.getJobId();
            row[1] = get.getClientName();
            row[2] = get.getFirstName() + " " + get.getLastName();
            row[3] = get.getJobDate();
            row[4] = get.getBillingMonth();
            row[5] = get.getSubTotal();
            row[6] = get.getDiscount();
            row[7] = get.getNetValue();

            String jobStatus;
            if (get.getJobStatus() == 1) {
                jobStatus = "Active";
            } else {
                jobStatus = "Close";
            }

            row[8] = jobStatus;

            model.addRow(row);

        }
    }//GEN-LAST:event_lblButnSearchMousePressed

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
            java.util.logging.Logger.getLogger(ViewAllJobs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllJobs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllJobs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllJobs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ViewAllJobs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel butnHome;
    private com.toedter.calendar.JDateChooser dcFromDate;
    private com.toedter.calendar.JDateChooser dcToDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBackButtn;
    private javax.swing.JLabel lblButnPreview;
    private javax.swing.JLabel lblButnSearch;
    private javax.swing.JLabel lblFrameName;
    private javax.swing.JLabel lblFromDate;
    private javax.swing.JLabel lblHeadBanner;
    private javax.swing.JLabel lblHom;
    private javax.swing.JLabel lblHom1;
    private javax.swing.JLabel lblToDate;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JTable tblJob;
    // End of variables declaration//GEN-END:variables

    private void loadTableData() {

        DBManager dbManager = new DBManager();

        ArrayList<Invoice> jobList = new ArrayList<Invoice>();

        jobList = dbManager.getAllJobs();

        model = (DefaultTableModel) tblJob.getModel();

        model.setRowCount(0);

        for (int i = 0; i < jobList.size(); i++) {
            Invoice get = jobList.get(i);

            Object row[] = new Object[9];
            row[0] = get.getJobId();
            row[1] = get.getClientName();
            row[2] = get.getFirstName() + " " + get.getLastName();
            row[3] = get.getJobDate();
            row[4] = get.getBillingMonth();
            row[5] = get.getSubTotal();
            row[6] = get.getDiscount();
            row[7] = get.getNetValue();

            String jobStatus;
            if (get.getJobStatus() == 1) {
                jobStatus = "Active";
            } else {
                jobStatus = "Close";
            }

            row[8] = jobStatus;

            model.addRow(row);

        }
    }
}
