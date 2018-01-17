package com.bayside.openserver.exception;

/**
 * 
 * 方法名称：OpenserverException 方法描述：开放平台sdk自定义异常
 * 
 * @param param
 * @return
 * @author liupf
 * @since 2017年12月20日 history 2017年12月20日 liupf 创建
 */
public class OpenserverException extends Exception {

	private String errorMsg;
	private int errorCode;

	public OpenserverException(int code, String msg) {
		errorCode = code;
		errorMsg = msg;
	}

	public OpenserverException(int code, Throwable e) {
		errorCode = code;
		errorMsg = e.getMessage();
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
