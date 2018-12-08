
public class Board {
    private Die dice[] = new Die[2];
    /* Board has 40 squares */
    Square[] squares = new Square[40];

    public Board(){
        createBoard();
        makeDice();
    }
    public Square normalizeSquarePosition(Square first, int k) {
        int end = (first.getLocation()+k)%40;
        return squares[end];
    }
    /* Creating board */
    private void createBoard() {
        for(int i = 0; i < 40; i++) {
            switch (i) {
                case 0:
                    squares[i] = SquareFactory.createSquare(SquareType.CommonSquare, i);
                    break;
                case 5:
                    squares[i] = SquareFactory.createSquare(SquareType.IncomeSquare, i);
                    break;
                case 10:
                    squares[i] = SquareFactory.createSquare(SquareType.JailSquare, i);
                    break;
                case 15:
                    squares[i] = SquareFactory.createSquare(SquareType.TaxSquare, i);
                    break;
                case 20:
                    squares[i] = SquareFactory.createSquare(SquareType.CommonSquare, i);
                    break;
                case 25:
                    squares[i] = SquareFactory.createSquare(SquareType.TaxSquare, i);
                    break;
                case 30:
                    squares[i] = SquareFactory.createSquare(SquareType.GoJailSquare, i);
                    break;
                case 40:
                    squares[i] = SquareFactory.createSquare(SquareType.TaxSquare, i);
                    break;
                default:
                    squares[i] = SquareFactory.createSquare(SquareType.TaxSquare, i);
                    break;
            }
        }
    }
    /* create two dice object */
    private  void makeDice() {

        for (int i = 0; i < 2; i++) {
            dice[i] = new Die();
        }
    }
    /* toss dice and get face numbers into an array */
    public int[] tossDice() {

        System.out.println("Rolling dice...");

        int tossTotal = 0;

        for(int j = 0; j < dice.length; j++){

            dice[j].toss();
            tossTotal += dice[j].getFaceNumber();
            int diceNumber = j + 1;
            System.out.println("Dice " + diceNumber + ": " + dice[j].getFaceNumber());
        }

        System.out.println("Total: " + tossTotal); // total toss

        int returnValues[] = new int[3];
        returnValues[0] = tossTotal;
        returnValues[1] = dice[0].getFaceNumber();
        returnValues[2] = dice[1].getFaceNumber();

        return returnValues;
    }

    public Square getSquare(int location) {
        return squares[location];
    }
}
