package us.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadUtil {

	public static ArrayList<Integer> loadInfoFromFile(String fName) throws IOException {

		File file = new File(fName); // file name
		ArrayList<Integer> l = new ArrayList<Integer>();
		try {
			@SuppressWarnings("resource")
			Scanner fileReader = new Scanner(file);
			while (fileReader.hasNext()) {
				String element = fileReader.next();
				l.add(Integer.valueOf(element));
			}
		} catch (IOException | NumberFormatException e) {
			System.out.println("the format in the file is wrong " + e.getMessage());
			throw new IOException();
		}
		return l;

	}

}
