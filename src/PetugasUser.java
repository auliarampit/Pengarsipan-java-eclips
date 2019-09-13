import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.Koneksi;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

public class PetugasUser extends JInternalFrame {
	private JTable table;
	public static String kdPetugas = ""; 

	/**
	 * Create the frame.
	 */
	public PetugasUser() {
		setTitle("Petugas");
		setBounds(0, 0, 1027, 612);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 579, 413);
		getContentPane().add(scrollPane);
		
		Object[][] rows = {};
		String [] Coloumns = {"Kode PT", "Nama Petugas", "Jenis Kelamin", "Alamat"};
		DefaultTableModel dataModel = new DefaultTableModel(rows, Coloumns);
		
		Koneksi.getConnection();
		try {
			ResultSet rs = Koneksi.stat.executeQuery("SELECT * FROM petugas");
			while(rs.next()){
				String kd = rs.getString("kd_petugas");
				String np = rs.getString("nama_lengkap");
				String jk = rs.getString("jenis_kelamin");
				String al = rs.getString("alamat");
				
			dataModel.addRow(new Object[]{kd, np, jk, al});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table = new JTable(dataModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Petugas2.kdPetugas = table.getValueAt(table.getSelectedRow(), 0). toString();
				InputPT.main(null);
			}
		});
		
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(2).setPreferredWidth(5);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		
		scrollPane.setViewportView(table);

	}
}
