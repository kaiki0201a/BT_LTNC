
public class Main {
    // Phải có public và String[] args thì Maven mới chịu chạy
    public static void main(String[] args) {
        // Thay IO.println bằng System.out.println
        System.out.println("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }
}