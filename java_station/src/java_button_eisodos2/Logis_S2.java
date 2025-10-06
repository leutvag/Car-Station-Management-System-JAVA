package java_button_eisodos2;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Logis_S2 {

    private JFrame frame;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private int userId;
    private String username;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Logis_S2 window = new Logis_S2();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Logis_S2() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(550, 275, 788, 513);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);

        ImageIcon icon = new ImageIcon("img/icon_name");
        frame.setIconImage(icon.getImage());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 102, 102));
        panel.setBounds(0, 0, 383, 474);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("\\java_button_eisodos2.icon\\login.png"));
        lblNewLabel.setBounds(140, 107, 96, 96);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("WELCOME");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel_2.setBounds(117, 200, 150, 53);
        panel.add(lblNewLabel_2);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(96, 250, 179, 2);
        panel.add(separator_2);

        JLabel lblLogin = new JLabel("LOGIN");
        lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblLogin.setBounds(540, 11, 80, 31);
        frame.getContentPane().add(lblLogin);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblUsername.setBounds(438, 120, 95, 22);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPassword.setBounds(438, 198, 95, 22);
        frame.getContentPane().add(lblPassword);

        txtUsername = new JTextField();
        txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtUsername.setBounds(438, 151, 249, 31);
        frame.getContentPane().add(txtUsername);
        txtUsername.setColumns(10);

        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtPassword.setBounds(438, 231, 249, 31);
        frame.getContentPane().add(txtPassword);
        txtPassword.setToolTipText("Απαιτούνται τουλάχιστον 4 χαρακτήρες, 2 ψηφία και 1 σύμβολο");

        final JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##elvagio2", "tiger");

                    PreparedStatement st = connection.prepareStatement("Select username, password, id from users where username=? and password=?");
                    st.setString(1, username);
                    st.setString(2, password);

                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        userId = rs.getInt("id");
                        JOptionPane.showMessageDialog(btnLogin, "You have successfully logged in");
                        frame.dispose();
                        openStoreWindow();
                    } else {
                        JOptionPane.showMessageDialog(btnLogin, "Wrong Username & Password");
                    }

                    connection.close();
                } catch (ClassNotFoundException | SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        btnLogin.setBounds(412, 297, 95, 31);
        frame.getContentPane().add(btnLogin);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtUsername.setText(null);
                txtPassword.setText(null);
            }
        });

        btnReset.setBounds(526, 297, 95, 31);
        frame.getContentPane().add(btnReset);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frmLoginSystem = new JFrame("Exit");
                if (JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit", "Login Systems",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        btnExit.setBounds(641, 297, 95, 31);
        frame.getContentPane().add(btnExit);

        JButton btnCreateAccount1 = new JButton("Create Account");
        btnCreateAccount1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createAccount();
            }
        });

        btnCreateAccount1.setBounds(599, 416, 95, 31);
        frame.getContentPane().add(btnCreateAccount1);
        JButton btnstaff = new JButton("Προσωπικό");
        
        btnstaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String staffUsername = JOptionPane.showInputDialog(frame, "Εισαγωγή Ονόματος Χρήστη:");
                if (staffUsername == null) {
                    return; // Ο χρήστης ακύρωσε την εισαγωγή
                }

                String staffPassword = new String(JOptionPane.showInputDialog(frame, "Εισαγωγή Κωδικού Πρόσβασης:"));

                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##elvagio2", "tiger");

                    PreparedStatement st = connection.prepareStatement("SELECT username_staff, password_staff FROM staff WHERE username_staff=? AND password_staff=?");
                    st.setString(1, staffUsername);
                    st.setString(2, staffPassword);

                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        // Επιτυχημένη σύνδεση προσωπικού
                        JOptionPane.showMessageDialog(frame, "Επιτυχής σύνδεση προσωπικού");
                        openStaffWindow(); // ’νοιγμα του νέου παραθύρου προσωπικού
                    } else {
                        JOptionPane.showMessageDialog(frame, "Λάθος Όνομα Χρήστη και Κωδικός Πρόσβασης για το Προσωπικό");
                    }

                    connection.close();
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Σφάλμα κατά τη σύνδεση προσωπικού. Παρακαλούμε προσπαθήστε ξανά.", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnstaff.setBounds(426, 416, 95, 31);
        frame.getContentPane().add(btnstaff);

        btnLogin.setToolTipText("Σύνδεση σε υπάρχον λογαριασμό");
        btnReset.setToolTipText("Καθαρισμός όλων των τιμών");
        btnExit.setToolTipText("Έξοδος από την Εφαρμογή");
        btnCreateAccount1.setToolTipText("Δημιουργία ενός νέου λογαριασμού");
        txtUsername.setToolTipText("Παρακαλώ πληκτρολογήστε το username");
        btnstaff.setToolTipText("Είσοδος Προσωπικού");
        
        btnLogin.setFocusable(false); // ΣΒΗΝΕΙ ΤΟ ΠΕΡΙΓΡΑΜΜΑ
        btnReset.setFocusable(false);
        btnExit.setFocusable(false);
        btnCreateAccount1.setFocusable(false);
        btnstaff.setFocusable(false);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(509, 40, 134, 2);
        frame.getContentPane().add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(393, 387, 369, 2);
        frame.getContentPane().add(separator_1);
        
//        JButton btnstaff = new JButton("Staff");
//        btnstaff.setBounds(426, 416, 95, 31);
//        frame.getContentPane().add(btnstaff);
        
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
    
    private void openStaffWindow() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StaffWindow staffWindow = new StaffWindow();
                    staffWindow.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

//    private void openStoreWindow() {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    StoreWindow storeWindow = new StoreWindow(userId, username);
//                    storeWindow.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
    private void openStoreWindow() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StoreWindow storeWindow = new StoreWindow(userId, username);
                    storeWindow.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private void createAccount() {
        String newUsername = JOptionPane.showInputDialog(frame, "Enter a new username:");

        if (newUsername == null) {
            return;
        }

        boolean passwordsMatch = false;
        String newPassword1 = null;

        while (!passwordsMatch) {
            newPassword1 = JOptionPane.showInputDialog(frame, "Enter a new password:");

            // Ελέγξτε αν ο χρήστης πάτησε το "Cancel"
            if (newPassword1 == null) {
                break;
            }

            String newPassword2 = JOptionPane.showInputDialog(frame, "Enter the password again:");

            // Αν ο χρήστης πάτησε "Cancel" ή οι κωδικοί είναι ίδιοι, κλείστε τη διαδικασία
            if (newPassword2 == null || newPassword1.equals(newPassword2)) {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##elvagio2", "tiger");

                    // Δεν προσθέτουμε το πεδίο "ID" εδώ, αφήνοντας το στο σύστημα διαχείρισης βάσης δεδομένων να το διαχειριστεί
                    String query = "INSERT INTO users ( username, password) VALUES ( ?, ?)";
                    try (PreparedStatement st = connection.prepareStatement(query)) {
                        st.setString(1, newUsername);
                        st.setString(2, newPassword1);
                        st.executeUpdate();
                    }

                    connection.close();

                    JOptionPane.showMessageDialog(frame, "Account created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    passwordsMatch = true;
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error creating the account. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Οι κωδικοί πρέπει να είναι ίδιοι", "Προειδοποίηση", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
//    private void openLogis_S2Window() {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    Logis_S2.this.setVisible(true);  // Κάνετε ορατό το τρέχον παράθυρο Logis_S2
//                    Logis_S2.this.toFront();  // Φέρετε το παράθυρο στο προσκήνιο
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    
}
    
    

