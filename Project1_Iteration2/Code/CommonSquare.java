/* CommonSquare simply does nothing to Player when its on this part of the Board */
public class CommonSquare extends Square {

    public CommonSquare(String name, int location) {
        super(name, location);
    }
    @Override
    public SquareType getSquareType() {
        return SquareType.CommonSquare;
    }
    @Override
    public void Action(Board board, Player player) {
        /* does nothing */
    }
}
