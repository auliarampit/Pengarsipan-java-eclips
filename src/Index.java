import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class Index extends JFrame {

	private JPanel contentPane;

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
					Index frame = new Index();
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
	public Index() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 622, 439);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(5, 168, 247));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelamatDatangDi = new JLabel("Selamat datang di aplikasi Pengarsipan");
		lblSelamatDatangDi.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblSelamatDatangDi.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelamatDatangDi.setBounds(0, 66, 606, 27);
		contentPane.add(lblSelamatDatangDi);
		
		JLabel lblSuratMasukDan = new JLabel("Surat Masuk dan Surat Keluar");
		lblSuratMasukDan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuratMasukDan.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblSuratMasukDan.setBounds(10, 92, 606, 27);
		contentPane.add(lblSuratMasukDan);
		
		JButton btnAdministrator = new JButton("Administrator");
		btnAdministrator.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login2 lg =new Login2();
				lg.setVisible(false);
				lg.show();
				dispose();
			}
		});
		btnAdministrator.setBounds(334, 211, 146, 40);
		contentPane.add(btnAdministrator);
		
		JButton btnUser = new JButton("User");
		btnUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			MainUser mu = new MainUser();
			mu.setVisible(false);
			try {
				MainUser.main(null);
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
			
			Beranda2 br = new Beranda2();
			mu.getDesktopPane().add(br);
			dispose();
			}
		});
		btnUser.setBounds(129, 211, 146, 40);
		contentPane.add(btnUser);
		
		JLabel lblLoginSebagaiUser = new JLabel("Login sebagai user biasa");
		lblLoginSebagaiUser.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		lblLoginSebagaiUser.setBounds(129, 173, 153, 27);
		contentPane.add(lblLoginSebagaiUser);
		
		JLabel lblLoginSebagaiUser_1 = new JLabel("Login sebagai user administrator");
		lblLoginSebagaiUser_1.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		lblLoginSebagaiUser_1.setBounds(334, 173, 182, 27);
		contentPane.add(lblLoginSebagaiUser_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(80, 152, 455, 123);
		panel_1.setBackground(new Color(0, 191, 255));
		contentPane.add(panel_1);
	}
}
