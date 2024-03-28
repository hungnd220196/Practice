package ra.business.design;

import ra.business.entity.Department;

public interface IDepartmentDesign extends IGenericDesign<Department, Integer> {
void searchDepartmentByName();
}
