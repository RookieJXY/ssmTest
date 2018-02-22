package cn.jxy.employee.web.model;

import java.sql.Timestamp;
import java.util.List;



public class Function {
	
private String functionId;
	
	private String functionName;
	
	private String functionCode;
	
	private String href;
	
	private String cssClass;
	
	private String functionDesc;
	
	private String parentFunctionId;
	
	private Timestamp crtTime;
	
	private List<Role> roles;
	
	private List<Function> subfunctions;

	public Function() {
		super();
	}
	
	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	
	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getFunctionDesc() {
		return functionDesc;
	}

	public void setFunctionDesc(String functionDesc) {
		this.functionDesc = functionDesc;
	}

	public String getParentFunctionId() {
		return parentFunctionId;
	}

	public void setParentFunctionId(String parentFunctionId) {
		this.parentFunctionId = parentFunctionId;
	}

	public Timestamp getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Timestamp crtTime) {
		this.crtTime = crtTime;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Function> getSubfunctions() {
		return subfunctions;
	}

	public void setSubfunctions(List<Function> subfunctions) {
		this.subfunctions = subfunctions;
	}
	
}

