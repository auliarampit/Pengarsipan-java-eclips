import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import Connection.*;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;

public class Login2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JLabel lblLoginPage;
	private JPasswordField txtPass;
	private JButton btnCancel;
	private JPanel panel;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login2 frame = new Login2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login2() {
		setResizable(false);
		setBackground(new Color(72, 209, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 622, 439);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(5, 168, 247));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBounds(189, 157, 234, 29);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnLogin = new JButton("");
		btnLogin.setIcon(new ImageIcon(Login2.class.getResource("/images/login - Copy.png")));
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Koneksi.getConnection();
				try {
					ResultSet rs = Koneksi.stat.executeQuery("select * from login where username= '"+ txtUser.getText() +"' and password= '"+ txtPass.getText() +"'");
					if(rs.next()){
						MainMenu2.main(null);
						Login2 lg = new Login2();
						lg.setVisible(false);
						dispose();
					}else{
						JOptionPane.showMessageDialog(null, "Username atau Password salah !!","INFORMASI", JOptionPane.INFORMATION_MESSAGE);
					
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(313, 274, 110, 32);
		contentPane.add(btnLogin);
		
	
		lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginPage.setFont(new Font("Palatino Linotype", Font.BOLD, 30));
		lblLoginPage.setBounds(0, 29, 615, 54);
		contentPane.add(lblLoginPage);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(189, 218, 234, 32);
		contentPane.add(txtPass);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Palatino Linotype", Font.PLAIN, 15));
		lblUsername.setBounds(189, 139, 89, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Palatino Linotype", Font.PLAIN, 15));
		lblPassword.setBounds(188, 203, 90, 14);
		contentPane.add(lblPassword);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(194, 212, 104));
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index i = new Index();
				i.setVisible(false);
				i.show();
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setBounds(189, 274, 103, 32);
		contentPane.add(btnCancel);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(162, 94, 285, 247);
		contentPane.add(panel);
	}
}
