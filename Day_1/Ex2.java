import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao so nguyen duong n: ");
        int n = scanner.nextInt();
        
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        
        System.out.println("Tong nghich dao la: " + sum);
        scanner.close();
    }
}