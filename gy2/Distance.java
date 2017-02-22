import java.util.*;
import java.lang.Math;

public class Distance{
    
    public static void main(String args[]){
        if (args.length % 2 != 0 || args.length < 4){
            System.out.print("Too few args\n");
        }else{

        LinkedList<Point> points = new LinkedList<>();

        int x;
        int y;

        for(int i = 0; i< args.length - 1; i += 2){
            x = Integer.parseInt(args[i]);
            y = Integer.parseInt(args[i+1]);
            points.add(new Point(x,y));
        }

        System.out.print("" + points.get(0).distance(points.get(1)));
        System.out.print("\n");
        System.out.print("" + points.get(0).compareTo(points.get(1)));
        }
    }
}