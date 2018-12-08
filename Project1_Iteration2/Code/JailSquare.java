/* JailSquare.java
 * Singleton object represents a single Square of type Jail.
 * Creating only one instance of this class allows us to maintain the main idea of the game.
 */

public class JailSquare extends Square { /* Jail is a Square as well. */
    /* Instantiate JailSquare Object with given name and position */
    private static final JailSquare jailSquare = new JailSquare("JailSquare", 10);

    private JailSquare(String name, int location) {
        super(name, location);
    }

    @Override
    public SquareType getSquareType() {
        return SquareType.JailSquare;
    }
    /* static method to access this JailSquare(singleton) object from outside of this class */
    public static JailSquare getJailSquare() {
        return jailSquare;
    }
    public void Action(Board board, Player player) {
        /* todo: stay in jail for a while (may be forever :D)*/
    }
}
