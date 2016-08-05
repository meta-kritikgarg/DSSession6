package uniqueCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author Kritik Garg
 *
 */
public class CharactersCounter {
	//to store Cache 
	HashMap<String, Integer> cache = new HashMap<String, Integer>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CharactersCounter charactersCounter = new CharactersCounter();

		// to interact with user
		while (true) {
			int userChoice = 0;
			String inData = charactersCounter.getStringfromUser("String");
			System.out.println("Unique charcters = "
					+ charactersCounter.countUniqueChar(inData));
			System.out.println("\nPress 1 for continue, 2 for exit");
			while (true) {
				userChoice = charactersCounter.getIntfromUser("Choice ");
				if (userChoice == 1 || userChoice == 2) {
					break;
				} else {
					System.out.println("try again, Enter 1 or 2");
				}
			}
			if (userChoice == 2) {
				break;
			}
		}
		scan.close();
	}

	/**
	 * Count no of unique char in string
	 * 
	 * @param string
	 * @return
	 */
	public int countUniqueChar(String string) {
		int result = checkInCache(string);
		// Not found in cache
		if (result == -1) {
			char[] charOfString = string.toCharArray();
			// To keep track unique characters
			Set<Character> uniqueChar = new HashSet<Character>();
			for (int i = 0; i < charOfString.length; i++) {
				uniqueChar.add(charOfString[i]);
			}
			// found in cache
			cache.put(string, uniqueChar.size());
			return uniqueChar.size();
		}
		return result;
	}

	/**
	 * To check string in cache
	 * 
	 * @param string
	 * @return
	 */
	private int checkInCache(String string) {
		if (cache.containsKey(string)) {
			System.out.println("found in cache");
			return cache.get(string);
		}
		return -1;
	}

	/**
	 * Method to read string data from standard input
	 * 
	 * @param Name
	 *            of variable to print
	 * @return String value input by user
	 */
	public String getStringfromUser(String Name) {
		Scanner s = new Scanner(System.in);
		String string = "";
		while (true) {
			try {
				System.out.println("Enter " + Name);
				string = s.nextLine();
				if (string.length() > 0) {
					break;
				} else {
					System.out.println("Invalid, Try Again");
				}
			} catch (Exception e) {
				System.out.println("Invalid, Try again");
				s.next();
			}
		}
		return string;
	}

	/**
	 * Method to read integer data from standard input
	 * 
	 * @param Name
	 *            of variable to print
	 * @return int value of integer
	 */
	public int getIntfromUser(String Name) {
		Scanner s = new Scanner(System.in);
		int number = 0;
		while (true) {
			try {
				System.out.println("Enter " + Name);
				number = s.nextInt();
				if (number > 0) {
					break;
				} else {
					System.out.println("Invalid, Try Again");
				}
			} catch (Exception e) {
				System.out.println("Invalid, Try again");
				s.next();
			}
		}
		return number;
	}

}
