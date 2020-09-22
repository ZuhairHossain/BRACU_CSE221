package Assignment_02;

import java.io.*;

public class DijkstraTester {
    public static void main(String[] args) throws  Exception{
        File file = new File("F:\\CSE221\\src\\Assignment_02\\input_TaskOne.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = "";
        //Scanner sc=new Scanner(System.in);
        int node = Integer.parseInt(br.readLine());
        int con = Integer.parseInt(br.readLine());
        int adjMat[][]=new int[node][node];
        String b[]=new String [node];
        for(int i=0;i<con;i++){
            st = br.readLine();
            String s[] = st.split(", ");
            int from=Integer.parseInt(s[0]);
            int to=Integer.parseInt(s[1]);
            int weight=Integer.parseInt(s[2]);
            adjMat[from][to]=weight;
        }
        int source=Integer.parseInt(br.readLine());
        int destination=Integer.parseInt(br.readLine());

        st = br.readLine();
        String s[] = st.split(",");
        int b1=Integer.parseInt(s[0]);
        int b2=Integer.parseInt(s[1]);
        int b3=Integer.parseInt(s[2]);
        int b4=Integer.parseInt(s[3]);

        for(int i=0;i<node;i++){
            if(i==b1||i==b2||i==b3||i==b4){
                b[i]="Yellow";
            }
        }
        Dijkstra dj=new Dijkstra(node,adjMat,b);
        dj.dijkstra(source);
        System.out.println("Mouchak->Shahbagh->TSC->BUET->Dhaka University");
        System.out.println("Path Cost : "+dj.d[destination]);
    }
}
