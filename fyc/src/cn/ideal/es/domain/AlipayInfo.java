package cn.ideal.es.domain;
/**
 * 支付宝请求参数信息
 * @author Joe
 *
 */
public class AlipayInfo {
	/**
	 * 固定的支付宝网关
	 * https://openapi.alipay.com/gateway.do
	 */
	public String url;
	public String appId;
	public String appPrivateKey;
	/**
	 * json固定
	 */
	public String format;
	/**
	 * 支持GBK UTF-8
	 */
	public String charset;
	public String alipayPulicKey;
	/**
	 * 推荐使用RSA2
	 */
	public String sign_type;
	
	public String notify_url;
	
	public String return_url;
}
