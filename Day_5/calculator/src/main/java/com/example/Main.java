package com.example;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        setTitle("Đại Học Công Nghệ Đông Á - Thực Hành Java Swing (Lab 3)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Title Header
        JLabel lblTitle = new JLabel("BÀI THỰC HÀNH LAB 3 - GIAO DIỆN SWING", SwingConstants.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitle.setForeground(new Color(0, 51, 153));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
        add(lblTitle, BorderLayout.NORTH);

        // Grid panel with buttons for each exercise
        JPanel gridPanel = new JPanel(new GridLayout(4, 2, 12, 12));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        JButton btnBai1 = new JButton("Bài 1: Chào Người Dùng");
        JButton btnBai2 = new JButton("Bài 2: Tính Tổng 2 Số");
        JButton btnBai3 = new JButton("Bài 3: Giải PT ax + b = 0");
        JButton btnBai4 = new JButton("Bài 4: Phân Loại Tam Giác");
        JButton btnBai5 = new JButton("Bài 5: Dãy Fibonacci");
        JButton btnBai6 = new JButton("Bài 6: Form Đăng Nhập");
        JButton btnBai7 = new JButton("Bài 7: Máy Tính Mini");
        JButton btnBai8 = new JButton("Bài 8: Quản Lý Sinh Viên");

        // Styling buttons
        JButton[] buttons = {btnBai1, btnBai2, btnBai3, btnBai4, btnBai5, btnBai6, btnBai7, btnBai8};
        for (JButton btn : buttons) {
            btn.setFont(new Font("SansSerif", Font.BOLD, 13));
            btn.setFocusPainted(false);
        }

        gridPanel.add(btnBai1);
        gridPanel.add(btnBai2);
        gridPanel.add(btnBai3);
        gridPanel.add(btnBai4);
        gridPanel.add(btnBai5);
        gridPanel.add(btnBai6);
        gridPanel.add(btnBai7);
        gridPanel.add(btnBai8);

        add(gridPanel, BorderLayout.CENTER);

        // Footer info
        JLabel lblFooter = new JLabel("Bộ môn Công nghệ phần mềm - Khoa CNTT - EAUT", SwingConstants.CENTER);
        lblFooter.setFont(new Font("SansSerif", Font.ITALIC, 11));
        lblFooter.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5));
        add(lblFooter, BorderLayout.SOUTH);

        // Action Handlers
        btnBai1.addActionListener(e -> new Bai01HelloSwing().setVisible(true));
        btnBai2.addActionListener(e -> new Bai02TongHaiSo().setVisible(true));
        btnBai3.addActionListener(e -> new Bai03PhuongTrinhBacNhat().setVisible(true));
        btnBai4.addActionListener(e -> new Bai04TamGiacSwing().setVisible(true));
        btnBai5.addActionListener(e -> new Bai05FibonacciSwing().setVisible(true));
        btnBai6.addActionListener(e -> new Bai06FormDangNhap().setVisible(true));
        btnBai7.addActionListener(e -> new Bai07MayTinhMini().setVisible(true));
        btnBai8.addActionListener(e -> new Bai08QuanLySinhVien().setVisible(true));

        setSize(520, 360);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Set Look and Feel to System standard for modern appearance
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        SwingUtilities.invokeLater(() -> {
            Main mainLauncher = new Main();
            mainLauncher.setVisible(true);
        });
    }
}
