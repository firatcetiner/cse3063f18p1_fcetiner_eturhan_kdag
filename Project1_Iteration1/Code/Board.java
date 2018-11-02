public class Board {
    private int totalPlayer = 0;
    private int currentPlayer = 0;
    Player[] players;
    /* Board has 40 squares */
    Square[] squares = new Square[40];

    public Board(int totalPlayer){
        this.totalPlayer = totalPlayer;
        players = new Player[this.totalPlayer];


        for(int i = 0;i < players.length;i++){
            players[i] = new Player(i);
        }
    }
    /* Get current player by accessing all players */
    public Player getCurrentPlayer() {
        return players[currentPlayer];
    }
    /* Move to the next player */
    public void nextPlayer() {
        if(++currentPlayer >= players.length){
            currentPlayer = 0;
        }
    }

    public int normalizePosition(int position) {
        return position % squares.length;
    }

}
