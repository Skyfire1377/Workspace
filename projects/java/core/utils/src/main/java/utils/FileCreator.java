package utils;

import java.io.File;
import java.io.IOException;

public class FileCreator{
	public String path = "";
	public FileCreator(String p){
		path = p;
		create();
	}
	public void create(){
		try{

			File f = new File(path);
			if(f.createNewFile()){
				System.out.println("File created");
			}else{
				System.out.println("File already exists");
			}
		}catch(IOException e){
			System.out.println("Error occured: ");
			e.printStackTrace();
		}
	}
}
