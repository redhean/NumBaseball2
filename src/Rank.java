/*
 *  This page is Rank page.
 *  User can check the each difficulty of rank.
 *  Also, user can choose restart the game or exit the game.
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Rank extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JList list;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPanel difficultyPanel;
	private JButton btn3difficulty;
	private JButton btn4difficulty;
	private JButton btn5difficulty;
	private PrintWriter writer3;
	private PrintWriter writer4;
	private PrintWriter writer5;
	private JLabel lbldifficulty;
	private JPanel tablePanel;
	private JLabel lblNewLabel_1;
	private static String nickname;	// store the nickname that user write in MakeRankingDialog page.
	private static String coment;	// store the coment that user write in MakeRankingDialog page.
	private static int difficulty;	// store the value of the number of user attempts to win the game.
	private static int numtry;		// store the difficulty of game.
	
	// For update the ranking page by using file I/O.
	List<String> listData = new ArrayList<String>();
	DefaultListModel<String> listModel = new DefaultListModel<String>();

	public Rank(String nickname, String coment, int difficulty, int numtry) {
		this.nickname = nickname;
		this.coment = coment;
		
		try {
			
			// make text file for each difficulty level.
			writer3 = new PrintWriter(new FileOutputStream("rank3.txt",true));
			writer4 = new PrintWriter(new FileOutputStream("rank4.txt",true));
			writer5 = new PrintWriter(new FileOutputStream("rank5.txt",true));	
			
			// update the rank file for each difficulty level.
			if(difficulty == 3) {
				writer3.println(String.format("%2d                     %s                    %s",numtry, nickname, coment));
				writer3.close();
			}
			else if(difficulty == 4) {
				writer4.println(String.format("%2d                     %s                    %s",numtry, nickname, coment));
				writer4.close();
			}
			else if(difficulty == 5) {
				writer5.println(String.format("%2d                     %s                    %s",numtry, nickname, coment));
				writer5.close();
			}
			
			// default rank page is 3 Strike(difficulty == 3).
			BufferedReader reader = new BufferedReader(new FileReader("rank3.txt"));
			String str;
			while((str = reader.readLine()) != null) {
				listData.add(str);
			}
			// sort the data by using the "Attempt" -> low attempt number is high rank.
			Collections.sort(listData);
			listModel.clear();
			listModel.addAll(listData);
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Rank.class.getResource("/images/baseball.png")));
		setTitle("SKKU NUM BASEBALL - RANK");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Rank.class.getResource("/images/rank.png")));
		lblNewLabel.setBounds(0, 0, 500, 155);
		contentPane.add(lblNewLabel);
		
		list = new JList(listModel);
		list.setFont(new Font("굴림", Font.BOLD, 15));
		scrollPane = new JScrollPane(list);
		scrollPane.setBounds(0, 258, 500, 262);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		panel.setBounds(0, 520, 500, 40);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnNewButton = new JButton("REGAME");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Restart the game.
				NumBaseball regame = new NumBaseball();
				regame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Exit the game.
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btnNewButton_1);
		
		difficultyPanel = new JPanel();
		difficultyPanel.setBounds(0, 159, 486, 72);
		contentPane.add(difficultyPanel);
		
		btn3difficulty = new JButton("3 Strike");
		btn3difficulty.setBackground(new Color(255, 255, 255));
		btn3difficulty.setBounds(0, 0, 162, 47);
		btn3difficulty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Show the rank page that the level of difficulty is 3(3 Strike).
				try {
					lbldifficulty.setText("3 Strike");
					listData.clear();
					BufferedReader reader = new BufferedReader(new FileReader("rank3.txt"));
					String str;
					while((str = reader.readLine()) != null) {
						listData.add(str);
					}
					// sort the data by using the "Attempt" -> low attempt number is high rank.
					Collections.sort(listData);
					listModel.clear();
					listModel.addAll(listData);
					
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				
			}
		});
		difficultyPanel.setLayout(null);
		btn3difficulty.setFont(new Font("굴림", Font.BOLD, 20));
		difficultyPanel.add(btn3difficulty);
		
		btn4difficulty = new JButton("4 Strike");
		btn4difficulty.setBackground(new Color(255, 255, 255));
		btn4difficulty.setBounds(162, 0, 162, 47);
		btn4difficulty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Show the rank page that the level of difficulty is 4(4 Strike).
				try {
					lbldifficulty.setText("4 Strike");
					listData.clear();
					BufferedReader reader = new BufferedReader(new FileReader("rank4.txt"));
					String str;
					while((str = reader.readLine()) != null) {
						listData.add(str);
					}
					// sort the data by using the "Attempt" -> low attempt number is high rank.
					Collections.sort(listData);
					listModel.clear();
					listModel.addAll(listData);
					
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});
		btn4difficulty.setFont(new Font("굴림", Font.BOLD, 20));
		difficultyPanel.add(btn4difficulty);
		
		btn5difficulty = new JButton("5 Strike");
		btn5difficulty.setBackground(new Color(255, 255, 255));
		btn5difficulty.setBounds(324, 0, 162, 47);
		btn5difficulty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Show the rank page that the level of difficulty is 5(5 Strike).
				try {
					lbldifficulty.setText("5 Strike");
					listData.clear();
					BufferedReader reader = new BufferedReader(new FileReader("rank5.txt"));
					String str;
					while((str = reader.readLine()) != null) {
						listData.add(str);
					}
					// sort the data by using the "Attempt" -> low attempt number is high rank.
					Collections.sort(listData);
					listModel.clear();
					listModel.addAll(listData);
					
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});
		btn5difficulty.setFont(new Font("굴림", Font.BOLD, 20));
		difficultyPanel.add(btn5difficulty);
		
		lbldifficulty = new JLabel("3 Strike");
		lbldifficulty.setBackground(new Color(255, 255, 255));
		lbldifficulty.setFont(new Font("굴림", Font.BOLD, 20));
		lbldifficulty.setBounds(0, 47, 486, 25);
		difficultyPanel.add(lbldifficulty);
		
		tablePanel = new JPanel();
		tablePanel.setBounds(0, 230, 486, 29);
		contentPane.add(tablePanel);
		tablePanel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Attemps   Nickname            Comment");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setBounds(0, 5, 486, 24);
		tablePanel.add(lblNewLabel_1);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rank frame = new Rank(nickname, coment, difficulty, numtry);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
