package Assignment03;

import java.io.*;
//Longest Common Subsequence
class L03T01 {
    static int[][] matrix;
    static String[] lcs;
    public static void main(String[] args) {
        try {
            File file = new File("F:\\CSE221\\src\\Assignment03\\input01.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String[] given_note = br.readLine().split(" ");
            String[] played_note = br.readLine().split(" ");
            LCS(given_note, played_note);

            double accuracy = ((double)lcs.length/given_note.length)*100;
            System.out.println();
            if(accuracy >= (double) 50){
                if(accuracy % 1!=0) {
                    System.out.printf("%.2f%s",accuracy,"% Passed");
                }
                else{
                    System.out.println((int)accuracy + "% Passed");
                }
            }
            else{
                if(accuracy % 1!=0) {
                    System.out.printf("%.2f%s", accuracy, "% Failed");
                }
                else{
                    System.out.println((int)accuracy + "% Failed");
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    static void LCS(String[] string1,String[] string2){
        matrix=new int[string1.length+1][string2.length+1];

        for (int i = 1; i <= string1.length; i++) {
            for (int j = 1; j <= string2.length; j++) {
                if (string1[i-1].equals(string2[j-1])) {
                    matrix[i][j] = ++matrix[i - 1][j - 1];
                } 
                else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }

        int index = matrix[string1.length][string2.length];
        int temp = index;

        lcs = new String[index];

        int u = string1.length;
        int v = string2.length;
        while (u > 0 && v > 0)
        {
            if (string1[u-1].equals(string2[v-1]))
            {
                lcs[index-1] = string1[u-1];
                u--;
                v--;
                index--;
            }
            else if (matrix[u-1][v] > matrix[u][v-1]){
                u--;
            }
            else{
                v--;
            }
        }

        for(int k=0;k < temp;k++){
            System.out.print(lcs[k]);
        }
    }
}

