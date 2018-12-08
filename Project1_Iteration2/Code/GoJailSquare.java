/* JailSquare.java
 * Singleton object represents a single Square of type Jail.
 * Creating only one instance of this class allows us to maintain the main idea of the game.
 */

public class GoJailSquare extends Square {
    private static final GoJailSquare goJailSquare = new GoJailSquare("Go Jail", 30);

    private GoJailSquare(String name, int location) {
        super(name,location);
    }
    @Override
    public SquareType getSquareType() {
        return SquareType.IncomeSquare;
    }

    public static GoJailSquare getGoJailSquare() {
        return goJailSquare;
    }
    @Override
    public void Action(Board board, Player player) {
        player.setPosition(board.getSquare(10));
    }
}
