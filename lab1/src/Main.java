import lab1.strategies.Fly;
import lab1.strategies.MoveStrategy;
import lab1.strategies.Ride;
import lab1.strategies.Walk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hero hero = new Hero();
        System.out.println("Please, enter a name of your hero :");
        String name = scanner.nextLine();
        hero.setName(name);
        System.out.print("""
                Please, select the type of movement :
                1 - Walk
                2 - Ride
                3 - Fly
                """);
        MoveStrategy strategy;
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> strategy = new Walk();
                case 2 -> strategy = new Ride();
                case 3 -> strategy = new Fly();
                default -> throw new NumberFormatException("You must enter the numbers from 1 to 3");
            }
        } else {
            throw new NumberFormatException("Invalid input! Enter only numbers!");
        }
        hero.setStrategy(strategy);
        System.out.print("Enter coordinates :\n");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        hero.move(x, y);
    }
}
