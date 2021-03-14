package teamproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class LoginEvt implements ActionListener{

	private Login li;
	
	public LoginEvt(Login li) {
		this.li = li;
		
		li.getJtfId().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				li.getJtfId().setText("");
			}
		});
		
		li.getJpfPw().addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseClicked(MouseEvent e){
		    	li.getJpfPw().setText("");   
		    }
		 });	
	}
	
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		ViewReport vr = new ViewReport();
		
		String id = li.getJtfId().getText();
		String pw ="";
		char[] pass = li.getJpfPw().getPassword();
		for(char p : pass) {
			pw += Character.toString(p);	
		}
		
		if(e.getSource() == li.getJbtnLogin()) {
			
			if((id.equals("admin"))&&(pw.equals("1234")) || (id.equals("root"))&&(pw.equals("1111"))) {
				//Dialog 실행 
				JDialog jdLog = new JDialog(li,true);
				vr.addDialog();
				li.dispose();
			}else{
				JOptionPane.showMessageDialog(null,"아이디 혹은 비밀번호를 잘못 입력하셨습니다.","로그인실패",JOptionPane.ERROR_MESSAGE);		
			}
			
		}
		
	}

}
