package Assignment03;

import java.io.*;

class L03T02 {
    static int[][] matrix;
    static String[] lcs;
    static String[] input_main;
    static String[] input_comp;
    static LCS_node[] n;

    public static void main(String[] args) {
        try {
            File file = new File("F:\\CSE221\\src\\Assignment03\\input02.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String[] main = br.readLine().split(" ");
            String[] comp = br.readLine().split(" ");

            n=new LCS_node[10];
            String[] split;

            for (int i = 0; i < 10; i++) {
                split=br.readLine().split(":");
                String x=split[0];
                String y=split[1];
                n[i]=new LCS_node(x,y);
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

    static void LCS(String[] string1, String[] string2) {
        matrix = new int[string1.length + 1][string2.length + 1];

        for (int i = 1; i <= string1.length; i++) {
            for (int j = 1; j <= string2.length; j++) {
                if (string1[i - 1].equals(string2[j - 1])) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }

        int index = matrix[string1.length][string2.length];
        int temp = index; //length

        lcs = new String[index];

        int u = string1.length;
        int v = string2.length;
        while (u > 0 && v > 0) {
            if (string1[u - 1].equals(string2[v - 1])) {
                lcs[index - 1] = string1[u - 1];
                u--;
                v--;
                index--;
            }
            else if (matrix[u - 1][v] > matrix[u][v - 1]){
                u--;
            }

            else {
                v--;
            }
        }

        System.out.println(lcs.length);
        for (int i = 0; i < temp; i++) {
            for(int j = 0;j < n.length; j++) {
                if(lcs[i].equals(n[j].c)) {
                    System.out.print(n[j].s+" ");
                }
            }
        }
        System.out.println();
    }
    private static class LCS_node {
        String c;
        String s;
        LCS_node(String c1,String s1){
            c=c1;
            s=s1;
        }
    }
}
