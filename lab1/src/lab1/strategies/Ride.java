package lab1.strategies;

public class Ride implements MoveStrategy {
    @Override
    public void move(int x, int y) {
        System.out.print("Ride on point " + x + ";" + y);
    }
}
