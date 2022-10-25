/*
ID: your_id_here
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;
public class gift1 {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        int numPeople = Integer.parseInt(st.nextToken());
        People[] peeps = new People[numPeople];
        for (int i = 0; i < numPeople; i++)
        {
            StringTokenizer st1 = new StringTokenizer(f.readLine());
            String dude = st1.nextToken();
            peeps[i]= new People(dude);
        }

        for (int i = 0; i < numPeople; i++)
        {
            StringTokenizer st1 = new StringTokenizer(f.readLine());
            String dude = st1.nextToken();
            int ind = findPerson(peeps, dude);
            People person = peeps[ind];
            StringTokenizer st2 = new StringTokenizer(f.readLine());
            int initMoney = Integer.parseInt(st2.nextToken());
            int numFriends = Integer.parseInt(st2.nextToken());
            int moneyEach = 0;
            person.setMoney(initMoney);
            if(numFriends != 0)
            {
                moneyEach = initMoney / numFriends;
            }
            for(int j = 0; j < numFriends; j++)
            {
                StringTokenizer st3 = new StringTokenizer(f.readLine());
                String friendName = st3.nextToken();
                People friend = peeps[findPerson(peeps, friendName)];
                person.giveMoney(friend, moneyEach);
            }
        }
        for (int i = 0; i < numPeople; i++)
        {
            People person = peeps[i];
            out.print(person.getName() + " ");
            out.println(person.getMoney() - person.getInitMoney());
        }
        out.close();
    }
    public static int findPerson(People[] a,String findName)
    {
        for(int b=0;b<a.length;b++)
        {
            if(a[b].getName().equals(findName))
                return b;
        }
        return -1;
    }
}


class People {
    String name;
    int money;
    int initMoney;

    public People(String setName)
    {
       name = setName;
       money = 0;
       initMoney = 0;
    }

    public void setMoney(int moneySet)
    {
        initMoney = moneySet;
        money += initMoney;
    }
    public String getName()
    {
        return name;
    }
    public void giveMoney(People person, int removeMoney)
    {
        money -= removeMoney;
        person.addMoney(removeMoney);
    }
    public void addMoney(int addMoney)
    {
        money += addMoney;
    }

    public int getMoney()
    {
        return money;
    }

    public int getInitMoney()
    {
        return initMoney;
    }

}