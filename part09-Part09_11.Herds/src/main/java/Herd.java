import java.util.ArrayList;

public class Herd  implements Movable{

//    private int x;
//    private int y;
//
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }

    private ArrayList<Movable> herd;

    public Herd() {
        herd = new ArrayList<>();
    }

    public void addToHerd (Movable movable) {
        this.herd.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable h : herd) {
            h.move(dx, dy);
        }
    }

    @Override
    public String toString() {

        String output = "";
        for (Movable h : herd) {
            output += h.toString() + "\n";
        }

        return output;
    }
}
