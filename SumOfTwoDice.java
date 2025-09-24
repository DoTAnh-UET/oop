public class SumOfTwoDice {
    public static void main(String[] args) {
        int surfaces = 6;
        int a = 1 + (int) (Math.random() * surfaces);
        int b = 1 + (int) (Math.random() * surfaces);
        System.out.println(a + b);
    }
}
