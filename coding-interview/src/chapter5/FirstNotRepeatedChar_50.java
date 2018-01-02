package chapter5;

import java.util.*;

public class FirstNotRepeatedChar_50 {
    public static void main(String[] args) {
        FirstNotRepeatedChar_50 fnrc = new FirstNotRepeatedChar_50();
        Scanner sc = new Scanner(System.in);
        Set<Character> set = new LinkedHashSet<>();

        String str = sc.nextLine();
        for(int i=0;i<str.length();i++) {
            if(!set.contains(str.charAt(i)))
                set.add(str.charAt(i));
            else
                set.remove(str.charAt(i));
        }

        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
