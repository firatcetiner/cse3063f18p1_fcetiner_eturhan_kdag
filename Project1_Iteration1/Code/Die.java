import java.util.Random;

public class Die {
    private int faceNumber;

    public Die(){

    }
    /* Generate a random variable to perform toss and die action. */
    public void tossDie(){
        Random rand = new Random();
        this.faceNumber = 1+rand.nextInt(6);
    }

    public int getFaceNumber() {
        return this.faceNumber;
    }
}
