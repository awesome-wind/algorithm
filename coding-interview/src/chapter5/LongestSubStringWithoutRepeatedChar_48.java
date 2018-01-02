package chapter5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LongestSubStringWithoutRepeatedChar_48 {
    public static void main(String[] args) {
        LongestSubStringWithoutRepeatedChar_48 lsw = new LongestSubStringWithoutRepeatedChar_48();
        Scanner sc =new Scanner(System.in);

        String str = sc.nextLine();
        lsw.findNeededSubString(str);
    }

    private void findNeededSubString(String str) {
        if(str == null || str.length() == 0)
        {
            System.out.println("输入的字符串为空");
            return ;
        }

        for(int i=0;i<str.length();i++)
            if(str.charAt(i)<'a' || str.charAt(i)>'z')
                return ;

        Queue<Character> queue = new LinkedList<>();
        int i = 0;
        int length = 0;
        while(i<str.length()) {
            if(queue.contains(str.charAt(i)))
            {
                boolean flag = true;
                if(queue.size()>length)
                    length = queue.size();
                while(flag) {
                    char ch = queue.poll();
                    if(ch == str.charAt(i))
                        flag = false;
                }
            }
            queue.offer(str.charAt(i));

            for(char ch:queue)
                System.out.print(ch+" ");
            System.out.println();

            i++;
        }

        System.out.println(length);
    }
}
