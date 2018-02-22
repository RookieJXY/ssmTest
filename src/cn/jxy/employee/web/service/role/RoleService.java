package cn.jxy.employee.web.service.role;

import java.util.List;
import java.util.Map;

import cn.jxy.employee.core.generic.GenericService;
import cn.jxy.employee.web.model.Role;
import cn.jxy.employee.web.model.User;
import cn.jxy.employee.web.model.application.ApplicationInfo;
import cn.jxy.employee.web.model.page.Page;

public interface RoleService extends GenericService<Role, String>{

	List<Role> selectListByPage(List<String> keywordsList, Page page);

	ApplicationInfo buildDeleteRoleApplicationInfo(User userlogin, Role role);

	void updateAvailState(String roleId, ApplicationInfo applicationInfo);

	Object selectRolesByKeywords(Map<String, String> paraMap1);
	
	

}
