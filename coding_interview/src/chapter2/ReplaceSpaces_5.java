package chapter2;

import java.util.Scanner;

public class ReplaceSpaces_5 {
	
	private String replace(String str)
	{
		String newStr="";
		int k=0;
		for(int i=0;i<str.length();i++)
		{
			if(' '==str.charAt(i))
			{
				newStr+=str.substring(k, i);
				newStr+="%20";
				k=i+1;
				System.out.println("k="+k);
				System.out.println(newStr);
			}
		}
		newStr+=str.substring(k,str.length());
		System.out.println(newStr);
		return newStr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReplaceSpaces_5 rs=new ReplaceSpaces_5();
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		
		str=rs.replace(str);
		System.out.println(str);
	}
}
