package cn.jxy.employee.core.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 该工具类用于一些通用字符串处理
 * @author wuhm
 *
 */
public class StringUtil {
	/**
	 * 该方法用于解析关键字
	 * @param keywords
	 * @return
	 */
	public static List<String> parseKeywordsToList(String keywords) {
		List<String> keywordsList = new ArrayList<String>();
		String regex = "([,，])|([ ]+)";
		if (keywords != null) {
			String[] array = keywords.split(regex);
			for (String keyword : array) {
				keywordsList.add(keyword);
			}
		}
		return keywordsList;
	}
	
	/**
	 * 重构字符串，用于解决中文乱码问题
	 * @param originalCharset
	 * @param presentCharset
	 * @param content
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String reorgStringByCharset(String originalCharset, String presentCharset, 
			String content) throws UnsupportedEncodingException {
		byte[] contentBytes = content.getBytes(originalCharset);
		return new String(contentBytes, presentCharset);
	}

	/**
	 * 服务发布集成服务适配功能_v2
	 * @param fieldPath
	 * @return
	 */
	public static String getNodeName(String fieldPath){
		String replaceStr = fieldPath.replaceAll("\\/|\\.", "_");
		String src = replaceStr.substring(0, 1);
		String dest = replaceStr.substring(1, replaceStr.length());
		if("_".equals(src)){
			return dest;
		}else{
			return replaceStr;
		}
	}
	
}
