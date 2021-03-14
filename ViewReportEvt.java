package teamproject;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ViewReportEvt implements ActionListener{

	private ViewReport vr;
	private JTextArea jtaLog;
	public File file;
	private String namePath1;
	private String namePath2;
	
	
	private static int CLICK = 1;
	private static int FILENUM = 0;
	
	public ViewReportEvt() {
		
	}
	
	public ViewReportEvt(ViewReport vr) {
		this.vr = vr;
	}//ViewReportEvt


	@Override
	public void actionPerformed(ActionEvent ae) {
		JButton jbtnView = vr.getJbtnView();
		JButton jbtnReport = vr.getJbtnReport();
		jtaLog = vr.getJtaLog();
		
		if(ae.getSource() == jbtnView) {
			CLICK = 0;
			try {
				jtaLog.setText("");
				getLogInfo();
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
		}//end if
		
		if(CLICK == 0) {
			if(ae.getSource() == jbtnReport) { 
				try {
					report();
				} catch (IOException e) {
					e.printStackTrace();
				
			}finally {
				JOptionPane.showMessageDialog(jbtnReport, "경로 : c:/dev/report\n파일이 생성되었습니다.");
			
			}//end if
		}
	}
}//actionPerformed

	public void getLogInfo() throws IOException {
		FileDialog fd = new FileDialog(vr,"LogFile Load", FileDialog.LOAD);
		fd.setVisible(true);

		String path = fd.getDirectory();
		String fileName = fd.getFile();
		file = new File(path + fileName);
		fd.setTitle(path + fileName);
		
		StringBuilder sbLogData1 = new StringBuilder();
		StringBuilder sbLogData2 = new StringBuilder();
		
		AnalysisLog1 al1 = new AnalysisLog1();
		AnalysisLog2 al2 = new AnalysisLog2();
		
		namePath1 = path+fileName; 
		al1.setNamePath(namePath1);
		
		namePath2 = path+fileName; 
		al2.setNamePath(namePath2);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 - MM월 - dd일 hh : mm : ss");
		Date date = new Date(System.currentTimeMillis());
		
		String sdfDate = sdf.format(date);
		
		if(file.exists() && file.getName().equals("sist_input_1.log")) {
			FILENUM = 1;
			
			sbLogData1.append("파일명").append("(" + file.getName() + ") ").append("log").append("(생성된 날짜 " + sdfDate + " ) ").append("\n\n")
			.append(al1.maxKey()).append("\n\n").append(al1.GoValue()).append("\n")
			.append(al1.DoneValue()).append("\n\n").append(al1.MaxRequest()).append("\n\n")
			.append(al1.ErrorValue()).append("\n\n").append(al1.RangeMaxKey(1, 100));
		
		vr.getJtaLog().setText(sbLogData1.toString());
		vr.getJtaLog().setEditable(false);
		
		}else if(file.exists() && file.getName().equals("sist_input_2.log")) {
			FILENUM = 2;
			
			sbLogData2.append("파일명").append("(" + file.getName() + ") ").append("log").append("(생성된 날짜 " + sdfDate + " ) ").append("\n\n")
			.append(al2.maxKey()).append("\n\n").append(al2.GoValue()).append("\n")
			.append(al2.DoneValue()).append("\n\n").append(al2.MaxRequest()).append("\n\n")
			.append(al2.ErrorValue()).append("\n\n").append(al2.RangeMaxKey(1, 100));
		
			vr.getJtaLog().setText(String.valueOf(sbLogData2));
			vr.getJtaLog().setEditable(false);
		}//end if 
		
		
		
	}//getLogInfo1
	
	public void report() throws IOException{
		
		jtaLog = vr.getJtaLog();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		String b = sdf.format(System.currentTimeMillis());
		
		File dir = new File("c:/dev/report");
		if(!dir.exists()) dir.mkdirs();
		
		File file = new File(dir.getAbsolutePath()+"/report"+FILENUM+"_"+b+".dat");
		
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter( new FileWriter(file));
			bw.write(jtaLog.getText());
			bw.flush();
		}finally {
			if(bw != null) {bw.close();}
			}
	}//report

	
	
}//class


