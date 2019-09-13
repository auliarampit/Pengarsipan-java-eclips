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

public class SuratMasuk2 extends JInternalFrame {
	private JTable table;
	public static String kdSuratMasuk = ""; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuratMasuk2 frame = new SuratMasuk2();
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
	public SuratMasuk2() {
		setTitle("Surat Masuk");
		setBounds(0, 0, 1027, 612);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(30);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.getColumnModel().getColumn(0).setMaxWidth(100);
		
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(1).setMaxWidth(100);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setMinWidth(120);
		table.getColumnModel().getColumn(2).setMaxWidth(120);
		
		table.getColumnModel().getColumn(3).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setMinWidth(130);
		table.getColumnModel().getColumn(3).setMaxWidth(130);
		
		table.getColumnModel().getColumn(4).setPreferredWidth(280);
		table.getColumnModel().getColumn(4).setMinWidth(280);
		table.getColumnModel().getColumn(4).setMaxWidth(280);
		
		table.getColumnModel().getColumn(5).setPreferredWidth(160);
		table.getColumnModel().getColumn(5).setMinWidth(160);
		table.getColumnModel().getColumn(5).setMaxWidth(160);
		
		table.getColumnModel().getColumn(6).setPreferredWidth(190);
		table.getColumnModel().getColumn(6).setMinWidth(290);
		table.getColumnModel().getColumn(6).setMaxWidth(290);
		
		table.getColumnModel().getColumn(7).setPreferredWidth(130);
		table.getColumnModel().getColumn(7).setMinWidth(130);
		table.getColumnModel().getColumn(7).setMaxWidth(130);
		
		table.getColumnModel().getColumn(8).setPreferredWidth(130);
		table.getColumnModel().getColumn(8).setMinWidth(130);
		table.getColumnModel().getColumn(8).setMaxWidth(130);

		scrollPane.setViewportView(table);
		
		JButton button = new JButton("Tambahkan");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InputSM.main(null);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(10, 35, 141, 37);
		getContentPane().add(button);

	}

}
