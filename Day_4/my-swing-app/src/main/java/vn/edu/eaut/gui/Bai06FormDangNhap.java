package vn.edu.eaut.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Bai06FormDangNhap extends JFrame{
    private final JTextField txtUsername = new JTextField();
    private final JPasswordField txtPassword = new JPasswordField();
    private final JComboBox<String> cbRole = new JComboBox<>(new String[]{"Admin", "User"});
    private final JCheckBox chkShowPassword = new JCheckBox("Hiển thị mật khẩu");
    private final JButton btnLogin = new JButton("Đăng nhập");

    public Bai06FormDangNhap() {
        setTitle("Màn hình Đăng nhập:");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5,2,10,10));

        add(new JLabel("Tài khoản: "));
        add(txtUsername);

        add(new JLabel("Mật khẩu:"));
        add(txtPassword);

        add(new JLabel("Vai trò:"));
        add(cbRole);
        
        add(chkShowPassword);
        add(new JLabel("")); // Ô trống căn chỉnh layout


        add(new JLabel(""));
        add(btnLogin);
                char defaultEchoChar = txtPassword.getEchoChar();
        chkShowPassword.addActionListener(e -> {
            if (chkShowPassword.isSelected()) {
                txtPassword.setEchoChar((char) 0); // Hiện mật khẩu
            } else {
                txtPassword.setEchoChar(defaultEchoChar); // Ẩn mật khẩu
            }
        });
        // Xử lý sự kiện Đăng nhập
        btnLogin.addActionListener(e -> xuLyDangNhap());
        setSize(500, 300);
        setLocationRelativeTo(null);
    }
     private void xuLyDangNhap() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());
        String role = (String) cbRole.getSelectedItem();
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ Tài khoản và Mật khẩu!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Kiểm tra tài khoản kiểm thử
        boolean isAdminValid = username.equalsIgnoreCase("admin") && password.equals("123456") && "Admin".equals(role);
        boolean isUserValid = username.equalsIgnoreCase("user") && password.equals("123456") && "User".equals(role);
        if (isAdminValid || isUserValid) {
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công!\nChào mừng " + role + ": " + username, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Tài khoản, mật khẩu hoặc vai trò không chính xác!", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai06FormDangNhap().setVisible(true));
    }

}
