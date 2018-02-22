package cn.jxy.employee.web.model.department;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.Length;

import cn.jxy.employee.web.constant.Constant;
import cn.jxy.employee.web.model.User;

public class Department {

private String departmentId;
	
	@Length(max=10)
	private String departmentName;
	
	private String departmentCode;
	
	private User manager;
	
	private String managerId;
	
	private String parentDepartmentId;
	
	private String type;
	
	private Timestamp crtTime;
	
	private String availState = Constant.AVAILABLE;

	public Department() {
		
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public String getParentDepartmentId() {
		return parentDepartmentId;
	}

	public void setParentDepartmentId(String parentDepartmentId) {
		this.parentDepartmentId = parentDepartmentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

}
