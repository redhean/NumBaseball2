/*
 *  This page is OptionRule page.
 *  User can choose the difficulty of game and the number of hint.
 *  Also user can see the rule of this game.
 *  If user click the play button it moves to the next page(Play page).
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class OptionRule extends JFrame {

	private JPanel contentPane;
	private JLabel lblBackground;
	private JLabel lblDifficulty;
	private JRadioButton rdbtn3Strike;
	private JRadioButton rdbtn4Strike;
	private JRadioButton rdbtn5Strike;
	private JLabel lblLife;
	private JRadioButton rdbtn1Hint;
	private JRadioButton rdbtn2Hint;
	private JRadioButton rdbtn3Hint;
	private JButton btnRule;
	private JButton btnPlay;
	private JRadioButton rdbtn0Hint;
	private JLabel lblExplain;
	private static int difficulty;	// store the value of difficulty that user choose.
	private static int hint;	// store the number of hint that user choose.


	public OptionRule() {
		setTitle("SKKU NUM BASEBALL");
		setIconImage(Toolkit.getDefaultToolkit().getImage(OptionRule.class.getResource("/images/baseball.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnPlay = new JButton("Play");
		btnPlay.setBackground(new Color(255, 255, 255));
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String warning = "";	// store the exception message.
				try {
					// If all difficulty buttons are not selected, add the warning message.
					if(rdbtn3Strike.isSelected() == false && rdbtn4Strike.isSelected() == false && rdbtn5Strike.isSelected() == false)
						warning += "You have to check Difficulty.\n";
					// If all hint buttons are not selected, add the warning message.
					if(rdbtn0Hint.isSelected() == false && rdbtn1Hint.isSelected() == false && rdbtn2Hint.isSelected() == false && rdbtn3Hint.isSelected() == false)
						warning += "You have to check Hint.\n";
					
					// If there are some adding warning message, throw the exception(OptionCheck).
					if(warning != "")
						throw new OptionCheck();
					
					// store the value of hint and difficulty according to the user clicked.
					if(rdbtn1Hint.isSelected()) hint = 1;
					else if(rdbtn2Hint.isSelected()) hint = 2;
					else if(rdbtn3Hint.isSelected()) hint = 3;
					else hint = 0;
					
					if(rdbtn3Strike.isSelected()) difficulty = 3;
					else if(rdbtn4Strike.isSelected()) difficulty = 4;
					else difficulty = 5;
					
					// move to next page -> Play page.
					Play play = new Play(difficulty, hint);
					play.setVisible(true);
					dispose();
					
				}catch(OptionCheck e1) {
					JOptionPane.showMessageDialog(null,warning,"Option Check Message",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		lblExplain = new JLabel("Only \"No Hint\" level can be ranked !!");
		lblExplain.setForeground(new Color(255, 255, 0));
		lblExplain.setFont(new Font("굴림", Font.BOLD, 20));
		lblExplain.setBounds(31, 404, 420, 26);
		contentPane.add(lblExplain);
		
		rdbtn0Hint = new JRadioButton("No Hint");
		rdbtn0Hint.setBackground(new Color(255, 255, 255));
		rdbtn0Hint.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn0Hint.setBounds(100, 224, 113, 50);
		contentPane.add(rdbtn0Hint);
		btnPlay.setBounds(360, 495, 91, 45);
		contentPane.add(btnPlay);
		
		btnRule = new JButton("Rule");
		btnRule.setBackground(new Color(255, 255, 255));
		btnRule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If user click the rule button, show rule page(RuleDialog).
				RuleDialog rule = new RuleDialog();
				rule.setModal(true);
				rule.setVisible(true);
			}
		});
		btnRule.setBounds(236, 495, 91, 45);
		contentPane.add(btnRule);
		
		rdbtn1Hint = new JRadioButton("1 Hint");
		rdbtn1Hint.setBackground(new Color(255, 255, 255));
		rdbtn1Hint.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn1Hint.setBounds(273, 224, 113, 50);
		contentPane.add(rdbtn1Hint);
		
		rdbtn2Hint = new JRadioButton("2 Hint");
		rdbtn2Hint.setBackground(new Color(255, 255, 255));
		rdbtn2Hint.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn2Hint.setBounds(100, 324, 113, 50);
		contentPane.add(rdbtn2Hint);
		
		rdbtn3Hint = new JRadioButton("3 Hint");
		rdbtn3Hint.setBackground(new Color(255, 255, 255));
		rdbtn3Hint.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn3Hint.setBounds(273, 324, 113, 50);
		contentPane.add(rdbtn3Hint);
		
		// make group for hint buttons to choose only one button.
		ButtonGroup G1 = new ButtonGroup();
		G1.add(rdbtn1Hint);
		G1.add(rdbtn2Hint);
		G1.add(rdbtn3Hint);
		G1.add(rdbtn0Hint);
		
		lblLife = new JLabel("Hint(Number of hint)");
		lblLife.setForeground(new Color(255, 255, 255));
		lblLife.setFont(new Font("굴림", Font.BOLD, 20));
		lblLife.setBounds(31, 182, 217, 26);
		contentPane.add(lblLife);
		
		rdbtn5Strike = new JRadioButton("5 Strike");
		rdbtn5Strike.setBackground(new Color(255, 255, 255));
		rdbtn5Strike.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn5Strike.setBounds(353, 102, 113, 50);
		contentPane.add(rdbtn5Strike);
		
		rdbtn4Strike = new JRadioButton("4 Strike");
		rdbtn4Strike.setBackground(new Color(255, 255, 255));
		rdbtn4Strike.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn4Strike.setBounds(195, 102, 113, 50);
		contentPane.add(rdbtn4Strike);
		
		rdbtn3Strike = new JRadioButton("3 Strike");
		rdbtn3Strike.setBackground(new Color(255, 255, 255));
		rdbtn3Strike.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn3Strike.setBounds(31, 102, 113, 50);
		contentPane.add(rdbtn3Strike);
		
		// make group for strike buttons to choose only one button.
		ButtonGroup G2 = new ButtonGroup();
		G2.add(rdbtn3Strike);
		G2.add(rdbtn4Strike);
		G2.add(rdbtn5Strike);
		
		
		
		lblDifficulty = new JLabel("Difficulty(Number of Strike)");
		lblDifficulty.setForeground(new Color(255, 255, 255));
		lblDifficulty.setFont(new Font("굴림", Font.BOLD, 20));
		lblDifficulty.setBounds(31, 61, 314, 26);
		contentPane.add(lblDifficulty);
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(OptionRule.class.getResource("/images/greenfield.png")));
		lblBackground.setBounds(0, 0, 500, 600);
		contentPane.add(lblBackground);
		
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionRule frame = new OptionRule();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
