import lab1.strategies.MoveStrategy;

public class Hero {
    private String name;
    private MoveStrategy strategy;

    public Hero() {

    }

    public Hero(String name) {
        this.name = name;
    }

    public void move(int x, int y) {
        strategy.move(x, y);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MoveStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(MoveStrategy strategy) {
        this.strategy = strategy;
    }
}
