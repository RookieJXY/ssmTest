package cn.jxy.employee.core.generic;

import java.util.List;

import cn.jxy.employee.web.model.page.Page;

/**
 * 所有自定义Dao的顶级接口, 封装常用的增删查改操作
 * Model : 代表数据库中的表 映射的Java对象类型    
 * PK :代表对象的主键类型
 */
public interface GenericDao<Model, PK> {

    /**
     * 插入对象
     *
     * @param model 对象
     */
    int insertSelective(Model model);

    /**
     * 更新对象
     *
     * @param model 对象
     */
    int updateByPrimaryKeySelective(Model model);

    /**
     * 通过主键, 删除对象
     *
     * @param id 主键
     */
    int deleteByPrimaryKey(PK id);

    /**
     * 通过主键, 查询对象
     *
     * @param id 主键
     * @return
     */
    Model selectByPrimaryKey(PK id);
    
    /**
     * 查询单个对象
     *
     * @return 对象
     */
    Model selectOne();
    
    /**
     * 查询多个对象
     *
     * @return 对象集合
     */
    List<Model> selectList();

    /**
     * 分页查询
     * @param page
     * @return
     */
	List<Model> selectListByPage(Page page);
	
    /**
     * 查询个数
     * @param page
     * @return
     */
	int selectQuantity();
}
