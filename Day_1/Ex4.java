import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Kiem tra va phan loai tam giac");
        System.out.print("Nhap vao canh a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhap vao canh b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhap vao canh c: ");
        double c = scanner.nextDouble();
        
        if (a + b > c && a + c > b && b + c > a) {
            System.out.print("Ba canh da nhap tao thanh mot tam giac ");
            
            if (a == b && b == c) {
                System.out.println("deu.");
            } else if (a == b || b == c || a == c) {
                if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
                    System.out.println("vuong can.");
                } else {
                    System.out.println("can.");
                }
            } else if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
                System.out.println("vuong.");
            } else {
                System.out.println("thuong.");
            }
        } else {
            System.out.println("3 so da nhap khong the tao thanh mot tam giac.");
        }
        
        scanner.close();
    }
}
