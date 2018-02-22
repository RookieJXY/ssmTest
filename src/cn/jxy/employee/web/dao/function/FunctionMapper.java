package cn.jxy.employee.web.dao.function;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jxy.employee.core.generic.GenericDao;
import cn.jxy.employee.web.model.Function;



@Repository
public interface FunctionMapper extends GenericDao<Function, String> {
	
	/**
	 * 查询所有的权限
	 */
	@Override
	public List<Function> selectList();
	
	/**
	 * 查询对应菜单下的所有子功能
	 * @param functionId
	 * @return
	 */
	public List<Function> selectListByParentFunctionId(String parentFunctionId);
	
	/**
	 * 根据父类节点查询所有的权限ID的list集合
	 * @param parentFunctionId
	 * @return
	 */
	public List<String> selectByparentFunctionId(String parentFunctionId);
	
	/**
	 * 批量删除
	 * @param functionIds
	 * @return
	 */
	public int deleteByFunctionIds(List<String> functionList);
	
	/**
	 * 已知角色id，查询所有的权限表，并把该角色id下拥有的权限表标注
	 * @param roleId
	 * @return
	 */
	public List<Function> selectListIfHasRole(String roleId);

	/**
	 * 根据角色查询对应的功能列表
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
