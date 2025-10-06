package java_button_eisodos2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Kausima extends JFrame {

    private JPanel contentPane;
    private JTextField txtQuantity;
    private JLabel lblPrice;
    private JLabel lblSavedPrice;
    private JComboBox<String> comboBoxFuel;
    private int userId;
    private String username;
    private JLabel lblQuantity_1;


    public Kausima(int userId, String username) {
    	this.userId = userId;
        this.username = username;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 433, 361);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 145, 145));
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel(" \u039A\u03B1\u03CD\u03C3\u03B9\u03BC\u03B1");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(155, 10, 95, 30);
        contentPane.add(lblNewLabel);
        
        //προσθήκη εικόνας
        ImageIcon icon = new ImageIcon("kausima.jpg");
        JLabel lblImag = new JLabel(icon);
        lblImag.setBounds(350,50,200,200);
        contentPane.add(lblImag);

        comboBoxFuel = new JComboBox<>();
        comboBoxFuel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboBoxFuel.setBounds(100, 80, 200, 30);
        // Προσθήκη καυσίμων από τη βάση δεδομένων
        loadFuelsFromDatabase();
        contentPane.add(comboBoxFuel);

        JLabel lblQuantity = new JLabel("Ποσότητα (λίτρα):");
        lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblQuantity.setBounds(100, 110, 200, 30);
        contentPane.add(lblQuantity);

        txtQuantity = new JTextField();
        txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtQuantity.setBounds(100, 140, 200, 30);
        contentPane.add(txtQuantity);

        lblPrice = new JLabel("Τιμή: ");
        lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPrice.setBounds(100, 180, 476, 30);
        contentPane.add(lblPrice);

        lblSavedPrice = new JLabel("Η τιμή αποθηκεύτηκε: ");
        lblSavedPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSavedPrice.setBounds(100, 210, 476, 30);
        contentPane.add(lblSavedPrice);

        JButton btnSavePrice = new JButton("\u039A\u03B1\u03C4\u03B1\u03C7\u03CE\u03C1\u03B7\u03C3\u03B7");
        btnSavePrice.setForeground(new Color(255, 255, 255));
        btnSavePrice.setBackground(new Color(0, 0, 0));
        btnSavePrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSavePrice.setBounds(269, 260, 129, 30);
        contentPane.add(btnSavePrice);

        JButton btnBack = new JButton("EXIT");
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBackground(new Color(0, 0, 0));
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnBack.setBounds(10, 260, 100, 30);
        contentPane.add(btnBack);

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnSavePrice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double totalPrice = calculateTotalPrice((String) comboBoxFuel.getSelectedItem(), txtQuantity.getText());

                // Εμφάνιση διαλόγου επιβεβαίωσης
                int result = JOptionPane.showConfirmDialog(Kausima.this, "Είστε σίγουρος ότι θέλετε να αποθηκεύσετε την τιμή;", "Επιβεβαίωση", JOptionPane.YES_NO_OPTION);
                
                if (result == JOptionPane.YES_OPTION) {
                    savePrice(totalPrice);
                }
            }
        });


        comboBoxFuel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatePrice(lblPrice, (String) comboBoxFuel.getSelectedItem(), txtQuantity.getText());
            }
        });

        setContentPane(contentPane);
        
        lblQuantity_1 = new JLabel("\u0395\u03C0\u03B9\u03BB\u03BF\u03B3\u03AE \u03BA\u03B1\u03C5\u03C3\u03AF\u03BC\u03BF\u03C5");
        lblQuantity_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblQuantity_1.setBounds(100, 51, 200, 30);
        contentPane.add(lblQuantity_1);
        setVisible(true);
    }

    // Μέθοδος για τη φόρτωση των καυσίμων από τη βάση δεδομένων
    private void loadFuelsFromDatabase() {
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##elvagio2","tiger");
           
            String query = "SELECT name_gas FROM gas_prices";
            try (PreparedStatement st = connection.prepareStatement(query)) {
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    String fuelName = rs.getString("name_gas");
                    comboBoxFuel.addItem(fuelName);
                }
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Σφάλμα κατά την ανάκτηση των καυσίμων από τη βάση δεδομένων", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calculatePrice(JLabel lblPrice, String selectedFuel, String quantity) {
        double pricePerLiter = getPriceFromDatabase(selectedFuel);

        try {
            double quantityLiters = Double.parseDouble(quantity);
            double totalPrice = pricePerLiter * quantityLiters;

            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String formattedTotalPrice = decimalFormat.format(totalPrice);

            lblPrice.setText("Τιμή: " + formattedTotalPrice + "€");
        } catch (NumberFormatException ex) {
            lblPrice.setText("Μη έγκυρη ποσότητα");
        }
    }

    private double calculateTotalPrice(String selectedFuel, String quantity) {
        double pricePerLiter = getPriceFromDatabase(selectedFuel);

        try {
            double quantityLiters = Double.parseDouble(quantity);
            return pricePerLiter * quantityLiters;
        } catch (NumberFormatException ex) {
            return 0.0;
        }
    }

    private double getPriceFromDatabase(String fuelName) {
        double price = 0.0;
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##elvagio2","tiger");
           
            String query = "SELECT price_gas FROM gas_prices WHERE name_gas = ?";
            try (PreparedStatement st = connection.prepareStatement(query)) {
                st.setString(1, fuelName);
                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    price = rs.getDouble("price_gas");
                }
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Σφάλμα κατά την ανάκτηση της τιμής από τη βάση δεδομένων", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
        }
        return price;
    }

    private void savePrice(double totalPrice) {
        String displayedPrice = lblPrice.getText();
        lblSavedPrice.setText("Η τιμή αποθηκεύτηκε: " + displayedPrice);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##elvagio2","tiger");

            String fuelType = (String) comboBoxFuel.getSelectedItem();

            // Ορίζουμε το format για έως δύο δεκαδικά ψηφία, με το Locale.US
            DecimalFormat decimalFormat = new DecimalFormat("#.##", DecimalFormatSymbols.getInstance(Locale.US));

            // Εφαρμόζουμε το format στην totalPrice
            String formattedTotalPrice = decimalFormat.format(totalPrice);

            // Αφαιρούμε τη στήλη quantity_liters από το query
            String query = "INSERT INTO gas (nameg, priceg, id) VALUES (?, ?, ?)";
            try (PreparedStatement st = connection.prepareStatement(query)) {
                st.setString(1, fuelType);
                st.setDouble(2, Double.parseDouble(formattedTotalPrice));
                st.setInt(3, userId); // Προσθήκη του id του χρήστη
                st.executeUpdate();
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Σφάλμα κατά την αποθήκευση στη βάση δεδομένων", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
        }
    }



}