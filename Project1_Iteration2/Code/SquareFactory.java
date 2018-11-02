/* Factory class to instantiate different types of Squares more efficiently */

public class SquareFactory {

    public static Square createSquare(SquareType squareType, int location) {
        Square square = null;

        switch (squareType) {
            case CommonSquare:
                square = createCommonSquare(squareType, location);
                break;
            case JailSquare:
                square = createJailSquare(); /* JailSquare is a singleton object */
                break;
            case GoJailSquare:
                square = createGoJailSquare(); /* GoJailSquare is a singleton object */
                break;
            case TaxSquare:
                square = createTaxSquare(squareType, location);
                break;
            case IncomeSquare:
                square = createIncomeSquare(squareType, location);
                break;
            default:
                break;
        }
        return square;
    }

    /* Create methods for different types of Squares
    *
    */
    private static Square createCommonSquare(SquareType squareType, int location) {
        return new CommonSquare(squareType.name(),location);
    }
    private static Square createJailSquare() {
        return JailSquare.getJailSquare(); // get single instance of JailSquare
    }
    private static Square createGoJailSquare() {
        return GoJailSquare.getGoJailSquare(); // get single instance of GoJailSquare
    }
    private static Square createTaxSquare(SquareType squareType, int location) {
        return new TaxSquare(squareType.name(), location);
    }
    private static Square createIncomeSquare(SquareType squareType, int location) {
        return new IncomeSquare(squareType.name(), location);
    }
}
