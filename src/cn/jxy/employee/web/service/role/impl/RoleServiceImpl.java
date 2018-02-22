package cn.jxy.employee.web.service.role.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jxy.employee.core.generic.GenericDao;
import cn.jxy.employee.core.generic.impl.GenericServiceImpl;
import cn.jxy.employee.web.dao.role.RoleMapper;
import cn.jxy.employee.web.model.Role;
import cn.jxy.employee.web.model.User;
import cn.jxy.employee.web.model.application.ApplicationInfo;
import cn.jxy.employee.web.model.page.Page;
import cn.jxy.employee.web.service.role.RoleService;

@Transactional
@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, String> implements
RoleService {

	@Resource
    private RoleMapper roleMapper;
	
	@Override
	public GenericDao<Role, String> getDao() {
		// TODO Auto-generated method stub
		return roleMapper;
	}

	@Override
	public List<Role> selectListByPage(List<String> keywordsList, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApplicationInfo buildDeleteRoleApplicationInfo(User userlogin,
			Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAvailState(String roleId, ApplicationInfo applicationInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object selectRolesByKeywords(Map<String, String> paraMap1) {
		// TODO Auto-generated method stub
		return null;
	}

}
