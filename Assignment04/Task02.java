package Assignment04;

import java.io.*;

class Task02{
    static int W;
    static int item;
    static float[][] matrix;
    static int[] wi;
    static float[] bi;
    static KP02_node[] n;

    public static void main(String[] args) {
        try {
            File file = new File("F:\\CSE221\\src\\Assignment04\\input_02.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            //BufferedReader br = new BufferedInputStream();

            W=Integer.parseInt(br.readLine());
            item=Integer.parseInt(br.readLine());
            br.readLine();
            n=new KP02_node[item];
            String[] split;
            int i=0;
            while (i<item) {
                String line3=br.readLine();
                split=line3.split(", ");
                String w=split[0];
                String x=split[1];
                String y=split[2];
                String z=split[3];
                n[i]=new KP02_node(w,x,y,z);
                i++;
            }

            wi=new int[item];
            bi=new float[item];

            for (int j = 0; j < item; j++) {
                wi[j]=Integer.parseInt(n[j].wi);
                bi[j]=Float.parseFloat(n[j].bi);
            }

            Knapsack(wi,bi);
            printKP();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void Knapsack(int[] wi,float[] bi) {
        matrix = new float[item + 1][W + 1];

        for (int i = 1; i <= wi.length; i++) {
            for (int w = 1; w <= W; w++) {
                if (i == 0 || w == 0) {
                    matrix[i][w] = 0;
                } else if (w >= wi[i - 1]) {
                    matrix[i][w] = Math.max(matrix[i - 1][w], matrix[i - 1][ w -wi[i - 1]] + bi[i - 1]);
                } else {
                    matrix[i][w] = matrix[i - 1][w];
                }
            }
        }
    }

    static void printKP(){
        float res = matrix[item][W];
        float total=res;
        System.out.println("Name of clubs whose trophies were sold:");
        int w = W, m = 0;
        String[] players = new String[item];

        for (int i = item; i > 0 && res > 1; i--) {
            if (res == matrix[i - 1][w]) {
                //ignore
            }
            else {
                players[m] = n[i - 1].club;
                m++;
                res = res -bi[i - 1];
                w = w - wi[i - 1];
            }
        }

        for (int i = item - 1; i > 0; i--) {
            if (players[i] != null) {
                System.out.print(players[i] + "-> ");
            }
        }
        System.out.println(players[0]);
        System.out.println("Maximum money he earned: "+total+" million");
    }
}

class KP02_node {
    String tn;
    String wi;
    String bi;
    String club;

    KP02_node(String club1, String wi1, String bi1, String tn1) {
        tn = tn1;
        wi = wi1;
        bi = bi1;
        club = club1;
    }

}
