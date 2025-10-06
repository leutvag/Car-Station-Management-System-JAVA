package java_button_eisodos2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

public class Help extends JDialog {
    public Help() {
        setTitle("Help");
        setBounds(100, 100, 670, 411);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 128, 128));
        setContentPane(contentPane);
        contentPane.setLayout(null);
 
        JButton btnButton1 = new JButton("EXIT");
        btnButton1.setForeground(new Color(255, 255, 255));
        btnButton1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnButton1.setBackground(new Color(255, 0, 0));
        btnButton1.setBounds(32, 306, 94, 27);
        contentPane.add(btnButton1);

        JButton btnButton2 = new JButton("\u03A0\u03C1\u03CC\u03B2\u03BB\u03B7\u03BC\u03B1 \u039A\u03B1\u03C4\u03B1\u03C7\u03CE\u03C1\u03B7\u03C3\u03B7\u03C2 \u03A0\u03B1\u03C1\u03B1\u03B3\u03B3\u03B5\u03BB\u03AF\u03B1\u03C2");
        btnButton2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnButton2.setBounds(325, 72, 293, 41);
        contentPane.add(btnButton2);
        
        JLabel lblNewLabel = new JLabel("\u039A\u0395\u039D\u03A4\u03A1\u039F \u0392\u039F\u0397\u0398\u0395\u0399\u0391\u03A3");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(249, 5, 163, 41);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("\u03A4\u0397\u039B: 21000000000");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(10, 48, 133, 22);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("\u03A3\u03C7\u03B5\u03C4\u03B9\u03BA\u03AC \u03BC\u03B5 \u03C4\u03B7\u03BD \u03B5\u03C6\u03B1\u03C1\u03BC\u03BF\u03B3\u03AE: ");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(129, 76, 198, 54);
        contentPane.add(lblNewLabel_2);
        
        JButton btnButton2_1 = new JButton("\u0397 \u0395\u03C6\u03B1\u03C1\u03BC\u03BF\u03B3\u03AE \u03B4\u03B5\u03BD \u0391\u03BD\u03C4\u03B1\u03C0\u03BF\u03BA\u03C1\u03AF\u03BD\u03B5\u03C4\u03B1\u03B9");
        btnButton2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnButton2_1.setBounds(325, 174, 293, 41);
        contentPane.add(btnButton2_1);
        
        JButton btnButton2_2 = new JButton("\u03A0\u03C1\u03CC\u03B2\u03BB\u03B7\u03BC\u03B1 \u03A3\u03CD\u03BD\u03B4\u03B5\u03C3\u03B7\u03C2 \u039B\u03BF\u03B3\u03B1\u03C1\u03B9\u03B1\u03C3\u03BC\u03BF\u03CD");
        btnButton2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnButton2_2.setBounds(325, 123, 293, 41);
        contentPane.add(btnButton2_2);
        
        JButton btnButton2_3 = new JButton("\u03A0\u03CE\u03C2 \u0394\u03B9\u03B1\u03B3\u03C1\u03AC\u03C6\u03C9 \u03C4\u03BF\u03BD \u039B\u03BF\u03B3\u03B1\u03C1\u03B9\u03B1\u03C3\u03BC\u03CC \u03BC\u03BF\u03C5;");
        btnButton2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnButton2_3.setBounds(325, 225, 293, 41);
        contentPane.add(btnButton2_3);
        
        btnButton1.setFocusable(false);
        btnButton2.setFocusable(false);
        btnButton2_1.setFocusable(false);
        btnButton2_2.setFocusable(false);
        btnButton2_3.setFocusable(false);
        
        btnButton1.setToolTipText("Έξοδος από την σελίδα");
        btnButton2_1.setToolTipText("Πρόβλημα καταχώρησης παραγγελίας");
        btnButton2_2.setToolTipText("Πρόβλημα σύνδεσης λογαριασμού");
        btnButton2_3.setToolTipText("Η εφαρμογή δεν ανταποκρίνεται");
        
        
        
        
        // Προσθήκη ActionListener για το πρώτο κουμπί
        btnButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Κώδικας για το κλείσιμο του παραθύρου
                dispose();
            }
        }); 

        // Προσθήκη ActionListener για το δεύτερο κουμπί
        btnButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ζητήστε από τον υπολογιστή να κάνει μια ερώτηση
//                String computerQuestion = "Πώς είναι η ημέρα σας;";

                // Εμφανίστε την ερώτηση και πάρτε την απάντηση του χρήστη
//                String userAnswer = JOptionPane.showInputDialog(contentPane, computerQuestion);

                // Εμφανίστε την απάντηση του χρήστη
//                JOptionPane.showMessageDialog(contentPane, "Η απάντησή σας: " + userAnswer, "Απάντηση", JOptionPane.INFORMATION_MESSAGE);
            	String name= JOptionPane.showInputDialog("Ποιο είναι το ονομά σας; (Γράψτε μόνο στα ελληνικά)");
            	String ap1=JOptionPane.showInputDialog("Γεια σας κυριε/ια" + " " + name + " έχετε πρόβλημα με την καταχώρηση της παραγγελίας σας;");
            	if(ap1.equals("nai") || ap1.equals("Nai") || ap1.equals("NAI") || ap1.equals("ναι") || ap1.equals("Ναι") || ap1.equals("ΝΑΙ") ) {
//        		JOptionPane.showMessageDialog(null, "Γεια σας κυριε/ια" + " " + name + "έχετε πρόβλημα με την καταχώρηση της παραγγελίας σας;");
            		String ap3=JOptionPane.showInputDialog("Το πρόβλημα που αντιμετωπίζετε συμβαίνει στις παραγγελίες των ανταλλακτικών, των καυσίμων ή της στάθμευσης; (χρησιμοποιήστε μία από τις τρείς λέξης αυτούσια");
            		if(ap3.equals("ανταλλακτικών") || ap3.equals("Ανταλλακτικών") || ap3.equals("ΑΝΤΑΛΛΑΚΤΙΚΩΝ") ) {
            			String ap33=JOptionPane.showInputDialog("Όταν πατάτε το κουμπί 'ΚΑΤΑΧΩΡΗΣΗ Ή ΑΠΟΘΗΚΕΥΣΗ' σας εμφανίζεται το μήνυμα ΄ΕΠΙΤΥΧΗΣ ΚΑΤΑΧΩΡΗΣΗ ΠΑΡΑΓΓΕΛΊΑΣ΄;");
	            			if(ap33.equals("nai") || ap33.equals("Nai") || ap33.equals("NAI") || ap33.equals("ναι") || ap33.equals("Ναι") || ap33.equals("ΝΑΙ") ) {
	            				JOptionPane.showMessageDialog(null,"Από ότι καταλαβαίνω εφόσον σας εμφανίζεται το μήνυμα δεν υπάρχει πρόβλημα με την παραγγελία σας!");
	            				  
	            			}else {
	            				String ap333=JOptionPane.showInputDialog("Έχετε επιλέξει τουλάχιστον 1 ανταλλακτικό;");
	            				if(ap333.equals("nai") || ap333.equals("Nai") || ap333.equals("NAI") || ap333.equals("ναι") || ap333.equals("Ναι") || ap333.equals("ΝΑΙ") ) {
	            					JOptionPane.showMessageDialog(null,"Αν δεν σας εμφανίζεται το μήνυμα ή υπάρχει κάποιο άλλο πρόβλημα απλά πατήστε στο κουμπί ΕΠΙΚΟΙΝΩΝΊΑ και ειδοποιήστε μας! Ευχαριστώ!");
	            				}else {
	            					JOptionPane.showMessageDialog(null,"Επιλέξτε τουλάχιστον 1 ανταλλακτικό και αν το πρόβλημα συνεχίζει πατήστε στο Κουμπί επικοινωνία!");
	            				}
	            				
	            			}
            		}else if(ap3.equals("καυσίμων") || ap3.equals("Καυσίμων") || ap3.equals("ΚΑΥΣΙΜΩΝ")) {
            			String ap32=JOptionPane.showInputDialog("Όταν πατάτε το κουμπί 'ΚΑΤΑΧΩΡΗΣΗ Ή ΑΠΟΘΗΚΕΥΣΗ' σας εμφανίζεται το μήνυμα ΄ΕΠΙΤΥΧΗΣ ΚΑΤΑΧΩΡΗΣΗ ΠΑΡΑΓΓΕΛΊΑΣ΄;");
            			if(ap32.equals("nai") || ap32.equals("Nai") || ap32.equals("NAI") || ap32.equals("ναι") || ap32.equals("Ναι") || ap32.equals("ΝΑΙ") ) {
            				JOptionPane.showMessageDialog(null,"Από ότι καταλαβαίνω εφόσον σας εμφανίζεται το μήνυμα δεν υπάρχει πρόβλημα με την παραγγελία σας!");
            				  
            			}else {
            				String ap322=JOptionPane.showInputDialog("Έχετε επιλέξει καύσιμο και ποσότητα;");
            				if(ap322.equals("nai") || ap322.equals("Nai") || ap322.equals("NAI") || ap322.equals("ναι") || ap322.equals("Ναι") || ap322.equals("ΝΑΙ") ) {
            					JOptionPane.showMessageDialog(null,"Αν έχετε επιλέξει καύσιμο και πληκτρολογήσατε την ποσότητα, προσπαθήστε να επιλέξετε πρώτα την ποσότητα και μετά το καύσιμο ώστε να σας εμφανιστεί η συνολική τιμή!");
            					JOptionPane.showMessageDialog(null,"Αν συνεχίζετε να έχετε πρόβλημα στείλτε μας μήνυμα πατώντας το κουμπί επικοινωνία!");

            				}else {
            					JOptionPane.showMessageDialog(null,"Επιλέξτε πρώτα την ποσότητα και μετά το καύσιμο που επιθυμείτε έτσι ώστε να σας εμφανιστεί η συνολική τιμή");
            					JOptionPane.showMessageDialog(null,"Αν συνεχίζετε να έχετε πρόβλημα στείλτε μας μήνυμα πατώντας το κουμπί επικοινωνία!");

            				}
            				
            			}
            		}else if(ap3.equals("στάθμευσης") || ap3.equals("Στάθμευσης") || ap3.equals("ΣΤΑΘΜΕΥΣΗΣ")) {
            			String ap31=JOptionPane.showInputDialog("Όταν πατάτε το κουμπί 'ΚΑΤΑΧΩΡΗΣΗ Ή ΑΠΟΘΗΚΕΥΣΗ' σας εμφανίζεται το μήνυμα ΄ΕΠΙΤΥΧΗΣ ΚΑΤΑΧΩΡΗΣΗ ΠΑΡΑΓΓΕΛΊΑΣ΄;");
            			if(ap31.equals("nai") || ap31.equals("Nai") || ap31.equals("NAI") || ap31.equals("ναι") || ap31.equals("Ναι") || ap31.equals("ΝΑΙ") ) {
            				JOptionPane.showMessageDialog(null,"Από ότι καταλαβαίνω εφόσον σας εμφανίζεται το μήνυμα δεν υπάρχει πρόβλημα με την παραγγελία σας!");
            				  
            			}else {
            				String ap311=JOptionPane.showInputDialog("Έχετε επιλέξει μία από τις τρεις επιλογές στάθμευσης;");
            				if(ap311.equals("nai") || ap311.equals("Nai") || ap311.equals("NAI") || ap311.equals("ναι") || ap311.equals("Ναι") || ap311.equals("ΝΑΙ") ) {
            					JOptionPane.showMessageDialog(null,"Αν έχετε επιλέξει τότε θα πρέπει να σας εμφανίζεται από κάτω η συνολική τιμή!");
            					JOptionPane.showMessageDialog(null,"Αν συνεχίζετε να έχετε πρόβλημα στείλτε μας μήνυμα πατώντας το κουμπί επικοινωνία!");

            				}else {
            					JOptionPane.showMessageDialog(null,"Επιλέξτε πρώτα μία από τις τρεις επιλογές που διαθέτει ο σταθμός μας και έπειτα πατήστε το κουμπί καταχώρηση/αποθήκευση");
            					JOptionPane.showMessageDialog(null,"Αν συνεχίζετε να έχετε πρόβλημα στείλτε μας μήνυμα πατώντας το κουμπί επικοινωνία!");

            				}
            				
            			}
            		}
            	
            	
            	}else {
					JOptionPane.showMessageDialog(null,"Εφόσον δεν έχετε κάποιο πρόβλημα με την παραγγελίας σας, σας αφήνω να ξεναγηθείτε στην εφαρμογή μας!");

            	}
            }
        });
        
        
        btnButton2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ζητήστε από τον υπολογιστή να κάνει μια ερώτηση
//                String computerQuestion = "Πώς είναι η ημέρα σας;";

                // Εμφανίστε την ερώτηση και πάρτε την απάντηση του χρήστη
//                String userAnswer = JOptionPane.showInputDialog(contentPane, computerQuestion);

                // Εμφανίστε την απάντηση του χρήστη
//                JOptionPane.showMessageDialog(contentPane, "Η απάντησή σας: " + userAnswer, "Απάντηση", JOptionPane.INFORMATION_MESSAGE);
            	String name= JOptionPane.showInputDialog("Ποιο είναι το ονομά σας; (Γράψτε μόνο στα ελληνικά)");
            	String ap1=JOptionPane.showInputDialog("Γεια σας κυριε/ια" + " " + name + " έχετε πρόβλημα με την σύνδεση στον λογαριασμό σας;");
            	if(ap1.equals("nai") || ap1.equals("Nai") || ap1.equals("NAI") || ap1.equals("ναι") || ap1.equals("Ναι") || ap1.equals("ΝΑΙ") ) {
//        		JOptionPane.showMessageDialog(null, "Γεια σας κυριε/ια" + " " + name + "έχετε πρόβλημα με την καταχώρηση της παραγγελίας σας;");
            		String ap3=JOptionPane.showInputDialog("Το πρόβλημα που αντιμετωπίζετε έχει να κάνει με το όνομα χρήστη (username)  ή με τον κωδικό (password) ");
            			if(ap3.equals("όνομα χρήστη") || ap3.equals("Ονομα Χρήστη") || ap3.equals("ΟΝΟΜΑ ΧΡΗΣΤΗ") || ap3.equals("USERNAME") || ap3.equals("Username") || ap3.equals("username")) {
                    		String ap33=JOptionPane.showInputDialog("Πληκτρολογείτε σωστά το username σας;");
                        		if(ap33.equals("nai") || ap33.equals("Nai") || ap33.equals("NAI") || ap33.equals("ναι") || ap33.equals("Ναι") || ap33.equals("ΝΑΙ") ) {
                        			JOptionPane.showMessageDialog(null, "Αν το πληκτρολογείτε σωστά και πάλι έχετε πρόβλημα πατήστε στο κουμπί ΄ΕΠΙΚΟΙΝΩΝΙΑ΄ και στείλτε μας μήνυμα!" );

                        		}else {
                        			JOptionPane.showMessageDialog(null, "Προσπαθήστε να το πληκτρολογήσετε σωστά. Σε περίπτωση που το έχετε ξεχάσει στείλτε μας μήνυμα από το κουμπί επικοινωνία" );

                        		}

            			}else if(ap3.equals("password") || ap3.equals("Password") || ap3.equals("PASSWORD") || ap3.equals("κωδικό") || ap3.equals("Κωδικό") || ap3.equals("ΚΩΔΙΚΟ") || ap3.equals("κωδικο") || ap3.equals("Κωδικο")) {
            				JOptionPane.showMessageDialog(null, "Για λόγους ασφάλειας, θέματα που αφορούν τον προσωπικό κωδικό πρόσβασης θα πρέπει να επικοινωνήσετε μαζί μας" );
            			}
            	}else {
					JOptionPane.showMessageDialog(null,"Εφόσον δεν έχετε κάποιο πρόβλημα με τον λογαριασμό σας, σας αφήνω να ξεναγηθείτε στην εφαρμογή μας!");
 
            	}
            }
        });
        
        
        btnButton2_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ζητήστε από τον υπολογιστή να κάνει μια ερώτηση
//                String computerQuestion = "Πώς είναι η ημέρα σας;";

                // Εμφανίστε την ερώτηση και πάρτε την απάντηση του χρήστη
//                String userAnswer = JOptionPane.showInputDialog(contentPane, computerQuestion);

                // Εμφανίστε την απάντηση του χρήστη
//                JOptionPane.showMessageDialog(contentPane, "Η απάντησή σας: " + userAnswer, "Απάντηση", JOptionPane.INFORMATION_MESSAGE);
            	String name= JOptionPane.showInputDialog("Ποιο είναι το ονομά σας; (Γράψτε μόνο στα ελληνικά)");
            	String ap1=JOptionPane.showInputDialog("Γεια σας κυριε/ια" + " " + name + " η εφαρμογή κολλάει, τερματίζει ή δεν ανταποκρίνεται;");
            	if(ap1.equals("nai") || ap1.equals("Nai") || ap1.equals("NAI") || ap1.equals("ναι") || ap1.equals("Ναι") || ap1.equals("ΝΑΙ") ) {
//        		JOptionPane.showMessageDialog(null, "Γεια σας κυριε/ια" + " " + name + "έχετε πρόβλημα με την καταχώρηση της παραγγελίας σας;");
            		String ap3=JOptionPane.showInputDialog("Δοκιμάσατε να διαγράψετε και να ξανά κάνετε εγκατάσταση την εφαρμογή;");
                	if(ap3.equals("nai") || ap3.equals("Nai") || ap3.equals("NAI") || ap3.equals("ναι") || ap3.equals("Ναι") || ap3.equals("ΝΑΙ") ) {
            			JOptionPane.showMessageDialog(null, "Τότε θα πρέπει να επικοινωνήσετε μαζί μας για να σας βοηθήσουμε!" );
                		}else {
                    	JOptionPane.showMessageDialog(null, "Δοκιμάστε να κάνετε απεγκατάσταση την εφαρμογή!" );
                		}
                    	
            	}else {
					JOptionPane.showMessageDialog(null,"Χαίρομαι που δεν αντιμετωπίζεται πρόβλημα, σας αφήνω να ξεναγηθείτε στην εφαρμογή μας!");
 
            	}
            }
        });
    }
}

