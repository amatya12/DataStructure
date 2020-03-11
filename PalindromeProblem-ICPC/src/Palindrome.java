import java.util.Scanner;
public class Palindrome {

	public boolean CheckPalindrome(String s) {
		int length = s.length();
		for(int i = 0; i < (s.length()/2); i++) {
			if(s.charAt(length-1)!=s.charAt(i)) {
				return false;
			}
			length--;
		}
		return true;
	}
	
	public String NumberRepresentatonInEveryBase(int number, int base) {
		int n = number;
		String baseRepresentation = "";
		while(n >= base-1) {
			baseRepresentation += (n%base);
			n=n/base;
		}
		return baseRepresentation;
	}
	
	
	public boolean CheckPalindromeInEveryBase(int numberToBeChecked, int maxBase) {
		boolean isPalindromeForEveryBase = true;
		for(int i = 2; i <= maxBase; i++) {
			String s = NumberRepresentatonInEveryBase(numberToBeChecked, i);
			boolean a =  CheckPalindrome(s);
			if(a==false) {
				isPalindromeForEveryBase = false;
				break;
			}
		}
		return isPalindromeForEveryBase;
	}
	
	public static void main(String[] args) {
		Scanner  input  = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		int count = 0;
		Palindrome p  = new Palindrome();
		for(int i = a; i<=b; i++) {
			boolean result = p.CheckPalindromeInEveryBase(i,c);
			if(result ==true) {
				count++;
			}
		}
		System.out.println(count);
		
	}
}
