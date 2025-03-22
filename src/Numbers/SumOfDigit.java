package Numbers;

public class SumOfDigit {
    public int addDigits(int num) {
        while(num>=10){
            num=sumOfDigits(num);
        }
        return num;
    }
    public int sumOfDigits(int num){
        int sum=0;
        while(num!=0){
            sum+=(num%10);
            num/=10;
        }
        return sum;
    }
    public static void main(String[] args) {
        SumOfDigit obj = new SumOfDigit();
        int num = 38;
        int result = obj.addDigits(num);
        System.out.println("Sum of digits until single digit: " + result);
    }

}