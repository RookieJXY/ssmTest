package cn.jxy.employee.core.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import cn.jxy.employee.web.model.User;
import cn.jxy.employee.web.model.exception.ResponseResult;

public class ApplicationUtils {

	/**
	 * 产生一个36个字符的UUID
	 * 
	 * @return UUID
	 */
	public static String randomUUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * md5加密
	 * 
	 * @param value
	 *            要加密的值
	 * @return md5加密后的值
	 */
	public static String md5Hex(String value) {
		return new Md5Hash(value).toString();
	}

	/**
	 * sha1加密
	 * 
	 * @param value
	 *            要加密的值
	 * @return sha1加密后的值
	 */
	public static String sha1Hex(String value) {
		return new Sha1Hash(value).toString();
	}

	/**
	 * sha256加密
	 * 
	 * @param value
	 *            要加密的值
	 * @return sha256加密后的值
	 */
	public static String sha256Hex(String value) {
		return new Sha256Hash(value).toString();
	}

	/**
	 * 构建响应信息
	 * @param responseType
	 * @param responseMessage
	 * @return
	 */
	public static JSONObject buildResponseMessage(String responseType,
			String responseMessage) {
		return JSONObject.fromObject(new ResponseResult(responseType,
				responseMessage));
	}

	/**
	 * 文件上传响应消息
	 * @param hasException
	 * @param message
	 * @param response
	 */
	public static void uploadResponseMessage(boolean hasException,
			String message, HttpServletResponse response) {
		String rspMessage = "";
		if (hasException) {
			rspMessage = "{success:false, msg:'" + message + "'}";
		} else {
			rspMessage = "{success:true, msg:'" + message + "'}";
		}
		response.setContentType("text/html; charset=utf-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(rspMessage);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 在session上绑定值
	 * @param attrName
	 * @param attrValue
	 */
	public static void setSession (String attrName, Object attrValue) {
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute(attrName, attrValue);
		
	}
	
	public static User getCurrentUser () {
		Subject subject = SecurityUtils.getSubject();
		User currentUser = (User)subject.getSession().getAttribute("userInfo");
		return currentUser;
	}
	
	/**
	 * 是或的关系，只要有其中一个角色，就返回true
	 * @param roleCodelistList
	 * @return
	 */
	public static boolean hasSomeRoles(List<String> roleCodeList) {
		Subject subject = SecurityUtils.getSubject();
		if (roleCodeList == null) {
			return false;
		}
		
		for (String roleCode : roleCodeList) {
			if (subject.hasRole(roleCode)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 当前用户是否拥有某一个角色
	 * @param roleCode
	 * @return
	 */
	public static boolean hasRole(String roleCode) {
		Subject subject = SecurityUtils.getSubject();
		return subject.hasRole(roleCode);
	}
	
	/**
	 * 
	 * @param Timestamp日期格式
	 */
	public static String formatDate(Timestamp time, String formatter){
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);
		return sdf.format(time);
	}
	
	public static void main(String[] args) {
		System.out.println(sha256Hex("admin"));
	}

}