package regExPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExMain {

	public static void main(String[] args) {
		
		int count = 0;
		
		String filePath = "src/text.txt";
		List<List<String>> fileData = RegExReader.getData(filePath);
		
		// 1
		
		String pattern1 = "[a-z]{26,}";
		
		for (List<String> list : fileData) {
			finder(list.toString(), pattern1, count);
			count++;
		}
		
		System.out.println("----------------------------------------------------------------------------");
		count = 0;
		
		// 2
		
		String pattern2 = "Ola";
		
		for (List<String> list : fileData) {
			finder(list.toString(), pattern2, count);
			count++;
		}
		
		System.out.println("----------------------------------------------------------------------------");
		count = 0;
		
		// 3
		
		String pattern3 = "a{3,5}";
		
		for (List<String> list : fileData) {
			count += finder1(list.toString(), pattern3).size();
		}
		
		System.out.println(String.format("Strings of 3-5 a appear %d times.", count));
		System.out.println("----------------------------------------------------------------------------");
		count = 0;
		
		// 4
		
		String pattern4 = "[^A-Za-z0-9]{2,}";
		
		for (List<String> list : fileData) {
			count += finder1(list.toString(), pattern4).size();
		}
		
		System.out.println(String.format("Strings of non-alphanumberic characters appear %d times.", count));
		System.out.println("----------------------------------------------------------------------------");
		count = 0;
		
		// 5
		
		String pattern5 = "([\\w]%?-?\\.?){2,}@([\\w]\\.?-?)+\\.[A-Za-z]{2,3}";
		
		for (List<String> list : fileData) {
			finder(list.toString(), pattern5, count);
			count++;
		}
		
		System.out.println("----------------------------------------------------------------------------");
		count = 0;
		
		// 6
		
		String pattern6 = "\\d{3}-?/?\\s?\\d{3}-?\\s?\\d{2,3}";
		
		for (List<String> list : fileData) {
			finder(list.toString(), pattern6, count);
			count++;
		}
		
		System.out.println("----------------------------------------------------------------------------");
		count = 0;
		
		// 7
		
		String pattern7 = "([A-Za-z])\\1{3}";
		
		for (List<String> list : fileData) {
			count += finder1(list.toString(), pattern7).size();
		}
		
		System.out.println(String.format("Strings of 4 identical letters appear %d times.", count));
		System.out.println("----------------------------------------------------------------------------");
		count = 0;
		
		// 8
		
		String pattern8 = "([a-z]{3})(/|_)([0-9]{3})";
		
		for (List<String> list : fileData) {
			finder(list.toString(), pattern8, count);
			count++;
		}
		
		System.out.println("----------------------------------------------------------------------------");
		count = 0;
		
		// 9
		
		String pattern9 = "\\(([A-Za-z0-9\\s]+)?\\)";
		
		for (List<String> list : fileData) {
			finder(list.toString(), pattern9, count);
			count++;
		}
		
		System.out.println("----------------------------------------------------------------------------");
		count = 0;
		
		// 10
		
		String pattern10 = "(if|for)\\(.+\\)\\{.+\\}";
		
		for (List<String> list : fileData) {
			finder(list.toString(), pattern10, count);
			count++;
		}
		
	}
	
	public static void finder(String myString, String pattern, int count) {
		
		Pattern p = Pattern.compile(pattern);
		Matcher matcher = p.matcher(myString);
		
		while (matcher.find()) {
			if (matcher.group().length() != 0) {
				System.out.println(String.format("Match: %s. Starts at: %d. Ends at: %d. On line: %d.", matcher.group(), matcher.start(), matcher.end(), count));
			}
		}
		
	}
	
	public static List<String> finder1(String myString, String pattern) {
		
		List<String> matches = new ArrayList<String>();
		
		Pattern p = Pattern.compile(pattern);
		Matcher matcher = p.matcher(myString);
		
		while (matcher.find()) {
			if (matcher.group().length() != 0) {
				matches.add(matcher.group());
			}
		}
		
		return matches;
		
	}
}
