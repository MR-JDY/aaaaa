package cn.ideal.es.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class XmlAndMap {

	/**
	 * xml转换成Map
	 * @param req
	 * @param resp
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String,String> xmlToMap(HttpServletRequest req,HttpServletResponse resp) throws IOException, DocumentException{
		Map<String, String> hashMap = new HashMap<String,String>();
		SAXReader saxReader = new SAXReader();
		InputStream inputStream = req.getInputStream();
		Document doc = saxReader.read(inputStream);
		Element rootElement = doc.getRootElement();
		List<Element> elements = rootElement.elements();
		for(Element e:elements){
			hashMap.put(e.getName(), e.getText());
		}
		inputStream.close();
		return hashMap;
	}
}
