package net.jaroski.game.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Files {
	
	protected String path;
	protected String name;
	protected File file;
	protected Scanner scan;
	protected String line;
	
	
	public Files(String name) {
		this.name = name;
		this.file = new File(name);
		
		checkFile(name);
		init();
	}
	
	public void init() {
		try {
			scan = new Scanner(file);
			System.out.println("Created Scanner for file: " + name);
		} catch (FileNotFoundException e) {
			System.out.println("Occured error while creating Scanner for file: " + name);
			e.printStackTrace();
		}
	}
	
	public void readFile() {
		
	}
	
	
	public void checkFile(String s) {
		System.out.println("Checking file: " + s);
		if(!doExist(s)) {
			createFile(s);
		}
		System.out.println("File has been checked: " + s);
	}
	
	public boolean doExist(String s) {
		File f = new File(s);
		if(f.exists()) {
			System.out.println("File exists!");
			return true;
		}
		System.out.println("Can not find file: " + f.toString());
		return false;
	}
	
	public void createFile(String s) {
		File f = new File(s);
		try {
			f.createNewFile();
			System.out.println("Created new file: " + f.toString());
		} catch (Exception e) {
			System.out.println("Failed to create new file: " + f + "!!!");
		}
	}
	
	public void checkFile(File f) {
		System.out.println("Checking file: " + f);
		if(!doExist(f)) {
			createFile(f);
		}
		System.out.println("File has been checked: " + f);
	}
	
	public boolean doExist(File f) {
		if(f.exists()) {
			System.out.println("File exists!");
			return true;
		}
		System.out.println("Can not find file: " + f.toString());
		return false;
	}
	
	public void createFile(File f) {
		try {
			f.createNewFile();
			System.out.println("Created new file: " + f.toString());
		} catch (Exception e) {
			System.out.println("Failed to create new file: " + f + "!!!");
		}
	}
}
