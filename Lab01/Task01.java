package Lab01;
import java.io.*;
import java.util.*;
public class Task01 {
    public static void main(String[] args) {
        try{
            File f1 = new File("F:\\CSE221\\src\\Lab01\\input.txt");
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            String st = br.readLine();
            while (st!=null)
            {
                System.out.println(st);
                st=br.readLine();
            }
        }
        catch(Exception a){

        }
    }
}
