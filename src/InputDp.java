import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connection.Koneksi;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class InputDp extends JFrame {

	private JPanel contentPane;
	private JTextField txtKdDisposisi;
	private JTextField txtKdSM;
	private JTextField txtPenerima;
	private JTextField txtS_Surat;
	private JTextArea taKeterangan;
	private JTextArea taTanggapan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputDp frame = new InputDp();
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
	public InputDp() {
		setResizable(false);
		setBounds(500, 160, 510, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKodeDisposisi = new JLabel("Kode Disposisi");
		lblKodeDisposisi.setBounds(34, 44, 108, 14);
		contentPane.add(lblKodeDisposisi);
		
		txtKdDisposisi = new JTextField();
		txtKdDisposisi.setColumns(10);
		txtKdDisposisi.setBounds(34, 62, 183, 34);
		contentPane.add(txtKdDisposisi);
		
		JLabel lblKodeSuratMasuk = new JLabel("Kode Surat Masuk");
		lblKodeSuratMasuk.setToolTipText("Silahkah mengisi kode petugas\r\n");
		lblKodeSuratMasuk.setBounds(34, 107, 95, 15);
		contentPane.add(lblKodeSuratMasuk);
		
		txtKdSM = new JTextField();
		txtKdSM.setColumns(10);
		txtKdSM.setBounds(34, 125, 183, 34);
		contentPane.add(txtKdSM);
		
		JLabel lblPenerima = new JLabel("Penerima");
		lblPenerima.setToolTipText("Silahkah mengisi kode petugas\r\n");
		lblPenerima.setBounds(34, 170, 95, 15);
		contentPane.add(lblPenerima);
		
		txtPenerima = new JTextField();
		txtPenerima.setColumns(10);
		txtPenerima.setBounds(34, 188, 183, 34);
		contentPane.add(txtPenerima);
		
		taKeterangan = new JTextArea();
		taKeterangan.setBounds(34, 253, 338, 54);
		contentPane.add(taKeterangan);
		
		JLabel lblKeterangan = new JLabel("Keterangan");
		lblKeterangan.setToolTipText("Silahkah mengisi kode petugas\r\n");
		lblKeterangan.setBounds(34, 235, 95, 15);
		contentPane.add(lblKeterangan);
		
		JLabel lblStatusSurat = new JLabel("Status Surat");
		lblStatusSurat.setBounds(290, 44, 108, 14);
		contentPane.add(lblStatusSurat);
		
		txtS_Surat = new JTextField();
		txtS_Surat.setColumns(10);
		txtS_Surat.setBounds(290, 62, 183, 34);
		contentPane.add(txtS_Surat);
		
		JLabel lblTanggapan = new JLabel("Tanggapan");
		lblTanggapan.setToolTipText("Silahkah mengisi kode petugas\r\n");
		lblTanggapan.setBounds(290, 107, 95, 15);
		contentPane.add(lblTanggapan);
		
		taTanggapan = new JTextArea();
		taTanggapan.setBounds(290, 125, 183, 70);
		contentPane.add(taTanggapan);
		
		JButton button = new JButton("SAVE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Koneksi.stat.executeUpdate("insert into disposisi values('"+ txtKdDisposisi.getText() +"', '"+ txtKdSM.getText() +"', '"+ txtPenerima.getText() +"','"+ taKeterangan.getText() +"', '"+ txtS_Surat.getText() +"','"+ taTanggapan.getText() +"')");
				reset();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(65, 387, 89, 32);
		contentPane.add(button);
		
		JButton button_1 = new JButton("UPDATE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Koneksi.stat.executeUpdate("update disposisi set kd_surat_masuk= '"+ txtKdSM.getText() +"', penerima= '"+ txtPenerima.getText() +"', keterangan= '"+ taKeterangan.getText() +"', status_surat= '"+ txtS_Surat.getText() +"', tanggapan= '"+ taTanggapan.getText() +"'");
				reset();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(194, 387, 89, 32);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("DELETE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confimation", JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION){
					Koneksi.getConnection();
					try {
						Koneksi.stat.executeUpdate("DELETE FROM Disposisi WHERE kd_disposisi= '"+ txtKdDisposisi.getText() +"'");
						reset();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		button_2.setBounds(323, 387, 89, 32);
		contentPane.add(button_2);
		
		Koneksi.getConnection();
		try {
			ResultSet rs = Koneksi.stat.executeQuery("select * from disposisi where kd_disposisi = '"+ Disposisi2.kdDisposisi +"'");
			while(rs.next()){
				txtKdDisposisi.setText(rs.getString("kd_disposisi"));
				txtKdSM.setText(rs.getString("kd_surat_masuk"));
				txtPenerima.setText(rs.getString("penerima"));
				taKeterangan.setText(rs.getString("keterangan"));
				txtS_Surat.setText(rs.getString("status_surat"));
				taTanggapan.setText(rs.getString("tanggapan"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void reset(){
		txtKdDisposisi.setText("");
		txtKdSM.setText("");
		txtPenerima.setText("");
		taKeterangan.setText("");
		txtS_Surat.setText("");
		taTanggapan.setText("");
	}
	public JTextArea getTaKeterangan() {
		return taKeterangan;
	}
	public JTextArea getTaTanggapan() {
		return taTanggapan;
	}
}
