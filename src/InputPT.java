import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connection.Koneksi;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import Connection.*;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InputPT extends JFrame {

	private JPanel contentPane;
	private JTextField txtKP;
	private JTextField txtPt;
	private JComboBox cJK;
	private JTextArea taA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputPT frame = new InputPT();
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
	public InputPT() {
		setVisible(true);
		setResizable(false);
		setBounds(500, 160, 404, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtKP = new JTextField();
		txtKP.setToolTipText("Masukkan Kode Petugas");
		txtKP.setBounds(27, 31, 179, 32);
		contentPane.add(txtKP);
		txtKP.setColumns(10);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Koneksi.getConnection();
				try {
					Koneksi.stat.executeUpdate("INSERT INTO petugas values('"+ txtKP.getText() +"', '"+ txtPt.getText() +"', '"+ cJK.getSelectedItem() +"', '"+ taA.getText() +"')");
					reset();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 351, 89, 32);
		contentPane.add(btnNewButton);
		
		JButton btnEdit = new JButton("UPDATE");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Koneksi.getConnection();
				try {
					Koneksi.stat.executeUpdate("UPDATE  petugas set nama_lengkap= '"+ txtPt.getText() +"', jenis_kelamin= '"+ cJK.getSelectedItem() +"', alamat= '"+ taA.getText() +"' WHERE kd_petugas= '"+ txtKP.getText() +"' ");
					reset();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEdit.setBounds(139, 351, 89, 32);
		contentPane.add(btnEdit);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int option = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confimation", JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION){
					Koneksi.getConnection();
					try {
						Koneksi.stat.executeUpdate("DELETE FROM petugas WHERE kd_petugas= '"+ txtKP.getText() +"'");
						reset();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			
			}
		});
		btnNewButton_2.setBounds(268, 351, 89, 32);
		contentPane.add(btnNewButton_2);
		
		JLabel lblKodePetugas = new JLabel("Kode Petugas");
		lblKodePetugas.setBounds(27, 11, 125, 14);
		contentPane.add(lblKodePetugas);
		
		JLabel lblNamaPetugas = new JLabel("Nama Petugas");
		lblNamaPetugas.setBounds(27, 74, 125, 14);
		contentPane.add(lblNamaPetugas);
		
		txtPt = new JTextField();
		txtPt.setToolTipText("Masukkan Nama Petugas");
		txtPt.setColumns(10);
		txtPt.setBounds(27, 94, 179, 36);
		contentPane.add(txtPt);
		
		JLabel lblJenisKelamin = new JLabel("Jenis Kelamin");
		lblJenisKelamin.setBounds(27, 141, 125, 14);
		contentPane.add(lblJenisKelamin);
		
		cJK = new JComboBox();
		cJK.setToolTipText("Pilih Jenis Kelamin");
		cJK.setModel(new DefaultComboBoxModel(new String[] {"==PILIH==", "L", "P"}));
		cJK.setBounds(27, 160, 125, 32);
		contentPane.add(cJK);
		
		JLabel lblAlamat = new JLabel("Alamat");
		lblAlamat.setBounds(29, 217, 89, 14);
		contentPane.add(lblAlamat);
		
		taA = new JTextArea();
		taA.setToolTipText("Masukkan Alamat");
		taA.setBounds(27, 238, 179, 80);
		contentPane.add(taA);
		
		Koneksi.getConnection();
		try {
			ResultSet rs = Koneksi.stat.executeQuery("SELECT * FROM petugas WHERE kd_petugas = '"+ Petugas2.kdPetugas +"'");
			while(rs.next()){
				txtKP.setText(rs.getString("kd_petugas"));
				txtPt.setText(rs.getString("nama_lengkap"));
				cJK.setSelectedItem(rs.getString("jenis_kelamin"));
				taA.setText(rs.getString("alamat"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public JComboBox getCJK() {
		return cJK;
	}
	public JTextArea getTaA() {
		return taA;
	}
	
	public void reset(){
		txtKP.setText("");
		txtPt.setText("");
		cJK.setSelectedItem("==PILIH==");
		taA.setText("");
	}
}
