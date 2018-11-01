package com.cse3063f18p1.monopolygame;

import java.util.Scanner;

public class Main {
    Board board; // Initializing the board
    private static int totalPlayer = 0;
    Die die = new Die();
    /* Constructing the board with given number of player */
    public Main(int totalPlayer) {
        board = new Board(totalPlayer);
    }

    public static void main(String[] args) {
        int inputvalue = 0;
        boolean catcher = false;

        System.out.print("-- Monopoly Game --\n");
        Scanner scanner = new Scanner(System.in);

        do {
            try {
                System.out.print("Enter the number of players to play (2 - 8) ( 0 for EXİT): ");
                inputvalue = scanner.nextInt();
                catcher = true;
            }catch(Exception e) {
                System.out.println("Error: Please enter number between 2-8.");
                continue;
            }finally {
                scanner.nextLine();
            }
            if (catcher){
                totalPlayer = inputvalue;
            }
            if(totalPlayer == 0){
                System.out.println("Exiting Game...");
                System.exit(0);
            }else if(totalPlayer > 8 || totalPlayer < 2) {
                System.out.println("Error: Invalid player number.\n");
                catcher = false;
            }
        }while (!catcher);
        Main game = new Main(totalPlayer);
        game.startGame(); // Start the game
    }

    public void startGame() {
        int previousPosition,currentPosition;
        System.out.println("--Game start--");
        int i=0;
        /* Get current and previous positions for current player,
        *  perform the toss action. Evaluate face number for current player and count laps.
        *  Then move to the next player to action. Once a player complete 10 laps, game over. */
        while(true) {
            previousPosition = board.getCurrentPlayer().getPosition();
            board.getCurrentPlayer().setPosition(board.normalizePosition(board.getCurrentPlayer().getPosition() + board.getCurrentPlayer().tossDie(die)));
            currentPosition = board.getCurrentPlayer().getPosition();
            System.out.println("Player " + (board.getCurrentPlayer().getId() + 1) + " position is " + board.getCurrentPlayer().getPosition() + ".");
            if (previousPosition > currentPosition){
                board.getCurrentPlayer().nextLap();
            }
            System.out.println("Player " + (board.getCurrentPlayer().getId() + 1) + " completed " + board.getCurrentPlayer().getTotalLap() + " laps.");
            if (board.getCurrentPlayer().totalLap >= 10){
                break;
            }
            board.nextPlayer();
            i++;
        }
        System.out.println("\nGame over! Player " + (board.getCurrentPlayer().getId() + 1) + " Win!");
    }
}
