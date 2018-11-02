public class TaxSquare extends Square {

    public TaxSquare(String name, int location) {
        super(name, location);
    }
    @Override
    public SquareType getSquareType() {
        return SquareType.TaxSquare;
    }
    @Override
    public void Action(Board board, Player player) {
        player.setMoney(-10);
    }
}