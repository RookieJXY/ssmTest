package cn.jxy.employee.web.service.function.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jxy.employee.core.generic.GenericDao;
import cn.jxy.employee.core.generic.impl.GenericServiceImpl;
import cn.jxy.employee.web.dao.function.FunctionMapper;
import cn.jxy.employee.web.dao.role.RoleMapper;
import cn.jxy.employee.web.model.Function;
import cn.jxy.employee.web.model.Role;
import cn.jxy.employee.web.service.function.FunctionService;

@Transactional
@Service
public class FunctionServiceImpl extends GenericServiceImpl<Function, String> implements FunctionService {

	@Resource
	private FunctionMapper functionMapper;
	
	@Resource
	private RoleMapper roleMapper;

	@Override
	public GenericDao<Function, String> getDao() {
		return functionMapper;
	}
	
	@Override
	public List<Function> selectList() {
		List<Function> functionList = super.selectList();
		for (Function function : functionList) {
			String functionId = function.getFunctionId();
			List<Function> subfunctions = selectSubfunctions(functionId);
			List<Role> roles = roleMapper.selectListByFunctionId(functionId);
			
			function.setSubfunctions(subfunctions);
			function.setRoles(roles);
		}
		System.out.println(functionList);
		return functionList;
	}
	
	private List<Function> selectSubfunctions(String functionId) {
		return functionMapper.selectListByParentFunctionId(functionId);
	}

	@Override
	public List<String> selectByParentFunctionId(String parentFunctionId) {
		List<String> functionIdList = new ArrayList<String>();
		return addList(parentFunctionId, functionIdList);
	}
	
	private List<String> addList(String parentFunctionId, List<String> functionIdList) {
		List<String> parentFunctionIdList = functionMapper.selectByparentFunctionId(parentFunctionId);
		if(parentFunctionIdList != null && parentFunctionIdList.size() > 0) {
			for (int i = 0; i < parentFunctionIdList.size(); i++) {
				String pFId = parentFunctionIdList.get(i);
				functionIdList.add(pFId);
				addList(pFId, functionIdList);
			}
		}
		return functionIdList;
	}

	@Override
	public int deleteByFunctionIds(List<String> functionList) {
		return functionMapper.deleteByFunctionIds(functionList);
	}

	@Override
	public List<Function> selectListIfHasRole(String roleId) {
		return functionMapper.selectListIfHasRole(roleId);
	}

	@Override
	public List<Function> selectListByRole(String roleId) {
		return functionMapper.selectListByRole(roleId);
	}
	
	@Override
	public Set<String> selectFunctionCodeSetByRole(String roleId) {
		Set<String> functionCodeSet = new HashSet<String>();
		List<Function> functions = selectListByRole(roleId);
		for (Function function : functions) {
			String functionCode = function.getFunctionCode();
			if (functionCode != null && !"".equals(functionCode.trim())) {
				functionCodeSet.add(functionCode);
			}
		}
		return functionCodeSet;
	}

	@Override
	public List<Function> selectListByHref(String href) {
		return functionMapper.selectListByHref(href);
	}

	@Override
	public List<Function> selectByParentFunctionId2(String parentFunctionId) {
		return functionMapper.selectByParentFunctionId2(parentFunctionId);
	}

	
	

	
}
