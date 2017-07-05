package edu.mum.cs.projects.attendance.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import edu.mum.cs.projects.attendance.domain.entity.CourseOffering;

public class FileUtil {
	public static final String ROOT_DIRECTORY = "src/main/resources/";
	
	private static Map<String, OutputStream> outputStreamMap = new HashMap<>();
	
	public static String createReportDirectory(CourseOffering courseOffering) {
		String directory = getReportDirectoryPath(courseOffering);
		
		File file = new File(directory);
		file.mkdirs();
		
		return directory;
	}

	public static String getReportDirectoryPath(CourseOffering courseOffering) {
		int year = courseOffering.getBlock().getBeginDate().getYear();
		String directory = ROOT_DIRECTORY + "reports/" + year + "/" + courseOffering.getBlock().getId().replaceAll(String.valueOf(year), "").substring(1) + "/";

		return directory;
	}
	
	public static String getTemplatesDirectoryPath() {
		return ROOT_DIRECTORY + "templates/";
	}
	
	public static OutputStream createOutputStream(String fileName) {
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(fileName);
			outputStreamMap.put(fileName, outputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return outputStream;
	}
	
	public static void closeFile(String fileName) {
		OutputStream outputStream = outputStreamMap.get(fileName);
		if(null == outputStream) {
			return;
		}
		
		try {
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void writeToFile(String fileName, String data) {
		OutputStream outputStream = outputStreamMap.get(fileName);
		if(null == outputStream) {
			outputStream = createOutputStream(fileName);
		}
		
		PrintWriter out = new PrintWriter(outputStream);
		out.println(data);
		out.flush();
	}

	public static String readFile(String fileName) {
		System.out.println("Reading file: " + fileName);
		Scanner scanner;
		String result = "";
		try {
			scanner = new Scanner(new File(getTemplatesDirectoryPath() + fileName));
			scanner.useDelimiter("\\Z"); 
			result = scanner.next();
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return result;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(readFile("email_body_part1.txt"));
	}
}
