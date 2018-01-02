package cn.ideal.es.third.weixin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ideal.es.controller.BaseController;
import cn.ideal.es.security.HttpUtils;
import cn.ideal.es.third.weixin.util.AuthUtil;
@Controller
@RequestMapping("/weixin")
public class WeiXinController extends BaseController {

	@RequestMapping("/entrance")
	public void entrance(HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println("演员");
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        String token = request.getParameter("token");
        System.out.println("演员"+token+"--"+echostr);
        PrintWriter out = response.getWriter();
        out.print(echostr);
	}
	
	@RequestMapping("/callBack")
	public void callBack(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("22进来了22");
        String code = request.getParameter("code");
        System.out.println("22进来了22"+code);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+ AuthUtil.APPID +
                "&secret="+AuthUtil.APPSECRET +
                "&code="+code    +
                "&grant_type=authorization_code";

        JSONObject jsonObject = AuthUtil.doGetJson(url);
        System.out.println("过来");
        String openid = jsonObject.getString("openid");
        System.out.println("openid:"+openid);
        String accessToken = jsonObject.getString("access_token");
        System.out.println("accessToken:"+accessToken);
        String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+accessToken +
                "&openid="+openid +
                "&lang=zh_CN";
        JSONObject jsonObject1 = AuthUtil.doGetJson(infoUrl);

        System.out.println("哈哈"+jsonObject1.toString());
        request.setAttribute("info",jsonObject1);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
	}
	@RequestMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println("地址"+request.getRemoteAddr()+"_"+request.getRemoteHost()+"_"+request.getRemotePort()+"__"+request.getRemoteUser());
		 String backUrl = "http://xqgdtx.ngrok.cc/fyc/weixin/callBack.do";
	        System.out.println("进来了"+URLEncoder.encode(backUrl));
	        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+ AuthUtil.APPID +
	                "&redirect_uri=" + URLEncoder.encode(backUrl)+
	                "&response_type=code" +
	                "&scope=snsapi_userinfo" +
	                "&state=STATE#wechat_redirect";

	        response.sendRedirect(url);
	}
	
	@RequestMapping("/getPay")
	public void getPay(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String resultString = HttpUtils.generateRequestString(request);
		System.out.println("微信支付返回"+resultString);
	}
}
