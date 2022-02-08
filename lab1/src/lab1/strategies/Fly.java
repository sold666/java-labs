package lab1.strategies;

public class Fly implements MoveStrategy {
    @Override
    public void move(int x, int y) {
        System.out.print("Fly on point " + x + ";" + y);
    }
}
