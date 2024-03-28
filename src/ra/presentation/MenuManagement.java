package ra.presentation;

import ra.business.design.IDepartmentDesign;

import java.util.Scanner;

public class MenuManagement {
    public static DepartmentManagement departmentManagement = new DepartmentManagement();
    public static EmployeeManagement employeeManagement = new EmployeeManagement();

    public static void main(String[] args) {
        while (true) {
            System.out.println("================MENU===================");
            System.out.println("1- Quản trị phòng ban : \n" +
                    "2- Quản lý nhân viên\n" +
                    "3.Thoát ");
            System.out.println("Nhập lựa chọn");
            int choice = Integer.parseInt(new Scanner(System.in).nextLine());
            switch (choice) {
                case 1:
                    departmentManagement.displayDepartmentMenu();
                    break;
                case 2:
                    employeeManagement.displayEmployeeMenu();
                    break;
                case 3:
                    System.out.println("Thoát");
                    return;
                default:
                    System.err.println("Nhap lua chon ko chinh xác");
            }
        }
    }
}
