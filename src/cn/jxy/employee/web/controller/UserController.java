package cn.jxy.employee.web.controller;
import static cn.jxy.employee.core.util.ApplicationUtils.buildResponseMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jxy.employee.core.util.ApplicationUtils;
import cn.jxy.employee.core.util.StringUtil;
import cn.jxy.employee.core.util.UserOperationType;
import cn.jxy.employee.web.constant.Constant;
import cn.jxy.employee.web.model.Function;
import cn.jxy.employee.web.model.Role;
import cn.jxy.employee.web.model.User;
import cn.jxy.employee.web.model.application.ApplicationInfo;
import cn.jxy.employee.web.model.department.Department;
import cn.jxy.employee.web.model.page.Page;
import cn.jxy.employee.web.model.page.UserPage;
import cn.jxy.employee.web.service.department.DepartmentService;
import cn.jxy.employee.web.service.function.FunctionService;
import cn.jxy.employee.web.service.role.RoleService;
import cn.jxy.employee.web.service.user.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);
	@Resource
	private UserService userService;
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private FunctionService functionService;
	
	@Resource
	private DepartmentService departmentService;

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @param result
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@UserOperationType("用户登录")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid User user, BindingResult result, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			Subject subject = SecurityUtils.getSubject();
			if (subject.isAuthenticated()) {
				return "redirect:/index";
			}

			if (result.hasErrors()) {
				model.addAttribute("error", "参数错误！");
				return "forward:/";
			}

			// 身份验证
			subject.login(new UsernamePasswordToken(user.getUsername(),
					ApplicationUtils.sha256Hex(user.getPassword())));
			// addCookie(user.getUsername(),user.getPassword(),request,response);

			List<Function> functionList = functionService.selectList();
			ApplicationUtils.setSession("functionList", functionList);
		} catch (Exception e) {
			// 身份验证失败
			logger.error("an exception occured.", e);
			model.addAttribute("error", e.getMessage());
			return "forward:/";
		}
		return "redirect:/index";
	}
	
	/**
	 * 用户登出
	 * 
	 * @param user
	 * @param result
	 * @param model
	 * @param request
	 * @return
	 */
	@UserOperationType("用户退出登录")
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.getSession().removeAttribute("userInfo");
		subject.logout();
		return "redirect:/";
	}
	
	@RequestMapping("/toRegister")
	public String toAdd(Model model){
		Map<String,String> paraMap = new HashMap<String,String>();
		List<Department> departmentList = new ArrayList<Department>();
		List<Role> roleList = new ArrayList<Role>();
		try {
			paraMap.put("availState", Constant.AVAILABLE);
			departmentList = departmentService.selectListByBreifInfo(paraMap);
			roleList = roleService.selectList();
			model.addAttribute("roleList", roleList);
			model.addAttribute("departmentList", departmentList);
			return "/user/register";
		} catch (Exception e) {
			logger.error(Constant.RSP_EXCEPTION, e);
			return "redirect:/500";
		}
		
	}
	
	@UserOperationType("新增用户")
	@ResponseBody
	@RequestMapping("/register")
	public JSONObject register(User user, ModelMap model) {
		try {
			userService.buildUser(user);
			Map<String,String> paraMap1 = new HashMap<String,String>();
			paraMap1.put("username", user.getUsername());
			Map<String,String> paraMap2 = new HashMap<String,String>();
			paraMap2.put("userCode", user.getUserCode());
			if(userService.selectUsersByKeywords(paraMap1) != null){
				return buildResponseMessage(Constant.RSP_ERROR, user.getUsername()
						+ "用户编号已经存在！");
			}
			Department department = new Department();
			if(user.getDepartmentId() != null && "0".equals(user.getIsManager())){
				department =  departmentService.selectById(user.getDepartmentId());
				if(department.getManagerId() != null){
					return buildResponseMessage(Constant.RSP_ERROR, "该部门已经存在负责人！");
				}
				//给部门负责人赋值
				department.setManagerId(user.getUserId());
				departmentService.updateManagerId(department);
			}
			
			User userlogin = ApplicationUtils.getCurrentUser();
			ApplicationInfo applicationInfo = userService.buildAddUserApplicationInfo(userlogin, user);
			
			userService.insertUser(user, applicationInfo);
			
			return buildResponseMessage(Constant.RSP_NORMAL, "用户" + user.getUserCode() + "注册成功！");
		} catch (Exception e) {
			logger.error(Constant.EXCEPTION_OCCURED, e);
			return buildResponseMessage(Constant.RSP_EXCEPTION, "系统错误，请稍后再试！");
		}
	}
	
	@RequestMapping("/queryEntire")
	public String queryEntire(){
		return "/user/queryEntire";
	}
	
	@RequestMapping("/listEntireByPage")
	public String listEntireByPage(UserPage page, String keywords, Model model){
		List<User> userList = null;
		try {
			List<String> keywordsList = StringUtil.parseKeywordsToList(keywords);
			page.setRows(userService.selectRowByKeywords(keywordsList));
			userList = userService.selectListByKeywords(keywordsList,page);
			
			model.addAttribute("userList", userList);
			model.addAttribute("page", page);
			return "/user/entireList";
		} catch (Exception e) {
			logger.error(Constant.EXCEPTION_OCCURED, e);
			return "redirect:/500";
		}
	}
	
	/**
	 * 根据Id查询用户
	 * 
	 * @param userId
	 * @param model
	 * @param flag
	 * @return 用户信息详情/用户编辑
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String userId, Model model, String flag){
		User user = null;
		try {
			Map<String,String> paraMap = new HashMap<String,String>();
			paraMap.put("userId", userId);
			List<User> userList = userService.selectUsersByKeywords(paraMap);
			if(userList != null){
				user = userList.get(0);
			}
			Department department = departmentService.selectById(user.getDepartmentId());
			model.addAttribute("user", user);
			model.addAttribute("department", department);
			return "/user/detail";
		} catch (Exception e) {
			logger.error(Constant.EXCEPTION_OCCURED, e);
			return "redirect:/500";
		}
	}
	
	@RequestMapping("/manager")
	public String manager(){
		return "/user/manager";
	}
	
	@RequestMapping("/listManagerByPage")
	private String listManagerByPage(Page page,String keywords,Model model) {
		List<User> userList = null;
		try {
			List<String> keywordsList = StringUtil.parseKeywordsToList(keywords);
			User user = ApplicationUtils.getCurrentUser();
			
			Map<String,String> paraMap = new HashMap<String,String>();
			if(ApplicationUtils.hasRole(Constant.ROLE_MANAGER)){
				paraMap.put("managerId", user.getUserId());
				page.setRows(userService.selectRowsByManagerId(paraMap));
				userList = userService.selectUsersByManagerId(paraMap, page);
			}
			
			List<String> roleCodeList = new ArrayList<String>();
			roleCodeList.add(Constant.ROLE_ADMIN);
			roleCodeList.add(Constant.ROLE_GOVERNOR);
			if(ApplicationUtils.hasSomeRoles(roleCodeList)){
				page.setRows(userService.selectRowsByKeywords(keywordsList));
				userList = userService.selectListByKeywords(keywordsList,page);
			}
			
			roleCodeList.clear();
			roleCodeList.add(Constant.ROLE_DEVELOPER);
			roleCodeList.add(Constant.ROLE_GUEST);
			if(ApplicationUtils.hasSomeRoles(roleCodeList)){
				userList =  new ArrayList<User>();
				userList.add(user);
				page.setRows(1);
			}
			model.addAttribute("userList", userList);
			model.addAttribute("page", page);
			return "/user/managerList";
		} catch (Exception e) {
			logger.error(Constant.EXCEPTION_OCCURED, e);
			return "redirect:/500";
		}
	}
	
	@RequestMapping("/toModify")
	private String toModify(String userId, Model model) {
		User user = null;
		Map<String,String> paraMap1 = new HashMap<String,String>();
		Map<String,String> paraMap2 = new HashMap<String,String>();
		List<Department> departmentList = null;
		List<Department> department = null;//用户所在部门
		try {
			paraMap1.put("availState", Constant.AVAILABLE);
			departmentList = departmentService.selectListByBreifInfo(paraMap1);
			paraMap2.put("userId", userId);
			List<User> userList = userService.selectUsersByKeywords(paraMap2);
			
			if(userList != null){
				user =  userList.get(0);
				//根据用户的userId查询对应部门信息
				Map<String,String> paraMap3 =  new HashMap<String, String>();
				paraMap3.put("departmentId", user.getDepartmentId());
				department = departmentService.selectListByBreifInfo(paraMap3);
			}
			
		} catch (Exception e) {
		}
		return null;
	}
}
