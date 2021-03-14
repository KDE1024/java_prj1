package teamproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AnalysisLog1 {
		
	private File fileLog1;
	private List<String> listLog1;
	private Map<String, Integer> keyMap;
	private int java;
	private int javascript;
	private int d8;
	private int jg9k;
	private int front;
	private int jsp;
	private int hadoop;
	private int res;
	private int ora;
	private int mongodb;
	
	private Map<String, Integer> keyMapHours;
	private int nineHours;
	private int tenHours;
	private int elevenHours;
		
	private String namePath;
	
	public String maxKey() throws IOException {//1번 로그
		fileLog1 = new File(namePath);
		keyMap = new HashMap<String, Integer>();
		String log = "";
		int max = 0;
		String maxName = null;
	
		BufferedReader br = null;
		
		br = new BufferedReader(new FileReader(fileLog1));

		while((log=br.readLine()) != null) {//각 키가 얼마나 들어있는지
				
			if(log.contains("key=java") && (!log.contains("script"))) {
				java++;
			}//if
			if(log.contains("key=javascript")) {
				javascript++;
			}//if
			if(log.contains("key=d8")) {
				d8++;
			}//if
			if(log.contains("key=jg9k")) {
				jg9k++;
			}//if
			if(log.contains("key=front")) {
				front++;
			}//if
			if(log.contains("key=jsp")) {
				jsp++;
			}//if
			if(log.contains("key=hadoop")) {
				hadoop++;
			}//if
			if(log.contains("key=res")) {
				res++;
			}//if
			if(log.contains("key=ora")) {
				ora++;
			}//if
			if(log.contains("key=mongodb")) {
				mongodb++;
			}//if
		}//while
				
			keyMap.put("java", java);
			keyMap.put("javascript", javascript);
			keyMap.put("jg9k", jg9k);
			keyMap.put("d8", d8);
			keyMap.put("front", front);
			keyMap.put("jsp", jsp);
			keyMap.put("hadoop", hadoop);
			keyMap.put("res", res);
			keyMap.put("ora", ora);
			keyMap.put("mongodb", mongodb);
				
			if(br!=null) {br.close();}//end if
			
			int[] count = {keyMap.get("java"), keyMap.get("javascript"), keyMap.get("jg9k"), keyMap.get("d8"), keyMap.get("front"), keyMap.get("jsp"), keyMap.get("hadoop"),
					keyMap.get("res"), keyMap.get("ora"), keyMap.get("mongodb")};
			
			max = count[0];
			
			for(int i = 1; i < count.length; i++) {
				if(max < count[i]) {
					max = count[i];
				}//end if
			}//end for
			
			if(max == keyMap.get("java")) {
				maxName = "java";
			}//end if

			if(max == keyMap.get("javascript")) {
				maxName = "javascript";
			}//end if
			
			if(max == keyMap.get("jg9k")) {
				maxName = "jg9k";
			}//end if

			if(max == keyMap.get("d8")) {
				maxName = "d8";
			}//end if
			
			if(max == keyMap.get("front")) {
				maxName = "front";
			}//end if
			
			if(max == keyMap.get("jsp")) {
				maxName = "jsp";
			}//end if
			
			if(max == keyMap.get("hadoop")) {
				maxName = "hadoop";
			}//end if
			
			if(max == keyMap.get("res")) {
				maxName = "res";
			}//end if
			
			if(max == keyMap.get("ora")) {
				maxName = "ora";
			}//end if
			
			if(max == keyMap.get("mongodb")) {
				maxName = "mongodb";
			}//end if
			
			
			return "1번\n 요청횟수가 가장 많은 키 : " + maxName + " " + max + "회";	
		}//maxKey	
	
	public String GoValue() throws IOException{
		int ie = 0;
		int opera = 0;
		int firefox = 0;
		int chrome = 0;
		int safari = 0;
		
		String temp;
		int Total = 0;
		BufferedReader br = null;
		br = new BufferedReader(new FileReader(fileLog1));

		while((temp = br.readLine()) != null) {
			String[] sTmp = temp.split("\\]\\[");
			switch (sTmp[2]) {
			case "ie": ie++; break;
			case "opera": opera++; break;
			case "firefox": firefox++; break;
			case "Chrome": chrome++; break;
			case "Safari": safari++; break;
			}//end switch
			Total++;
		}//end while
		
		if(br != null) {br.close();}//end if
		
		return  "2번\n ie 들어간 횟수 : " + ie + "회\n" + "opera 들어간 횟수 : " + opera +" 회\n" + "firefox 들어간 횟수 : " + firefox + "회\n" +
        "chrome 들어간 횟수 : " + chrome + "회\n"+"Safari 들어간 횟수 : "+safari+"회\n\n"+"ie 들어간 비율 = " + ((float)ie /(float)Total)*100 +" %\n" 
        +  "opera 들어간 비율 = " + ((float)opera /(float)Total)*100 +" %\n"+"firefox 들어간 비율 = " + ((float)firefox /(float)Total)*100 +" %\n" 
        +"chrome 들어간 비율 = " + ((float)chrome /(float)Total)*100 +" %\n"+"Safari 들어간 비율 = " + ((float)safari /(float)Total)*100 +" %\n" ;

	}//GoValue 

	public String DoneValue() throws IOException{
		int success = 0;
		int fail = 0;
		String temp;
		BufferedReader br = null;
		
		br = new BufferedReader(new FileReader(fileLog1));
		while((temp = br.readLine()) != null) {
			if(temp.substring(1,4).equals("200")) {
				success++;
			} else if(temp.substring(1,4).equals("404")){
				fail++;
			}//end else	
		}//end while
		if(br != null) {br.close();}
	
		return "3번\n 성공적으로 수행한 횟수(200) : "+success+"회\n실패(404) : "+fail+"회";
		
	}//DoneValue
	
	public String MaxRequest() throws IOException {
		keyMapHours = new HashMap<String, Integer>();
		String log = "";
		int max = 0;
		String maxHours = "";
		
		BufferedReader br = null;
		
		br=new BufferedReader(new FileReader(fileLog1));
		while((log=br.readLine())!=null) {
			if(log.substring(log.indexOf("5")+1).contains(" 09")) {
				nineHours++;
			}//if
			if(log.substring(log.indexOf("5")+1).contains(" 10")) {
				tenHours++;
			}//if
			if(log.substring(log.indexOf("5")+1).contains(" 11")) {
				elevenHours++;
			}//if
		}//while
		
		keyMapHours.put("9시", nineHours);
		keyMapHours.put("10시", tenHours);
		keyMapHours.put("11시", elevenHours);
			
		if(br!=null) {br.close();}
		
		int[] count = {keyMapHours.get("9시"), keyMapHours.get("10시"), keyMapHours.get("11시")};
		
		max = count[0];
		
		for(int i = 1; i < count.length; i++) {
			if(max < count[i]) {
				max = count[i];
			}//end if
		}//end for
		
		if(max == keyMapHours.get("9시")) {
			maxHours = "9시";
		}//end if
	
		if(max == keyMapHours.get("10시")) {
			maxHours = "10시";
		}//end if
		
		if(max == keyMapHours.get("11시")) {
			maxHours = "11시";
		}//end if
		
		return "4번\n 요청시간이 제일 많은 시간 : "+"["+maxHours+"], "+" " + max + "회";

	}//MaxRequest
	
	public String ErrorValue() throws IOException{
		int success = 0;
		int fail = 0;
		int request =0;
		String temp;
		int sum = 0;
		
		BufferedReader br = null;
		
		br = new BufferedReader(new FileReader(fileLog1));

		while((temp = br.readLine())!=null) {
			if(temp.substring(1,4).equals("200")) {
				success++;
			}
		
			if(temp.substring(1,4).equals("404")){
				fail++;
			}
			
			if(temp.substring(1,4).equals("403")) {
				request++;
			}
			
			sum++;
	
		}//while

		if( br != null) {br.close();}//end if
			
		return "5번\n 성공적으로 수행한 횟수(200) : "+success+"회\n실패한 횟수(404) : "+fail+"회\n비정상적인 요청인 횟수(403) : " + request + "회\n"
				+ "\n성공적으로 수행한 비율(200) = "+(((float)success / (float)sum)*100)+"%"
				+"\n실패한 비율(404) = "+(((float)fail/(float)sum)*100)+"%"
				+"\n비정상적인 요청 비율(403) = "+(((float)request/sum)*100)+"%";
			
		}// ErrorValue
	
	public String RangeMaxKey(int startLine, int endLine) throws IOException, FileNotFoundException {

		java = 0;
		javascript = 0;
		d8 = 0;
		jg9k = 0;
		front = 0;
		jsp = 0;
		hadoop = 0;
		res = 0;
		ora = 0;
		mongodb = 0;
		
		listLog1 = new ArrayList<String>();  
		Map<String, Integer> keyMap = new HashMap<String, Integer>();
		
		String log1 = null;
		String maxName = null;
		int max = 0;
			
		BufferedReader br = null;
		
		if(fileLog1.exists()) {
			br = new BufferedReader(new FileReader(fileLog1));
			while((log1 = br.readLine()) != null) {

				listLog1.add(log1);
				
			}//end while
			
			for(int i = startLine - 1; i < endLine; i++) {
				if((listLog1.get(i).contains("key=java")) && (!listLog1.get(i).contains("script"))) {
					java++;
				}//end if
				
				if(listLog1.get(i).contains("key=javascript")) {
					javascript++;
				}//end if

				if(listLog1.get(i).contains("key=d8")) {
					d8++;
				}//end if
				
				if(listLog1.get(i).contains("key=jg9k")) {
					jg9k++;
				}//end if

				if(listLog1.get(i).contains("key=front")) {
					front++;
				}//end if
				
				if(listLog1.get(i).contains("key=jsp")) {
					jsp++;
				}//end if
				
				if(listLog1.get(i).contains("key=hadoop")) {
					hadoop++;
				}//end if
				
				if(listLog1.get(i).contains("key=res")) {
					res++;
				}//end if
				
				if(listLog1.get(i).contains("key=ora")) {
					ora++;
				}//end if

				if(listLog1.get(i).contains("key=mongodb")) {
					mongodb++;
				}//end if
				
			}//end for

			keyMap.put("java", java);
			keyMap.put("javascript", javascript);
			keyMap.put("jg9k", jg9k);
			keyMap.put("d8", d8);
			keyMap.put("front", front);
			keyMap.put("jsp", jsp);
			keyMap.put("hadoop", hadoop);
			keyMap.put("res", res);
			keyMap.put("ora", ora);
			keyMap.put("mongodb", mongodb);
			
			int[] count = {keyMap.get("java"), keyMap.get("javascript"), keyMap.get("jg9k"), keyMap.get("d8"), keyMap.get("front"), keyMap.get("jsp"), keyMap.get("hadoop"),
					keyMap.get("res"), keyMap.get("ora"), keyMap.get("mongodb")};
			
			max = count[0];
			
			for(int i = 1; i < count.length; i++) {
				if(max < count[i]) {
					max = count[i];
				}//end if
			}//end for
			
			if(max == keyMap.get("java")) {
				maxName = "java";
			}//end if

			if(max == keyMap.get("javascript")) {
				maxName = "javascript";
			}//end if
			
			if(max == keyMap.get("jg9k")) {
				maxName = "jg9k";
			}//end if

			if(max == keyMap.get("d8")) {
				maxName = "d8";
			}//end if
			
			if(max == keyMap.get("front")) {
				maxName = "front";
			}//end if
			
			if(max == keyMap.get("jsp")) {
				maxName = "jsp";
			}//end if
			
			if(max == keyMap.get("hadoop")) {
				maxName = "hadoop";
			}//end if
			
			if(max == keyMap.get("res")) {
				maxName = "res";
			}//end if
			
			if(max == keyMap.get("ora")) {
				maxName = "ora";
			}//end if
			
			if(max == keyMap.get("mongodb")) {
				maxName = "mongodb";
			}//end if
			
		}//end if
		
		if(br != null) {br.close();};
		
		return "6번\n"+startLine + " ~ " + endLine + " 번 라인 중 최다 사용 키의 이름 : " + maxName + " / " + max + "회" ;
	}//rangeMaxKey

	/**
	 * @param namePath the namePath to set
	 */
	public void setNamePath(String namePath) {
		this.namePath = namePath;
	}

	/**
	 * @return the namePath
	 */
	public String getNamePath() {
		return namePath;
	}
	

	
	
}//class
			
