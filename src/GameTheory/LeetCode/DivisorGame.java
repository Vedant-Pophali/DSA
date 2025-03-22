package GameTheory.LeetCode;

public class DivisorGame {
    public boolean divisorGame(int n) {
        return (n%2==0)?true:false;
    }
    public static void main(String[] args) {
        DivisorGame game = new DivisorGame();
        int n=15;
        System.out.println(n+" "+game.divisorGame(n));
    }
}
