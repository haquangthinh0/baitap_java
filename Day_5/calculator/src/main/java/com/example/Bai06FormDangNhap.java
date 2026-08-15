package com.example;

import javax.swing.*;
import java.awt.*;

public class Bai06FormDangNhap extends JFrame {
    private final JTextField txtUsername = new JTextField(15);
    private final JPasswordField txtPassword = new JPasswordField(15);
    private final JComboBox<String> cbRole = new JComboBox<>(new String[]{"Admin", "User"});
    private final JCheckBox chkShowPassword = new JCheckBox("Hiển thị mật khẩu");
    private final JButton btnLogin = new JButton("Đăng nhập");

    public Bai06FormDangNhap() {
        setTitle("Bài 6 - Form Đăng Nhập");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 8, 6, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Header Label
        JLabel lblHeader = new JLabel("ĐĂNG NHẬP HỆ THỐNG", SwingConstants.CENTER);
        lblHeader.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblHeader.setForeground(new Color(0, 102, 204));
        add(lblHeader, BorderLayout.NORTH);

        // Row 0: Username
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Tài khoản:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtUsername, gbc);

        // Row 1: Password
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Mật khẩu:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtPassword, gbc);

        // Row 2: Show password checkbox
        gbc.gridx = 1; gbc.gridy = 2;
        formPanel.add(chkShowPassword, gbc);

        // Row 3: Role JComboBox
        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Vai trò:"), gbc);
        gbc.gridx = 1;
        formPanel.add(cbRole, gbc);

        add(formPanel, BorderLayout.CENTER);

        // South Panel: Login Button
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnLogin);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listeners
        chkShowPassword.addActionListener(e -> {
            if (chkShowPassword.isSelected()) {
                txtPassword.setEchoChar((char) 0);
            } else {
                txtPassword.setEchoChar('•');
            }
        });

        btnLogin.addActionListener(e -> xuLyDangNhap());

        pack();
        setLocationRelativeTo(null);
    }

    private void xuLyDangNhap() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();
        String role = (String) cbRole.getSelectedItem();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ tài khoản và mật khẩu!", "Lỗi nhập liệu", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if ("admin".equals(username) && "123456".equals(password) && "Admin".equals(role)) {
            JOptionPane.showMessageDialog(this, "Xin chào Admin! Đăng nhập thành công với quyền Quản trị viên.", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        } else if ("user".equals(username) && "123456".equals(password) && "User".equals(role)) {
            JOptionPane.showMessageDialog(this, "Xin chào User! Đăng nhập thành công với quyền Người dùng.", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Tài khoản, mật khẩu hoặc vai trò không chính xác!", "Đăng nhập thất bại", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai06FormDangNhap().setVisible(true));
    }
}
