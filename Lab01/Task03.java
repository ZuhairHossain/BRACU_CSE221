package Lab01;
import java.io.*;
import java.util.*;

public class Task03{
    static int[][] matrix;
    static int n;
    static LinkedList[] ar;
    public static void main(String[] args) {
        try {
            File f = new File("F:\\CSE221\\src\\Lab01\\input.txt");
            Scanner sc = new Scanner(f);
            n=Integer.parseInt(sc.nextLine());
            matrix=new int[n][n];
            ar=new LinkedList[n];
            for(int i=0;i<ar.length;i++){
                ar[i]=new LinkedList<String>();
            }

            String[] split;
            while (sc.hasNext()) {
                String line=sc.nextLine();
                split=line.split(" ");
                int x=Integer.parseInt(split[0]);
                int y=Integer.parseInt(split[1]);

                edgeUndirectedMatrixConnector(x,y);
                edgeUndirectedListConnector(x,y);
            }

            System.out.println("Undirected Graph…..");
            System.out.println("\n\nAdjacency Matrix :-");
            printUpperSide();
            printUndirectedMatrix();

            System.out.println("\n\nAdjacency List: -");
            printUndirectedList();

            System.out.println("\n\nOut degree:-");
            printUndirectedOutDegrees();

        }

        catch(Exception e){
            e.printStackTrace();
        }
    }

    static void edgeUndirectedMatrixConnector(int i,int j){
        matrix[i][j] = 1;
        matrix[j][i] = 1;
    }

    static void edgeUndirectedListConnector(int i , int j){
        ar[i].add(j);
        ar[j].add(i);
    }

    static void printUndirectedMatrix(){
        int c=0;
        for (int i = 0; i <n; i++) {
            System.out.print((c++));
            for (int j = 0; j < n; j++) {
                System.out.print(" "+matrix[i][j]);
            }
            System.out.println();
        }
    }

    static void printUndirectedList(){
        for (int i=0;i<ar.length;i++){
            System.out.print(i+" -> ");
            for (int j=0;j<ar[i].size()-1;j++){
                System.out.print(ar[i].get(j)+" --> ");
            }
            System.out.println(ar[i].get(ar[i].size()-1));
        }
    }

    static void printUndirectedOutDegrees(){
        for (int i=0;i<ar.length;i++){
            System.out.println(i+" --> "+ar[i].size());
        }
    }

    static void printUpperSide(){
        int c=0;
        System.out.print(" ");
        for (int i = 0; i < n; i++) {
            System.out.print(" "+c++);
        }
        System.out.println();
    }

}