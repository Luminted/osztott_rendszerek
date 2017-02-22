import java.util.*;

public class Shooting{
    public static void main(String[] args){
        if(args.length >= 2){
            int n = Integer.parseInt(args[1]);
            int m = Integer.parseInt(args[0]);

            Object[][] table = new Object[n][m];
            LinkedList<Point> hits = new LinkedList<>();

            for(int i = 0; i< n; i++){
                for(int j = 0; j<m; j++){
                    table[i][j] = new Point(i,j);
                }
            }

            for(int i = 2; i < args.length-1; i+=2){
                int x = Integer.parseInt(args[i]);
                int y = Integer.parseInt(args[i+1]);
                table[x][y] = new Hit(x, y);
            }

            for(int i = 0; i< n; i++){
                for(int j = 0; j<m; j++){
                    System.out.print(table[i][j].toString());
                }
                System.out.print("\n");
            }

        }else{
            System.out.print("Fuck off!");
        }
    }
}