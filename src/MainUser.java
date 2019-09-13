import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.seaglasslookandfeel.icons.DesktopPane;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Label;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import java.awt.Cursor;
import Connection.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainUser extends JFrame {

	private JPanel contentPane;
	private static JDesktopPane desktopPane;
	

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
					MainUser frame = new MainUser();
					frame.setVisible(true);
					
					Beranda2 br = new Beranda2();
					desktopPane.add(br);
				br.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainUser() {
		setResizable(false);
		
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setBounds(50, 20, 1278, 696);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBackground(new Color(5, 168, 247));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblicon = new JLabel("");
		lblicon.setToolTipText("Ganti Foto\r\n");
		lblicon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fc =new JFileChooser();
				fc.setCurrentDirectory(new File (System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*. IMAGE", "jpg", "png", "gif");
				fc.addChoosableFileFilter(filter);
				int result = fc.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fc.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					
					Koneksi.getConnection();
					
					try {
						Koneksi.stat.executeUpdate("UPDATE path set location = QUOTE('"+ path + "') where id= '1'");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					lblicon.setIcon(new ImageIcon(path));
				}
			}
		});
		lblicon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		String path = "";
		Koneksi.getConnection();
		ResultSet rs;
		try {
			rs = Koneksi.stat.executeQuery("select * from path where id= '1'");
			rs.first();
			path = rs.getString("location");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		lblicon.setIcon(new ImageIcon(path));
		lblicon.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon.setBounds(53, 30, 118, 108);
		contentPane.add(lblicon);
		
		
		JLabel label = new JLabel("");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(MainMenu2.class.getResource("/images/home.png")));
		label.setBounds(10, 195, 51, 43);
		contentPane.add(label);
		
		JLabel lblPetuags = new JLabel("Petugas");
		lblPetuags.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				desktopPane.removeAll();
				PetugasUser pt = new PetugasUser();
				desktopPane.add(pt);
				pt.setVisible(true);
			}
		});
		lblPetuags.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPetuags.setForeground(Color.WHITE);
		lblPetuags.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		lblPetuags.setBounds(62, 253, 86, 39);
		contentPane.add(lblPetuags);
		
		JLabel label_2 = new JLabel("");
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setIcon(new ImageIcon(MainMenu2.class.getResource("/images/employee.png")));
		label_2.setBounds(10, 249, 51, 43);
		contentPane.add(label_2);
		
		JLabel lblSuratMasuk = new JLabel("Surat Masuk");
		lblSuratMasuk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				desktopPane.removeAll();
				SMUser sm = new SMUser();
				desktopPane.add(sm);
				sm.setVisible(true);
			}
		});
		lblSuratMasuk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSuratMasuk.setForeground(Color.WHITE);
		lblSuratMasuk.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		lblSuratMasuk.setBounds(62, 303, 118, 43);
		contentPane.add(lblSuratMasuk);
		
		JLabel label_3 = new JLabel("");
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		label_3.setIcon(new ImageIcon(MainMenu2.class.getResource("/images/inbox.png")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(10, 303, 51, 43);
		contentPane.add(label_3);
		
		JLabel lblSuratKeluar = new JLabel("Surat Keluar");
		lblSuratKeluar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				desktopPane.removeAll();
				SKUser sk = new SKUser();
				desktopPane.add(sk);
				sk.setVisible(true);
			}
		});
		lblSuratKeluar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSuratKeluar.setForeground(Color.WHITE);
		lblSuratKeluar.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		lblSuratKeluar.setBounds(62, 357, 118, 43);
		contentPane.add(lblSuratKeluar);
		
		JLabel label_4 = new JLabel("");
		label_4.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		label_4.setIcon(new ImageIcon(MainMenu2.class.getResource("/images/inbox (1).png")));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(10, 357, 51, 43);
		contentPane.add(label_4);
		
		JLabel lblDisposisi = new JLabel("Disposisi");
		lblDisposisi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				desktopPane.removeAll();
				DisposisiUser dp = new DisposisiUser();
				desktopPane.add(dp);
				dp.setVisible(true);
			}
		});
		lblDisposisi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDisposisi.setForeground(Color.WHITE);
		lblDisposisi.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		lblDisposisi.setBounds(62, 411, 118, 43);
		contentPane.add(lblDisposisi);
		
		JLabel label_5 = new JLabel("");
		label_5.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		label_5.setIcon(new ImageIcon(MainMenu2.class.getResource("/images/bar-chart.png")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(10, 419, 51, 25);
		contentPane.add(label_5);
		
		JLabel lblLaporanSuratMasuk = new JLabel("Laporan Surat Masuk");
		lblLaporanSuratMasuk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				desktopPane.removeAll();
				LaporanSuratMasuk lsm = new LaporanSuratMasuk();
				desktopPane.add(lsm);
				lsm.setVisible(true);
			}
		});
		lblLaporanSuratMasuk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLaporanSuratMasuk.setForeground(Color.WHITE);
		lblLaporanSuratMasuk.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		lblLaporanSuratMasuk.setBounds(62, 465, 167, 43);
		contentPane.add(lblLaporanSuratMasuk);
		
		JLabel label_6 = new JLabel("");
		label_6.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		label_6.setIcon(new ImageIcon(MainMenu2.class.getResource("/images/cv.png")));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(10, 465, 51, 43);
		contentPane.add(label_6);
		
		JLabel lblLaporanSuratKeluar = new JLabel("Laporan Surat Keluar");
		lblLaporanSuratKeluar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				desktopPane.removeAll();
				LaporanSuratKeluar2 lsk = new LaporanSuratKeluar2();
				desktopPane.add(lsk);
				lsk.setVisible(true);
			}
		});
		lblLaporanSuratKeluar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLaporanSuratKeluar.setForeground(Color.WHITE);
		lblLaporanSuratKeluar.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		lblLaporanSuratKeluar.setBounds(62, 519, 167, 43);
		contentPane.add(lblLaporanSuratKeluar);
		
		JLabel label_7 = new JLabel("");
		label_7.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		label_7.setIcon(new ImageIcon(MainMenu2.class.getResource("/images/test.png")));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(10, 519, 51, 43);
		contentPane.add(label_7);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(249, 61, 1036, 612);
		contentPane.add(desktopPane);
		
		JLabel lblPengarsipanSurat = new JLabel("Pengarsipan Surat");
		lblPengarsipanSurat.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblPengarsipanSurat.setForeground(new Color(255, 255, 255));
		lblPengarsipanSurat.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPengarsipanSurat.setBounds(310, 11, 188, 39);
		contentPane.add(lblPengarsipanSurat);
		
		JLabel label_1 = new JLabel("");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		label_1.setIcon(new ImageIcon(MainMenu2.class.getResource("/images/business-partnership.png")));
		label_1.setBounds(272, 11, 40, 39);
		contentPane.add(label_1);
		
		JButton btnLogout = new JButton("Log-Out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Index i = new Index();
				i.setVisible(false);
				i.show();
				dispose();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogout.setBounds(1163, 30, 89, 26);
		contentPane.add(btnLogout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(250, 0, 1134, 61);
		contentPane.add(panel_1);
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel_1.setBackground(new Color(5, 127, 227));
		
		JLabel lblBeranda = new JLabel("Beranda");
		lblBeranda.setBounds(62, 211, 68, 27);
		contentPane.add(lblBeranda);
		lblBeranda.setBorder(null);
		lblBeranda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBeranda.setForeground(Color.WHITE);
		lblBeranda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				desktopPane.removeAll();
				Beranda2 br = new Beranda2();
				desktopPane.add(br);
				br.setVisible(true);
			}
		});
		lblBeranda.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
	}
	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}
}
