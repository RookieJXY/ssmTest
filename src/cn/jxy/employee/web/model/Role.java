package cn.jxy.employee.web.model;

import java.sql.Timestamp;

public class Role {

	private String roleId;
	private String roleName;
	private String roleCode;
	private String roleDesc;
	private Timestamp crtTime;
	
	//增加屬性可用狀態:0--不可用,1--可用
	private String availState;

	public Role(String roleId, String roleName, String roleCode,
			String roleDesc, Timestamp crtTime,String availState) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleCode = roleCode;
		this.roleDesc = roleDesc;
		this.crtTime = crtTime;
		this.availState = availState;
	}

	public Role() {
		super();
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Timestamp getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Timestamp crtTime) {
		this.crtTime = crtTime;
	}

	public String getAvailState() {
		return availState;
	}

	public void setAvailState(String availState) {
		this.availState = availState;
	}

}
