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
import java.util.ArrayList;
import java.util.List;

public class AntallaktikaPage extends JFrame {

    private JPanel contentPane;
    private List<Product> selectedProducts = new ArrayList<>();
    private int userId;
    private String username;

    public AntallaktikaPage(int userId, String username) {
        this.userId = userId;
        this.username = username;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 624, 468);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 147, 147));
        contentPane.setLayout(null);
//        contentPane.setLayout(new FlowLayout());

        setResizable(false);

        JLabel lblNewLabel = new JLabel("Ανταλλακτικά");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(239, 10, 154, 31);
        contentPane.add(lblNewLabel);

        JButton btnSave = new JButton("\u039A\u03B1\u03C4\u03B1\u03C7\u03CE\u03C1\u03B7\u03C3\u03B7");
        btnSave.setBackground(new Color(0, 0, 0));
        btnSave.setForeground(new Color(255, 255, 255));
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSave.setBounds(426, 380, 120, 30);
        contentPane.add(btnSave);

        List<Product> products = fetchProductsFromDatabase();

        int yCoordinate = 70;
        for (final Product product : products) {
            final JCheckBox checkBox = new JCheckBox(product.getName() + " - Τιμή: " + product.getPrice());
            checkBox.setBounds(22, yCoordinate, 300, 25);
            yCoordinate += 30;

            checkBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (checkBox.isSelected()) {
                        selectedProducts.add(product);
                        decreaseQuantityInDatabase(product);
                    } else {
                        selectedProducts.remove(product);
                    }
                }
            });

            contentPane.add(checkBox);
        }

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTotalPriceToDatabase();
            }
        });


        setContentPane(contentPane);
        
        JButton btnclose = new JButton("EXIT");
        btnclose.setForeground(new Color(255, 255, 255));
        btnclose.setBackground(new Color(0, 0, 0));
        btnclose.setBounds(38, 379, 78, 31);
        contentPane.add(btnclose);
        
        
        
        btnclose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Κλείνει το παράθυρο
            }
        });
    }
    

    private List<Product> fetchProductsFromDatabase() {
        List<Product> products = new ArrayList<>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##elvagio2", "tiger");

            String query = "SELECT part_code, namem, pricem FROM maintenance";
            try (PreparedStatement st = connection.prepareStatement(query)) {
                ResultSet resultSet = st.executeQuery();

                while (resultSet.next()) {
                    int partCode = resultSet.getInt("part_code");
                    String name = resultSet.getString("namem");
                    double price = resultSet.getDouble("pricem");

                    Product product = new Product(partCode, name, price);
                    products.add(product);
                }
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(contentPane, "Error fetching products from database.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return products;
    }

    private void saveTotalPriceToDatabase() {
        double totalPrice = calculateTotalPrice();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##elvagio2", "tiger");

            String query = "INSERT INTO maintenance_total_price (namem, pricem, id) VALUES (?, ?, ?)";
            try (PreparedStatement st = connection.prepareStatement(query)) {
                st.setString(1, "Συνολική Τιμή");
                st.setDouble(2, totalPrice);
                st.setInt(3, getUserIdFromLoggedInUser());
                st.executeUpdate();
                JOptionPane.showMessageDialog(contentPane, "Η παραγγελία καταχωρήθηκε επιτυχώς.", "Επιτυχία", JOptionPane.INFORMATION_MESSAGE);

            }

            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(contentPane, "Σφάλμα κατά την αποθήκευση της παραγγελίας στη βάση δεδομένων.", "Σφάλμα", JOptionPane.ERROR_MESSAGE);        }
    }

    private double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : selectedProducts) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    private int getUserIdFromLoggedInUser() {
        return userId;
    }
    
    private void decreaseQuantityInDatabase(Product product) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##elvagio2", "tiger");

            String query = "UPDATE maintenance SET quantity = quantity - 1 WHERE part_code = ?";
            try (PreparedStatement st = connection.prepareStatement(query)) {
                st.setInt(1, product.getPartCode());
                st.executeUpdate();
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(contentPane, "Error updating quantity in database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private static class Product {
        private int partCode;
        private String name;
        private double price;

        public Product(int partCode, String name, double price) {
            this.partCode = partCode;
            this.name = name;
            this.price = price;
        }

        public int getPartCode() {
            return partCode;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
        
       

    }
}
