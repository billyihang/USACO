/*
ID: billyih1
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
import java.util.*;
public class dualpal {
    public static void main (String [] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken()) + 1;
        int count = 0;
        while(count<n)
        {
            int baseCount=0;
            for(int a = 2;a<=10;a++)
            {
                if(isPalindrome(convertBase(s,a)))
                    baseCount++;
            }
            if(baseCount>2){
                out.println(s);
                count++;
            }
            s++;

        }
        out.close();


    }
    public static int findMaxPower(int num, int base)
    {
        return (int)Math.floor(Math.log(num)/Math.log(base));
    }
    public static int convertBase(int num, int base)
    {
       int answer = 0;
       while (num > 0)
       {
           int digit = num/(int)Math.pow(base, findMaxPower(num, base));
           answer = answer + digit * (int)(Math.pow(10, findMaxPower(num, base)));
           num = num - digit * (int)Math.pow(base, findMaxPower(num, base));
       }
       return answer;
    }
    public static boolean isPalindrome(int baseNum)
    {
        String str = baseNum + "";
        for (int i = 0; i < str.length()/2; i++)
        {
            if ((str.charAt(i) == str.charAt(str.length() - 1 - i)) == false)
            {
                return false;
            }
        }
        return true;
    }
}