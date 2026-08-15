package com.example;

import javax.swing.*;
import java.awt.*;

public class Bai08QuanLySinhVien extends JFrame {
    private final JTextField txtMaSV = new JTextField();
    private final JTextField txtHoTen = new JTextField();
    private final JTextField txtDiemTB = new JTextField();

    private final StudentTableModel tableModel = new StudentTableModel();
    private final JTable tblStudents = new JTable(tableModel);

    private final JButton btnAdd = new JButton("Thêm");
    private final JButton btnEdit = new JButton("Sửa");
    private final JButton btnDelete = new JButton("Xóa");
    private final JButton btnClear = new JButton("Làm mới");

    public Bai08QuanLySinhVien() {
        setTitle("Bài 8 - Quản Lý Sinh Viên");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Header Title
        JLabel lblTitle = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN", SwingConstants.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitle.setForeground(new Color(0, 102, 204));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        add(lblTitle, BorderLayout.NORTH);

        // Input Form Panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 8, 8));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Thông tin sinh viên"));
        inputPanel.add(new JLabel("Mã Sinh Viên:"));
        inputPanel.add(txtMaSV);
        inputPanel.add(new JLabel("Họ và Tên:"));
        inputPanel.add(txtHoTen);
        inputPanel.add(new JLabel("Điểm Trung Bình (0 - 10):"));
        inputPanel.add(txtDiemTB);

        // Buttons Panel
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        btnPanel.add(btnAdd);
        btnPanel.add(btnEdit);
        btnPanel.add(btnDelete);
        btnPanel.add(btnClear);

        // Combine Input & Buttons
        JPanel topContainer = new JPanel(new BorderLayout());
        topContainer.add(inputPanel, BorderLayout.CENTER);
        topContainer.add(btnPanel, BorderLayout.SOUTH);

        // Table Panel inside ScrollPane
        tblStudents.setRowHeight(24);
        tblStudents.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        JScrollPane scrollTable = new JScrollPane(tblStudents);
        scrollTable.setBorder(BorderFactory.createTitledBorder("Danh sách sinh viên"));

        add(topContainer, BorderLayout.NORTH);
        add(scrollTable, BorderLayout.CENTER);

        // Populate sample data for quick testing
        tableModel.addStudent(new Student("SV01", "Nguyễn Văn An", 8.8));
        tableModel.addStudent(new Student("SV02", "Trần Thị Bình", 7.2));
        tableModel.addStudent(new Student("SV03", "Lê Hoàng Cường", 4.5));

        // Event handling
        tblStudents.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tblStudents.getSelectedRow();
                if (selectedRow >= 0) {
                    Student st = tableModel.getStudentAt(selectedRow);
                    if (st != null) {
                        txtMaSV.setText(st.getMaSV());
                        txtHoTen.setText(st.getHoTen());
                        txtDiemTB.setText(String.valueOf(st.getDiemTB()));
                    }
                }
            }
        });

        btnAdd.addActionListener(e -> themSinhVien());
        btnEdit.addActionListener(e -> suaSinhVien());
        btnDelete.addActionListener(e -> xoaSinhVien());
        btnClear.addActionListener(e -> lamMoiForm());

        setSize(650, 480);
        setLocationRelativeTo(null);
    }

    private void themSinhVien() {
        if (!validateInput()) return;

        String maSV = txtMaSV.getText().trim();
        // Check duplicate Student ID
        for (Student st : tableModel.getStudentList()) {
            if (st.getMaSV().equalsIgnoreCase(maSV)) {
                JOptionPane.showMessageDialog(this, "Mã sinh viên đã tồn tại!", "Lỗi trùng mã", JOptionPane.WARNING_MESSAGE);
                txtMaSV.requestFocus();
                return;
            }
        }

        String hoTen = txtHoTen.getText().trim();
        double diemTB = Double.parseDouble(txtDiemTB.getText().trim());

        tableModel.addStudent(new Student(maSV, hoTen, diemTB));
        JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        lamMoiForm();
    }

    private void suaSinhVien() {
        int selectedRow = tblStudents.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên cần sửa từ bảng!", "Chưa chọn dòng", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!validateInput()) return;

        String maSV = txtMaSV.getText().trim();
        String hoTen = txtHoTen.getText().trim();
        double diemTB = Double.parseDouble(txtDiemTB.getText().trim());

        Student updatedStudent = new Student(maSV, hoTen, diemTB);
        tableModel.updateStudent(selectedRow, updatedStudent);
        JOptionPane.showMessageDialog(this, "Cập nhật thông tin sinh viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        lamMoiForm();
    }

    private void xoaSinhVien() {
        int selectedRow = tblStudents.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên cần xóa từ bảng!", "Chưa chọn dòng", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Student st = tableModel.getStudentAt(selectedRow);
        int choice = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc chắn muốn xóa sinh viên " + st.getHoTen() + " (" + st.getMaSV() + ")?",
                "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            tableModel.removeStudent(selectedRow);
            JOptionPane.showMessageDialog(this, "Đã xóa sinh viên!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            lamMoiForm();
        }
    }

    private void lamMoiForm() {
        txtMaSV.setText("");
        txtHoTen.setText("");
        txtDiemTB.setText("");
        tblStudents.clearSelection();
        txtMaSV.requestFocus();
    }

    private boolean validateInput() {
        String maSV = txtMaSV.getText().trim();
        String hoTen = txtHoTen.getText().trim();
        String strDiem = txtDiemTB.getText().trim();

        if (maSV.isEmpty() || hoTen.isEmpty() || strDiem.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ tất cả thông tin!", "Thiếu thông tin", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        try {
            double diem = Double.parseDouble(strDiem);
            if (diem < 0 || diem > 10) {
                JOptionPane.showMessageDialog(this, "Điểm trung bình phải nằm trong khoảng từ 0.0 đến 10.0!", "Lỗi điểm", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Điểm trung bình phải là số thực hợp lệ!", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai08QuanLySinhVien().setVisible(true));
    }
}
