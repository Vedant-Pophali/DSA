package GameTheory.LeetCode;
public class NimGame{
    public boolean canWinNim(int n) {
    return n % 4 != 0;
}
    public static void main(String[] args) {
        NimGame obj = new NimGame();
        int[] testCases = {1, 2, 3, 4, 5, 8, 10, 15};
        for (int n : testCases) {
            System.out.println("Can win with " + n + " stones: " + obj.canWinNim(n));
        }
    }
}