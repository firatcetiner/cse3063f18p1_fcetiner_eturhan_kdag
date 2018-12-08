public class Die {
    private int faceNumber;

    public Die(){
        toss();
    }
    /* Generate a random variable to perform toss and die action. */
    public void toss() {

        faceNumber = (int) ((Math.random()*6) + 1);
    }

    public int getFaceNumber() {
        return faceNumber;
    }
}
