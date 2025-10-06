package java_button_eisodos2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffWindow extends JFrame {
    private JTable table;
    private JTable table_1;

    public StaffWindow() {
        initialize();
        loadMaintenanceData();
        loadUserData();
    }

    private void initialize() {
        setTitle("Παράθυρο Προσωπικού");
        setBounds(100, 100, 914, 588);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(173, 216, 230));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        DefaultTableModel model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 109, 383, 268);
        panel.add(scrollPane);

        JLabel lblMaintenanceTable = new JLabel("ΑΠΟΘΕΜΑΤΑ ΑΝΤΑΛΛΑΚΤΙΚΩΝ");
        lblMaintenanceTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblMaintenanceTable.setBounds(111, 74, 220, 25);
        panel.add(lblMaintenanceTable);

        JButton btnExit = new JButton("EXIT");
        btnExit.setForeground(new Color(255, 255, 255));
        btnExit.setBackground(new Color(255, 0, 0));
        btnExit.setBounds(41, 516, 74, 25);
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(btnExit);

        DefaultTableModel userModel = new DefaultTableModel();
        table_1 = new JTable(userModel);
        JScrollPane scrollPaneUsers = new JScrollPane(table_1);
        scrollPaneUsers.setBounds(515, 109, 364, 268);
        panel.add(scrollPaneUsers);

        JLabel lblUsersTable = new JLabel("ΠΙΝΑΚΑΣ ΧΡΗΣΤΩΝ");
        lblUsersTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblUsersTable.setBounds(641, 74, 144, 25);
        panel.add(lblUsersTable);

        JButton btnNewButton = new JButton("MHNYMATA");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(758, 497, 121, 44);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openMessageWindow();
            }
        });
        panel.add(btnNewButton);
        
        btnNewButton.setToolTipText("Προβολή μηνυμάτων των Χρηστών");
        btnExit.setToolTipText("Έξοδος από την Εφαρμογή");
        btnExit.setFocusable(false);
        btnNewButton.setFocusable(false);
    }

    private void loadMaintenanceData() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##elvagio2", "tiger");

            String query = "SELECT * FROM maintenance";
            try (PreparedStatement st = connection.prepareStatement(query)) {
                ResultSet resultSet = st.executeQuery();

                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setColumnIdentifiers(new Object[]{"part_code", "namem", "pricem", "quantity"});

                while (resultSet.next()) {
                    Object[] rowData = {
                            resultSet.getInt("part_code"),
                            resultSet.getString("namem"),
                            resultSet.getDouble("pricem"),
                            resultSet.getInt("quantity")
                    };
                    model.addRow(rowData);
                }
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading maintenance data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadUserData() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##elvagio2", "tiger");

            String query = "SELECT * FROM users WHERE id <> 1";
            try (PreparedStatement st = connection.prepareStatement(query)) {
                ResultSet resultSet = st.executeQuery();

                DefaultTableModel userModel = (DefaultTableModel) table_1.getModel();
                userModel.setColumnIdentifiers(new Object[]{"id", "username"});

                while (resultSet.next()) {
                    Object[] rowData = {
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                    };
                    userModel.addRow(rowData);
                }
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading user data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openMessageWindow() {
        MessageWindow messageWindow = new MessageWindow();
        messageWindow.setVisible(true);

    }
}
