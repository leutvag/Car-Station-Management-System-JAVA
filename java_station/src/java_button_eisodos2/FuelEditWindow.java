package java_button_eisodos2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuelEditWindow extends JFrame {

    private JPanel contentPane;
    private JTextField txtPetrolPrice;
    private JTextField txtRegularGasPrice;
    private JTextField txtSuperGasPrice;
    private JTextField txtGasPrice;  // Προστέθηκε το πεδίο κειμένου για την τιμή του αερίου

    public FuelEditWindow() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 458, 344);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(134, 0, 0));
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Επεξεργασία Τιμών Καυσίμων");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(80, 30, 250, 30);
        contentPane.add(lblNewLabel);

        JLabel lblPetrol = new JLabel("Τιμή Πετρελαίου:");
        lblPetrol.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPetrol.setForeground(Color.WHITE);
        lblPetrol.setBounds(30, 80, 120, 20);
        contentPane.add(lblPetrol);

        txtPetrolPrice = new JTextField();
        txtPetrolPrice.setBounds(191, 83, 120, 20);
        contentPane.add(txtPetrolPrice);

        JLabel lblRegularGas = new JLabel("Τιμή Αμόλυβδης Απλής:");
        lblRegularGas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblRegularGas.setForeground(Color.WHITE);
        lblRegularGas.setBounds(29, 110, 161, 20);
        contentPane.add(lblRegularGas);

        txtRegularGasPrice = new JTextField();
        txtRegularGasPrice.setBounds(191, 113, 120, 20);
        contentPane.add(txtRegularGasPrice);

        JLabel lblSuperGas = new JLabel("Τιμή Αμόλυβδης Σούπερ:");
        lblSuperGas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSuperGas.setForeground(Color.WHITE);
        lblSuperGas.setBounds(30, 140, 160, 20);
        contentPane.add(lblSuperGas);

        txtSuperGasPrice = new JTextField();
        txtSuperGasPrice.setBounds(191, 143, 120, 20);
        contentPane.add(txtSuperGasPrice);

        JLabel lblGas = new JLabel("Τιμή Αερίου:");
        lblGas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblGas.setForeground(Color.WHITE);
        lblGas.setBounds(30, 170, 120, 20);
        contentPane.add(lblGas);

        txtGasPrice = new JTextField();
        txtGasPrice.setBounds(191, 170, 120, 20);
        contentPane.add(txtGasPrice);

        JButton btnSavePrices = new JButton("Αποθήκευση Τιμών");
        btnSavePrices.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSavePrices.setBounds(110, 210, 168, 30);
        contentPane.add(btnSavePrices);

        btnSavePrices.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveFuelPrices();
            }
        });

        setContentPane(contentPane);
        
        JButton btnClose = new JButton("Exit");
        btnClose.setForeground(new Color(255, 255, 255));
        btnClose.setBackground(new Color(0, 0, 0));
        btnClose.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnClose.setBounds(349, 276, 85, 21);
        contentPane.add(btnClose);
        btnClose.setToolTipText("Έξοδος από την φόρμα επεξεργασίας");
        

        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void saveFuelPrices() {
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##elvagio2","tiger");
           
            updateFuelPrice(connection, "Πετρέλαιο", txtPetrolPrice.getText());
            updateFuelPrice(connection, "ΒΕΝΖΙΝΗ ΑΠΛΗ", txtRegularGasPrice.getText());
            updateFuelPrice(connection, "ΒΕΝΖΙΝΗ ΣΟΥΠΕΡ", txtSuperGasPrice.getText());
            updateFuelPrice(connection, "Αέριο", txtGasPrice.getText());

            connection.close();
            JOptionPane.showMessageDialog(this, "Οι τιμές αποθηκεύτηκαν επιτυχώς.", "Επιτυχία", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Σφάλμα κατά την αποθήκευση των τιμών.", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateFuelPrice(Connection connection, String fuelType, String newPrice) throws SQLException {
        String query = "UPDATE gas_prices SET price_gas = ? WHERE name_gas = ?";
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setString(1, newPrice);
            st.setString(2, fuelType);
            st.executeUpdate();
        }
    }
}