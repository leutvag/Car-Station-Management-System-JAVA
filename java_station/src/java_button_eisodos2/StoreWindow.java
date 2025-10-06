package java_button_eisodos2;

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
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class StoreWindow extends JFrame {
    private final int userId;
    private String username;
    private JPanel contentPane;

    public StoreWindow(final int userId, final String username) {
        this.userId = userId;
        this.username = username;
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 797, 539);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 145, 145));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("\u039A\u0391\u03A4\u0391\u03A3\u03A4\u0397\u039C\u0391");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBackground(new Color(0, 0, 0));
        lblNewLabel.setBounds(328, 40, 136, 43);
        contentPane.add(lblNewLabel);

        JButton btnNewButton = new JButton("ΚΑΥΣΙΜΑ");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setFocusable(false);
        btnNewButton.setBounds(47, 245, 127, 33);
        contentPane.add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openKausima();
            }
        });

        JButton btnNewButton_1 = new JButton("ΑΝΤΑΛΛΑΚΤΙΚΑ");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_1.setFocusable(false);
        btnNewButton_1.setBounds(231, 245, 141, 33);
        contentPane.add(btnNewButton_1);

        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AntallaktikaPage antallaktikaPage = new AntallaktikaPage(userId, username);
                antallaktikaPage.setVisible(true);
            }
        });

        JButton btnNewButton_2 = new JButton("ΣΥΝΤΗΡΗΣΗ");
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_2.setFocusable(false);
        btnNewButton_2.setBounds(433, 245, 127, 33);
        contentPane.add(btnNewButton_2);

        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MaintenancePage maintenancePage = new MaintenancePage(userId);
                maintenancePage.setVisible(true);
            }
        });

        JButton btnParking = new JButton("ΣΤΑΘΜΕΥΣΗ");
        btnParking.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnParking.setFocusable(false);
        btnParking.setBounds(618, 245, 127, 33);
        contentPane.add(btnParking);

        btnParking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openParkingPage();
            }
        });

        JButton btnEdit = new JButton("ΕΠΕΞΕΡΓΑΣΙΑ");
        btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnEdit.setFocusable(false);
        btnEdit.setBounds(32, 350, 131, 33);
        contentPane.add(btnEdit);

        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char[] enteredCode = promptForAdminCode();

                if (enteredCode != null && checkAdminCode(enteredCode)) {
                    EditWindow editWindow = new EditWindow();
                    editWindow.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Invalid admin code.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton btnNewButton_4 = new JButton("EXIT");
        btnNewButton_4.setForeground(new Color(255, 255, 255));
        btnNewButton_4.setBackground(new Color(255, 0, 0));
        btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton_4.setFocusable(false);
        btnNewButton_4.setBounds(652, 452, 85, 21);
        contentPane.add(btnNewButton_4);

        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JButton btnHelp = new JButton("\u0392\u039F\u0397\u0398\u0395\u0399\u0391");
        btnHelp.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnHelp.setFocusable(false);
        btnHelp.setBounds(328, 350, 127, 33);
        contentPane.add(btnHelp);

        btnHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openHelpPage();
            }
        });

        btnNewButton.setToolTipText("Καυσίμα");
        btnNewButton_1.setToolTipText("Ανταλλακτικά");
        btnNewButton_2.setToolTipText("Συντήρηση");
        btnParking.setToolTipText("Στάθμευση");
        btnEdit.setToolTipText("Επεξεργασία");
        btnNewButton_4.setToolTipText("Έξοδος");
        
        JButton btnDeleteUser = new JButton("ΔΙΑΓΡΑΦΗ ΧΡΗΣΤΗ");
        btnDeleteUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnDeleteUser.setFocusable(false);
        btnDeleteUser.setBounds(20, 445, 180, 33);
        contentPane.add(btnDeleteUser);

        btnDeleteUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(contentPane, "Είστε σίγουρος ότι θέλετε να διαγράψετε τον λογαριασμό σας;", "Επιβεβαίωση Διαγραφής", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    deleteUser();
                }
            }
        });


        JLabel lblNewLabel_1 = new JLabel("\u039A\u0391\u039B\u03A9\u03A3 \u0397\u03A1\u0398\u0391\u03A4\u0395 \u03A3\u03A4\u039F \u039A\u0391\u03A4\u0391\u03A3\u03A4\u0397\u039C\u0391 \u039C\u0391\u03A3");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(231, 106, 381, 43);
        contentPane.add(lblNewLabel_1);

        JSeparator separator = new JSeparator();
        separator.setBounds(209, 147, 364, 2);
        contentPane.add(separator);

        JButton btn_contact = new JButton("\u0395\u03A0\u0399\u039A\u039F\u0399\u039D\u03A9\u039D\u0399\u0391");
        btn_contact.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_contact.setBounds(618, 352, 142, 33);
        contentPane.add(btn_contact);

        btn_contact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openContactDialog();
            }
        });
        btn_contact.setToolTipText("Επικοινωνήστε μαζί μας");
        btn_contact.setFocusable(false);
    }

    private char[] promptForAdminCode() {
        JPasswordField passwordField = new JPasswordField();
        int action = JOptionPane.showConfirmDialog(contentPane, passwordField, "Enter admin code:", JOptionPane.OK_CANCEL_OPTION);

        if (action == JOptionPane.OK_OPTION) {
            return passwordField.getPassword();
        } else {
            return null;
        }
    }

    private boolean checkAdminCode(char[] enteredCode) {
        char[] adminCode = retrieveAdminCodeFromDatabase();
        return Arrays.equals(enteredCode, adminCode);
    }

    private void deleteUser() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##elvagio2", "tiger");

            String deleteQuery = "DELETE FROM users WHERE id = ?";
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                deleteStatement.setInt(1, userId);

                int rowsAffected = deleteStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(contentPane, "Ο χρήστης διαγράφηκε επιτυχώς.", "Επιτυχία", JOptionPane.INFORMATION_MESSAGE);
                    dispose();  // Κλείστε το τρέχον παράθυρο μετά τη διαγραφή

                    // Ανοίγετε ένα νέο παράθυρο Logis_S2
//                    openLogis_S2Window();
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Σφάλμα κατά τη διαγραφή του χρήστη.", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
                }
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(contentPane, "Σφάλμα κατά την επικοινωνία με τη βάση δεδομένων.", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
        }
    }

//    private void openLogis_S2Window() {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    Logis_S2 logisS2 = new Logis_S2();  // Δημιουργία ενός νέου αντικειμένου Logis_S2
//                    logisS2.setVisible(true);  // Κάνετε ορατό το νέο παράθυρο Logis_S2
//                    logisS2.toFront();  // Φέρετε το παράθυρο στο προσκήνιο
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }






    
    
    
    private char[] retrieveAdminCodeFromDatabase() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##elvagio2", "tiger");

            PreparedStatement st = connection.prepareStatement("SELECT password FROM users WHERE id = 1");
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return rs.getString("password").toCharArray();
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void openKausima() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Kausima kausimaPage = new Kausima(userId, username);
                    kausimaPage.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void openParkingPage() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ParkingPage parkingPage = new ParkingPage(userId);
                    parkingPage.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void openHelpPage() {
        Help helpPage = new Help();
        helpPage.setVisible(true);
    }

    private void openContactDialog() {
        JTextArea messageArea = new JTextArea();
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);

        Object[] message = {
                "ID: " + userId + " - " + username,
                "Γράψτε το μήνυμά σας:",
                messageArea
        };

        int option = JOptionPane.showConfirmDialog(contentPane, message, "Επικοινωνία", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String messageText = messageArea.getText();
            saveContactMessage(userId, messageText);
        }
    }

    private void saveContactMessage(int userId, String message) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##elvagio2", "tiger");

            String query = "INSERT INTO contact (id, dm) VALUES (?, ?)";
            try (PreparedStatement st = connection.prepareStatement(query)) {
                st.setInt(1, userId);
                st.setString(2, message);

                int rowsAffected = st.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(contentPane, "Το μήνυμα εστάλη επιτυχώς.", "Επιτυχία", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Σφάλμα κατά την αποθήκευση του μηνύματος.", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
                }
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}
