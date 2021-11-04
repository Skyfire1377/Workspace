package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IOFiles{
	public String path = "";
	public IOFiles(String p){
		path = p;
	}
	public void write(String s){
		try{
			FileWriter fw = new FileWriter(path);
			fw.write(s);
			fw.close();
		}catch(IOException e){
			System.out.println("Error occured");
			e.printStackTrace();
		}
	}

	public String read(){
		String s = "";	
		try{
			File f = new File(path);
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()){
				s += sc.nextLine() + "\n";
			}
			sc.close();
		}catch(IOException e){
			System.out.println("Error occured");
			e.printStackTrace();
		}
		return s;

	}
	public void create(){
		FileCreator fc = new FileCreator(path);
	}
}
