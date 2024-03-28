package ra.presentation;

import ra.business.design.IEmployeeDesign;
import ra.business.impl.EmployeeImplement;

import java.util.Scanner;

public class EmployeeManagement {
    static IEmployeeDesign employeeDesign = new EmployeeImplement();

    public void displayEmployeeMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("================Department Menu===================");
            System.out.println("1- Hiển thi tất cả các employee \n" +
                    "2- Thêm mới employee\n" +
                    "3- Sửa thông tin employee \n" +
                    "4- Thay đổi trạng thái employee \n" +
                    "5- Tìm kiếm employee theo tên \n" +
                    "6- Tìm kiếm employee theo mã phòng ban \n" +
                    "7- Quay lại ");

            System.out.println("Nhập lựa chọn");
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    employeeDesign.displayAll();
                    break;
                case 2:
                    employeeDesign.addNew();
                    break;
                case 3:
                    employeeDesign.update();
                    break;
                case 4:
                    System.out.println("mời bạn nhập id cần chuyển đổi status");
                    int idChange = Integer.parseInt(scanner.nextLine());
                    employeeDesign.changeStatusById(idChange);
                    break;
                case 5:
                    employeeDesign.getListEmployeeByDepartment();
                    break;
                case 6:
                    employeeDesign.sortEmployeeNameAscending();
                    break;
                case 7:
                    return;
                default:
                    System.err.println("Nhap lua chon ko chinh xác");
            }
        }
    }
}

