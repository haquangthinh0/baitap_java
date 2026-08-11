package vn.edu.eaut.gui;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Bai02TinhTong1 extends JFrame {
    private final JTextField a = new JTextField();
    private final JTextField b = new JTextField();
    private final JLabel result = new JLabel("Result: ");


    public Bai02TinhTong1() {
      setTitle("Bài 2 - Tính tổng hai số"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 8, 8)); 
 
        add(new JLabel("Số thứ nhất:")); 
        add(a); 
        add(new JLabel("Số thứ hai:")); 
        add(b); 
 
        JButton btnSum = new JButton("Tính tổng"); 
        JButton btnClear = new JButton("Làm mới"); 
        add(btnSum); 
        add(btnClear); 
        add(new JLabel("")); 
        add(result); 
 
        btnSum.addActionListener(e -> tinhTong()); 
        btnClear.addActionListener(e -> lamMoi()); 
 
        setSize(380, 190); 
        setLocationRelativeTo(null); 
    }

        public void tinhTong() {
            try {
                int numberA = Integer.parseInt(a.getText().trim());
                int numberB = Integer.parseInt(a.getText().trim());
                result.setText("Kết quả :"+ (numberA + numberB));
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Dữ liệu nhập vào không hợp lệ!!");
            }
        }

        public void lamMoi() {
            a.setText("");
            b.setText("");
            result.setText("Ket qua: ");
            a.requestFocus();
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new Bai02TinhTong1().setVisible(true)); 
        }
}
