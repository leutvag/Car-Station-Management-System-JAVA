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

public class MessageWindow extends JFrame {
    private final JTable table = new JTable();

    public MessageWindow() {
        setTitle("Παράθυρο Μηνυμάτων");
        setBounds(100, 100, 791, 494);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(173, 216, 230));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(152, 39, 585, 414);
        panel.add(panel_1);

        // Ορίστε τα ονόματα των στηλών
        String[] columnNames = {"ID", "DM"};

        // Εδώ θα αποθηκεύονται τα δεδομένα του πίνακα
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        // Συνδέστε το JTable με το DefaultTableModel
        table.setModel(model);

        // Προσθέστε το JTable σε ένα JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        panel_1.add(scrollPane);

        JLabel lblNewLabel = new JLabel("\u039C\u0397\u039D\u03A5\u039C\u0391\u03A4\u0391 \u03A0\u0395\u039B\u0391\u03A4\u03A9\u039D");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(370, 11, 182, 22);
        panel.add(lblNewLabel);

        JButton btnExit = new JButton("EXIT");
        btnExit.setForeground(new Color(255, 255, 255));
        btnExit.setBackground(new Color(255, 0, 0));
        btnExit.setBounds(21, 396, 85, 26);
        btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        panel.add(btnExit);

        // Φορτώστε τα δεδομένα από τον πίνακα "contact"
        loadDataFromDatabase();
    }

    private void loadDataFromDatabase() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##elvagio2", "tiger");

            String query = "SELECT id, dm FROM contact";
            try (PreparedStatement st = connection.prepareStatement(query)) {
                ResultSet resultSet = st.executeQuery();

                // Προσθέστε τα δεδομένα από τη βάση στον πίνακα
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                while (resultSet.next()) {
                    Object[] rowData = {
                            resultSet.getInt("id"),
                            resultSet.getString("dm")
                    };
                    model.addRow(rowData);
                }
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading data from database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
