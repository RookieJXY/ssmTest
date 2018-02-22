package cn.jxy.employee.web.dao.department;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.jxy.employee.core.generic.GenericDao;
import cn.jxy.employee.web.model.department.Department;
import cn.jxy.employee.web.model.page.Page;

@Repository
public interface DepartmentMapper extends GenericDao<Department, String>{

	/**
	 * 根据参数查询对应部门
	 * @param departmentId
	 * @return
	 */
	List<Department> selectListByBreifInfo(Map<String, String> paraMap);

	/**
	 * 根据关键字查询部门总数
	 * @param keywords
	 * @return
	 */
	Integer selectRowsByKeywords(@Param(value = "keywords") List<String> keywords);

	/**
	 * 根据关键字分页查询部门信息 
	 * @param keywords
	 * @param page
	 * @return
	 */
	List<Department> selectListBykeywords(@Param(value = "keywords") List<String> keywords,
			@Param(value = "page") Page page);
	
	/**
	 * 将部门状态置为不可用
	 * @param departmentId
	 * @return
	 */
	int updateAvailById(String departmentId);

	int selectRowsByKeywords2(@Param(value = "keywords") List<String> keywords);

	int updateManagerId(Department department);

}
