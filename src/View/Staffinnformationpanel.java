package View;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Model.Staff;
import dao.OwnerDao;

public class Staffinnformationpanel extends javax.swing.JFrame {

    private JTable staffTable;

    public Staffinnformationpanel() {
        initComponents();
        generateTable();
    }

    public void generateTable() {
        OwnerDao dao = new OwnerDao();
        List<Staff> staffList = dao.fetchStaffRecords();

        // Column names
        String[] columnNames = {"ID", "Name", "Password"};

        // Table model
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Populate table model
        for (Staff staff : staffList) {
            Object[] rowData = {staff.getId(), staff.getName(), staff.getPassword()};
            tableModel.addRow(rowData);
        }

        // Initialize table with model
        staffTable = new JTable(tableModel);

        // Scroll pane
        JScrollPane scrollPane = new JScrollPane(staffTable);

        // Add scroll pane to the panel
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Delete = new javax.swing.JButton();
        Register = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 500));
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(51, 0, 51));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Staff information panel");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(6, 6, 859, 56);

        jLabel2.setBackground(new java.awt.Color(102, 0, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Back");
        jLabel2.setOpaque(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(719, 417, 91, 35);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicmanagementsystem/view/staff information.png")));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(17, 1596, 0, 0);

        Delete.setBackground(new java.awt.Color(102, 0, 102));
        Delete.setFont(new java.awt.Font("Segoe UI", 1, 14));
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        getContentPane().add(Delete);
        Delete.setBounds(576, 417, 91, 35);

        Register.setBackground(new java.awt.Color(102, 0, 102));
        Register.setFont(new java.awt.Font("Segoe UI", 1, 14));
        Register.setForeground(new java.awt.Color(255, 255, 255));
        Register.setText("Register");
        getContentPane().add(Register);
        Register.setBounds(413, 418, 101, 34);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/staff information.png")));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(32, 86, 350, 360);

        pack();
    }

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {
        // Handle back button click
    }

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {
        // Handle delete button click
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Staffinnformationpanel().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton Delete;
    private javax.swing.JTable ID;
    private javax.swing.JButton Register;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration
}
