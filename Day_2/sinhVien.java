import java.util.Scanner;

public class sinhVien {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap thong tin sinh vien: ");
        int msv = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhap ten hoc sinh:");
        String hoTen = sc.nextLine();
        System.out.print("Nhap diem chuyen can: ");
        double diemChuyenCan = sc.nextDouble();
        System.out.print("Nhap diem giua ky: ");
        double diemGiuaKy = sc.nextDouble();
        System.out.print("Nhap diem cuoi ky: ");
        double diemCuoiKy = sc.nextDouble();

        double tong = 0;



        if (diemChuyenCan < 0 || diemChuyenCan > 10 || 
            diemGiuaKy < 0 || diemGiuaKy > 10 || 
            diemCuoiKy < 0 || diemCuoiKy > 10) {
            System.out.println("Diem khong hop le, vui long nhap lai diem (0 - 10)!!");
        } else {
            tong = diemChuyenCan * 0.1 + diemGiuaKy * 0.3 + diemCuoiKy * 0.6;
            
            String hocLuc;
            if (tong >= 8.5) {
                hocLuc = "A (Xuat sac / Gioi)";
            } else if (tong >= 7.0) {
                hocLuc = "B (Kha)";
            } else if (tong >= 5.5) {
                hocLuc = "C (Trung binh)";
            } else if (tong >= 4.0) {
                hocLuc = "D (Yeu)";
            } else {
                hocLuc = "F (Kem / Truot)";
            }
            System.out.printf("Ma sinh vien   : %d\n", msv);
            System.out.printf("Ho ten         : %s\n", hoTen);
            System.out.printf("Diem chuyen can: %.2f\n", diemChuyenCan);
            System.out.printf("Diem giua ky   : %.2f\n", diemGiuaKy);
            System.out.printf("Diem cuoi ky   : %.2f\n", diemCuoiKy);
            System.out.printf("Diem tong ket  : %.2f\n", tong);
            System.out.printf("Hoc luc        : %s\n", hocLuc);
        }
        sc.close();
    }
}
