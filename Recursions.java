import java.util.Scanner;
import java.util.StringTokenizer;

public class Recursions {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter two test strings for recursion1 in separate lines");
		System.out.println(recursion1(sc.nextLine(), sc.nextLine()));
		
		System.out.println("Please enter a test string for recursion2");
		System.out.println(recursion2(sc.nextLine()));

		System.out.println("Please enter a test integer for recursion3");
		System.out.println(recursion3(sc.nextInt()));

		System.out.println("Please enter a test integer for recursion4");
		System.out.println(recursion4(sc.nextInt()));
		
		sc.close();
	}
	
	public static String recursion1(String x, String y){
		if (x.length() == 0 || y.length() == 0){ //base case - this is where we return to finalize the result and end the recursion
			return "";
		}
		//Recursive step - calls the recursive method with input reduced towards the base case
		String result = "" + x.charAt(0) + y.charAt(0);
		String newX = x.substring(1);
		String newY = y.substring(1);
		return result + recursion1(newX, newY);			//We are calling the recursion with substrings, therefore we will eventually hit the base case (where the substring is the empty string)
	}
	
	public static String recursion2(String x){
		StringTokenizer st = new StringTokenizer(x);
		if (st.countTokens() == 0){ //base case - this is where we return to finalize the result and end the recursion
			return "";
		}
		//Recursive step - calls the recursive method with input reduced towards the base case
		String lastToken = "";
		while (st.hasMoreTokens()){
			lastToken = st.nextToken(); //gets to the last token
		}
		String nextIteration = x.substring(0, x.lastIndexOf(lastToken));
		return lastToken + " " + recursion2(nextIteration);	//We are calling the recursion with substrings, therefore we will eventually hit the base case (where the substring is the empty string)
	}
	
	public static String recursion3(int x){
		if (x == 0){
			return "" + 0;
		}
		
		return "" + x + " " + recursion3(x/2);
	}
	
	public static int recursion4(int x){
		if (x < 10)//base case
		{
			return x;
		}
		
		//process the current input
		int lastDigit = x%10; //x = 1024, x%10 = 4
		//make the recursive call, with REDUCED input
		return lastDigit + recursion4(x/10);
	}
}