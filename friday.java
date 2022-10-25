/*
ID: billyih1
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;
public class friday {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] days = new int[7];
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int count = 1;

        for(int year = 1900; year < n + 1900; year++)
        {
            if(year % 400 == 0)
            {
                for (int i = 0; i < 12; i++)
                {
                    int monthDays = months[i];
                    if (monthDays == 28)
                    {
                        monthDays = 29;
                    }
                    count = (count + 13) % 7;
                    days[count]++;
                    count = (count + (monthDays - 13)) % 7;
                }
            }
            else if(year % 4 == 0 && (year % 100 != 0))
            {
                for (int i = 0; i < 12; i++)
                {
                    int monthDays = months[i];
                    if (monthDays == 28)
                    {
                        monthDays = 29;
                    }
                    count = (count + 13) % 7;
                    days[count]++;
                    count = (count + (monthDays - 13)) % 7;
                }
            }

            else
            {
                for (int i = 0; i < 12; i++)
                {
                    int monthDays = months[i];
                    count = (count + 13) % 7;
                    days[count]++;
                    count = (count + (monthDays - 13)) % 7;
                }
            }

        }

        for(int num = 0; num < 6; num++)
        {
            out.print(days[num] + " ");
        }
        out.println(days[6]);
        out.close();

    }
}