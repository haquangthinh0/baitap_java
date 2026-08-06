import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao so nguyen n de kiem tra:");
        int n = sc.nextInt();
        boolean isPrime = true;
        if (n < 2){
            isPrime = false;
        }
        else {
            for(int i = 2; i <= Math.sqrt(n); i++) {
                if(n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        if(isPrime) {
            System.out.println(n+"la so nguyen to");
        }
        else {
            System.out.println(n+"khong la so nguyen to");
        }
        sc.close();

    }
}
