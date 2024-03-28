package ra.business.impl;

import ra.business.design.IDepartmentDesign;
import ra.business.entity.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentImplement implements IDepartmentDesign {
    static List<Department> departmentList = new ArrayList<>();

    @Override
    public void displayAll() {
        if (departmentList.isEmpty()) {
            System.err.println("Danh sách trống");
        } else {
            departmentList.forEach(Department::displayData);
        }

    }

    @Override
    public void addNew() {
        System.out.println("Nhap so luong phong ban muon them");
        byte count = new Scanner(System.in).nextByte();
        for (int i = 1; i <= count; i++) {
            System.out.println("Nhap thong tin cho phong ban thư " + i);
            Department department = new Department();
            department.inputData(departmentList);
            departmentList.add(department);
        }
        System.out.println("Đã them moi thanh cong ");
    }

    @Override
    public void update() {
        System.out.println("Hãy chọn ID department muốn update");
        int id = Integer.parseInt(new Scanner(System.in).nextLine());
        Department edit = findById(id);
        if (edit == null) {
            System.err.println("id không tim thấy");
            return;
        }
        System.out.println("Thong tin cũ là ");
        edit.displayData();
        // yêu cầu nhập thông tin mới
        System.out.println("Hãy nhap thong tin mơi ");
        edit.inputData(departmentList);
        System.out.println("Cập nhật thành công");

    }

    @Override
    public Department findById(Integer id) {
        for (Department d : departmentList) {
            if (d.getId() == (id))
                return d;
        }
        return null;
    }

    @Override
    public Department changeStatusById(Integer id) {
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getId() == id) {
                departmentList.get(i).setStatus(!departmentList.get(i).getStatus());
               return departmentList.get(i);
            }
        }
        return null;
    }

    @Override
    public void searchDepartmentByName() {
        System.out.println(" mời bạn nhập tên phòng ban muốn tìm kiếm");
        String nameSearch = new Scanner(System.in).nextLine();
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getName().toLowerCase().contains(nameSearch.toLowerCase())) {
                departmentList.get(i).displayData();
            }
        }
    }
}
