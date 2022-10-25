/*
ID: billyih1
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;
public class milk2 {
    public static void main (String [] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int size = Integer.parseInt(st.nextToken());

        int realMaxTime = 0;
        int realMaxIdle = 0;
        int maxTime = 0;
        int count = 1;
        int n1, n2, n3, n4;

        if(size >= 1)
        {
            StringTokenizer st2 = new StringTokenizer(f.readLine());
            n1 = Integer.parseInt(st2.nextToken());
            n2 = Integer.parseInt(st2.nextToken());
            maxTime = n2-n1;
            realMaxTime = maxTime;
            count++;
        }
        else {
            n1 = 0;
            n2 = 0;
        }

        while(count <= size)
        {
            StringTokenizer st1 = new StringTokenizer(f.readLine());
            n3 = Integer.parseInt(st1.nextToken());
            n4 = Integer.parseInt(st1.nextToken());
            int dif = n3 - n2;
            if(dif <= 0)
            {
                maxTime += n4 - n2;
                if(maxTime > realMaxTime)
                {
                    realMaxTime = maxTime;
                }
                n2 = n4;
            }
            else
            {
                if(dif > realMaxIdle)
                {
                    realMaxIdle = dif;
                }
                maxTime = n4-n3;
                n1 = n3;
                n2 = n4;
                if(maxTime > realMaxTime)
                {
                    realMaxTime = maxTime;
                }
            }
            count++;
        }

        out.println(realMaxTime + " " + realMaxIdle);
        out.close();
    }
}