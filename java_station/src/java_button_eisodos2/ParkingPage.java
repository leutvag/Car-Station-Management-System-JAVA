package java_button_eisodos2;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.EventQueue;

class DatabaseManager {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "c##elvagio2";
    private static final String PASSWORD = "tiger";

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

public class ParkingPage extends JFrame {
    private JPanel contentPane;
    private JComboBox<String> optionsComboBox;
    private JLabel valueLabel;
    private JLabel messageLabel;
    private final int userId;

    public ParkingPage(int userId) {
        this.userId = userId;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 517, 432);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 145, 145));
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("\u03A3\u03C4\u03AC\u03B8\u03BC\u03B5\u03C5\u03C3\u03B7");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(202, 10, 121, 30);
        contentPane.add(lblNewLabel);

        optionsComboBox = new JComboBox<>(new String[]{"Ημερήσια", "Εβδομαδιαία", "Μηνιαία"});
        optionsComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
        optionsComboBox.setBounds(334, 70, 120, 30);
        contentPane.add(optionsComboBox);

        valueLabel = new JLabel("Επιλέξτε τύπο στάθμευσης:");
        valueLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        valueLabel.setBounds(34, 70, 250, 30);
        contentPane.add(valueLabel);

        messageLabel = new JLabel("");
        messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        messageLabel.setBounds(80, 170, 400, 30);
        contentPane.add(messageLabel);

        optionsComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateValueLabel();
            }
        });

        JButton btnSaveToDatabase = new JButton("Καταχώρηση");
        btnSaveToDatabase.setForeground(new Color(255, 255, 255));
        btnSaveToDatabase.setBackground(new Color(0, 0, 0));
        btnSaveToDatabase.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSaveToDatabase.setBounds(294, 351, 186, 29);
        contentPane.add(btnSaveToDatabase);

        btnSaveToDatabase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveToDatabase();
            }
        });

        JButton btnBack = new JButton("EXIT");
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBackground(new Color(0, 0, 0));
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnBack.setBounds(20, 350, 80, 30);
        contentPane.add(btnBack);

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setContentPane(contentPane);
    }

    private void updateValueLabel() {
        String selectedOption = (String) optionsComboBox.getSelectedItem();
        double price = calculatePrice(selectedOption);
        valueLabel.setText("Τιμή Στάθμευσης: " + price + " ευρώ");
    }

    private double calculatePrice(String option) {
        switch (option) {
            case "Ημερήσια":
                return 20.0;
            case "Εβδομαδιαία":
                return 100.0;
            case "Μηνιαία":
                return 150.0;
            default:
                return 0.0;
        }
    }

    private void saveToDatabase() {
        String selectedOption = (String) optionsComboBox.getSelectedItem();
        double price = calculatePrice(selectedOption);

        int result = JOptionPane.showConfirmDialog(ParkingPage.this, "Είστε σίγουρος ότι θέλετε να καταχωρήσετε τα δεδομένα;", "Επιβεβαίωση", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            try (Connection connection = DatabaseManager.getConnection()) {
            	String sql = "INSERT INTO parking ( namep, pricep,id) VALUES (?, ?, ?)";	
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                    statement.setInt(1, userId);
                    statement.setString(1, selectedOption);
                    statement.setDouble(2, price);
                    statement.setInt(3, userId);
                    statement.executeUpdate();
                    messageLabel.setText("Τα δεδομένα αποθηκεύτηκαν στη βάση δεδομένων.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            messageLabel.setText("Η καταχώρηση ακυρώθηκε.");
        }
    }
}

