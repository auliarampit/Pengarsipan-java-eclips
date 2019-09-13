import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Connection.Koneksi;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Beranda2 extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Beranda2 frame = new Beranda2();
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
	public Beranda2() {
		getContentPane().setBackground(new Color(225, 225, 225));
		setBounds(0, 0, 1027, 612);
		getContentPane().setLayout(null);
		
		JLabel lblCountSuratMasuk = new JLabel("1");
		lblCountSuratMasuk.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblCountSuratMasuk.setHorizontalAlignment(SwingConstants.CENTER);
		lblCountSuratMasuk.setBounds(112, 196, 119, 36);
		getContentPane().add(lblCountSuratMasuk);
		
		Koneksi.getConnection();
		try {
			ResultSet rs = Koneksi.stat.executeQuery("select count(kd_surat_masuk)  jumlah from surat_masuk");
			rs.first();
			lblCountSuratMasuk.setText(rs.getString("jumlah"));
			
			JPanel panel = new JPanel();
			panel.setToolTipText("Jumlah Surat Masuk\r\n");
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(81, 153, 184, 124);
			getContentPane().add(panel);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(5, 127, 227));
			panel_1.setBounds(81, 126, 184, 31);
			getContentPane().add(panel_1);
			
			JLabel lblSuratMasuk = new JLabel("Surat Masuk ");
			panel_1.add(lblSuratMasuk);
			lblSuratMasuk.setBackground(new Color(30, 144, 255));
			lblSuratMasuk.setFont(new Font("Tahoma", Font.BOLD, 17));
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(5, 127, 227));
			panel_2.setBounds(81, 277, 184, 15);
			getContentPane().add(panel_2);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(5, 127, 227));
		panel_3.setBounds(322, 126, 184, 31);
		getContentPane().add(panel_3);
		
		JLabel lblSuratKeluar = new JLabel("Surat Keluar");
		lblSuratKeluar.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSuratKeluar.setBackground(new Color(30, 144, 255));
		panel_3.add(lblSuratKeluar);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(5, 127, 227));
		panel_5.setBounds(322, 277, 184, 15);
		getContentPane().add(panel_5);
		
		JLabel label = new JLabel("1");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 28));
		label.setBounds(354, 196, 119, 36);
		getContentPane().add(label);
		
		Koneksi.getConnection();
		try {
			ResultSet rs = Koneksi.stat.executeQuery("select count(kd_surat_keluar)  jumlah from surat_keluar");
			rs.first();
			label.setText(rs.getString("jumlah"));
			
			JPanel panel = new JPanel();
			panel.setToolTipText("Jumlah Surat Keluar");
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(322, 153, 184, 124);
			getContentPane().add(panel);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(5, 127, 227));
		panel_11.setBounds(564, 126, 184, 31);
		getContentPane().add(panel_11);
		
		JLabel lblDisposisi = new JLabel("Disposisi");
		lblDisposisi.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDisposisi.setBackground(new Color(30, 144, 255));
		panel_11.add(lblDisposisi);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBackground(new Color(5, 127, 227));
		panel_22.setBounds(564, 277, 184, 15);
		getContentPane().add(panel_22);
		
		JLabel lblHhhh = new JLabel("hhhh");
		lblHhhh.setBounds(598, 197, 119, 34);
		getContentPane().add(lblHhhh);
		lblHhhh.setHorizontalAlignment(SwingConstants.CENTER);
		lblHhhh.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		
		Koneksi.getConnection();
		try {
			ResultSet rs2 = Koneksi.stat.executeQuery("select count(kd_disposisi) jumlah from disposisi");
			rs2.first();
			lblHhhh.setText(rs2.getString("jumlah"));
			
			JPanel panel = new JPanel();
			panel.setToolTipText("Jumlah Disposisi");
			panel.setBackground(Color.WHITE);
			panel.setBounds(564, 153, 184, 124);
			getContentPane().add(panel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
