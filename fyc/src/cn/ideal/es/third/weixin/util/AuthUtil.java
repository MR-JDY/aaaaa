package cn.ideal.es.third.weixin.util;


import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class AuthUtil {
    public static final String APPID = "wxac65f4b782d9a548";
    public static final String APPSECRET="b3e0b6be9064706304ed981ff8e27a68";
    public static JSONObject doGetJson(String url) throws IOException {
        JSONObject jsonObject = null;
        System.out.println("0");
        CloseableHttpClient defaultHttpClient = HttpClients.createDefault();
        System.out.println("1");
        HttpGet httpGet = new HttpGet(url);
        System.out.println("2");
        CloseableHttpResponse response = defaultHttpClient.execute(httpGet);
        System.out.println("3");
        HttpEntity entity = response.getEntity();
        System.out.println("4");
        if(entity!=null){
            System.out.println("5");
            String result = EntityUtils.toString(entity,"UTF-8");
            System.out.println("6"+result);
            jsonObject = JSONObject.fromObject(result);
        }
        System.out.println("7");
        httpGet.releaseConnection();
        System.out.println("8");
        return jsonObject;

    }
}
