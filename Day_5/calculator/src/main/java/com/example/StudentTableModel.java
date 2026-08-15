package com.example;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentTableModel extends AbstractTableModel {
    private final String[] columnNames = {"STT", "Mã SV", "Họ và Tên", "Điểm TB", "Xếp Loại"};
    private final List<Student> studentList;

    public StudentTableModel() {
        this.studentList = new ArrayList<>();
    }

    public StudentTableModel(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public int getRowCount() {
        return studentList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student st = studentList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return st.getMaSV();
            case 2:
                return st.getHoTen();
            case 3:
                return String.format("%.2f", st.getDiemTB());
            case 4:
                return st.getXepLoai();
            default:
                return null;
        }
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public Student getStudentAt(int index) {
        if (index >= 0 && index < studentList.size()) {
            return studentList.get(index);
        }
        return null;
    }

    public void addStudent(Student student) {
        studentList.add(student);
        fireTableRowsInserted(studentList.size() - 1, studentList.size() - 1);
    }

    public void updateStudent(int index, Student student) {
        if (index >= 0 && index < studentList.size()) {
            studentList.set(index, student);
            fireTableRowsUpdated(index, index);
        }
    }

    public void removeStudent(int index) {
        if (index >= 0 && index < studentList.size()) {
            studentList.remove(index);
            fireTableRowsDeleted(index, index);
        }
    }

    public void clearAll() {
        int size = studentList.size();
        if (size > 0) {
            studentList.clear();
            fireTableDataChanged();
        }
    }
}
