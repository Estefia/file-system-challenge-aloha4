package file.system.exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import file.system.exercise.model.FileSystem;

public class Solution {

	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		FileSystem fileSystem = new FileSystem();
		String input = new String();
		while (true) {
			input = reader.readLine();
			fileSystem.execute(input);
		}
	}
}