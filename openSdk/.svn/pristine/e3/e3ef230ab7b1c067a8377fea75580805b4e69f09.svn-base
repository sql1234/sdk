package com.bayside.openserver.auth;

import org.json.JSONObject;

import com.bayside.openserver.http.OpenserverHttpClient;
import com.bayside.openserver.http.OpenserverRequest;
import com.bayside.openserver.http.OpenserverResponse;
import com.bayside.openserver.util.OpenserverClientConfiguration;
import com.bayside.openserver.util.OpenserverClientConstants;
import com.bayside.openserver.util.Util;

import java.net.URI;
import java.net.URISyntaxException;

public class DevAuth {

	/**
	 * get access_token from openapi
	 * 
	 * @param apiKey
	 *            API key from console
	 * @param secretKey
	 *            Secret Key from console
	 * @param config
	 *            network config settings
	 * @return JsonObject of response from OAuth server
	 */
	public static JSONObject oauth(String apiKey, String secretKey, OpenserverClientConfiguration config) {
		try {
			OpenserverRequest request = new OpenserverRequest();
			request.setUri(new URI(OpenserverClientConstants.OAUTH_URL));
			request.addBody("grant_type", "client_credentials");
			request.addBody("client_id", apiKey);
			request.addBody("client_secret", secretKey);
			request.setConfig(config);
			OpenserverResponse response = OpenserverHttpClient.post(request);
			String res = response.getBodyStr();
			int statusCode = response.getStatus();
			if (res != null && !res.equals("")) {
				return new JSONObject(res);
			} else {
				return Util.getGeneralError(statusCode, "Server response code: " + statusCode);
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
}