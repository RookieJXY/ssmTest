package cn.jxy.employee.web.service.user.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jxy.employee.core.generic.GenericDao;
import cn.jxy.employee.core.generic.impl.GenericServiceImpl;
import cn.jxy.employee.core.util.ApplicationUtils;
import cn.jxy.employee.web.constant.Constant;
import cn.jxy.employee.web.dao.application.ApplicationInfoMapper;
import cn.jxy.employee.web.dao.role.RoleMapper;
import cn.jxy.employee.web.dao.user.UserMapper;
import cn.jxy.employee.web.model.Role;
import cn.jxy.employee.web.model.User;
import cn.jxy.employee.web.model.application.ApplicationInfo;
import cn.jxy.employee.web.model.page.Page;
import cn.jxy.employee.web.service.user.UserService;

@Transactional
@Service
public class UserServiceImpl extends GenericServiceImpl<User, String> implements
		UserService {

	@Resource
    private UserMapper userMapper;
	
	@Resource
    private RoleMapper roleMapper;
	
	@Resource
    private ApplicationInfoMapper applicationInfoMapper;
	
	@Override
	public User authentication(User user) {
		return userMapper.authentication(user);
	}

	@Override
	public GenericDao<User, String> getDao() {
		return userMapper;
	}

	@Override
	public List<User> selectListByRoleId(String roleId) {
		return null;
	}

	@Override
	public User buildUser(User user) {
		Role guest = roleMapper.selectRoleByRoleCode(Constant.ROLE_GUEST);
		user.setUserId(ApplicationUtils.randomUUID());
		user.setPassword(ApplicationUtils.sha256Hex(user.getPassword()));
		user.setCrtTime(new Timestamp(System.currentTimeMillis()));
		if(user.getRoleId() == "" || user.getRoleId() == null){
			user.setRoleId(guest.getRoleId());
		}
		return user;
	}

	@Override
	public List<User> selectUsersByKeywords(Map<String, String> paraMap) {
		List<User> userList =  userMapper.selectUserListByKeywords(paraMap);
		if(userList != null && userList.size() > 0){
			return userList;
		}
		return null;
	}

	@Override
	public ApplicationInfo buildAddUserApplicationInfo(User userlogin, User user) {
		ApplicationInfo applicationInfo =  new ApplicationInfo();
		
		applicationInfo.setApplicationId(UUID.randomUUID().toString());
		//applicationInfo.setApplicationDesc(ApplicationInfoConstant);    部门描述
		applicationInfo.setType(Constant.APPLICATION_USER_TYPE);
		applicationInfo.setOprType(Constant.ADD_OPR_TYPE);
		applicationInfo.setChangeNo(null);
		applicationInfo.setEntityId(user.getUserId());
		applicationInfo.setEntityVersionId(null);
		applicationInfo.setChangeDetailId(null);
		applicationInfo.setAuditState(Constant.AUDIT_PASSED);
		applicationInfo.setCrtTime(new Timestamp(System.currentTimeMillis()));
		
		return applicationInfo;
	}

	@Override
	public Integer insertUser(User user, ApplicationInfo applicationInfo) {
		insert(user);
		return applicationInfoMapper.insertSelective(applicationInfo);
	}

	@Override
	public Integer selectRowByKeywords(List<String> keywords) {
		return userMapper.selectRowsByKeywords(keywords);
	}

	@Override
	public List<User> selectListByKeywords(List<String> keywords,
			Page page) {
		return userMapper.selectListByKeywords(keywords, page);
	}

	@Override
	public Integer selectRowsByManagerId(Map<String, String> paraMap) {
		return userMapper.selectRowsByManagerId(paraMap);
	}

	@Override
	public List<User> selectUsersByManagerId(Map<String, String> paraMap,
			Page page) {
		return userMapper.selectUsersByManagerId(paraMap, page);
	}

	@Override
	public Integer selectRowsByKeywords(List<String> keywords) {
		return userMapper.selectRowsByKeywords(keywords);
	}

	

}
