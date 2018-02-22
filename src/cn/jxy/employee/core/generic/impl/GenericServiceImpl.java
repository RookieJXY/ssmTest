package cn.jxy.employee.core.generic.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jxy.employee.core.generic.GenericDao;
import cn.jxy.employee.core.generic.GenericService;
import cn.jxy.employee.web.model.page.Page;


@Transactional
@Service
public abstract class GenericServiceImpl<Model, PK> implements GenericService<Model, PK> {
	
	public abstract GenericDao<Model, PK> getDao();
	
	 /**
     * 插入对象
     *
     * @param model 对象
     */
	@Override
    public int insert(Model model) {
        return getDao().insertSelective(model);
    }
	
	@Override
	public int insert(Object obj1, Object obj2) {
		return 0;
	}
    
    /**
     * 更新对象
     *
     * @param model 对象
     */
    @Override
    public int update(Model model){
    	return getDao().updateByPrimaryKeySelective(model);
    }
    
    
    /**
     * 通过主键, 删除对象
     *
     * @param id 主键
     * @return
     */
    @Override
    public int delete(PK id) {
    	return getDao().deleteByPrimaryKey(id);
    }
    
    /**
     * 通过主键, 查询对象
     *
     * @param id 主键
     * @return
     */
    @Override
    public Model selectById(PK id) {
        return getDao().selectByPrimaryKey(id);
    }
    
    /**
     * 查询单个对象
     *
     * @return 对象
     */
    @Override
    public Model selectOne() {
        return getDao().selectOne();
    }

    /**
     * 查询多个对象
     *
     * @return 对象
     */
    @Override
    public List<Model> selectList() {
        return getDao().selectList();
    }
    
    /**
     * 分页查询
     */
    @Override
    public List<Model> selectListByPage(Page page) {
    	return getDao().selectListByPage(page);
    }
    
    public int selectQuantity(){
    	return getDao().selectQuantity();
    }
}
