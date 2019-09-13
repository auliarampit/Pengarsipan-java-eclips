import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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

public class SuratKeluar2 extends JInternalFrame {
	private JTable table;
	public static String kdSuratKeluar = "";
	public JScrollPane scrollPane;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuratKeluar2 frame = new SuratKeluar2();
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
	public SuratKeluar2() {
		setTitle("Surat Keluar");
		setBounds(0, 0, 1027, 612);
		getContentPane().setLayout(null);
		
		tampilTable();
		
		button = new JButton("Tambahkan");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InputSK.main(null);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(0, 36, 141, 37);
		getContentPane().add(button);

	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
	public void tampilTable(){
		scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 73, 1011, 498);
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
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setMinWidth(115);
		table.getColumnModel().getColumn(0).setMaxWidth(115);
		table.getColumnModel().getColumn(0).setPreferredWidth(115);
		
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(1).setMaxWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		
		table.getColumnModel().getColumn(2).setMinWidth(100);
		table.getColumnModel().getColumn(2).setMaxWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		
		table.getColumnModel().getColumn(3).setMinWidth(185);
		table.getColumnModel().getColumn(3).setMaxWidth(185);
		table.getColumnModel().getColumn(3).setPreferredWidth(185);
		
		table.getColumnModel().getColumn(4).setMinWidth(185);
		table.getColumnModel().getColumn(4).setMaxWidth(185);
		table.getColumnModel().getColumn(4).setPreferredWidth(185);
		
		table.getColumnModel().getColumn(1).setMinWidth(185);
		table.getColumnModel().getColumn(1).setMaxWidth(185);
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		
		table.getColumnModel().getColumn(1).setMinWidth(85);
		table.getColumnModel().getColumn(1).setMaxWidth(85);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(1).setMaxWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(125);
		
		table.getColumnModel().getColumn(1).setMinWidth(125);
		table.getColumnModel().getColumn(1).setMaxWidth(125);
		table.getColumnModel().getColumn(8).setPreferredWidth(100);
		
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(1).setMaxWidth(100);
		scrollPane.setViewportView(table);
	}


	public JButton getButton() {
		return button;
	}
}
