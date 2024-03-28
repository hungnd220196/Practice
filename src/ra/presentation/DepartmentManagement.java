package ra.presentation;

import ra.business.design.IDepartmentDesign;
import ra.business.entity.Department;
import ra.business.impl.DepartmentImplement;

import java.util.Scanner;

public class DepartmentManagement {
    static IDepartmentDesign departmentDesign = new DepartmentImplement();

    public void displayDepartmentMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("================Department Menu===================");
            System.out.println("1- Hiển thi tất cả cac department \n" +
                    "2- Thêm mới department\n" +
                    "3- Sửa thông tin department \n" +
                    "4- Thay đổi trạng thái department \n" +
                    "5- Tìm kiếm phòng ban theo tên \n" +
                    "6- Quay lại ");

            System.out.println("Nhập lựa chọn");
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    departmentDesign.displayAll();
                    break;
                case 2:
                    departmentDesign.addNew();
                    break;
                case 3:
                    departmentDesign.update();
                    break;
                case 4:
                    System.out.println("mời bạn nhập id cần chuyển đổi status");
                    int idChange = Integer.parseInt(scanner.nextLine());
                    departmentDesign.changeStatusById(idChange);
                    break;
                case 5:
                    departmentDesign.searchDepartmentByName();
                    break;
                case 6:
                    return;
                default:
                    System.err.println("Nhap lua chon ko chinh xác");
            }
        }
    }


}
