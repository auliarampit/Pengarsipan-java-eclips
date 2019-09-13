import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.Koneksi;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class SMUser extends JInternalFrame {
	private JTable table;
	public static String kdSuratMasuk = ""; 

	/**
	 * Create the frame.
	 */
	public SMUser() {
		setTitle("Surat Masuk");
		setBounds(0, 0, 1027, 612);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 73, 1021, 498);
		getContentPane().add(scrollPane);
		
		Object[][] rows = {};
		String [] coluomns = {"Kd SM", "Kd PT", "NO Agenda", "NO Surat", "Prihal", "Jenis Surat", "Pengirim", "Tanggal Surat", "Tanggal Terima"};
		DefaultTableModel dataModel = new DefaultTableModel(rows, coluomns);
		
		Koneksi.getConnection();
		try {
			ResultSet rs = Koneksi.stat.executeQuery("SELECT * FROM surat_masuk");
			while(rs.next()){
				String ksm = rs.getString("kd_surat_masuk");
				String kdp = rs.getString("kd_petugas");
				String na  = rs.getString("no_agenda");
				String ns  = rs.getString("no_surat");
				String p   = rs.getString("prihal");
				String js  = rs.getString("jenis_surat");
				String prm = rs.getString("pengirim");
				String ts  = rs.getString("tanggal_surat");
				String tt  = rs.getString("tanggal_terima");
				
			dataModel.addRow(new Object[]{ksm, kdp, na, ns, p, js, prm, ts, tt});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table = new JTable(dataModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				SuratMasuk2.kdSuratMasuk = table.getValueAt(table.getSelectedRow(), 0). toString();
				InputSM.main(null);
			}
		});
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(8);
		table.getColumnModel().getColumn(1).setPreferredWidth(8);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
		table.getColumnModel().getColumn(5).setPreferredWidth(70);
		table.getColumnModel().getColumn(6).setPreferredWidth(190);
		table.getColumnModel().getColumn(7).setPreferredWidth(40);
		table.getColumnModel().getColumn(8).setPreferredWidth(40);
		scrollPane.setViewportView(table);

	}

}
