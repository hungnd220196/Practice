package ra.business.design;

import ra.business.entity.Department;
import ra.business.entity.Employee;

public interface IEmployeeDesign extends IGenericDesign<Employee, Integer> {
    void getListEmployeeByDepartment();
    void sortEmployeeNameAscending();
}
