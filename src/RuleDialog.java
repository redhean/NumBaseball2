import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class RuleDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RuleDialog dialog = new RuleDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RuleDialog() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RuleDialog.class.getResource("/images/baseball.png")));
		setTitle("SKKU NUM BASEBALL - RULE");
		setBounds(100, 100, 654, 382);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));
		{
			JTextArea txtrWithskkuNum = new JTextArea();
			txtrWithskkuNum.setFont(new Font("Monospaced", Font.BOLD, 13));
			// Show the whole rules
			txtrWithskkuNum.setText("With \"SKKU NUM BASEBALL\" you can play baseball alone!! \r\nThe rule is very simple but game will be little bit tricky. \r\n\r\nBefore you play the game, you can choose the two things.\r\n\r\nFirst you have to choose number of digits.\r\nThis is kind of difficulty of game.\r\nThere are \"3 Strike\", \"4 Strike\" and \"5 Strike\".\r\nEach number is the number of digits that you have to find out!! \r\nThe bigger number will be more difficult.\r\n\r\nSecond you can choose the number of hint.\r\nThere are \"No Hint\", \"1 Hint\", \"2 Hint\" and \"3 Hint\".\r\nEach number is the number of hints. \r\nBut be careful!! \r\nIf you want to be ranked, you should play in \"No Hint\" level!!\r\nYou can use the hint with \"Light bulb button\" on the right side. \r\nAnd  the number of hint that you can use \r\nwill show on the top of the screen(baseball bat).\r\n\r\nThe rule is simple. \r\nYou have to find out the number that computer randomly made. \r\nThe number of each digits will between 0 ~ 9.\r\n\r\n1. You should enter the number that you guess using \"number buttons\". \r\nIf you want reenter the number, click the \"backspace button\" \r\nand reenter the number.\r\n\r\n2. If you want to submit, click the \"baseball button\".\r\n\r\n3.  On the result  screen, computer will show the result of your answer \r\nwith \"Strike\" and \"Ball\".\r\nIf the number and the position both are correct, that number is \"Strike\".\r\nIf the only number is correct, that number is \"Ball\".\r\n\r\nExample)\r\nComputer : 123\r\nYou : 139\r\nThen the result is : 1 Strike(1) 1Ball(3)\r\n\r\nUsing the last results, you have to find the right number!!\r\n\r\n4. If you find the right number you win!!\r\nIf you want to give up the game, you just click the \"Give Up\" button.\r\n\r\nI hope you will enjoy the game :)\r\n");
			txtrWithskkuNum.setEditable(false);
			JScrollPane scrollPane = new JScrollPane(txtrWithskkuNum);
			contentPanel.add(scrollPane);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
