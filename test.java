import java.util.Scanner;

public class test {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		
		while (true) {
			
			System.out.println("enter the string:");
		String entry = sc.nextLine();
		if (entry == "break") {
			break;
			
		}
		
		int c = entry.length();
		String can = "aeiou";
		
		int count = 0;
		
		for (int i = 0; i<c;i++) {
			char res = entry.charAt(i);
			int f = can.indexOf(res);
			if (f != -1) {
				count++;
				
			}
		
		}
		System.out.println("There are "+count+"vowels in the word"+entry+"  :)");
		
		}
		sc.close();
		

	}

}
