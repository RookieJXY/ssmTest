package cn.jxy.employee.web.service.user;

import java.util.List;
import java.util.Map;

import cn.jxy.employee.core.generic.GenericService;
import cn.jxy.employee.web.model.User;
import cn.jxy.employee.web.model.application.ApplicationInfo;
import cn.jxy.employee.web.model.page.Page;

public interface UserService extends GenericService<User, String>{
	
	/**
	 * 用户验证
	 * @param user
	 * @return
	 */
	User authentication(User user);
	
	/**
	 * 根据角色ID查询是否有用户，作为角色删除的判断
	 * @param roleId
	 * @return
	 */
	List<User> selectListByRoleId(String roleId);

	
	User buildUser(User user);
	
	/**
	 * 根据条件查询用户
	 * @param paraMap
	 * @return
	 */
	List<User> selectUsersByKeywords(Map<String, String> paraMap);

	ApplicationInfo buildAddUserApplicationInfo(User userlogin, User user);

	Integer insertUser(User user, ApplicationInfo applicationInfo);
	
	/**
	 * 关键字查询总用户数
	 * @param keywordsList
	 * @return
	 */
	Integer selectRowByKeywords(List<String> keywordsList);
	/**
	 * 根据关键字分页查询所有用户信息
	 * @param keywordsList
	 * @param page
	 * @return
	 */
	List<User> selectListByKeywords(List<String> keywordsList, Page page);

	Integer selectRowsByManagerId(Map<String, String> paraMap);

	List<User> selectUsersByManagerId(Map<String, String> paraMap, Page page);

	Integer selectRowsByKeywords(List<String> keywordsList);

}
