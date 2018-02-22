package cn.jxy.employee.web.model.application;

import java.sql.Timestamp;

public class ApplicationInfo {
	
	private String applicationId;
	private String applicationDesc;
	private String type;
	private String oprType;
	private String changeNo;
	private String systemId;
	private String entityId;
	private String entityVersionId;
	private String changeDetailId;
	private String auditState;
	private Timestamp crtTime;
	private String reserveda;
	private String reservedb;
	private String reservedc;
	
	public String getReservedc() {
		return reservedc;
	}

	public void setReservedc(String reservedc) {
		this.reservedc = reservedc;
	}

	public String getReservedb() {
		return reservedb;
	}

	public void setReservedb(String reservedb) {
		this.reservedb = reservedb;
	}

	public String getReserveda() {
		return reserveda;
	}

	public void setReserveda(String reserveda) {
		this.reserveda = reserveda;
	}

	public ApplicationInfo(){
		
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicationDesc() {
		return applicationDesc;
	}

	public void setApplicationDesc(String applicationDesc) {
		this.applicationDesc = applicationDesc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOprType() {
		return oprType;
	}

	public void setOprType(String oprType) {
		this.oprType = oprType;
	}

	public String getChangeNo() {
		return changeNo;
	}

	public void setChangeNo(String changeNo) {
		this.changeNo = changeNo;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getEntityVersionId() {
		return entityVersionId;
	}

	public void setEntityVersionId(String entityVersionId) {
		this.entityVersionId = entityVersionId;
	}

	public String getChangeDetailId() {
		return changeDetailId;
	}

	public void setChangeDetailId(String changeDetailId) {
		this.changeDetailId = changeDetailId;
	}

	public String getAuditState() {
		return auditState;
	}

	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	public Timestamp getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Timestamp crtTime) {
		this.crtTime = crtTime;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	
}
