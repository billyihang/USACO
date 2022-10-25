/*
ID: billyih1
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;
public class ride {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        StringTokenizer st2 = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        String s1 = st.nextToken();
        String s2 = st2.nextToken();
        int i1 = 1;
        int i2 = 1;

        for(int i = 0; i < s1.length(); i++){
            i1 *= s1.charAt(i) - 64;
        }

        for(int i = 0; i < s2.length(); i++){
            i2 *= s2.charAt(i) - 64;
        }

        if(i1 % 47 == i2 % 47){
            out.println("GO");
        }
        else {
            out.println("STAY");
        }

        out.close();

    }
}