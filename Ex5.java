import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao so nguyen duong n de in day Fibonacci: ");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("Vui long nhap so nguyen duong lon hon 0.");
        } else if (n == 1) {
            System.out.println("0");
        } else {
            int first = 0, second = 1;
            System.out.print("Day Fibonacci gom " + n + " so: ");
            System.out.print(first + " " + second + " ");
            
            for (int i = 3; i <= n; i++) {
                int next = first + second;
                System.out.print(next + " ");
                
                first = second;
                second = next;
            }
            System.out.println();
        }
        
        scanner.close();
    }
}
