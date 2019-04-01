package me.xueyao.util;

import com.thoughtworks.xstream.XStream;
import me.xueyao.entity.message.request.BaseMessage;
import me.xueyao.entity.message.request.InTextMessage;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 消息处理工具
 * @author: Simon.Xue
 * @date: 2019/3/26 16:33
 */
public class MessageUtil {

    /**
     * 将用户的xml消息转换成Map
     * @param request
     * @return
     */
    public static Map<String, String> convertXMLToMap(HttpServletRequest request) throws IOException, DocumentException {
        HashMap<String, String> map = new HashMap<>();

        InputStream inputStream = request.getInputStream();
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        Element root = document.getRootElement();
        List<Element> elements = root.elements();
        for (Element element : elements) {
            map.put(element.getName(), element.getText());
        }
        inputStream.close();

        return map;
    }

    /**
     * 对象转换成Xml
     * @param message
     * @return
     */
    public static String convertObjectToXml(BaseMessage message) {
        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);
        String textXml = xStream.toXML(message);
        return textXml;
    }
}
