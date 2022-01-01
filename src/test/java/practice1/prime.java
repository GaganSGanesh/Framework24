package practice1;

public class prime {
	public static void main(String[] args) {
		String s1="india";
		String rev="";
		for (int i=s1.length()-1;i<=0;i--)
		{
			rev=rev+s1.charAt(i);
			}
		System.out.println(rev);
		}
	}