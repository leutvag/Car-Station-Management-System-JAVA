package java_button_eisodos2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EditWindow extends JFrame {
	public DefaultTableModel tableModel;
    private JPanel contentPane;
    private JTextField txtUserId;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    private JTable table;

    public EditWindow() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 926, 587);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(119, 0, 0));
        contentPane.setLayout(null);

        
        JLabel lblNewLabel = new JLabel("\u0395\u03C0\u03B5\u03BE\u03B5\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1 \u03A3\u03C4\u03B1\u03B8\u03BC\u03BF\u03CD");
        lblNewLabel.setBounds(319, 10, 250, 30);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setForeground(Color.WHITE);
        contentPane.add(lblNewLabel);

        JButton btnClose = new JButton("Exit");
        btnClose.setBounds(820, 502, 64, 26);
        btnClose.setForeground(new Color(255, 255, 255));
        btnClose.setBackground(new Color(0, 0, 0));
        btnClose.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(btnClose);
        btnClose.setToolTipText("Έξοδος από την φόρμα επεξεργασίας");
        

        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JButton btnShowUsers = new JButton("\u03A7\u03C1\u03AE\u03C3\u03C4\u03B5\u03C2");
        btnShowUsers.setBounds(784, 216, 100, 30);
        btnShowUsers.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnShowUsers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showUsers();
            }
        });
        contentPane.add(btnShowUsers);
        
        //βάζει το μήνυμα πάνω στο πεδιο που γράφουμε το id
        txtUserId = new JTextField();
        txtUserId.setBounds(784, 138, 100, 25);
        txtUserId.setToolTipText("Εισάγετε το ID χρήστη εδώ");
        contentPane.add(txtUserId);
        
        JButton btnFuelPrices = new JButton("Καύσιμα");
        btnFuelPrices.setBounds(783, 260, 100, 30);
        btnFuelPrices.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(btnFuelPrices);
        btnFuelPrices.setToolTipText("Επεξεργαστείτε τις τιμές των Καυσίμων");

        btnFuelPrices.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFuelPricesPage();
            }
        });
        
        JButton btnChangePrices = new JButton("\u0391\u03BD\u03C4\u03B1\u03BB\u03BB\u03B1\u03BA\u03C4\u03B9\u03BA\u03AC");
        btnChangePrices.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnChangePrices.setBounds(784, 360, 100, 26);
        contentPane.add(btnChangePrices);

        btnChangePrices.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeProductPrices();
            }

            private void changeProductPrices() {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##elvagio2", "tiger");

                    // Εμφάνιση λίστας των διαθέσιμων προϊόντων
                    String productsQuery = "SELECT DISTINCT namem FROM maintenance";
                    try (PreparedStatement productsStatement = connection.prepareStatement(productsQuery)) {
                        ResultSet productsResultSet = productsStatement.executeQuery();

                        // Χάρτης για την αποθήκευση των νέων τιμών ανά προϊόν
                        Map<String, Double> newPrices = new HashMap<>();

                        while (productsResultSet.next()) {
                            String namem = productsResultSet.getString("namem");

                            // Εισαγωγή της νέας τιμής για κάθε προϊόν
                            String newPriceStr = JOptionPane.showInputDialog(EditWindow.this, "Εισάγετε τη νέα τιμή για το προϊόν " + namem + ":", "Εισαγωγή Νέας Τιμής", JOptionPane.PLAIN_MESSAGE);

                            if (newPriceStr != null && !newPriceStr.isEmpty()) {
                                double newPrice = Double.parseDouble(newPriceStr);
                                newPrices.put(namem, newPrice);
                            } else {
                            	JOptionPane.showMessageDialog(EditWindow.this, "Οι τιμές των προϊόντων έχουν ενημερωθεί επιτυχώς.", "Επιτυχία", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }

                        // Ενημέρωση των τιμών στη βάση δεδομένων
                        String updateQuery = "UPDATE maintenance SET pricem = ? WHERE product = ?";
                        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                            for (Map.Entry<String, Double> entry : newPrices.entrySet()) {
                                updateStatement.setDouble(1, entry.getValue());
                                updateStatement.setString(2, entry.getKey());
                                updateStatement.executeUpdate();
                            }
                        }

                        // Εμφάνιση επιτυχούς μηνύματος
                        JOptionPane.showMessageDialog(EditWindow.this, "Οι τιμές των προϊόντων έχουν ενημερωθεί επιτυχώς.", "Επιτυχία", JOptionPane.INFORMATION_MESSAGE);

                        // Ανανέωση του JTable για να εμφανίσετε τις νέες τιμές
                        table_load();
                    }

                    connection.close();
                } catch (ClassNotFoundException | SQLException | NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(EditWindow.this, "Σφάλμα κατά την ενημέρωση των τιμών των προϊόντων.", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnChangePrices.setToolTipText("Αλλαγή των τιμών των ανταλλακτικών");

        JButton btnDeleteUser = new JButton("Διαγραφή");
        btnDeleteUser.setBounds(784, 175, 100, 30);
        btnDeleteUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(btnDeleteUser);
        btnDeleteUser.setToolTipText("Διαγραφή κάποιου Χρήστη");

        btnDeleteUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteUser();
            }
        });
        setContentPane(contentPane);
        
        JButton btnViewPurchases = new JButton("\u03A0\u03C1\u03BF\u03B2\u03BF\u03BB\u03AE ");
        btnViewPurchases.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnViewPurchases.setBounds(784, 310, 100, 26);
        contentPane.add(btnViewPurchases);

        btnViewPurchases.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewPurchasesAndTotal();
            }
        });
        btnViewPurchases.setToolTipText("Προβολή λογαριασμών των πελατών");
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(45, 90, 471, 421);
        contentPane.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        // Νέος κώδικας: Καλέστε τη μέθοδο table_load() για να φορτώσετε τα δεδομένα στον πίνακα.
        table_load();
        


    }
    
    private void viewPurchasesAndTotal() {
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##elvagio2","tiger");
            
            // Εμφάνιση αγορών για τον επιλεγμένο πελάτη
            String purchasesQuery = "SELECT * FROM gas WHERE nameg = ?";
            try (PreparedStatement purchasesStatement = connection.prepareStatement(purchasesQuery)) {
                String selectedClient = txtUserId.getText(); // Χρησιμοποιεί το ID χρήστη από το πεδίο εισαγωγής
                purchasesStatement.setString(1, selectedClient);
                ResultSet purchasesResultSet = purchasesStatement.executeQuery();

                StringBuilder purchasesMessage = new StringBuilder("Αγορές του πελάτη " + selectedClient + " από καύσιμα:\n");

                while (purchasesResultSet.next()) {
                    double price = purchasesResultSet.getDouble("priceg");
                    purchasesMessage.append("Τιμή: ").append(price).append("€\n");
                }

                // Εμφάνιση συνολικού λογαριασμού του πελάτη
                String accountQuery = "SELECT SUM(priceg) AS total FROM gas WHERE nameg = ?";
                try (PreparedStatement accountStatement = connection.prepareStatement(accountQuery)) {
                    accountStatement.setString(1, selectedClient);
                    ResultSet accountResultSet = accountStatement.executeQuery();

                    if (accountResultSet.next()) {
                        double totalAccount = accountResultSet.getDouble("total");
                        purchasesMessage.append("Συνολικός Λογαριασμός: ").append(totalAccount).append("€");
                    }
                }

                JOptionPane.showMessageDialog(this, purchasesMessage.toString(), "Αγορές και Συνολικός Λογαριασμός", JOptionPane.INFORMATION_MESSAGE);
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Σφάλμα κατά την ανάκτηση δεδομένων", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    

    private void showUsers() {
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##elvagio2","tiger");
            
            String query = "SELECT id, username FROM users";
            try (PreparedStatement st = connection.prepareStatement(query)) {
                ResultSet rs = st.executeQuery();

                StringBuilder userMessage = new StringBuilder("Users:\n");

                while (rs.next()) {
                    int userId = rs.getInt("id");
                    String username = rs.getString("username");
                    userMessage.append("ID: ").append(userId).append(", Username: ").append(username).append("\n");
                }

                if (userMessage.toString().equals("Users:\n")) {
                    JOptionPane.showMessageDialog(this, "No users found.", "User List", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, userMessage.toString(), "User List", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving user list. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
 


    private void deleteUser() {
        String userIdToDelete = txtUserId.getText();

        if (userIdToDelete != null && !userIdToDelete.isEmpty()) {
            try {
            	Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##elvagio2","tiger");
               
                String query = "DELETE FROM users WHERE id=?";
                try (PreparedStatement st = connection.prepareStatement(query)) {
                    st.setString(1, userIdToDelete);
                    st.executeUpdate();
                }

                connection.close();
                JOptionPane.showMessageDialog(this, "User deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error deleting user. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a user id.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void table_load() {
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##elvagio2","tiger");
            pst = con.prepareStatement("select * from users");
            rs = pst.executeQuery();

            // Create a DefaultTableModel and set it for the JTable
            this.tableModel = new DefaultTableModel();
            this.tableModel.addColumn("ID");
            this.tableModel.addColumn("Username");

            while (rs.next()) {
                String id = rs.getString("id");
                String username = rs.getString("username");
                this.tableModel.addRow(new Object[]{id, username});
            }

            // Set the table model
            table.setModel(this.tableModel);
            this.tableModel.fireTableDataChanged();
        } catch (SQLException e) {
            e.printStackTrace();
        }
  }

    private void openFuelPricesPage() {
        FuelEditWindow fuelPricesPage = new FuelEditWindow();
        fuelPricesPage.setVisible(true);
    }
}
