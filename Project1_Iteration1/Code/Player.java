public class Player {
    protected int totalLap = 0;
    private int position = 0;
    private int id;
    /* Each player has an unique id */
    public Player(int id) {
        this.id = id;
    }
    /* Perform toss and die action for a current player and print face numbers. */
    public int tossDie(Die die) {
        die.tossDie();
        int faceNumber1 = die.getFaceNumber();
        die.tossDie();
        int faceNumber2 = die.getFaceNumber();
        System.out.print("\nPlayer " + (this.id + 1) + " toss die. Face numbers are " + faceNumber1 + " and " + faceNumber2 + ".\n");
        return faceNumber1+faceNumber2;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition(){
        return this.position;
    }


    public int getId() {
        return this.id;
    }

    public int getTotalLap() {
        return this.totalLap;
    }

    public void nextLap() {
        this.totalLap++;
    }
}
