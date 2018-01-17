package com.bayside.openserver.client;

import com.bayside.openserver.auth.CloudAuth;
import com.bayside.openserver.auth.DevAuth;
import com.bayside.openserver.error.OpenserverError;
import com.bayside.openserver.http.Headers;
import com.bayside.openserver.http.HttpContentType;
import com.bayside.openserver.http.HttpMethodName;
import com.bayside.openserver.http.OpenserverHttpClient;
import com.bayside.openserver.http.OpenserverRequest;
import com.bayside.openserver.http.OpenserverResponse;
import com.bayside.openserver.util.OpenserverClientConfiguration;
import com.bayside.openserver.util.OpenserverClientConstants;
import com.bayside.openserver.util.SignUtil;
import com.bayside.openserver.util.Util;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.Proxy;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class BaseClient {

	protected String appId;
	protected String aipKey;
	protected String aipToken;
	protected String accessToken; // 不适用于使用公有云ak/sk的用户
	protected AtomicBoolean isAuthorized;
	protected AtomicBoolean isBceKey; // 是否为公有云用户
	protected Calendar expireDate;
	protected AuthState state;
	protected OpenserverClientConfiguration config;

	class AuthState {

		private EAuthState state;

		public AuthState() {
			state = EAuthState.STATE_UNKNOWN;
		}

		public EAuthState getState() {
			return state;
		}

		public void setState(EAuthState state) {
			this.state = state;
		}

		public void transfer(boolean value) {
			switch (state) {
			case STATE_UNKNOWN: {
				if (value) {
					state = EAuthState.STATE_AIP_AUTH_OK;
					isBceKey.set(false);
				} else {
					state = EAuthState.STATE_TRUE_CLOUD_USER;
					isBceKey.set(true);
				}
				break;
			}
			case STATE_AIP_AUTH_OK: {
				if (value) {
					state = EAuthState.STATE_TRUE_AIP_USER;
					isBceKey.set(false);
					isAuthorized.set(true);
				} else {
					state = EAuthState.STATE_POSSIBLE_CLOUD_USER;
					isBceKey.set(true);
				}
				break;
			}
			case STATE_TRUE_AIP_USER:
				break;
			case STATE_POSSIBLE_CLOUD_USER: {
				if (value) {
					state = EAuthState.STATE_TRUE_CLOUD_USER;
					isBceKey.set(true);
				} else {
					state = EAuthState.STATE_TRUE_AIP_USER;
					isBceKey.set(false);
					isAuthorized.set(true);
				}
				break;
			}
			case STATE_TRUE_CLOUD_USER:
				break;
			default:
				break;
			}
		}
	}

	/*
	 * BaseClient constructor, default as AIP user
	 */
	protected BaseClient(String appId, String apiKey, String secretKey) {
		this.appId = appId;
		this.aipKey = apiKey;
		this.aipToken = secretKey;
		isAuthorized = new AtomicBoolean(false);
		isBceKey = new AtomicBoolean(false);
		accessToken = null;
		expireDate = null;
		state = new AuthState();
	}

	/**
	 *
	 * @param timeout
	 *            服务器建立连接的超时时间（单位：毫秒）
	 */
	public void setConnectionTimeoutInMillis(int timeout) {
		if (config == null) {
			config = new OpenserverClientConfiguration();
		}
		this.config.setConnectionTimeoutMillis(timeout);
	}

	/**
	 *
	 * @param timeout
	 *            通过打开的连接传输数据的超时时间（单位：毫秒）
	 */
	public void setSocketTimeoutInMillis(int timeout) {
		if (config == null) {
			config = new OpenserverClientConfiguration();
		}
		this.config.setSocketTimeoutMillis(timeout);
	}

	/**
	 * 设置访问网络需要的http代理
	 * 
	 * @param host
	 *            代理服务器地址
	 * @param port
	 *            代理服务器端口
	 */
	public void setHttpProxy(String host, int port) {
		if (config == null) {
			config = new OpenserverClientConfiguration();
		}
		this.config.setProxy(host, port, Proxy.Type.HTTP);
	}

	/**
	 * 设置访问网络需要的socket代理
	 * 
	 * @param host
	 *            代理服务器地址
	 * @param port
	 *            代理服务器端口
	 */
	public void setSocketProxy(String host, int port) {
		if (config == null) {
			config = new OpenserverClientConfiguration();
		}
		this.config.setProxy(host, port, Proxy.Type.SOCKS);
	}

	/**
	 * get OAuth access token, synchronized function
	 * 
	 * @param config
	 *            网络连接设置
	 */
	protected synchronized void getAccessToken(OpenserverClientConfiguration config) {
		if (!needAuth()) {
			return;
		}
		JSONObject res = DevAuth.oauth(aipKey, aipToken, config);
		if (res == null) {
			return;
		}
		if (!res.isNull("access_token")) {
			// openAPI认证成功
			state.transfer(true);
			accessToken = res.getString("access_token");
			Integer expireSec = res.getInt("expires_in");
			Calendar c = Calendar.getInstance();
			c.add(Calendar.SECOND, expireSec);
			expireDate = c;
			// isBceKey.set(false);
			// 验证接口权限
			String[] scope = res.getString("scope").split(" ");
			boolean hasRight = false;
			for (String str : scope) {
				if (OpenserverClientConstants.AI_ACCESS_RIGHT.contains(str)) {
					// 权限验证通过
					hasRight = true;
					break;
				}
			}
			state.transfer(hasRight);
		} else if (!res.isNull("error_code")) {
			state.transfer(false);
		}
	}

	/*
	 * 需要重新获取access_token的条件： 1. 是DEV用户，即 isBceKey为false 2.
	 * isAuthorized为false，或isAuthorized为true，但当前时间晚于expireDate前一天
	 */
	protected Boolean needAuth() {
		if (isBceKey.get()) {
			return false;
		}
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);
		return !isAuthorized.get() || c.after(expireDate);
	}

	/*
	 * 为DEV创建的用户填充body
	 */
	protected void preOperation(OpenserverRequest request) {
		if (needAuth()) {
			getAccessToken(config);
		}

		request.setHttpMethod(HttpMethodName.POST);
		request.addHeader(Headers.CONTENT_TYPE, HttpContentType.FORM_URLENCODE_DATA);
		request.addHeader("accept", "*/*");
		request.setConfig(config);
	}

	/*
	 * 填充http header，传入的request中body&param已经ready
	 * 
	 */
	protected void postOperation(OpenserverRequest request) {
		String bodyStr = request.getBodyStr();
		try {
			int len = bodyStr.getBytes(request.getContentEncoding()).length;
			request.addHeader(Headers.CONTENT_LENGTH, Integer.toString(len));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		request.addHeader(Headers.CONTENT_MD5, SignUtil.md5(bodyStr, request.getContentEncoding()));
		String timestamp = Util.getCanonicalTime();
		request.addHeader(Headers.HOST, request.getUri().getHost());
		request.addHeader(Headers.BCE_DATE, timestamp);
		request.addHeader(Headers.AUTHORIZATION, CloudAuth.sign(request, this.aipKey, this.aipToken, timestamp));
	}

	/**
	 * send request to server
	 * 
	 * @param request
	 *            AipRequest object
	 * @return JSONObject of server response
	 */
	protected JSONObject requestServer(OpenserverRequest request) {
		// 请求API
		OpenserverResponse response = OpenserverHttpClient.post(request);
		String resData = response.getBodyStr();
		Integer status = response.getStatus();
		if (status.equals(200) && !resData.equals("")) {
			try {
				JSONObject res = new JSONObject(resData);
				if (state.getState().equals(EAuthState.STATE_POSSIBLE_CLOUD_USER)) {
					boolean cloudAuthState = res.isNull("error_code")
							|| res.getInt("error_code") != OpenserverClientConstants.IAM_ERROR_CODE;
					state.transfer(cloudAuthState);
					if (!cloudAuthState) {
						return Util.getGeneralError(OpenserverClientConstants.OPENAPI_NO_ACCESS_ERROR_CODE,
								OpenserverClientConstants.OPENAPI_NO_ACCESS_ERROR_MSG);
					}
				}
				return res;
			} catch (JSONException e) {
				return Util.getGeneralError(-1, resData);
			}
		} else {
			return OpenserverError.NET_TIMEOUT_ERROR.toJsonResult();

		}
	}

	// getters and setters for UT
	private void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	private AtomicBoolean getIsAuthorized() {
		return isAuthorized;
	}

	private void setIsAuthorized(boolean isAuthorized) {
		this.isAuthorized.set(isAuthorized);
	}

	private AtomicBoolean getIsBceKey() {
		return isBceKey;
	}

	private void setIsBceKey(boolean isBceKey) {
		this.isBceKey.set(isBceKey);
	}

	private Calendar getExpireDate() {
		return expireDate;
	}

	private void setExpireDate(Calendar expireDate) {
		this.expireDate = expireDate;
	}

}
