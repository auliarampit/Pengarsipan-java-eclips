import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.seaglasslookandfeel.icons.DesktopPane;

import Connection.Koneksi;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InputSK extends JFrame {

	private JPanel contentPane;
	private JTextField txtKdSK;
	private JTextField kdPT;
	private JTextField txtNA;
	private JTextField txtNS;
	private JTextField txtPr;
	private JTextField txtJS;
	private JTextField txtTj;
	private JTextField txtAT;
	private JTextField txtTK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputSK frame = new InputSK();
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
	public InputSK() {
		setResizable(false);
		setBounds(500, 160, 510, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKodeSuratKeluar = new JLabel("Kode Surat Keluar");
		lblKodeSuratKeluar.setBounds(33, 44, 108, 14);
		contentPane.add(lblKodeSuratKeluar);
		
		txtKdSK = new JTextField();
		txtKdSK.setColumns(10);
		txtKdSK.setBounds(33, 62, 183, 34);
		contentPane.add(txtKdSK);
		
		JLabel label_1 = new JLabel("Kode Petugas");
		label_1.setToolTipText("Silahkah mengisi kode petugas\r\n");
		label_1.setBounds(33, 107, 95, 15);
		contentPane.add(label_1);
		
		kdPT = new JTextField();
		kdPT.setColumns(10);
		kdPT.setBounds(33, 125, 183, 34);
		contentPane.add(kdPT);
		
		JLabel label_2 = new JLabel("No Agenda");
		label_2.setBounds(33, 170, 95, 15);
		contentPane.add(label_2);
		
		txtNA = new JTextField();
		txtNA.setColumns(10);
		txtNA.setBounds(33, 188, 183, 34);
		contentPane.add(txtNA);
		
		JLabel label_3 = new JLabel("No Surat");
		label_3.setBounds(33, 233, 95, 15);
		contentPane.add(label_3);
		
		txtNS = new JTextField();
		txtNS.setColumns(10);
		txtNS.setBounds(33, 251, 183, 34);
		contentPane.add(txtNS);
		
		JLabel label_4 = new JLabel("Prihal");
		label_4.setBounds(33, 296, 95, 15);
		contentPane.add(label_4);
		
		txtPr = new JTextField();
		txtPr.setColumns(10);
		txtPr.setBounds(33, 314, 183, 34);
		contentPane.add(txtPr);
		
		JLabel label_5 = new JLabel("Jenis Surat");
		label_5.setBounds(296, 44, 95, 15);
		contentPane.add(label_5);
		
		txtJS = new JTextField();
		txtJS.setColumns(10);
		txtJS.setBounds(296, 62, 183, 34);
		contentPane.add(txtJS);
		
		JLabel lblTujuan = new JLabel("Tujuan");
		lblTujuan.setBounds(296, 107, 95, 15);
		contentPane.add(lblTujuan);
		
		txtTj = new JTextField();
		txtTj.setColumns(10);
		txtTj.setBounds(296, 125, 183, 34);
		contentPane.add(txtTj);
		
		JLabel lblAlamatTujuan = new JLabel("Alamat Tujuan");
		lblAlamatTujuan.setBounds(296, 170, 95, 15);
		contentPane.add(lblAlamatTujuan);
		
		txtAT = new JTextField();
		txtAT.setColumns(10);
		txtAT.setBounds(296, 188, 183, 34);
		contentPane.add(txtAT);
		
		JLabel lblTanggalKirim = new JLabel("Tanggal Kirim");
		lblTanggalKirim.setBounds(296, 233, 95, 15);
		contentPane.add(lblTanggalKirim);
		
		txtTK = new JTextField();
		txtTK.setColumns(10);
		txtTK.setBounds(296, 251, 183, 34);
		contentPane.add(txtTK);
		
		JButton button = new JButton("SAVE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Koneksi.getConnection();
//				try {
//					Koneksi.stat.executeUpdate("INSERT INTO surat_keluar Values('"+ txtKdSK.getText() +"', '"+ kdPT.getText() +"', '"+ txtNA.getText() +"', '"+ txtNS.getText() +"', '"+ txtPr.getText() +"', '"+ txtJS.getText() +"', '"+ txtTj.getText() +"', '"+ txtAT.getText() +"', '"+ txtTK.getText() +"') ");
//					refresh();
//					
//					SuratKeluar2 sk2 = new SuratKeluar2();
//					sk2.getContentPane().remove(sk2.scrollPane);
//					sk2.tampilTable();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				SuratKeluar2 sk2 = new SuratKeluar2();
				sk2.getContentPane().remove(sk2.scrollPane);
				//sk2.tampilTable();
				
				sk2.repaint();
				sk2.validate();

				MainMenu2 mm2 = new MainMenu2();
				mm2.getDesktopPane().removeAll();
				mm2.getDesktopPane().repaint();
				mm2.getDesktopPane().validate();
				
				
				System.out.println("doit =>");
			}
		});
		button.setBounds(65, 392, 89, 32);
		contentPane.add(button);
		
		JButton button_1 = new JButton("UPDATE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Koneksi.stat.executeUpdate("update surat_keluar set kd_petugas= '"+ kdPT.getText() +"', no_agenda='"+ txtNA.getText() +"', no_surat= '"+ txtNS.getText() +"', prihal= '"+ txtPr.getText() +"', jenis_surat= '"+ txtJS.getText() +"', tujuan='"+ txtTj.getText() +"', alamat_tujuan= '"+ txtAT.getText() +"', tanggal_kirim= '"+ txtTK.getText() +"' where kd_surat_keluar= '"+ txtKdSK.getText() +"' ");
					refresh();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(194, 392, 89, 32);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("DELETE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Koneksi.getConnection();
				try {
					Koneksi.stat.executeUpdate("delete from surat_keluar where kd_surat_keluar= '"+ txtKdSK.getText() +"'");
					refresh();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}
		});
		button_2.setBounds(323, 392, 89, 32);
		contentPane.add(button_2);
		
		Koneksi.getConnection();
		try {
			ResultSet rs = Koneksi.stat.executeQuery("select * from surat_keluar where kd_surat_keluar= '"+ SuratKeluar2.kdSuratKeluar +"' ");
			while(rs.next()){
				txtKdSK.setText(rs.getString("kd_surat_keluar"));
				kdPT.setText(rs.getString("kd_petugas"));
				txtNA.setText(rs.getString("no_agenda"));
				txtNS.setText(rs.getString("no_surat"));
				txtPr.setText(rs.getString("prihal"));
				txtJS.setText(rs.getString("jenis_surat"));
				txtTj.setText(rs.getString("tujuan"));
				txtAT.setText(rs.getString("alamat_tujuan"));
				txtTK.setText(rs.getString("tanggal_kirim"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JTextField getTxtAT() {
		return txtAT;
	}
	public JTextField getTxtTj() {
		return txtTj;
	}
	public JTextField getTxtTK() {
		return txtTK;
	}
	public JTextField getKdPT() {
		return kdPT;
	}
	public JTextField getTxtNA() {
		return txtNA;
	}
	public JTextField getTxtJS() {
		return txtJS;
	}
	public JTextField getTxtNS() {
		return txtNS;
	}
	public JTextField getTxtPr() {
		return txtPr;
	}
	public JTextField getTxtKdSK() {
		return txtKdSK;
	}
	
	public void refresh(){
		txtKdSK.setText("");
		kdPT.setText("");
		txtNA.setText("");
		txtNS.setText("");
		txtPr.setText("");
		txtJS.setText("");
		txtTj.setText("");
		txtAT.setText("");
		txtTK.setText("");
	}
}
