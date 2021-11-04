package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Out{
	public void log(String s){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String sWithDate = dtf.format(now) + " " + s;
		String path = "../resources/log.md";
		IOFiles iof = new IOFiles(path);
		iof.write(sWithDate);	
	}
	public void println(String s){
		System.out.println(s);
	}

}
