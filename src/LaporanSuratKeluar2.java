import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Connection.Koneksi;

import javax.swing.JButton;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;

public class LaporanSuratKeluar2 extends JInternalFrame {
	private JTable table;
	private JTextField txtCari;
	private JButton btnPrint;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaporanSuratKeluar2 frame = new LaporanSuratKeluar2();
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
	public LaporanSuratKeluar2() {
		setBounds(0, 0, 1027, 612);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 73, 1021, 498);
		getContentPane().add(scrollPane);
		
		Object [][] rows = {};
		String [] coloumns = {"Tanggal Kirim", "Nama Petugas", "No Agenda", "No Surat", "Prihal", "Tujuan"};
		DefaultTableModel dataModel = new DefaultTableModel(rows, coloumns);
		
		Koneksi.getConnection();
		try {
			ResultSet rs = Koneksi.stat.executeQuery("select s.tanggal_kirim, p.nama_lengkap, s.no_agenda, s.no_surat, s.prihal, s.tujuan from surat_keluar s inner join petugas p on s.kd_petugas = p.kd_petugas");
			while(rs.next()){
				String TK = rs.getString("tanggal_kirim");
				String NP = rs.getString("nama_lengkap");
				String NA = rs.getString("no_agenda");
				String NO = rs.getString("no_surat");
				String P  = rs.getString("prihal");
				String T  = rs.getString("tujuan");
				
			dataModel.addRow(new Object[] {TK, NP, NA, NO, P, T});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table = new JTable(dataModel);
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(45);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);
		scrollPane.setViewportView(table);
		
		txtCari = new JTextField();
		txtCari.setColumns(10);
		txtCari.setBounds(622, 31, 232, 32);
		getContentPane().add(txtCari);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getContentPane().remove(scrollPane);
				getContentPane().repaint();
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 73, 1021, 498);
				getContentPane().add(scrollPane);
				
				Object [][] rows = {};
				String [] coloumns = {"Tanggal Kirim", "Nama Petugas", "No Agenda", "No Surat", "Prihal", "Tujuan"};
				DefaultTableModel dataModel = new DefaultTableModel(rows, coloumns);
				
				Koneksi.getConnection();
				try {
					ResultSet rs = Koneksi.stat.executeQuery("select s.tanggal_kirim, p.nama_lengkap, s.no_agenda, s.no_surat, s.prihal, s.tujuan from surat_keluar s inner join petugas p on s.kd_petugas = p.kd_petugas where nama_lengkap like '%"+ txtCari.getText() +"%'");
					while(rs.next()){
						String TK = rs.getString("tanggal_kirim");
						String NP = rs.getString("nama_lengkap");
						String NA = rs.getString("no_agenda");
						String NO = rs.getString("no_surat");
						String P  = rs.getString("prihal");
						String T  = rs.getString("tujuan");
						
					dataModel.addRow(new Object[] {TK, NP, NA, NO, P, T});
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				table = new JTable(dataModel);
				table.setRowHeight(30);
				table.getColumnModel().getColumn(0).setPreferredWidth(30);
				table.getColumnModel().getColumn(1).setPreferredWidth(50);
				table.getColumnModel().getColumn(2).setPreferredWidth(40);
				table.getColumnModel().getColumn(3).setPreferredWidth(40);
				table.getColumnModel().getColumn(4).setPreferredWidth(45);
				table.getColumnModel().getColumn(5).setPreferredWidth(60);
				scrollPane.setViewportView(table);
				
			}
		});
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Palatino Linotype", Font.PLAIN, 15));
		button.setBounds(860, 23, 89, 48);
		getContentPane().add(button);
		
		btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MessageFormat judul = new MessageFormat("LAPORAN SURAT KELUAR");
				MessageFormat halaman = new MessageFormat("Hal.1");
				try {
					table.print(JTable.PrintMode.FIT_WIDTH, judul, halaman);
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrint.setFont(new Font("Palatino Linotype", Font.PLAIN, 15));
		btnPrint.setBounds(949, 23, 62, 48);
		getContentPane().add(btnPrint);

	}
}
