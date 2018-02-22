package cn.jxy.employee.web.service.department.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jxy.employee.core.generic.GenericDao;
import cn.jxy.employee.core.generic.impl.GenericServiceImpl;
import cn.jxy.employee.web.dao.department.DepartmentMapper;
import cn.jxy.employee.web.model.department.Department;
import cn.jxy.employee.web.service.department.DepartmentService;

@Transactional
@Service
public class DepartmentServiceImpl extends GenericServiceImpl<Department, String> implements DepartmentService{

	@Resource
	private DepartmentMapper departmentMapper;
	
	@Override
	public GenericDao<Department, String> getDao() {
		return departmentMapper;
	}

	@Override
	public List<Department> selectListByBreifInfo(Map<String, String> paraMap) {
		List<Department> resultList = departmentMapper.selectListByBreifInfo(paraMap);
		if(resultList == null || resultList.size() <= 0){
			return null;
		}
		return resultList;
	}

	@Override
	public Integer updateManagerId(Department department) {
		return departmentMapper.updateManagerId(department);
	}

	

}
