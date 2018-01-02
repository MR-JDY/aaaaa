package cn.ideal.es.domain;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016082500308911";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCH0hF1fBgSR/wUNbFKeuTP6l4Dh2fmScXVRTZ7/kqCy3cu/kB20WIeTqn4MslfwCPcYT0AQBPWCNuH2kss1VavYIVBoaqfMkTapLICRdIkxZud1pWcse7/e1Hrt13yztUFkqrsV7fWQit4Fl7KOrXcV3jV82MAM1LXT5YJB54cTikS0lYcyIvQt3UCmDOg62xxc1mMKD3F0jV2e9mSigZ3xZ5/HjiFJ0hQeP3V0VsNG23lnX/A+Gt5uBR74XsENQLkzBdvySGQezjV4rIdPPQXG40huUth2qlS5truc8adJyC7HPaKeuhEmFD6BJk9OhMIJyyqb8aSFGgpdMs8UavhAgMBAAECggEAApctIhKF2wNoeXI0uXjymEyeEm8ouim6DkFNsru87BW5ZjoPPLTtrCpP7534XU0q4e8w3KpcNn7gwQyW1noTNzEeGYxd1r98tLbjdkuioHTsbOxE2kJCjrjpbReIQTNUuNB9VhiuNvX4Ikg68pyAD33TnjEQOFbCQ70O3Yk5qMyFp3RfrPXcCZUa2mKO9wi6DKiuIA5ATaeM8U++lOMEvm9byRldKPSp4Y83FsOmvPgsdttKK/EqBOG/1MYQWx3p7TBXJczjwKdrdX0P0NDMioz33Y3u2gGBIt5PcrJVys2oHuz5hAwAD5i8O1K3YmJtS70PWUP4vh/O8jHtUFeBiQKBgQDX6aBw3uQm/lhyAMfBf1MYcmvTZyZ9JCSCk9cPV9pBoJ8pzrr4VJYvs3ELcYLYNaiPtiTfMXOpBSKghQ7HTE2O1+syFITx6Mt8i0TFZf0o6BgKyCvichCl+SdEegaUnAF/B7YehUtPk1pCChXHDBj9n9HuH+zDMcHUTg3izNL+dwKBgQChCaZmZvKGhfObe5YBkx4Ln3FzJvpOX1ptfIM5gtur93zWFIEZNlZaGo3A1Z1BlouPVMuQvllZlqDGmKL1AzcclGbEJmuZbN+itdNQru5qPdwaNFHvTEkqL6xFjq9zTqycQbfaraFxdAyIKrib5jYJ56VNoS3QkPO9orLI112GZwKBgHlN1MoVL/GIbICAV7oqorDVeCbpiQI90BVcojMIlKLSbxm5/+mM/GQIWLapK231l6JGHykWS3jmXbH5j3gBMoHSZV1ZkeendsueIyEUT8svunI0TBOJKjlVZe5e8FuF2oFX/8Xd9ZXbn5YCvIF8Fn5H0FYMsaRozBFPWRXXJaO5AoGAbWKEqOIcssuiIWbdCczIh9SR10oOk9WpMt10tUfxtumw3imnV1zVYvbOesGew8JiocVTUMo7HuN16fAcIJlCgiM7etkuFVUiwv8GvrNUNs42B4aqcQU8XW9scQLuokA6dxkcrWlrVAkjygpaw2qoIio62nQ1DoqnRZSSJGJFoNkCgYBcvzPCLmu0qC0z9gSCSnNQ7yA48JQLNDqpH5qVn93JuecwvH4UXLlKlT0spcYq74RtJnpuHqiUOw90DhTvXmwGfc8QqmDGKmDE7+IVD+nw0wXUNWicGYMr24Mf2cRi7BeLgi0j4FImKlCf72toDnvj+G/mf9MKyl7vyDElWX+Q7A==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuBD8HvR7WwWW8nqiqDedXNjnif7GPf7RW2+Qc+ZrnptI3DkCapwBc0i6hNKWJexZAp98i4dvXQOsOpsk9u6TK4Pa29HAbIj32nx0yoHsVq3ceoeEZhhW6QPhXE5zNIoHWzrNu+snER5XI0E7aJ8vAbdzbg/bwyDm4Cy0luj9kotf3k02QMTN8FytDNg5Nbe/sie4am2yBrIMBcI+RbFtSt4rLj/NbtFEU4mLbRSxSUwxOVxWATQBqRajE/DtFUKPGE8vEsux/r7wL0mZm0N8YxwpkcS+fWKYO23lSEoAVuvrsrP/seLoF8dNKZZbxkdEUhkRR3Tw+GU8Q2GZcoJuqwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://xqgdtx.ngrok.cc/fyc/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://xqgdtx.ngrok.cc/fyc/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关https://openapi.alipaydev.com/gateway.do
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
//	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

