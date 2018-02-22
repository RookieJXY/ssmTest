package cn.jxy.employee.web.service.function;

import java.util.List;
import java.util.Set;

import cn.jxy.employee.core.generic.GenericService;
import cn.jxy.employee.web.model.Function;


public interface FunctionService extends GenericService<Function, String>{
	
	/**
	 * 查出这个id下面所有的子权限的list集合
	 * @param parentFunctionId
	 * @return
	 */
	public List<String> selectByParentFunctionId(String parentFunctionId);
	
	public int deleteByFunctionIds(List<String> functionList); 
	
	/**
	 * 已知角色id，查询所有的权限表，并把该角色id下拥有的权限表标注
	 * @param roleId
	 * @return
	 */
	public List<Function> selectListIfHasRole(String roleId);

	/**
	 * 根据角色获取功能href
	 * @param roleId
	 * @return
	 */
	public Set<String> selectFunctionCodeSetByRole(String roleId);
	
	/**
	 * 根据角色获取功能列表
	 * @param roleId
	 * @return
	 */
	public List<Function> selectListByRole(String roleId);
	
	/**
	 * 根据href查询第二层菜单
	 * @param href
	 * @return
	 */
	public List<Function> selectListByHref(String href);
	
	/**
	 * 根据父功能的功能ID查询下面的子功能列表
	 * @param parentFunctionId
	 * @return
	 */
	public List<Function> selectByParentFunctionId2(String parentFunctionId);
}
