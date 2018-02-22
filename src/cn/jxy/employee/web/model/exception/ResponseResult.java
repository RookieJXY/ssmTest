package cn.jxy.employee.web.model.exception;

public class ResponseResult {
	private String responseType;
	private String responseMessage;
	
	public ResponseResult() {
		super();
	}
	
	public ResponseResult(String responseType, String responseMessage) {
		super();
		this.responseType = responseType;
		this.responseMessage = responseMessage;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	@Override
	public String toString() {
		return "ResponseResult [responseType=" + responseType
				+ ", responseMessage=" + responseMessage + "]";
	}
}
