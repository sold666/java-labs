package lab1.strategies;

public class Walk implements MoveStrategy {
    @Override
    public void move(int x, int y) {
       System.out.print("Walk on point " + x + ";" + y);
    }
}
