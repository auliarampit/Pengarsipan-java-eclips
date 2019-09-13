import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;

public class TentangAplikasi extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TentangAplikasi frame = new TentangAplikasi();
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
	public TentangAplikasi() {
		setBounds(0, 0, 1027, 612);
		
		JLabel lblTentangAplikasi = new JLabel("Tentang Aplikasi");
		lblTentangAplikasi.setHorizontalAlignment(SwingConstants.CENTER);
		lblTentangAplikasi.setFont(new Font("Palatino Linotype", Font.BOLD, 30));
		getContentPane().add(lblTentangAplikasi, BorderLayout.NORTH);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(0, 153, 255));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("D:\\''SMK 5 Telkom''\\Belajar PBO\\new\\Arsip2\\src\\images\\icoh-header.png"));
		getContentPane().add(label, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblTtdPembuat = new JLabel("TTD PEMBUAT");
		panel_1.add(lblTtdPembuat);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblAuliaRahmat = new JLabel("AULIA RAHMAT");
		panel_2.add(lblAuliaRahmat);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.WEST);
		
		JLabel lblXiiRpl = new JLabel("");
		panel.add(lblXiiRpl, BorderLayout.EAST);

	}

}
