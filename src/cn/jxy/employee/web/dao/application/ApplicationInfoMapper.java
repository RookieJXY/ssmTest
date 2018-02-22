package cn.jxy.employee.web.dao.application;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.jxy.employee.core.generic.GenericDao;
import cn.jxy.employee.web.model.application.ApplicationInfo;
import cn.jxy.employee.web.model.page.Page;



@Repository
public interface ApplicationInfoMapper extends GenericDao<ApplicationInfo, String>{
	
	public int selectRowsOfApplicationInfo(@Param(value = "paramMap") Map<String, String> paramMap);
	
	public List<ApplicationInfo> selectApplicationInfoByPage(@Param(value = "paramMap") Map<String, String> paramMap,@Param(value = "page") Page page);
	//
	public List<ApplicationInfo> selectApplicationInfoByPage1(@Param(value = "paramMap") Map<String, String> paramMap,@Param(value = "page") Page page);
	
	
	public List<ApplicationInfo> selectApplicationAuditingInfoByPage(@Param(value = "paramMap") Map<String, String> paramMap,@Param(value = "page") Page page);
	
	public List<ApplicationInfo> selectApplicationInfoByKeyWord(Map<String, String> paramMap); 
	
	/**
	 * 可部署的申请单有以下几种情况
	 * 1)审核通过且未部署DEV、SIT、UAT
	 * 2)审核通过且DEV、SIT、UAT环境上至少有一个环境部署失败
	 * @param keywords
	 * @return
	 */
	public Integer selectRowsOfCanDeployApplication(@Param(value = "keywords") List<String> keywords);
	
//	public List<ApplicationInfo> selectCanDeployApplicationByPage(@Param(value = "keywords") List<String> keywords,@Param(value = "page") ApplicationInfoPage page);
	
	public Integer selectRowsOfCanDeployApplicationBySystem(@Param(value = "keywords") List<String> keywords, @Param(value = "sysIds") List<String> sysIds);

 //   public List<ApplicationInfo> selectCanDeployApplicationByPageAndSystem(@Param(value = "keywords") List<String> keywords, 
  //  		@Param(value = "page") ApplicationInfoPage page, @Param(value = "sysIds") List<String> sysIds);

	public int selectMessageGather(Map paramMap);

	List<ApplicationInfo> selectAllByChangeNo(@Param(value="changeNoList")List<String> changeNoList);

	Integer selectApplicationInfoByChangeNo(String changeNo);
//	List<ApplicationInfo> selectFree();
//	
//	int updateFree(String applicationId);
}
