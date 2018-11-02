public class Player {
    private int id;

    private int money;
    private Piece piece;

    /* Each player has an unique id */
    public Player(Piece piece, int id) {
        this.id = id;
        this.piece = piece;
    }

    public Square getPosition(){
        return piece.getLocation();
    }

    public int  getId() {
        return this.id;
    }


    public int   getMoney() {
        return money;
    }
    public Piece getPiece() {
        return piece;
    }
    /* Set player's position to a square */
    public void  setPosition(Square square) {
        piece.setLocation(square);
    }
    /* arrange money */
    public void  setMoney(int change) {
        money += change;
    }
    public boolean isPlayerGoBankrupt() {
        return money <= 0;
    }
}
