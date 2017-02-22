import java.lang.Math;

public class Point implements Comparable<Point>{
    public int x;
    public int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double distance(Point p){
        return Math.sqrt(Math.pow((p.x - this.x), 2) + Math.pow((p.y - this.y), 2));
    }

    @Override
    public int compareTo(Point other){
        Point origo = new Point(0,0);
        if(this.distance(origo) > other.distance(origo)){
            return 1;
        }else if(this.distance(origo) == other.distance(origo)){
            return 0;
        }else{
            return -1;
        }
    }

    public String toString(){
        return ".";
    }
}