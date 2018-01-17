package com.bayside.openserver.ocr;

import java.util.Map;

import org.json.JSONObject;

import com.bayside.openserver.client.BaseClient;
import com.bayside.openserver.http.OpenserverRequest;

public class OpenServer extends BaseClient {

	public OpenServer(String appId, String apiKey, String secretKey) {
		super(appId, apiKey, secretKey);
	}
	/**
	 * 
		 * 方法名称：dataSearchByWord
		 * 方法描述：全网数据
		 * @param param
		 * @return
		 * @author liupf
		 * @since  2017年12月20日
		 * history 2017年12月20日 liupf 创建
	 */
	public JSONObject dataSearchByWord(Map<String, String> options) {
		OpenserverRequest request = new OpenserverRequest();
		for (Map.Entry<String, String> entry : options.entrySet()) {
			request.addBody(entry.getKey(), entry.getValue());
		}
		request.setUri(OpenserverConstants.DATA_SEARCH_BY_WORD);
		postOperation(request);
		return requestServer(request);
	}
	/**
	 * 
		 * 方法名称：microBlogSearchByWord
		 * 方法描述：微博数据
		 * @param param
		 * @return
		 * @author liupf
		 * @since  2017年12月20日
		 * history 2017年12月20日 liupf 创建
	 */
	public JSONObject microBlogSearchByWord(Map<String, String> options) {
		OpenserverRequest request = new OpenserverRequest();
		for (Map.Entry<String, String> entry : options.entrySet()) {
			request.addBody(entry.getKey(), entry.getValue());
		}
		request.setUri(OpenserverConstants.MICROBLOG_SEARCH_BY_WORD);
		postOperation(request);
		return requestServer(request);
	}
	/**
	 * 
		 * 方法名称：webChatSearchByWord
		 * 方法描述：微信数据
		 * @param param
		 * @return
		 * @author liupf
		 * @since  2017年12月20日
		 * history 2017年12月20日 liupf 创建
	 */
	public JSONObject webChatSearchByWord(Map<String, String> options) {
		OpenserverRequest request = new OpenserverRequest();
		for (Map.Entry<String, String> entry : options.entrySet()) {
			request.addBody(entry.getKey(), entry.getValue());
		}
		request.setUri(OpenserverConstants.WEBCHAT_SEARCH_BY_WORD);
		postOperation(request);
		return requestServer(request);
	}
	/**
	 * 
		 * 方法名称：postBarSearchByWord
		 * 方法描述：贴吧数据
		 * @param param
		 * @return
		 * @author liupf
		 * @since  2017年12月20日
		 * history 2017年12月20日 liupf 创建
	 */
	public JSONObject postBarSearchByWord(Map<String, String> options) {
		OpenserverRequest request = new OpenserverRequest();
		for (Map.Entry<String, String> entry : options.entrySet()) {
			request.addBody(entry.getKey(), entry.getValue());
		}
		request.setUri(OpenserverConstants.POSTBAR_SEARCH_BY_WORD);
		postOperation(request);
		return requestServer(request);
	}
	/**
	 * 
		 * 方法名称：regionAnalysis
		 * 方法描述：地域识别
		 * @param param
		 * @return
		 * @author liupf
		 * @since  2017年12月20日
		 * history 2017年12月20日 liupf 创建
	 */
	public JSONObject regionAnalysis(Map<String, String> options) {
		OpenserverRequest request = new OpenserverRequest();
		for (Map.Entry<String, String> entry : options.entrySet()) {
			request.addBody(entry.getKey(), entry.getValue());
		}
		request.setUri(OpenserverConstants.REGION_ANALYSIS);
		postOperation(request);
		return requestServer(request);
	}
	/**
	 * 
		 * 方法名称：sentimentAnalysis
		 * 方法描述：情感分析
		 * @param param
		 * @return
		 * @author liupf
		 * @since  2017年12月20日
		 * history 2017年12月20日 liupf 创建
	 */
	public JSONObject sentimentAnalysis(Map<String, String> options) {
		OpenserverRequest request = new OpenserverRequest();
		for (Map.Entry<String, String> entry : options.entrySet()) {
			request.addBody(entry.getKey(), entry.getValue());
		}
		request.setUri(OpenserverConstants.SENTIMENT_ANALYSIS);
		postOperation(request);
		return requestServer(request);
	}
	/**
	 * 
		 * 方法名称：abstractAnalysis
		 * 方法描述：摘要提取
		 * @param param
		 * @return
		 * @author liupf
		 * @since  2017年12月20日
		 * history 2017年12月20日 liupf 创建
	 */
	public JSONObject abstractAnalysis(Map<String, String> options) {
		OpenserverRequest request = new OpenserverRequest();
		for (Map.Entry<String, String> entry : options.entrySet()) {
			request.addBody(entry.getKey(), entry.getValue());
		}
		request.setUri(OpenserverConstants.ABSTRACT_ANALYSIS);
		postOperation(request);
		return requestServer(request);
	}
	/**
	 * 
		 * 方法名称：accountSearchByWord
		 * 方法描述：账户信息
		 * @param param
		 * @return
		 * @author liupf
		 * @since  2017年12月20日
		 * history 2017年12月20日 liupf 创建
	 */
	public JSONObject accountSearchByWord(Map<String, String> options) {
		OpenserverRequest request = new OpenserverRequest();
		for (Map.Entry<String, String> entry : options.entrySet()) {
			request.addBody(entry.getKey(), entry.getValue());
		}
		request.setUri(OpenserverConstants.ACCOUNT_SEARCH_BY_WORD);
		postOperation(request);
		return requestServer(request);
	}
	/**
	 * 
		 * 方法名称：lexicalAnalysis
		 * 方法描述：中文分词
		 * @param param
		 * @return
		 * @author liupf
		 * @since  2017年12月20日
		 * history 2017年12月20日 liupf 创建
	 */
	public JSONObject lexicalAnalysis(Map<String, String> options) {
		OpenserverRequest request = new OpenserverRequest();
		for (Map.Entry<String, String> entry : options.entrySet()) {
			request.addBody(entry.getKey(), entry.getValue());
		}
		request.setUri(OpenserverConstants.LEXICAL_ANALYSIS);
		postOperation(request);
		return requestServer(request);
	}
	/**
	 * 
		 * 方法名称：personAnalysis
		 * 方法描述：人名识别
		 * @param param
		 * @return
		 * @author liupf
		 * @since  2017年12月20日
		 * history 2017年12月20日 liupf 创建
	 */
	public JSONObject personAnalysis(Map<String, String> options) {
		OpenserverRequest request = new OpenserverRequest();
		for (Map.Entry<String, String> entry : options.entrySet()) {
			request.addBody(entry.getKey(), entry.getValue());
		}
		request.setUri(OpenserverConstants.PERSON_ANALYSIS);
		postOperation(request);
		return requestServer(request);
	}
	/**
	 * 
		 * 方法名称：mechanismAnalysis
		 * 方法描述：机构识别
		 * @param param
		 * @return
		 * @author liupf
		 * @since  2017年12月20日
		 * history 2017年12月20日 liupf 创建
	 */
	public JSONObject mechanismAnalysis(Map<String, String> options) {
		OpenserverRequest request = new OpenserverRequest();
		for (Map.Entry<String, String> entry : options.entrySet()) {
			request.addBody(entry.getKey(), entry.getValue());
		}
		request.setUri(OpenserverConstants.MECHANISM_ANALYSIS);
		postOperation(request);
		return requestServer(request);
	}
	/**
	 * 
		 * 方法名称：tiebaDataByCode
		 * 方法描述：贴吧账号下的数据
		 * @param param
		 * @return
		 * @author liupf
		 * @since  2017年12月20日
		 * history 2017年12月20日 liupf 创建
	 */
	public JSONObject tiebaDataByCode(Map<String, String> options) {
		OpenserverRequest request = new OpenserverRequest();
		for (Map.Entry<String, String> entry : options.entrySet()) {
			request.addBody(entry.getKey(), entry.getValue());
		}
		request.setUri(OpenserverConstants.TIEBA_DATA_BY_CODE);
		postOperation(request);
		return requestServer(request);
	}
	/**
	 * 
		 * 方法名称：weiboDataByCode
		 * 方法描述：微博账号下的数据
		 * @param param
		 * @return
		 * @author liupf
		 * @since  2017年12月20日
		 * history 2017年12月20日 liupf 创建
	 */
	public JSONObject weiboDataByCode(Map<String, String> options) {
		OpenserverRequest request = new OpenserverRequest();
		for (Map.Entry<String, String> entry : options.entrySet()) {
			request.addBody(entry.getKey(), entry.getValue());
		}
		request.setUri(OpenserverConstants.WEIBO_DATA_BY_CODE);
		postOperation(request);
		return requestServer(request);
	}
	/**
	 * 
		 * 方法名称：weixinDataByCode
		 * 方法描述：微信账号下的数据
		 * @param param
		 * @return
		 * @author liupf
		 * @since  2017年12月20日
		 * history 2017年12月20日 liupf 创建
	 */
	public JSONObject weixinDataByCode(Map<String, String> options) {
		OpenserverRequest request = new OpenserverRequest();
		for (Map.Entry<String, String> entry : options.entrySet()) {
			request.addBody(entry.getKey(), entry.getValue());
		}
		request.setUri(OpenserverConstants.WEIXIN_DATA_BY_CODE);
		postOperation(request);
		return requestServer(request);
	}
	/**
	 * 
		 * 方法名称：microBlogTopList
		 * 方法描述：微博榜单
		 * @param param
		 * @return
		 * @author liupf
		 * @since  2017年12月20日
		 * history 2017年12月20日 liupf 创建
	 */
	public JSONObject microBlogTopList(Map<String, String> options) {
		OpenserverRequest request = new OpenserverRequest();
		for (Map.Entry<String, String> entry : options.entrySet()) {
			request.addBody(entry.getKey(), entry.getValue());
		}
		request.setUri(OpenserverConstants.MICROBLOG_TOP_LIST);
		postOperation(request);
		return requestServer(request);
	}
	/**
	 * 
		 * 方法名称：postBarTopList
		 * 方法描述：贴吧榜单
		 * @param param
		 * @return
		 * @author liupf
		 * @since  2017年12月20日
		 * history 2017年12月20日 liupf 创建
	 */
	public JSONObject postBarTopList(Map<String, String> options) {
		OpenserverRequest request = new OpenserverRequest();
		for (Map.Entry<String, String> entry : options.entrySet()) {
			request.addBody(entry.getKey(), entry.getValue());
		}
		request.setUri(OpenserverConstants.POSTBAR_TOP_LIST);
		postOperation(request);
		return requestServer(request);
	}
	/**
	 * 
		 * 方法名称：webChatTopList
		 * 方法描述：微信榜单
		 * @param param
		 * @return
		 * @author liupf
		 * @since  2017年12月20日
		 * history 2017年12月20日 liupf 创建
	 */
	public JSONObject webChatTopList(Map<String, String> options) {
		OpenserverRequest request = new OpenserverRequest();
		for (Map.Entry<String, String> entry : options.entrySet()) {
			request.addBody(entry.getKey(), entry.getValue());
		}
		request.setUri(OpenserverConstants.WEBCHAT_TOP_LIST);
		postOperation(request);
		return requestServer(request);
	}
	/**
	 * 
		 * 方法名称：contentAnalyze
		 * 方法描述：内容分析
		 * @param param
		 * @return
		 * @author liupf
		 * @since  2017年12月20日
		 * history 2017年12月20日 liupf 创建
	 */
	public JSONObject contentAnalyze(Map<String, String> options) {
		OpenserverRequest request = new OpenserverRequest();
		for (Map.Entry<String, String> entry : options.entrySet()) {
			request.addBody(entry.getKey(), entry.getValue());
		}
		request.setUri(OpenserverConstants.CONTENT_ANALYZE);
		postOperation(request);
		return requestServer(request);
	}
	/**
	 * 
		 * 方法名称：microBlogAnalysis
		 * 方法描述：微博分析
		 * @param param
		 * @return
		 * @author liupf
		 * @since  2017年12月20日
		 * history 2017年12月20日 liupf 创建
	 */
	public JSONObject microBlogAnalysis(Map<String, String> options) {
		OpenserverRequest request = new OpenserverRequest();
		for (Map.Entry<String, String> entry : options.entrySet()) {
			request.addBody(entry.getKey(), entry.getValue());
		}
		request.setUri(OpenserverConstants.MICROBLOG_ANALYSIS);
		postOperation(request);
		return requestServer(request);
	}
	/**
	 * 
		 * 方法名称：postBarAnalysis
		 * 方法描述：贴吧分析
		 * @param param
		 * @return
		 * @author liupf
		 * @since  2017年12月20日
		 * history 2017年12月20日 liupf 创建
	 */
	public JSONObject postBarAnalysis(Map<String, String> options) {
		OpenserverRequest request = new OpenserverRequest();
		for (Map.Entry<String, String> entry : options.entrySet()) {
			request.addBody(entry.getKey(), entry.getValue());
		}
		request.setUri(OpenserverConstants.POSTBAR_ANALYSIS);
		postOperation(request);
		return requestServer(request);
	}
	/**
	 * 
		 * 方法名称：bloggerAnalysis
		 * 方法描述：博主分析
		 * @param param
		 * @return
		 * @author liupf
		 * @since  2017年12月20日
		 * history 2017年12月20日 liupf 创建
	 */
	public JSONObject bloggerAnalysis(Map<String, String> options) {
		OpenserverRequest request = new OpenserverRequest();
		for (Map.Entry<String, String> entry : options.entrySet()) {
			request.addBody(entry.getKey(), entry.getValue());
		}
		request.setUri(OpenserverConstants.BLOGGER_ANALYSIS);
		postOperation(request);
		return requestServer(request);
	}

}
