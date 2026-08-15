package com.example;

import javax.swing.*;
import java.awt.*;

public class Bai07MayTinhMini extends JFrame {
    private final JTextField txtSo1 = new JTextField();
    private final JTextField txtSo2 = new JTextField();
    private final JTextField txtKetQua = new JTextField();
    private final JTextArea txtHistory = new JTextArea(8, 25);

    public Bai07MayTinhMini() {
        setTitle("Bài 7 - Máy tính mini");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 8, 8));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Nhập số liệu"));
        inputPanel.add(new JLabel("Số thứ 1:"));
        inputPanel.add(txtSo1);
        inputPanel.add(new JLabel("Số thứ 2:"));
        inputPanel.add(txtSo2);
        inputPanel.add(new JLabel("Kết quả:"));

        txtKetQua.setEditable(false);
        txtKetQua.setFont(new Font("SansSerif", Font.BOLD, 13));
        txtKetQua.setBackground(new Color(240, 240, 240));
        inputPanel.add(txtKetQua);

        // Control / Buttons Panel
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 5));
        JButton btnCong = new JButton("+");
        JButton btnTru = new JButton("-");
        JButton btnNhan = new JButton("*");
        JButton btnChia = new JButton("/");
        JButton btnClear = new JButton("Clear");

        btnPanel.add(btnCong);
        btnPanel.add(btnTru);
        btnPanel.add(btnNhan);
        btnPanel.add(btnChia);
        btnPanel.add(btnClear);

        // Center Panel combining Input & Buttons
        JPanel centerPanel = new JPanel(new BorderLayout(5, 5));
        centerPanel.add(inputPanel, BorderLayout.CENTER);
        centerPanel.add(btnPanel, BorderLayout.SOUTH);

        // History Panel
        txtHistory.setEditable(false);
        txtHistory.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollHistory = new JScrollPane(txtHistory);
        scrollHistory.setBorder(BorderFactory.createTitledBorder("Lịch sử phép tính"));

        add(centerPanel, BorderLayout.NORTH);
        add(scrollHistory, BorderLayout.CENTER);

        // Action Listeners
        btnCong.addActionListener(e -> tinhToan("+"));
        btnTru.addActionListener(e -> tinhToan("-"));
        btnNhan.addActionListener(e -> tinhToan("*"));
        btnChia.addActionListener(e -> tinhToan("/"));
        btnClear.addActionListener(e -> xoaForm());

        setSize(420, 420);
        setLocationRelativeTo(null);
    }

    private void tinhToan(String phepToan) {
        try {
            if (txtSo1.getText().trim().isEmpty() || txtSo2.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ hai số!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            double a = Double.parseDouble(txtSo1.getText().trim());
            double b = Double.parseDouble(txtSo2.getText().trim());
            double kq = 0;

            switch (phepToan) {
                case "+":
                    kq = a + b;
                    break;
                case "-":
                    kq = a - b;
                    break;
                case "*":
                    kq = a * b;
                    break;
                case "/":
                    if (Math.abs(b) < 1e-9) {
                        JOptionPane.showMessageDialog(this, "Không thể chia cho 0!", "Lỗi chia cho 0", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    kq = a / b;
                    break;
            }

            String strKq = String.format("%.4f", kq).replaceAll("0+$", "").replaceAll("\\.$", "");
            txtKetQua.setText(strKq);
            txtHistory.append(String.format("%s %s %s = %s\n", a, phepToan, b, strKq));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Dữ liệu nhập vào phải là số hợp lệ!", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void xoaForm() {
        txtSo1.setText("");
        txtSo2.setText("");
        txtKetQua.setText("");
        txtHistory.setText("");
        txtSo1.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai07MayTinhMini().setVisible(true));
    }
}
