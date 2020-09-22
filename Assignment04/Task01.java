package Assignment04;

import java.io.*;

class Task01 {
    static int total_budget, shortlist_player;
    static int[][] matrix;
    static String[] pricing;
    static String[] form;
    static KnapSack_Node[] node;

    public static void main(String[] args) {
        try {
            File file = new File("F:\\CSE221\\src\\Assignment04\\input01.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            //BufferedReader br = new BufferedInputStream();

            total_budget = Integer.parseInt(br.readLine());
            shortlist_player = Integer.parseInt(br.readLine());

            node = new KnapSack_Node[shortlist_player];
            String[] str;

            String player, price, form, position;
            br.readLine(); //line_space
            for (int i = 0; i < shortlist_player; i++) {
                str = br.readLine().split(", ");
                player = str[0];
                price = str[1];
                form = str[2];
                position = str[3];
                node[i]=new KnapSack_Node(player,price,form,position);
            }

            pricing = new String[shortlist_player];
            Task01.form = new String[shortlist_player];

            for (int j = 0; j < shortlist_player; j++) {
                pricing[j]= node[j].price;
                Task01.form[j]= node[j].form;
            }

            Knapsack(pricing, Task01.form);
            print();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void Knapsack(String[] pricing,String[] forms) {
        matrix = new int[shortlist_player + 1][total_budget + 1];

        for (int i = 1; i <= pricing.length; i++) {
            for (int j = 1; j <= total_budget; j++) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                }
                else if (j >= Integer.parseInt(pricing[i - 1])) {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - Integer.parseInt(pricing[i - 1])] + Integer.parseInt(forms[i - 1]));
                }
                else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }
    }

    static void print(){
        int res = matrix[shortlist_player][total_budget];
        int total = res;
        int w = total_budget, m = 0;
        String[] players = new String[shortlist_player];

        System.out.println("Bought Players:");

        for (int i = shortlist_player; i > 0 && res > 0; i--) {
            if (res == matrix[i - 1][w]) {
                //ignore
            }
            else {
                players[m] = node[i - 1].player;
                m++;
                res -= Integer.parseInt(form[i - 1]);
                w -= Integer.parseInt(pricing[i - 1]);
            }
        }

        for (int i = shortlist_player - 1; i >= 1; i--) {
            if (players[i] != null) {
                System.out.print(players[i] + "-> ");
            }
        }
        System.out.println(players[0]);
        System.out.println(total);
    }
}

class KnapSack_Node {
    String player;
    String price;
    String form;
    String position;

    KnapSack_Node(String player_temp, String price_temp, String form_temp, String position_temp) {
        player = player_temp;
        price = price_temp;
        form = form_temp;
        position = position_temp;
    }
}
