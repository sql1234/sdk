package openserver_sdk.openserver_sdk;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.bayside.openserver.ocr.OpenServer;

public class PersonAnalysis {
	// 设置APPID/AK/SK
	public static final String APP_ID = "1d562bef05e641aaa7abd4e6941413ce";
	public static final String API_KEY = "zd5lxzhugq9l3kumn";
	public static final String SECRET_KEY = "zd5lxzhugq9l3kumn";
	public static final String ACCESS_TOKEN = "zd5lxzhugq9l3kumn";

	public static void main(String[] args) {
		// 初始化一个AipOcr
		OpenServer client = new OpenServer(APP_ID, API_KEY, SECRET_KEY);

		// 可选：设置网络连接参数
//		client.setConnectionTimeoutInMillis(2000);
//		client.setSocketTimeoutInMillis(60000);

		// 可选：设置代理服务器地址, http和socket二选一，或者均不设置
		// client.setHttpProxy("proxy_host", 123); // 设置http代理
		// client.setSocketProxy("proxy_host", 123); // 设置socket代理

		// 调用接口
		Map<String, String> options = new HashMap<String, String>();
		options.put("apiaccess_key", ACCESS_TOKEN);
		options.put("content", "令狐冲慕容复乔峰段誉虚竹王语嫣盖聂卫庄");
		JSONObject res = client.personAnalysis(options);
		System.out.println(res.toString(2));
	}
}
