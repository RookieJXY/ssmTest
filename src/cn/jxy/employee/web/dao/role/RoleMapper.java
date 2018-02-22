package cn.jxy.employee.web.dao.role;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.jxy.employee.core.generic.GenericDao;
import cn.jxy.employee.web.model.Role;
import cn.jxy.employee.web.model.page.Page;



@Repository
public interface RoleMapper extends GenericDao<Role, String> {
	
	List<Role> selectListByFunctionId(String functionId);
	
	/**
	 * 根据角色名字模糊查询 分页
	 * @param roleName
	 * @return
	 */
//	public List<Role> selectListByPage(RolePage rolePage);
	public List<Role> selectListByPage(@Param(value = "keywords") List<String> keywords,
			@Param(value = "page") Page page);
	
	/**
	 * 模糊查询总行数
	 * @param roleName
	 * @return
	 */
//	public Integer selectQuantity(RolePage rolePage);
	public Integer selectQuantity(@Param(value = "keywords") List<String> keywords);
	
	/**
	 * 插入角色权限映射表
	 * @param roleId
	 * @param functionId
	 * @return
	 */
	public int insertRoleFunction(Map<String, String> params);
	
	/**
	 * 根据角色代码查询角色信息
	 * @param roleCode
	 * @return
	 */
	public Role selectRoleByRoleCode(String roleCode);
	
	/**
	 * 根据参数查询对应角色
	 * @param paraMap
	 * @return
	 */
	List<Role> selectListByBreifInfo(Map<String, String> paraMap);
	
	List<Role> selectRoleListByKeywords(Map<String, String> paraMap);
	
	public int updateAvailState(String roleId);
}
