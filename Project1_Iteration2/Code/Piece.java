public class Piece {

    private Square location;
    private String name;

    public Piece(Square location,int nameNumber) {
        this.location=location;

        String[] pieceNames = {"Hat", "Car", "Shoe", "Dog", "Lantern", "BattleShip", "Cannon", "Horse"};
        this.name = pieceNames[nameNumber];
    }

    public Square getLocation() {
        return location;
    }

    public void setLocation(Square location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }
}