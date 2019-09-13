import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.Koneksi;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DisposisiUser extends JInternalFrame {
	private JTable table;
	public static String kdDisposisi = ""; 

	/**
	 * Create the frame.
	 */
	public DisposisiUser() {
		setTitle("Disposisi");
		setBounds(0, 0, 1027, 612);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 73, 1021, 498);
		getContentPane().add(scrollPane);
		
		Object [][] rows = {};
		String [] coloumns = {"Kode Disposisi", "Kode SM", "Penerima" ,"Keterangan", "Status Surat", "Tanggapan"};
		DefaultTableModel dataModel = new DefaultTableModel(rows, coloumns);
		
		Koneksi.getConnection();
		try {
			ResultSet rs = Koneksi.stat.executeQuery("SELECT * FROM disposisi");
			while(rs.next()){
				String kdDisposisi 	= rs.getString("kd_disposisi");
				String kdSM			= rs.getString("kd_surat_masuk");
				String Penerima		= rs.getString("penerima");
				String Keterangan	= rs.getString("keterangan");
				String S_status		= rs.getString("status_surat");
				String Tanggapan	= rs.getString("tanggapan");
				
			dataModel.addRow(new Object[] {kdDisposisi, kdSM, Penerima, Keterangan, S_status, Tanggapan});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table = new JTable(dataModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Koneksi.getConnection();
			Disposisi2.kdDisposisi = table.getValueAt(table.getSelectedRow(), 0). toString();
			InputDp.main(null);
			}
		});
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(25);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		table.getColumnModel().getColumn(4).setPreferredWidth(125);
		table.getColumnModel().getColumn(5).setPreferredWidth(125);
		scrollPane.setViewportView(table);

	}
}
