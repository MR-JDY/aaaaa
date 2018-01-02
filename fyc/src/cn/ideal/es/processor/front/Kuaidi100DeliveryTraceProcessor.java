package cn.ideal.es.processor.front;

import java.util.HashMap;
import java.util.Map;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.maicard.http.HttpClientPoolV3;
import com.maicard.http.HttpUtilsV3;
/**
 * 查询快递
 * @author Joe
 *
 */
@Service
public class Kuaidi100DeliveryTraceProcessor {


	private final String apiHost = "api.kuaidi100.com";
	private final String htmlHost = "www.kuaidi100.com";
	private final String mHtmlHost = "m.kuaidi100.com";

	private final int port = 80;
	//private final String key = "7f69ce4e7967c4a7";
	private final String apiPrefix = "http://" + apiHost + ":" + port + "/api";
	private final String htmlPrefix = "http://" + htmlHost + ":" + port + "/applyurl";
	private final String mHtmlPrefix = "http://" + mHtmlHost + ":" + port + "/index_all.html";
	private final String defaultMode = "mhtml";
	//	private final String defaultMode = "api";

	private final int PAGE_TYPE_JSON = 0;
	@SuppressWarnings("unused")
	private final int PAGE_TYPE_TXT = 3;

	private static Map<String,String> keyCacheMap = new HashMap<String,String>();



	public HashMap<String, String> trace() {
		String displayMode = null;
		String displayType = "####";
		if(StringUtils.isBlank(displayType)){
			displayMode = defaultMode;
		} else {
			displayMode = displayType;
		}
		if(displayMode.equals("api")){
			return _apiQuery();
		} else		if(displayMode.equals("mhtml")){
			return _mHtmlQuery();
		}
		return _htmlQuery();
	}





	private HashMap<String, String> _apiQuery() {

		String key = getKey();




		String url = apiPrefix + "?id" +  "=" + key + "&com=" + "例如圆通的是yuantong"+ "&nu=" + "运单号" + "&multi=" + PAGE_TYPE_JSON;
		HttpClient httpClient = HttpClientPoolV3.getHttpClient(htmlHost, port);
		String page = null;
		try {
			page = HttpUtilsV3.getData(httpClient, url, null);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HashMap<String, String> traceData = new HashMap<String, String>();
		if(page.indexOf("身份key认证失败") >= 0){
			return null;
		}
		traceData.put("trace", page);
		return traceData;
	}

	private String getKey() {

		String key = "跟快递100相关的key";//例如7f69ce4e7967c4a7
		return key;
	}





	private HashMap<String, String> _htmlQuery() {
		String key = getKey();

		String url = htmlPrefix + "?key" +  "=" + key + "&com=" + "yuantong" + "&nu=" + "运单号";
		HttpClient httpClient = HttpClientPoolV3.getHttpClient(apiHost, port);
		String page = null;
		try {
			page = HttpUtilsV3.getData(httpClient, url, null);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HashMap<String, String> traceData = new HashMap<String, String>();
		if(page.indexOf("身份key认证失败") >= 0){
			return null;
		}
		traceData.put("traceUrl", page.trim());
		return traceData;
	}

	private HashMap<String, String> _mHtmlQuery() {
		String url = mHtmlPrefix + "?type=" + "yuantong" + "&postid=" + "运单号";
		String returnUrl = "回调地址";
		if(StringUtils.isNotBlank(returnUrl)){
			url += "&callbackurl=" + returnUrl;
		}

		HashMap<String, String> traceData = new HashMap<String, String>();


		traceData.put("traceUrl", url);
		return traceData;
	}

}
