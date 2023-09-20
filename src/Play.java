/*
 *  This page is Play page.
 *  User play the game in this page.
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Play extends JFrame {

	private JPanel contentPane;
	private JLabel lblBackground;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn0;
	private JButton btnDelete;
	private JButton btnEnter;
	private JScrollPane scrollPane;
	private JTextArea txtResult;
	private JTextField txtAnswer;
	private JButton btnGiveup;
	private JLabel lblHint1;
	private JLabel lblHint3;
	private JLabel lblHint2;
	private JButton btnHint;
	private JLabel lblGiveup;
	private JLabel lblHint;
	
	private static int difficulty;	// store the value of difficulty.
	private static int hint;	// store the number of hint.
	private int count;	// count the number of digits that user write. It should be <= difficulty
	private String result = "";	// store the whole process result.
	private int target[] = new int[5];	// store the number that computer made(user should find this number).
	private Random r = new Random();	// for make random number.
	private int hintchk;	// for check the number of left hint.
	private int numtry = 0;	// store the number of user attempts.
	
	
	public Play(int difficulty, int hint) {
		this.difficulty = difficulty;
		this.hint = hint;
		count = this.difficulty;
		hintchk = hint;
		
		// make the random number and store to target array.
		// the number of digits is same as difficulty.
		// the number will between 0 ~ 9.
		// there are no duplicate number.
		for(int i = 0; i < difficulty; i++) {
			target[i] = r.nextInt(10);
			for(int j = 0; j < i; j++) {
				if(target[i] == target[j])
					i--;
			}
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Play.class.getResource("/images/baseball.png")));
		if(difficulty == 3)
			setTitle("SKKU NUM BASEBALL - PLAY 3 Strike");
		else if(difficulty == 4)
			setTitle("SKKU NUM BASEBALL - PLAY 4 Strike");
		else
			setTitle("SKKU NUM BASEBALL - PLAY 5 Strike");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnHint = new JButton("");
		btnHint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If the left number of hint is 3 show first number.
				// If the left number of hint is 2 show last number.
				// If the left number of hint is 1 show middle number.
				
				if(hintchk == 3) {
					result += "================================\n";
					result += "Hint : The first number is " + target[0] + "\n";
					result += "================================\n";
					txtResult.setText(result);
					// reduce the number of hint and change the image to empty.
					hintchk--;
					lblHint3.setIcon(new ImageIcon(Play.class.getResource("/images/empty.png")));
				}
				else if(hintchk == 2) {
					result += "================================\n";
					result += "Hint : The last number is " + target[difficulty - 1] + "\n";
					result += "================================\n";
					txtResult.setText(result);
					// reduce the number of hint and change the image to empty.
					hintchk--;
					lblHint2.setIcon(new ImageIcon(Play.class.getResource("/images/empty.png")));
				}
				else if(hintchk == 1) {
					if(difficulty == 3 || difficulty == 5) {
						result += "================================\n";
						result += "Hint : The middle number is " + target[difficulty/2] + "\n";
						result += "================================\n";
						txtResult.setText(result);
					}
					// If the difficulty is 4 Strike, the middle number will be second number.
					else {
						result += "================================\n";
						result += "Hint : The second number is " + target[difficulty/2 - 1] + "\n";
						result += "================================\n";
						txtResult.setText(result);
					}
					// reduce the number of hint and change the image to empty.
					hintchk--;
					lblHint1.setIcon(new ImageIcon(Play.class.getResource("/images/empty.png")));
				}
				// If there are no left hint, show error message.
				else {
					JOptionPane.showMessageDialog(null,"There are no more hint left :(","No Hint",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		lblHint = new JLabel("Hint");
		lblHint.setHorizontalAlignment(SwingConstants.CENTER);
		lblHint.setFont(new Font("굴림", Font.BOLD, 15));
		lblHint.setBounds(346, 190, 90, 21);
		contentPane.add(lblHint);
		
		lblGiveup = new JLabel("Give Up");
		lblGiveup.setHorizontalAlignment(SwingConstants.CENTER);
		lblGiveup.setFont(new Font("굴림", Font.BOLD, 15));
		lblGiveup.setBounds(346, 279, 90, 21);
		contentPane.add(lblGiveup);
		btnHint.setIcon(new ImageIcon(Play.class.getResource("/images/lightbulb.png")));
		btnHint.setBounds(346, 213, 90, 60);
		contentPane.add(btnHint);
		
		lblHint2 = new JLabel("");
		lblHint2.setBounds(195, 29, 90, 60);
		contentPane.add(lblHint2);
		
		lblHint3 = new JLabel("");
		lblHint3.setBounds(346, 29, 90, 60);
		contentPane.add(lblHint3);
		
		lblHint1 = new JLabel("");
		lblHint1.setBounds(44, 29, 90, 60);
		contentPane.add(lblHint1);
		
		// Show the number of hint by the image of baseball bat and empty image.
		if(this.hint == 1) {
			lblHint1.setIcon(new ImageIcon(Play.class.getResource("/images/baseball bat.png")));
			lblHint2.setIcon(new ImageIcon(Play.class.getResource("/images/empty.png")));
			lblHint3.setIcon(new ImageIcon(Play.class.getResource("/images/empty.png")));
		}
		else if(this.hint == 2) {
			lblHint1.setIcon(new ImageIcon(Play.class.getResource("/images/baseball bat.png")));
			lblHint2.setIcon(new ImageIcon(Play.class.getResource("/images/baseball bat.png")));
			lblHint3.setIcon(new ImageIcon(Play.class.getResource("/images/empty.png")));
		}
		else if(this.hint == 3){
			lblHint1.setIcon(new ImageIcon(Play.class.getResource("/images/baseball bat.png")));
			lblHint2.setIcon(new ImageIcon(Play.class.getResource("/images/baseball bat.png")));
			lblHint3.setIcon(new ImageIcon(Play.class.getResource("/images/baseball bat.png")));
		}
		else {
			lblHint1.setIcon(new ImageIcon(Play.class.getResource("/images/empty.png")));
			lblHint2.setIcon(new ImageIcon(Play.class.getResource("/images/empty.png")));
			lblHint3.setIcon(new ImageIcon(Play.class.getResource("/images/empty.png")));
		}
		
		btnGiveup = new JButton("");
		btnGiveup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If user click the "Give Up" button, show the answer and move to the last rank page.
				String message = "";
				message += "The answer is : ";
				for(int i = 0; i < difficulty; i++) {
					message += target[i];
				}
				message += " ! \n";
				count = 0;
				txtResult.setText(result + message);
				JOptionPane.showMessageDialog(null,message,"You Give Up",JOptionPane.ERROR_MESSAGE);
				
				Rank rank = new Rank("","",0,0);
				rank.setVisible(true);
				dispose();
			}
		});
		btnGiveup.setIcon(new ImageIcon(Play.class.getResource("/images/giveup.png")));
		btnGiveup.setBounds(346, 304, 90, 60);
		contentPane.add(btnGiveup);
		
		txtAnswer = new JTextField();
		txtAnswer.setEditable(false);
		txtAnswer.setBounds(44, 115, 290, 21);
		contentPane.add(txtAnswer);
		txtAnswer.setColumns(10);
		
		// Click the each number buttons, add to the answer field.
		btn2 = new JButton("");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count > 0) {
					txtAnswer.setText(txtAnswer.getText() + "2");
					count--;
				}
					
			}
		});
		btn2.setIcon(new ImageIcon(Play.class.getResource("/images/2.png")));
		btn2.setBounds(109, 390, 60, 60);
		contentPane.add(btn2);
		
		btn1 = new JButton("");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count > 0) {
					txtAnswer.setText(txtAnswer.getText() + "1");
					count--;
				}
			}
		});
		btn1.setIcon(new ImageIcon(Play.class.getResource("/images/1.png")));
		btn1.setBounds(44, 390, 60, 60);
		contentPane.add(btn1);
		
		btn3 = new JButton("");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count > 0) {
					txtAnswer.setText(txtAnswer.getText() + "3");
					count--;
				}
			}
		});
		btn3.setIcon(new ImageIcon(Play.class.getResource("/images/3.png")));
		btn3.setBounds(174, 390, 60, 60);
		contentPane.add(btn3);
		
		btn4 = new JButton("");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count > 0) {
					txtAnswer.setText(txtAnswer.getText() + "4");
					count--;
				}
			}
		});
		btn4.setIcon(new ImageIcon(Play.class.getResource("/images/4.png")));
		btn4.setBounds(242, 390, 60, 60);
		contentPane.add(btn4);
		
		btn5 = new JButton("");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count > 0) {
					txtAnswer.setText(txtAnswer.getText() + "5");
					count--;
				}
			}
		});
		btn5.setIcon(new ImageIcon(Play.class.getResource("/images/5.png")));
		btn5.setBounds(309, 390, 60, 60);
		contentPane.add(btn5);
		
		btn6 = new JButton("");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count > 0) {
					txtAnswer.setText(txtAnswer.getText() + "6");
					count--;
				}
			}
		});
		btn6.setIcon(new ImageIcon(Play.class.getResource("/images/6.png")));
		btn6.setBounds(44, 459, 60, 60);
		contentPane.add(btn6);
		
		btn7 = new JButton("");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count > 0) {
					txtAnswer.setText(txtAnswer.getText() + "7");
					count--;
				}
			}
		});
		btn7.setIcon(new ImageIcon(Play.class.getResource("/images/7.png")));
		btn7.setBounds(109, 460, 60, 60);
		contentPane.add(btn7);
		
		btn8 = new JButton("");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count > 0) {
					txtAnswer.setText(txtAnswer.getText() + "8");
					count--;
				}
			}
		});
		btn8.setIcon(new ImageIcon(Play.class.getResource("/images/8.png")));
		btn8.setBounds(174, 460, 60, 60);
		contentPane.add(btn8);
		
		btn9 = new JButton("");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count > 0) {
					txtAnswer.setText(txtAnswer.getText() + "9");
					count--;
				}
			}
		});
		btn9.setIcon(new ImageIcon(Play.class.getResource("/images/9.png")));
		btn9.setBounds(242, 460, 60, 60);
		contentPane.add(btn9);
		
		btn0 = new JButton("");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count > 0) {
					txtAnswer.setText(txtAnswer.getText() + "0");
					count--;
				}
			}
		});
		btn0.setIcon(new ImageIcon(Play.class.getResource("/images/0.png")));
		btn0.setBounds(309, 460, 60, 60);
		contentPane.add(btn0);
		
		btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAnswer.setText("");
				count = difficulty;
			}
		});
		btnDelete.setIcon(new ImageIcon(Play.class.getResource("/images/delete.png")));
		btnDelete.setBounds(376, 390, 60, 60);
		contentPane.add(btnDelete);
		
		btnEnter = new JButton("");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numtry++;	// When user click the enter, add the number of attempts.
				int[] answer = new int[6]; // store the user input
				String tempanswer = "";
				int temp = 0;
				int strike = 0;	// store the number of strikes.
				int ball = 0;	// store the number of balls
				
				// change the String value to Integer value and store in temp(User input).
				temp = Integer.parseInt(txtAnswer.getText());
				for(int i = difficulty - 1; i >= 0; i--) {
					// by dividing 10, store the each positions of digits to answer array.
					answer[i] = temp % 10;
					temp /= 10;
				}
					
				// store to String of user inputs.	
				for(int i = 0; i < difficulty; i++) {
					tempanswer += answer[i];
				}
				
				// compare the target(computer made) and answer(user inputs), count the strikes and balls.
				for (int i = 0; i < difficulty; i++) {
					for (int j = 0; j < difficulty; j++) {
						if (target[i] == answer[j]) {
							if (i == j)
								// position and number both same.
								strike++;
							else 
								// only number is same.
								ball++;
						}
					}
				}
				
				// update the txtResult.
				result += numtry + ". " + tempanswer + " -> " + strike + " Strike " + ball + " Ball\n";
				txtResult.setText(result);
				
				// initialize
				txtAnswer.setText("");
				count = difficulty;
					
				// When user find the exact number then user win.
				// If No Hint mode, go to make ranking or just go to rank page directly.
				if(strike == difficulty) {
					result += "================================\n" + "You Win!!\n";
					txtResult.setText(result);
					count = 0;
					if(hint == 0) {
						JOptionPane.showMessageDialog(null,"You Win!","You Win",JOptionPane.INFORMATION_MESSAGE);
						MakeRankingDialog nickname = new MakeRankingDialog(numtry, difficulty);
						nickname.setModal(true);
						nickname.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null,"You Win!","You Win",JOptionPane.INFORMATION_MESSAGE);
						Rank rank = new Rank("","",0,0);
						rank.setVisible(true);
						dispose();
					}	
				}
			}
		});
		btnEnter.setIcon(new ImageIcon(Play.class.getResource("/images/enter.png")));
		btnEnter.setBounds(376, 460, 60, 60);
		contentPane.add(btnEnter);
		
		txtResult = new JTextArea();
		txtResult.setEditable(false);
		txtResult.setFont(new Font("Monospaced", Font.BOLD, 15));
		scrollPane = new JScrollPane(txtResult);
		scrollPane.setBounds(44, 146, 290, 218);
		contentPane.add(scrollPane);
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(Play.class.getResource("/images/greenfield.png")));
		lblBackground.setBounds(0, 0, 500, 600);
		contentPane.add(lblBackground);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Play frame = new Play(difficulty, hint);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
