package ra.business.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Employee {
    private int id;
    static int nextId = 1;
    private String fullName;
    private String address;
    private String phone;
    private LocalDate dateOfBirth;
    private Department department;
    private Boolean status = true;

    public Employee() {
        this.id = nextId++;
    }

    public Employee(int id, String fullName, String address, String phone, LocalDate dateOfBirth, Department department, Boolean status) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void inputData(List<Department> departmentList, List<Employee> employeeList) {
        Scanner scanner = new Scanner(System.in);
        this.fullName = getInputEmployeeName();
        System.out.println("mời bạn nhập địa chỉ");
        while (true) {
            String inputDepartmentAddress = scanner.nextLine();
            if (!inputDepartmentAddress.isBlank()) {
                break;
            } else {
                System.err.println("địa chỉ không được để trống, vui lòng nhập lại");
            }
        }
        System.out.println("mời bạn nhập số điện thoại");
        this.phone = isValidPhone();
        this.dateOfBirth = getInputBirthDay();
        this.department = getInputDepartment(departmentList);
    }

    private String isValidPhone() {
        String regexPhone = "((^(\\+84|84|0|0084){1})([35789]))+([0-9]{8})$";
        while (true) {
            String inputPhone = new Scanner(System.in).nextLine();
            if (inputPhone.matches(regexPhone)) {
                return inputPhone;
            }
            System.err.println("số điện thoại không đúng");
        }
    }

    private String getInputEmployeeName() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Nhập vào tên nhân vien");
            String departmentNameInput = sc.nextLine();
            if (!departmentNameInput.isBlank()) {
                return departmentNameInput;
            } else {
                System.err.println("Không được để trống");
            }
        }
    }

    private LocalDate getInputBirthDay() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Nhập vào ngày sinh dd-MM-yyyy");
            String employeeDateInput = sc.nextLine();
            DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                return LocalDate.parse(employeeDateInput, DTF);
            } catch (DateTimeParseException e) {
                System.err.println("Khong dung dinh dang");
            }
        }
    }

    private Department getInputDepartment(List<Department> departmentList) {
        Scanner sc = new Scanner(System.in);
        // hiển thị danh sách phòng ban
        System.out.println("Danh sach phòng ban");
        for (int i = 0; i < departmentList.size(); i++) {
            System.out.printf("| STT : %d | Name : %-15s |\n", i + 1, departmentList.get(i).getName());
        }
        while (true) {
            System.out.println("Nhập vào vị trí phòng ban (theo STT)");
            int index = sc.nextInt();
            if (index >= 1 && index <= departmentList.size()) {
                Department department1 = departmentList.get(index - 1);
                // tăng số nhân viên lên 1
                department1.setNumberEmployee(department1.getNumberEmployee() + 1);
                return department1;
            }
            System.err.println("Vi tri nhap khong hơp lẹ, vui lòng chọn lại");
        }
    }

    public void displayData() {
        System.out.printf("| ID : %-5s | Name : %-10s | DoB : %-10s |Số điện thoại: %10s| Department : %-15s | Trạng thái: %10s\n",
                this.id, fullName, dateOfBirth.toString(), phone, department.getName(), status ? "Đang hoạt động" : "Không hoạt động");
        System.out.println("----------------------------------------------------------------------------------");
    }
}
