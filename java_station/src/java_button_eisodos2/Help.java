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
        
        btnButton1.setToolTipText("������ ��� ��� ������");
        btnButton2_1.setToolTipText("�������� ����������� �����������");
        btnButton2_2.setToolTipText("�������� �������� �����������");
        btnButton2_3.setToolTipText("� �������� ��� ��������������");
        
        
        
        
        // �������� ActionListener ��� �� ����� ������
        btnButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ������� ��� �� �������� ��� ���������
                dispose();
            }
        }); 

        // �������� ActionListener ��� �� ������� ������
        btnButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ������� ��� ��� ���������� �� ����� ��� �������
//                String computerQuestion = "��� ����� � ����� ���;";

                // ��������� ��� ������� ��� ����� ��� �������� ��� ������
//                String userAnswer = JOptionPane.showInputDialog(contentPane, computerQuestion);

                // ��������� ��� �������� ��� ������
//                JOptionPane.showMessageDialog(contentPane, "� �������� ���: " + userAnswer, "��������", JOptionPane.INFORMATION_MESSAGE);
            	String name= JOptionPane.showInputDialog("���� ����� �� ����� ���; (������ ���� ��� ��������)");
            	String ap1=JOptionPane.showInputDialog("���� ��� �����/��" + " " + name + " ����� �������� �� ��� ���������� ��� ����������� ���;");
            	if(ap1.equals("nai") || ap1.equals("Nai") || ap1.equals("NAI") || ap1.equals("���") || ap1.equals("���") || ap1.equals("���") ) {
//        		JOptionPane.showMessageDialog(null, "���� ��� �����/��" + " " + name + "����� �������� �� ��� ���������� ��� ����������� ���;");
            		String ap3=JOptionPane.showInputDialog("�� �������� ��� �������������� ��������� ���� ����������� ��� �������������, ��� �������� � ��� ����������; (�������������� ��� ��� ��� ����� ����� ��������");
            		if(ap3.equals("�������������") || ap3.equals("�������������") || ap3.equals("�������������") ) {
            			String ap33=JOptionPane.showInputDialog("���� ������ �� ������ '���������� � ����������' ��� ����������� �� ������ ��������� ���������� �������˺�Ӵ;");
	            			if(ap33.equals("nai") || ap33.equals("Nai") || ap33.equals("NAI") || ap33.equals("���") || ap33.equals("���") || ap33.equals("���") ) {
	            				JOptionPane.showMessageDialog(null,"��� ��� ����������� ������ ��� ����������� �� ������ ��� ������� �������� �� ��� ���������� ���!");
	            				  
	            			}else {
	            				String ap333=JOptionPane.showInputDialog("����� �������� ����������� 1 ������������;");
	            				if(ap333.equals("nai") || ap333.equals("Nai") || ap333.equals("NAI") || ap333.equals("���") || ap333.equals("���") || ap333.equals("���") ) {
	            					JOptionPane.showMessageDialog(null,"�� ��� ��� ����������� �� ������ � ������� ������ ���� �������� ���� ������� ��� ������ ��������ͺ� ��� ����������� ���! ���������!");
	            				}else {
	            					JOptionPane.showMessageDialog(null,"�������� ����������� 1 ������������ ��� �� �� �������� ��������� ������� ��� ������ �����������!");
	            				}
	            				
	            			}
            		}else if(ap3.equals("��������") || ap3.equals("��������") || ap3.equals("��������")) {
            			String ap32=JOptionPane.showInputDialog("���� ������ �� ������ '���������� � ����������' ��� ����������� �� ������ ��������� ���������� �������˺�Ӵ;");
            			if(ap32.equals("nai") || ap32.equals("Nai") || ap32.equals("NAI") || ap32.equals("���") || ap32.equals("���") || ap32.equals("���") ) {
            				JOptionPane.showMessageDialog(null,"��� ��� ����������� ������ ��� ����������� �� ������ ��� ������� �������� �� ��� ���������� ���!");
            				  
            			}else {
            				String ap322=JOptionPane.showInputDialog("����� �������� ������� ��� ��������;");
            				if(ap322.equals("nai") || ap322.equals("Nai") || ap322.equals("NAI") || ap322.equals("���") || ap322.equals("���") || ap322.equals("���") ) {
            					JOptionPane.showMessageDialog(null,"�� ����� �������� ������� ��� ��������������� ��� ��������, ����������� �� ��������� ����� ��� �������� ��� ���� �� ������� ���� �� ��� ���������� � �������� ����!");
            					JOptionPane.showMessageDialog(null,"�� ���������� �� ����� �������� ������� ��� ������ �������� �� ������ �����������!");

            				}else {
            					JOptionPane.showMessageDialog(null,"�������� ����� ��� �������� ��� ���� �� ������� ��� ���������� ���� ���� �� ��� ���������� � �������� ����");
            					JOptionPane.showMessageDialog(null,"�� ���������� �� ����� �������� ������� ��� ������ �������� �� ������ �����������!");

            				}
            				
            			}
            		}else if(ap3.equals("����������") || ap3.equals("����������") || ap3.equals("����������")) {
            			String ap31=JOptionPane.showInputDialog("���� ������ �� ������ '���������� � ����������' ��� ����������� �� ������ ��������� ���������� �������˺�Ӵ;");
            			if(ap31.equals("nai") || ap31.equals("Nai") || ap31.equals("NAI") || ap31.equals("���") || ap31.equals("���") || ap31.equals("���") ) {
            				JOptionPane.showMessageDialog(null,"��� ��� ����������� ������ ��� ����������� �� ������ ��� ������� �������� �� ��� ���������� ���!");
            				  
            			}else {
            				String ap311=JOptionPane.showInputDialog("����� �������� ��� ��� ��� ����� �������� ����������;");
            				if(ap311.equals("nai") || ap311.equals("Nai") || ap311.equals("NAI") || ap311.equals("���") || ap311.equals("���") || ap311.equals("���") ) {
            					JOptionPane.showMessageDialog(null,"�� ����� �������� ���� �� ������ �� ��� ����������� ��� ���� � �������� ����!");
            					JOptionPane.showMessageDialog(null,"�� ���������� �� ����� �������� ������� ��� ������ �������� �� ������ �����������!");

            				}else {
            					JOptionPane.showMessageDialog(null,"�������� ����� ��� ��� ��� ����� �������� ��� �������� � ������� ��� ��� ������ ������� �� ������ ����������/����������");
            					JOptionPane.showMessageDialog(null,"�� ���������� �� ����� �������� ������� ��� ������ �������� �� ������ �����������!");

            				}
            				
            			}
            		}
            	
            	
            	}else {
					JOptionPane.showMessageDialog(null,"������ ��� ����� ������ �������� �� ��� ����������� ���, ��� ����� �� ����������� ���� �������� ���!");

            	}
            }
        });
        
        
        btnButton2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ������� ��� ��� ���������� �� ����� ��� �������
//                String computerQuestion = "��� ����� � ����� ���;";

                // ��������� ��� ������� ��� ����� ��� �������� ��� ������
//                String userAnswer = JOptionPane.showInputDialog(contentPane, computerQuestion);

                // ��������� ��� �������� ��� ������
//                JOptionPane.showMessageDialog(contentPane, "� �������� ���: " + userAnswer, "��������", JOptionPane.INFORMATION_MESSAGE);
            	String name= JOptionPane.showInputDialog("���� ����� �� ����� ���; (������ ���� ��� ��������)");
            	String ap1=JOptionPane.showInputDialog("���� ��� �����/��" + " " + name + " ����� �������� �� ��� ������� ���� ���������� ���;");
            	if(ap1.equals("nai") || ap1.equals("Nai") || ap1.equals("NAI") || ap1.equals("���") || ap1.equals("���") || ap1.equals("���") ) {
//        		JOptionPane.showMessageDialog(null, "���� ��� �����/��" + " " + name + "����� �������� �� ��� ���������� ��� ����������� ���;");
            		String ap3=JOptionPane.showInputDialog("�� �������� ��� �������������� ���� �� ����� �� �� ����� ������ (username)  � �� ��� ������ (password) ");
            			if(ap3.equals("����� ������") || ap3.equals("����� ������") || ap3.equals("����� ������") || ap3.equals("USERNAME") || ap3.equals("Username") || ap3.equals("username")) {
                    		String ap33=JOptionPane.showInputDialog("�������������� ����� �� username ���;");
                        		if(ap33.equals("nai") || ap33.equals("Nai") || ap33.equals("NAI") || ap33.equals("���") || ap33.equals("���") || ap33.equals("���") ) {
                        			JOptionPane.showMessageDialog(null, "�� �� �������������� ����� ��� ���� ����� �������� ������� ��� ������ ������������� ��� ������� ��� ������!" );

                        		}else {
                        			JOptionPane.showMessageDialog(null, "����������� �� �� ��������������� �����. �� ��������� ��� �� ����� ������� ������� ��� ������ ��� �� ������ �����������" );

                        		}

            			}else if(ap3.equals("password") || ap3.equals("Password") || ap3.equals("PASSWORD") || ap3.equals("������") || ap3.equals("������") || ap3.equals("������") || ap3.equals("������") || ap3.equals("������")) {
            				JOptionPane.showMessageDialog(null, "��� ������ ���������, ������ ��� ������� ��� ��������� ������ ��������� �� ������ �� �������������� ���� ���" );
            			}
            	}else {
					JOptionPane.showMessageDialog(null,"������ ��� ����� ������ �������� �� ��� ���������� ���, ��� ����� �� ����������� ���� �������� ���!");
 
            	}
            }
        });
        
        
        btnButton2_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ������� ��� ��� ���������� �� ����� ��� �������
//                String computerQuestion = "��� ����� � ����� ���;";

                // ��������� ��� ������� ��� ����� ��� �������� ��� ������
//                String userAnswer = JOptionPane.showInputDialog(contentPane, computerQuestion);

                // ��������� ��� �������� ��� ������
//                JOptionPane.showMessageDialog(contentPane, "� �������� ���: " + userAnswer, "��������", JOptionPane.INFORMATION_MESSAGE);
            	String name= JOptionPane.showInputDialog("���� ����� �� ����� ���; (������ ���� ��� ��������)");
            	String ap1=JOptionPane.showInputDialog("���� ��� �����/��" + " " + name + " � �������� �������, ���������� � ��� ��������������;");
            	if(ap1.equals("nai") || ap1.equals("Nai") || ap1.equals("NAI") || ap1.equals("���") || ap1.equals("���") || ap1.equals("���") ) {
//        		JOptionPane.showMessageDialog(null, "���� ��� �����/��" + " " + name + "����� �������� �� ��� ���������� ��� ����������� ���;");
            		String ap3=JOptionPane.showInputDialog("���������� �� ���������� ��� �� ���� ������ ����������� ��� ��������;");
                	if(ap3.equals("nai") || ap3.equals("Nai") || ap3.equals("NAI") || ap3.equals("���") || ap3.equals("���") || ap3.equals("���") ) {
            			JOptionPane.showMessageDialog(null, "���� �� ������ �� �������������� ���� ��� ��� �� ��� ����������!" );
                		}else {
                    	JOptionPane.showMessageDialog(null, "��������� �� ������ ������������� ��� ��������!" );
                		}
                    	
            	}else {
					JOptionPane.showMessageDialog(null,"�������� ��� ��� ��������������� ��������, ��� ����� �� ����������� ���� �������� ���!");
 
            	}
            }
        });
    }
}

