package GameTheory.LeetCode;
public class WinningPlayerInCoinGame {
    public static String winningPlayer(int x, int y) {
        return (Math.min(x, y / 4) % 2 == 0) ? "Bob" : "Alice";
    }
    public static void main(String[] args) {
        System.out.println(winningPlayer(4,15));
        System.out.println(winningPlayer(4,5));
        System.out.println(winningPlayer(8,4));
    }
}