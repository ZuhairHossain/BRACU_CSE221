package Assignment03;

import java.io.*;
import java.util.*;

class Lab03Task02 {
    static int[][] matrix;
    static String[] lcs;
    static String[] input_main;
    static String[] input_comp;
    static LCS_node[] n;

    public static void main(String[] args) {
        try {
            File f = new File("F:\\CSE221\\src\\Assignment03\\input02.txt");
            Scanner sc = new Scanner(f);

            String line1 = sc.nextLine();
            String[] main = line1.split(" ");
            String line2 = sc.nextLine();
            String[] comp = line2.split(" ");

            n=new LCS_node[10];
            String[] split;
            int i=0;
            while (i<10) {
                String line3=sc.nextLine();
                split=line3.split(":");
                String x=split[0];
                String y=split[1];
                n[i]=new LCS_node(x,y);
                i++;
            }

            input_main=new String[main.length];
            input_comp=new String[comp.length];

            for (int j = 0; j < main.length; j++) {
                for (int k = 0; k < n.length; k++) {
                    if(main[j].equals(n[k].s)){
                        input_main[j]=n[k].c;
                    }
                }
            }

            for (int j = 0; j < comp.length; j++) {
                for (int k = 0; k < n.length; k++) {
                    if(comp[j].equals(n[k].s)){
                        input_comp[j]=n[k].c;
                    }
                }
            }

            LCS(input_main, input_comp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void LCS(String[] s1, String[] s2) {
        matrix = new int[s1.length + 1][s2.length + 1];

        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1].equals(s2[j - 1])) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }

        int index = matrix[s1.length][s2.length];
        int length = index;

        lcs = new String[index];

        int i = s1.length;
        int j = s2.length;
        while (i > 0 && j > 0) {
            if (s1[i - 1].equals(s2[j - 1])) {
                lcs[index - 1] = s1[i - 1];
                i--;
                j--;
                index--;
            } else if (matrix[i - 1][j] > matrix[i][j - 1])
                i--;
            else
                j--;
        }

        System.out.println(lcs.length);
        for (int k = 0; k < length; k++) {
            for(int m=0;m<n.length;m++) {
                if(lcs[k].equals(n[m].c)) {
                    System.out.print(n[m].s+" ");
                }
            }
        }
        System.out.println();

    }

}
