package cn.jxy.employee.web.service.department;

import java.util.List;
import java.util.Map;

import cn.jxy.employee.core.generic.GenericService;
import cn.jxy.employee.web.model.department.Department;

public interface DepartmentService extends GenericService<Department, String>{

	List<Department> selectListByBreifInfo(Map<String, String> paramap);

	Integer updateManagerId(Department department);

}
