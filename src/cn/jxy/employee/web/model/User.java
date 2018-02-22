package cn.jxy.employee.web.model;

import java.io.Serializable;
import java.sql.Timestamp;

import cn.jxy.employee.web.constant.Constant;



public class User implements Serializable{

	/**
	 * 用户实体类
	 */
	private static final long serialVersionUID = 1L;

	private String userId;

	private String userCode;

	private String username;

	private String password;

	private String phoneNo;

	private String email;

	private String departmentId;
	
	private String isManager;

	private String roleId;

	private Timestamp crtTime;

	private String availState = Constant.AVAILABLE;

	private String departmentName;
	
	private String roleName;

	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Timestamp crtTime) {
		this.crtTime = crtTime;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getIsManager() {
		return isManager;
	}

	public void setIsManager(String isManager) {
		this.isManager = isManager;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getAvailState() {
		return availState;
	}

	public void setAvailState(String availState) {
		this.availState = availState;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userCode=" + userCode
				+ ", username=" + username + ", password=" + password
				+ ", phoneNo=" + phoneNo + ", email=" + email
				+ ", departmentId=" + departmentId + ", isManager=" + isManager
				+ ", roleId=" + roleId + ", crtTime=" + crtTime
				+ ", availState=" + availState + ", departmentName="
				+ departmentName + ", roleName=" + roleName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
}
