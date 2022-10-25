/*
ID: billyih1
LANG: JAVA
TASK: palsquare
*/
import java.io.*;
import java.util.*;
public class palsquare {
    public static void main (String [] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int base = Integer.parseInt(st.nextToken());
        String str = " 123456789ABCDEFGHIJK"
        for(int a = 1;a<=300;a++)
        {
            if(isPalindrome(convertBase(a*a,base)))
                out.print(a+" "+a*a);
        }

        out.close();
    }
    public static int findMaxPower(int num, int base)
    {
        return (int)Math.floor(Math.log(num)/Math.log(base));
    }
    public static String convertBase(int num, int base)
    {
        String answer = "";
        while (num > 0)
        {
            int digit = num/(int)Math.pow(base, findMaxPower(num, base));
            if(digit==10)

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