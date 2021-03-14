package teamproject;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *	프로젝트 Login JFrame
 * @author user
 */
@SuppressWarnings("serial")
public class Login extends JFrame{
	
	private JButton jbtnLogin;
	private JTextField jtfId;
	private JPasswordField jpfPw;
	
	public Login() {
		super("Login");
		
		jbtnLogin = new JButton("Login");
		jtfId = new JTextField("ID");
		jpfPw = new JPasswordField("Pass",4);
		JLabel jlIfm = new JLabel("Ver1.0 Log Information system");
		
		//사진경로 나중에 수정하기!!!!!!!!!!!!!!!!!!!!!!!!
		ImageIcon iiImg = new ImageIcon("c:/dev/group_prj1/Imagesist.jpg");
		JLabel jlImg = new JLabel(iiImg);
		jlImg.setIcon(iiImg);
		
		Font jbtnfont = new Font("맑은고딕",Font.BOLD, 30);
		Font loginfont = new Font("맑은고딕",Font.PLAIN, 20);
		jbtnLogin.setFont(jbtnfont);
		jtfId.setFont(loginfont);
		jpfPw.setFont(loginfont);
		
		jbtnLogin.setForeground(Color.white);
		jbtnLogin.setBackground(Color.pink);
		getContentPane().setBackground(Color.white);
		
//		TitledBorder tb = new TitledBorder("Login");
		
		setLayout(null);
		setBounds(300, 200, 530, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(jbtnLogin);
		add(jtfId);
		add(jpfPw);
		add(jlImg);
		add(jlIfm);
		
		jtfId.setBounds(70, 150, 380, 50);
		jpfPw.setBounds(70, 210, 380, 50);
		jbtnLogin.setBounds(70, 270, 380, 50);
		jlImg.setBounds(60, 30, 397, 100);
		jlIfm.setBounds(170, 325, 200, 30);
		
		LoginEvt le = new LoginEvt(this);
		jbtnLogin.addActionListener(le);
		
	}
	
	
	public JButton getJbtnLogin() {
		return jbtnLogin;
	}

	public JTextField getJtfId() {
		return jtfId;
	}

	public JPasswordField getJpfPw() {
		return jpfPw;
	}
	
}
