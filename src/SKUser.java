import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.Koneksi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class SKUser extends JInternalFrame {
	private JTable table;
	public static String kdSuratKeluar = "";

	/**
	 * Create the frame.
	 */
	public SKUser() {
		setTitle("Surat Keluar");
		setBounds(0, 0, 1027, 612);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 73, 1021, 498);
		getContentPane().add(scrollPane);
		
		Object [][] rows = {};
		String [] coluomns = {"Kode SK", "Kode Petugas", "No Agenda", "No Surat", "Prihal", "Jenis Surat", "Tujuan", "Alamat Tujuan", "Tanggal Kirim"};
		DefaultTableModel dataModel = new DefaultTableModel(rows, coluomns);
		
		Koneksi.getConnection();
		try {
			ResultSet rs = Koneksi.stat.executeQuery("select * from surat_keluar");
			while(rs.next()){
				String KodeSk 		= rs.getString("kd_surat_keluar");
				String KodeP  		= rs.getString("kd_petugas");
				String No_Agenda 	= rs.getString("no_agenda");
				String No_Surat		= rs.getString("no_surat");
				String Prihal		= rs.getString("prihal");
				String J_Surat		= rs.getString("jenis_surat");
				String Tujuan 		= rs.getString("tujuan");
				String A_Tujuan		= rs.getString("alamat_tujuan");
				String T_Kirim		= rs.getString("tanggal_kirim");
				
			dataModel.addRow(new Object[]{ KodeSk, KodeP, No_Agenda, No_Surat, Prihal, J_Surat, Tujuan, A_Tujuan, T_Kirim});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table = new JTable(dataModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				SuratKeluar2.kdSuratKeluar = table.getValueAt(table.getSelectedRow(), 0). toString();
				InputSK.main(null);
			}
		});
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(25);
		table.getColumnModel().getColumn(2).setPreferredWidth(55);
		table.getColumnModel().getColumn(3).setPreferredWidth(55);
		table.getColumnModel().getColumn(4).setPreferredWidth(155);
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		table.getColumnModel().getColumn(0).setPreferredWidth(65);
		table.getColumnModel().getColumn(0).setPreferredWidth(125);
		table.getColumnModel().getColumn(0).setPreferredWidth(105);
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		
		scrollPane.setViewportView(table);

	}
}
