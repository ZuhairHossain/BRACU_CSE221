package Assignment_02;

import java.util.*;

public class Dijkstra {
    int n; //number of nodes
    int adjMat[][]; //graph
    int d[]; //distance array
    int [] parent;
    String b[];
    PriorityQueue<Node> pq;

    class Node implements Comparator<Node> {
        int node;
        int distance;

        public Node(int n, int d) {
            node = n;
            distance = d;
        }

        public Node() {

        }

        public int compare(Node n1, Node n2) {
            if (n1.distance < n2.distance) return -1;
            else if (n1.distance > n2.distance) return 1;
            return 0;
        }
    }

    public Dijkstra(int e, int a[][], String c[]) {
        n = e;
        adjMat = a;
        d = new int[n];
        parent=new int[n];
        b = c;
        for (int i = 0; i < n; i++) {
            d[i] = 999999;
            parent[i]=0;
        }
        pq = new PriorityQueue<Node>(n, new Node());
    }

    public void dijkstra(int s) {
        d[s] = 0;
        pq.add(new Node(s, d[s]));
        while (pq.isEmpty() != true) {
            int u = pq.remove().node;
            if(b[u]=="Yellow"){
            }
            else {
                for (int v = 0; v < n; v++) {
                    if (adjMat[u][v] > 0 && d[v] > adjMat[u][v] + d[u]) {
                        d[v] = adjMat[u][v] + d[u]; //path relaxation
                        parent[v]=u;
                        pq.add(new Node(v, d[v]));
                    }
                }
            }
        }
    }
}
