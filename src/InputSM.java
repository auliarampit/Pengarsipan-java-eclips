import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connection.Koneksi;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InputSM extends JFrame {

	private JPanel contentPane;
	private JTextField txtKd_surat_masuk;
	private JTextField txtKd_Petugas;
	private JTextField txtNA;
	private JTextField txtNS;
	private JTextField txtJS;
	private JTextField txtPengirim;
	private JTextField txtTS;
	private JTextField txtTT;
	private JTextField txtPrihal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputSM frame = new InputSM();
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
	public InputSM() {
		setResizable(false);
		setBounds(500, 160, 510, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtKd_surat_masuk = new JTextField();
		txtKd_surat_masuk.setBounds(33, 62, 183, 34);
		contentPane.add(txtKd_surat_masuk);
		txtKd_surat_masuk.setColumns(10);
		
		JLabel lblKodeSuratMasuk = new JLabel("Kode Surat Masuk");
		lblKodeSuratMasuk.setBounds(33, 44, 108, 14);
		contentPane.add(lblKodeSuratMasuk);
		
		JLabel lblKodePetugas = new JLabel("Kode Petugas");
		lblKodePetugas.setToolTipText("Silahkah mengisi kode petugas\r\n");
		lblKodePetugas.setBounds(33, 107, 95, 15);
		contentPane.add(lblKodePetugas);
		
		txtKd_Petugas = new JTextField();
		txtKd_Petugas.setColumns(10);
		txtKd_Petugas.setBounds(33, 125, 183, 34);
		contentPane.add(txtKd_Petugas);
		
		JLabel lblNoAgenda = new JLabel("No Agenda");
		lblNoAgenda.setBounds(33, 170, 95, 15);
		contentPane.add(lblNoAgenda);
		
		txtNA = new JTextField();
		txtNA.setColumns(10);
		txtNA.setBounds(33, 188, 183, 34);
		contentPane.add(txtNA);
		
		JLabel lblNoSurat = new JLabel("No Surat");
		lblNoSurat.setBounds(33, 233, 95, 15);
		contentPane.add(lblNoSurat);
		
		txtNS = new JTextField();
		txtNS.setColumns(10);
		txtNS.setBounds(33, 251, 183, 34);
		contentPane.add(txtNS);
		
		JLabel lblJenisSurat = new JLabel("Jenis Surat");
		lblJenisSurat.setBounds(296, 44, 95, 15);
		contentPane.add(lblJenisSurat);
		
		txtJS = new JTextField();
		txtJS.setColumns(10);
		txtJS.setBounds(296, 62, 183, 34);
		contentPane.add(txtJS);
		
		JLabel lblPengirim = new JLabel("Pengirim");
		lblPengirim.setBounds(296, 107, 95, 15);
		contentPane.add(lblPengirim);
		
		txtPengirim = new JTextField();
		txtPengirim.setColumns(10);
		txtPengirim.setBounds(296, 125, 183, 34);
		contentPane.add(txtPengirim);
		
		JLabel lblTanggalSurat = new JLabel("Tanggal Surat");
		lblTanggalSurat.setBounds(296, 170, 95, 15);
		contentPane.add(lblTanggalSurat);
		
		txtTS = new JTextField();
		txtTS.setColumns(10);
		txtTS.setBounds(296, 188, 183, 34);
		contentPane.add(txtTS);
		
		JLabel lblTanggalTerima = new JLabel("Tanggal Terima");
		lblTanggalTerima.setBounds(296, 233, 95, 15);
		contentPane.add(lblTanggalTerima);
		
		txtTT = new JTextField();
		txtTT.setColumns(10);
		txtTT.setBounds(296, 251, 183, 34);
		contentPane.add(txtTT);
		
		JButton btnButton = new JButton("SAVE");
		btnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	Koneksi.getConnection();
				
				try {
					Koneksi.stat.executeUpdate("INSERT INTO `surat_masuk` values ('"+txtKd_surat_masuk.getText()+"','"+txtKd_Petugas.getText()+"','"+txtNA.getText()+"','"+txtNS.getText()+"','"+txtPrihal.getText()+"','"+txtJS.getText()+"','"+txtPengirim.getText()+"','"+txtTS.getText()+"','"+txtTT.getText()+"')");
				
					clear();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnButton.setBounds(65, 392, 89, 32);
		contentPane.add(btnButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Koneksi.stat.executeUpdate("UPDATE surat_masuk set kd_petugas= '"+ txtKd_Petugas.getText() +"', no_agenda= '"+ txtNA.getText() +"', no_surat= '"+ txtNS.getText() +"', prihal= '"+ txtPrihal.getText() +"' , jenis_surat= '"+ txtJS.getText() +"', pengirim= '"+ txtPengirim.getText() +"',tanggal_surat= '"+ txtTS.getText() +"', tanggal_terima= '"+ txtTT.getText() +"' where kd_surat_masuk= '"+ txtKd_surat_masuk.getText() +"' ");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(194, 392, 89, 32);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int option = JOptionPane.showConfirmDialog(null, "Are you sure??", "Confirmation", JOptionPane.YES_NO_OPTION);
				
				if(option == JOptionPane.YES_OPTION){
					
					try {
						Koneksi.stat.executeUpdate("DELETE FROM surat_masuk where kd_surat_masuk = '"+ txtKd_surat_masuk.getText() +"' ");
						
						JOptionPane.showConfirmDialog(null, "Data Berhasil Dihapus", "Konfirmasi", JOptionPane.YES_OPTION);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			
			}
		});
		btnDelete.setBounds(323, 392, 89, 32);
		contentPane.add(btnDelete);
		
		txtPrihal = new JTextField();
		txtPrihal.setColumns(10);
		txtPrihal.setBounds(33, 314, 183, 34);
		contentPane.add(txtPrihal);
		
		JLabel lblPrihal = new JLabel("Prihal");
		lblPrihal.setBounds(33, 296, 95, 15);
		contentPane.add(lblPrihal);
		
		Koneksi.getConnection();
		try {
			ResultSet rs = Koneksi.stat.executeQuery("select * from surat_masuk where kd_surat_masuk= '"+ SuratMasuk2.kdSuratMasuk +"' ");
			while(rs.next()){
			txtKd_surat_masuk.setText(rs.getString("kd_surat_masuk"));
			txtKd_Petugas.setText(rs.getString("kd_petugas"));
			txtNA.setText(rs.getString("no_agenda"));
			txtNS.setText(rs.getString("no_surat"));
			txtPrihal.setText(rs.getString("prihal"));
			txtJS.setText(rs.getString("jenis_surat"));
			txtPengirim.setText(rs.getString("pengirim"));
			txtTS.setText(rs.getString("tanggal_surat"));
			txtTT.setText(rs.getString("tanggal_terima"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clear(){
		txtKd_surat_masuk.setText("");
		txtKd_Petugas.setText("");
		txtNA.setText("");
		txtNS.setText("");
		txtPrihal.setText("");
		txtJS.setText("");
		txtPengirim.setText("");
		txtTS.setText("");
		txtTT.setText("");
	}
}
