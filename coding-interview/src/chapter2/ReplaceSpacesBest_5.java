package chapter2;

import java.util.Scanner;

public class ReplaceSpacesBest_5 {
	
	private String replace(String str)
	{
		int space_count=0;
		for(int i=0;i<str.length();i++)
			if(' '==str.charAt(i))
				space_count++;
		
		char[] ch=new char[str.length()+space_count*2];
		int k1=str.length()-1,k2=ch.length-1;
		while(k1>=0 && k2>=k1)
		{
			if(' '!=str.charAt(k1))
				ch[k2--]=str.charAt(k1);
			else
			{
				ch[k2--]='0';
				ch[k2--]='2';
				ch[k2--]='%';
			}
			k1--;
		}
		
		String str1=new String(ch);
		System.out.println(str1);
		return str1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReplaceSpacesBest_5 rl=new ReplaceSpacesBest_5();
		
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		
		String str1=rl.replace(str);
		System.out.println(str1);
	}

}
