package cn.jxy.employee.web.dao.user;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.jxy.employee.core.generic.GenericDao;
import cn.jxy.employee.web.model.User;
import cn.jxy.employee.web.model.page.Page;

@Repository
public interface UserMapper extends GenericDao<User, String> {

	/**
	 * 用户登录验证查询
	 * 
	 * @param record
	 * @return
	 */
	User authentication(@Param("record") User user);
	
	/**
	 * 根据用户名查询用户
	 * 
	 * @param username
	 * @return
	 */
	User selectByUsername(String username);
	
	/**
	 * 根据用户编号查询用户
	 * 
	 * @param userId
	 * @return
	 */
	User selectByUserId(String userId);
	
	/**
	 * 根据部门ID查询该部门下所有用户
	 * 
	 * @param departmentId
	 * @return
	 */
	List<User> selectListByDepartmentId(String departmentId);

	/**
	 * 根据角色查询所需用户
	 * 
	 * @param roleCodes
	 * @return
	 */
	List<User> selectListByRole(@Param(value = "roleCodes") Set<String> roleCodes);
	
	List<User> selectListByRoleTask(@Param(value = "roleCodes") Set<String> roleCodes);

	/**
	 * 根据关键字查询符合条件的用户简要信息
	 */
	List<Map<String, String>> selectUserBriefInfoByKeyWord(
			Map<String, String> paramMap);

	/**
	 * 根据关键字查询用户总数
	 * 
	 * @param keywords
	 * @return
	 */
	Integer selectRowsByKeywords(
			@Param(value = "keywords") List<String> keywords);

	/**
	 * 根据关键字分页查询用户信息
	 * 
	 * @param keywords
	 * @param page
	 * @return
	 */
	List<User> selectListByKeywords(
			@Param(value = "keywords") List<String> keywords,
			@Param(value = "page") Page page);
	
	/**
	 * 根据系统查询查询该系统下的可用用户
	 * @param paraMap
	 * @param page
	 * @return
	 */
	List<User> selectListBySystem(@Param(value="param") Map<String, String> paraMap,
			@Param(value="page") Page page);
	
	List<User> selectListBySystemId(@Param(value="param") Map<String, String> paraMap);
	
	List<User> selectUsersByManagerId(@Param(value="param") Map<String, String> paraMap,
			@Param(value="page") Page page);
	
	Integer selectRowsByManagerId(Map<String, String> paraMap);
	
	Integer selectRowsBySystem(Map<String, String> paraMap);
	
	List<Map<String,String>> selectManagerAndDeveloperAndGuest();
	
	//只选择项目经理
	List<Map<String,String>> selectManager();
	
	List<User> selectUserListByKeywords(Map<String, String> paraMap);
	
	List<String> selectUserIdListByKeywords(Map<String, String> paraMap);

	List<User> selectListByRoleId(String roleId);
	
	List<User> selectList();
	
	int updateMyPassword(User user);
}
