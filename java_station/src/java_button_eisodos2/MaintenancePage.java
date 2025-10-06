package java_button_eisodos2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MaintenancePage extends JFrame {
    private int userId;
    private JTextField txtName;
    private JTextField txtCarPlate;
    private JButton btnSave;
    private JButton btnExit;
    private JComboBox<String> dateComboBox;

    public MaintenancePage(int userId) {
        this.userId = userId;
        getContentPane().setBackground(new Color(0, 145, 145));
        getContentPane().setLayout(null);

        txtName = new JTextField();
        txtName.setBounds(84, 90, 161, 30);
        getContentPane().add(txtName);
        txtName.setColumns(10);

        txtCarPlate = new JTextField();
        txtCarPlate.setBounds(84, 156, 161, 30); 
        getContentPane().add(txtCarPlate);
        txtCarPlate.setColumns(10);

        JLabel lblNewLabel = new JLabel("Συντήρηση Αυτοκινήτου");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(145, 27, 226, 30);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel(" Παρακαλώ εισάγετε το Ονοματεπώνυμό σας");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(80, 67, 271, 24);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel(" Παρακαλώ εισάγετε την πινακίδα του αυτοκινήτου σας");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1_1.setBounds(80, 130, 342, 24);
        getContentPane().add(lblNewLabel_1_1);

        btnExit = new JButton("ΕΧΙΤ");
        btnExit.setBackground(new Color(0, 0, 0));
        btnExit.setForeground(new Color(255, 255, 255));
        btnExit.setBounds(10, 370, 85, 30);
        getContentPane().add(btnExit);

        btnSave = new JButton("Καταχώρηση");
        btnSave.setForeground(Color.WHITE);
        btnSave.setBackground(Color.BLACK);
        btnSave.setBounds(382, 370, 113, 30);
        getContentPane().add(btnSave);

        // Προσθήκη JComboBox για τις ημερομηνίες
        String[] dateOptions = {"20/12/2023", "21/12/2023", "22/12/2023", "23/12/2023","6/1/2024","6/1/2024","7/1/2024","12/1/2024"};  
        dateComboBox = new JComboBox<>(dateOptions);
        dateComboBox.setBounds(84, 200, 161, 30);
        getContentPane().add(dateComboBox);

        setSize(524, 445);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);

        initialize();
    }

    private void initialize() {
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void saveData() {
        String name = txtName.getText();
        String sign_car = txtCarPlate.getText();
        String selectedDate = (String) dateComboBox.getSelectedItem();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##elvagio2", "tiger");

            String query = "INSERT INTO cars (id, sign_car, name, date_car) VALUES (?, ?, ?, ?)";
            try (PreparedStatement st = connection.prepareStatement(query)) {
                st.setInt(1, userId);
                st.setString(2, sign_car);
                st.setString(3, name);
                st.setString(4, selectedDate);
                st.executeUpdate();
            }

            connection.close();

            JOptionPane.showMessageDialog(this, "Τα δεδομένα αποθηκεύτηκαν επιτυχώς!");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Σφάλμα κατά την αποθήκευση των δεδομένων.", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
        }
    }
}

