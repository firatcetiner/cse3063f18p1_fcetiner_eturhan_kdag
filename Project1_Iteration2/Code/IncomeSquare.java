/* Player earns some amount of money from somewhere */

public class IncomeSquare extends Square {

    public IncomeSquare(String name, int location) {
        super(name, location);
    }
    @Override
    public SquareType getSquareType() {
        return SquareType.IncomeSquare;
    }
    @Override
    public void Action(Board board, Player player) {
        player.setMoney(300);
        System.out.println("Player earned $300\n");
    }
}
