/*
 *  This page is MakeRankingDialog page.
 *  If user win the game with "No Hint" level, then user can rank the game.
 *  In this page user can write nickname and coment.
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MakeRankingDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNickname;
	private JTextField txtComent;
	private static int numtry;	// store the value of the number of user attempts to win the game.
	private static int difficulty;	// store the difficulty of game.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			// make MakeRankingDialog page using numtry and difficulty.
			MakeRankingDialog dialog = new MakeRankingDialog(numtry, difficulty);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MakeRankingDialog(int numtry, int difficulty) {
		this.difficulty = difficulty;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MakeRankingDialog.class.getResource("/images/baseball.png")));
		setTitle("SKKU NUM BASEBALL - MAKERANKIING");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtNickname = new JTextField();
			txtNickname.setText("");
			txtNickname.setBounds(166, 35, 258, 34);
			contentPanel.add(txtNickname);
			txtNickname.setColumns(10);
		}
		{
			JLabel lblNickname = new JLabel("Nickname : ");
			lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
			lblNickname.setFont(new Font("굴림", Font.BOLD, 15));
			lblNickname.setBounds(12, 34, 142, 34);
			contentPanel.add(lblNickname);
		}
		{
			JLabel lblComent = new JLabel("Comment : ");
			lblComent.setHorizontalAlignment(SwingConstants.CENTER);
			lblComent.setFont(new Font("굴림", Font.BOLD, 15));
			lblComent.setBounds(12, 133, 142, 34);
			contentPanel.add(lblComent);
		}
		{
			txtComent = new JTextField();
			txtComent.setText("");
			txtComent.setColumns(10);
			txtComent.setBounds(166, 134, 258, 34);
			contentPanel.add(txtComent);
		}
		{
			JLabel lblWarning1 = new JLabel("The maximum length of nickname is 10 !!");
			lblWarning1.setFont(new Font("굴림", Font.BOLD, 12));
			lblWarning1.setForeground(new Color(255, 0, 0));
			lblWarning1.setBounds(166, 66, 258, 24);
			contentPanel.add(lblWarning1);
		}
		{
			JLabel lblWarning2 = new JLabel("The maximum length of comment is 20 !!");
			lblWarning2.setForeground(Color.RED);
			lblWarning2.setFont(new Font("굴림", Font.BOLD, 12));
			lblWarning2.setBounds(166, 166, 258, 24);
			contentPanel.add(lblWarning2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String warning = "";	// store the exception message
						try {
							// If the nickname is empty, add the warning message.
							if(txtNickname.getText().length() == 0)
								warning += "You need to write nickname.\n";
							// If the comment is empty, add the warning message.
							if(txtComent.getText().length() == 0)
								warning += "You need to write comment.\n";
							// If the nickname is too long, add the warning message.
							if(txtNickname.getText().length() > 10)
								warning += "The maximum length of nickname is 10.\n";
							// If the comment  is too long, add the warning message.
							if(txtComent.getText().length() > 20)
								warning += "The maximum length comment is 20.\n";
							
							// If there are some adding warning message, throw the exception(RankCheck).
							if(warning != "")
								throw new RankCheck();
							
							Rank rank = new Rank(txtNickname.getText(), txtComent.getText(), difficulty, numtry);
							rank.setVisible(true);
							dispose();
							
						}catch(RankCheck e1) {
							JOptionPane.showMessageDialog(null,warning,"Rank Check Message",JOptionPane.ERROR_MESSAGE);
						}
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
