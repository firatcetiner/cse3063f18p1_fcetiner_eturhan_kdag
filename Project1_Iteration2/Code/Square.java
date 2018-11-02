public abstract class Square {
    private int location;
    private String name;

    public Square(String name, int location) {
        this.location = location;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getLocation() {
        return location;
    }
    /* further implementation */
    public abstract SquareType getSquareType();

    public abstract void Action(Board board, Player player);
}