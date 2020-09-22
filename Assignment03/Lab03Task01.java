package Assignment03;

import java.io.*;
import java.util.*;

class Lab03Task01 {
    static int[][] matrix;
    static String[] lcs;
    public static void main(String[] args) {
        try {
            File f = new File("F:\\CSE221\\src\\Assignment03\\input01.txt");
            Scanner sc = new Scanner(f);

            String line1=sc.nextLine();
            String[] given=line1.split(" ");
            String line2=sc.nextLine();
            String[] played=line2.split(" ");
            LCS(given,played);

            double r=Accuracy(lcs.length,given.length);
            System.out.println();
            if(r>=50.0){
                System.out.printf("%.2f%s",r,"% Passed");
            }
            else{
                System.out.printf("%.2f%s",r,"% Failed");
            }
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }

    static void LCS(String[] s1,String[] s2) {
        matrix=new int[s1.length+1][s2.length+1];

        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i-1].equals(s2[j-1])) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }

        int index = matrix[s1.length][s2.length];
        int temp = index;

        lcs = new String[index];

        int i = s1.length;
        int j = s2.length;
        while (i > 0 && j > 0)
        {
            if (s1[i-1].equals(s2[j-1]))
            {
                lcs[index-1] = s1[i-1];
                i--;
                j--;
                index--;
            }
            else if (matrix[i-1][j] > matrix[i][j-1])
                i--;
            else
                j--;
        }

        for(int k=0;k<temp;k++){
            System.out.print(lcs[k]);
        }
    }

    static int Max ( int x, int y){
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }

    static double Accuracy(int lcs, int gL){
        return (((double)lcs/gL)*100);
    }
}
