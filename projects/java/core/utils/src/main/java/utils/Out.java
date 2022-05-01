package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Out{
	
	public void log(Object object){
		String s = String.valueOf(object);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String sWithDate = dtf.format(now) + " " + s;
		String path = "../resources/log.md";
		IOFiles iof = new IOFiles(path);
		iof.append(sWithDate + "\n");	
	}
	public void println(Object s){
		System.out.println(String.valueOf(s));
	}
	public void toFile(String filePath, String stringData){
		IOFiles iof = new IOFiles(filePath);
		iof.write(stringData);
	}

}
