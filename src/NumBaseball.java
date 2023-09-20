/*
 *  This page is start page.
 *  It shows the Title of the game and start button.
 *  If the user click the start button, it moves to the next page(OptionRule page).
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NumBaseball extends JFrame {

	private JPanel contentPane;
	private JLabel lblBackground;
	private JLabel lblTitle;
	private JButton btnStart;
	private JLabel lblNewLabel;


	public NumBaseball() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(NumBaseball.class.getResource("/images/baseball.png")));
		setTitle("SKKU Num Baseball");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("START");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(65, 267, 78, 24);
		contentPane.add(lblNewLabel);
		
		btnStart = new JButton("");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If user click the start button, show OptionRule page.
				OptionRule option = new OptionRule();
				option.setVisible(true);
				dispose();
			}
		});
		btnStart.setBackground(new Color(0, 0, 0));
		btnStart.setIcon(new ImageIcon(NumBaseball.class.getResource("/images/pngegg.png")));
		btnStart.setFont(new Font("굴림", Font.BOLD, 20));
		btnStart.setBounds(78, 211, 50, 50);
		contentPane.add(btnStart);
		
		lblTitle = new JLabel("");
		lblTitle.setIcon(new ImageIcon(NumBaseball.class.getResource("/images/Logo.png")));
		lblTitle.setBounds(0, 0, 500, 140);
		contentPane.add(lblTitle);
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(NumBaseball.class.getResource("/images/baseball.png")));
		lblBackground.setBounds(0, 0, 500, 600);
		contentPane.add(lblBackground);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumBaseball frame = new NumBaseball();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
