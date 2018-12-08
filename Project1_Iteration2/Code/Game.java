import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Game {
    private static int totalRound = 0;

    private Board board = new Board();

    public Game() {
        System.out.println("Welcome to Monopoly Game\n");

        play(initPlayers());
    }

    private void play(ArrayList<Player> players) {   //Game go on until 1 player stay in the game


        while (true){
            System.out.println("===Round "+(totalRound++)+"===\n");

            for (Iterator<Player> iterator = players.iterator(); iterator.hasNext();) { //take turns in the round
                Player player = iterator.next();
                nextTurn(player);

                if (player.isPlayerGoBankrupt()) { // if player is bankrupted, kick the player, long live capitalism! :)
                    System.out.println(player.getId()+" WENT BANKRUPT!");
                    iterator.remove();
                }
                // Game go on till 1 player stays
                // Last player in the game is WINNER
                if (players.size() == 1){
                    System.out.println(players.get(0).getId() + " is WINNER!");
                    break;
                }
            }
            if (players.size() == 1){
                break;
            }

        }

        System.out.println("Game is over!");
    }
    /* Init player array */
    private ArrayList<Player> initPlayers() {
        int numOfPlayers = 0;

        while (numOfPlayers < 2 || numOfPlayers > 8) {
            System.out.println("Enter number of Players between 2 and 8: "); // Enter number of players

            Scanner scanner = new Scanner(System.in);

            if(scanner.hasNextInt()){
                numOfPlayers = scanner.nextInt();
            }else {
                System.out.println("Please enter a valid number!");
            }
        }

        ArrayList<Player> players = new ArrayList<>();

        System.out.println("\nEnter initial money for Players: "); // Initial money value of players at the starting of the game
        Scanner scanner = new Scanner(System.in);
        int moneyInput = scanner.nextInt();


        for (int i = 0; i < numOfPlayers; i++) {
            players.add(new Player(new Piece(board.getSquare(0),i),i)); // create pieces for each player
            players.get(i).setMoney(moneyInput);
        }

        System.out.println("\nGame Starting...\n\n");

        return players;
    }
    /* Corresponding player takes turn */
    private void nextTurn(Player player) {

        System.out.println("Player " + player.getId() + " (" + player.getMoney() + "$) is taking turn:\n");
        System.out.println(player.getPiece().getName() + " is at " + player.getPosition().getLocation() + ": " +
                player.getPosition().getName() + "\n");


            int[] dice;

            do {
                dice = board.tossDice();
                    player.setPosition(board.normalizeSquarePosition(player.getPosition(), dice[0]));

                    System.out.println("\n" + player.getPiece().getName() + "'s new location is " +
                            player.getPosition().getLocation() + ": " + player.getPosition().getName());

                    player.getPosition().Action(board, player);

            } while (dice[1] == dice[2]);


        System.out.println("\n\n");
    }
}
