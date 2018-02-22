package cn.jxy.employee.web.security;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import cn.jxy.employee.core.util.ApplicationUtils;
import cn.jxy.employee.web.constant.Constant;
import cn.jxy.employee.web.model.Role;
import cn.jxy.employee.web.model.User;
import cn.jxy.employee.web.service.function.FunctionService;
import cn.jxy.employee.web.service.role.RoleService;
import cn.jxy.employee.web.service.user.UserService;



/**
 * 身份验证及授权
 */
@Component("securityRealm")
public class SecurityRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private FunctionService functionService;

	/**
	 * 权限校验
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection token) {
		try {
			SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
			
			User currentUser = (User)token.getPrimaryPrincipal();
			Role role = roleService.selectById(currentUser.getRoleId());
			Set<String> permissionSet = functionService.selectFunctionCodeSetByRole(
					role.getRoleId());
			
			authorizationInfo.addRole(role.getRoleCode());
			authorizationInfo.addStringPermissions(permissionSet);
			
			return authorizationInfo;
			
		} catch (Exception e) {
			throw new AuthorizationException("授权失败：" + e.getMessage());
		}
	}

	/**
	 * 用户验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		try {
			String username = String.valueOf(token.getPrincipal());
			String password = new String((char[]) token.getCredentials());
			
			final User authentication = userService.authentication(new User(
					username, password));
			if (authentication == null) {
				throw new AuthenticationException("用户名或密码错误 ！");
			}
			
			if (Constant.NOT_AVAILABLE.equals(authentication.getAvailState())) {
				throw new AuthenticationException("此用户已失效 ！");
			}
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
					authentication, password, getName());
			ApplicationUtils.setSession("userInfo", authentication);
			return authenticationInfo;
		} catch (Exception e) {
			throw new AuthenticationException("登录失败：" + e.getMessage());
		}
	}

}
