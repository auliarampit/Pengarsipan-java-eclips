import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.Koneksi;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class LaporanSuratMasuk extends JInternalFrame {
	private JTable table;
	private JTextField txtCari;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaporanSuratMasuk frame = new LaporanSuratMasuk();
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
	public LaporanSuratMasuk() {
		setBounds(0, 0, 1027, 612);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 73, 1021, 498);
		getContentPane().add(scrollPane);
		
		Object[][] rows = {};
		String [] coloumns = {"Tanggal Terima" ,"No Agenda", "No Surat", "Nama Petugas", "Tanggal Surat", "Prihal", "Pengirim"};
		DefaultTableModel dataModel = new DefaultTableModel(rows, coloumns);
		
		Koneksi.getConnection();
		try {
			ResultSet rs = Koneksi.stat.executeQuery("select s.tanggal_terima,s.no_agenda,s.no_surat,p.nama_lengkap,s.tanggal_surat,s.prihal,s.pengirim from surat_masuk s inner join petugas p on s.kd_petugas=p.kd_petugas ");
			while(rs.next()){
				String TT = rs.getString("tanggal_terima");
				String NA = rs.getString("no_agenda");
				String NO = rs.getString("no_surat");
				String NP = rs.getString("nama_lengkap");
				String TS = rs.getString("tanggal_surat");
				String P  = rs.getString("prihal");
				String Pr = rs.getString("pengirim");
				
			dataModel.addRow(new Object[] {TT,NA,NO,NP,TS,P,Pr});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table = new JTable(dataModel);
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(35);
		table.getColumnModel().getColumn(2).setPreferredWidth(35);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.getColumnModel().getColumn(5).setPreferredWidth(45);
		table.getColumnModel().getColumn(6).setPreferredWidth(145);
		scrollPane.setViewportView(table);
		
		txtCari = new JTextField();
		txtCari.setBounds(622, 31, 232, 32);
		getContentPane().add(txtCari);
		txtCari.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getContentPane().remove(scrollPane);
				getContentPane().repaint();
				
				showTable();
				
			}
		});
		btnNewButton.setFont(new Font("Palatino Linotype", Font.PLAIN, 15));
		btnNewButton.setBounds(860, 23, 89, 48);
		getContentPane().add(btnNewButton);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setFont(new Font("Palatino Linotype", Font.PLAIN, 15));
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MessageFormat judul = new MessageFormat("LAPORAN SURAT MASUK");
				MessageFormat halaman = new MessageFormat("Hal.1");
				try {
					table.print(JTable.PrintMode.FIT_WIDTH, judul, halaman);
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrint.setBounds(949, 23, 62, 48);
		getContentPane().add(btnPrint);

	}
	
	public void showTable(){
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 73, 1021, 498);
		getContentPane().add(scrollPane);
		
		Object[][] rows = {};
		String [] coloumns = {"Tanggal Terima" ,"No Agenda", "No Surat", "Nama Petugas", "Tanggal Surat", "Prihal", "Pengirim"};
		DefaultTableModel dataModel = new DefaultTableModel(rows, coloumns);
		
		Koneksi.getConnection();
		try {
			ResultSet rs = Koneksi.stat.executeQuery("select s.tanggal_terima,s.no_agenda,s.no_surat,p.nama_lengkap,s.tanggal_surat,s.prihal,s.pengirim from surat_masuk s inner join petugas p on s.kd_petugas=p.kd_petugas where nama_lengkap like '%"+ txtCari.getText() +"%'");
			while(rs.next()){
				String TT = rs.getString("tanggal_terima");
				String NA = rs.getString("no_agenda");
				String NO = rs.getString("no_surat");
				String NP = rs.getString("nama_lengkap");
				String TS = rs.getString("tanggal_surat");
				String P  = rs.getString("prihal");
				String Pr = rs.getString("pengirim");
				
			dataModel.addRow(new Object[] {TT,NA,NO,NP,TS,P,Pr});
			}
		} catch (SQLException ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}
		
		table = new JTable(dataModel);
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(35);
		table.getColumnModel().getColumn(2).setPreferredWidth(35);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.getColumnModel().getColumn(5).setPreferredWidth(45);
		table.getColumnModel().getColumn(6).setPreferredWidth(145);
		scrollPane.setViewportView(table);
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}
}
