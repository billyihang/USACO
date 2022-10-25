/*
ID: billyih1
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;
public class beads {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        StringTokenizer st1 = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int numBeads = Integer.parseInt(st.nextToken());    // first integer
        String listBeads = st1.nextToken();    // second integer
        int finalCount=0;
        if(listBeads.indexOf("r") == -1 || listBeads.indexOf("b") == -1){
            finalCount = numBeads;
        }
        else {
            for (int a = 0; a < listBeads.length(); a++) {
                int count = 1;
                int temp = a;
                int move = a;
                String realListBeads = listBeads + listBeads;
                boolean go = true;
                boolean switchColor = false;
                while (go) {
                    if(realListBeads.charAt(temp) == 'w'){
                        while (realListBeads.charAt(move) == 'w'){
                            move++;
                            count++;
                        }
                        temp = move;
                    }
                    if (realListBeads.charAt(move) == realListBeads.charAt(temp) || realListBeads.charAt(move) == 'w') {
                        count++;
                        move++;
                    } else if (switchColor == false) {
                        switchColor = true;
                        temp = move;
                        move++;

                    } else
                        go = false;


                }
                if (count >= numBeads) {
                    go = false;
                    finalCount = numBeads;
                } else if (count > finalCount)
                {
                    finalCount = count;
                }

            }
        }
        out.println(finalCount);
        out.close();
    }
}
